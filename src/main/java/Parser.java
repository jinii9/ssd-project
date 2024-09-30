public class Parser {

    // 명령어에 따른 CommandData를 생성
    public CommandData getCommandData(String[] args) {
        if (args.length == 2) {
            return createCommandData(args[0], args[1], null);
        }
        if (args.length == 3) {
            return createCommandData(args[0], args[1], args[2]);
        }
        throw new IllegalArgumentException("입력 args의 형식이 맞지 않습니다.");
    }

    // CommandData 생성 로직
    private CommandData createCommandData(String methodArg, String lineArg, String valueArg) {
        Method method = parseMethod(methodArg);
        int lineNumber = parseLineNumber(lineArg);

        // 값이 주어진 경우에만 유효성 검증을 수행
        String inputValue = (valueArg != null) ? validateAndReturnInputValue(valueArg) : null;

        return new CommandData(method, lineNumber, inputValue);
    }

    // 메서드 파싱 및 검증
    private Method parseMethod(String inputMethod) {
        try {
            return Method.valueOf(inputMethod);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("명령어는 W, R 중 하나로 입력해주세요.");
        }
    }

    // lineNumber 파싱 및 검증
    private int parseLineNumber(String inputLineNumber) {
        try {
            int lineNumber = Integer.parseInt(inputLineNumber);
            validateLineNumberRange(lineNumber); // 라인 넘버 0~99 범위 검증
            return lineNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("lineNumber는 숫자여야 합니다.");
        }
    }

    // 값을 검증한 후 반환
    private String validateAndReturnInputValue(String inputValue) {
        validateStartsWith0x(inputValue);   // 0x로 시작하는지 검증
        validateLength(inputValue);         // 길이가 10자리인지 검증
        validateHexFormat(inputValue);      // 뒤 8자리가 숫자인지 검증
        return inputValue;
    }

    // 검증 함수들 (void 반환, 조건 불일치 시 예외 발생)

    // 1. 입력값이 0x로 시작하는지 확인
    private void validateStartsWith0x(String inputValue) {
        if (!inputValue.startsWith("0x")) {
            throw new IllegalArgumentException("inputValue 입력값은 '0x'로 시작해야 합니다.");
        }
    }

    // 2. 입력값의 길이가 10자리인지 확인
    private void validateLength(String inputValue) {
        if (inputValue.length() != 10) {
            throw new IllegalArgumentException("inputValue 입력값은 10 자리여야 합니다.");
        }
    }

    // 3. 입력값의 뒤 8자리가 16진수 숫자인지 확인
    private void validateHexFormat(String inputValue) {
        String hexPart = inputValue.substring(2); // "0x" 다음의 8자리 추출
        if (!hexPart.matches("[0-9A-Fa-f]{8}")) {
            throw new IllegalArgumentException("inputValue의 마지막 8 자리는 16진수 값이어야 합니다.");
        }
    }

    // 4. lineNumber 값이 0~99 범위인지 확인
    private void validateLineNumberRange(int lineNumber) {
        if (lineNumber < 0 || lineNumber > 99) {
            throw new IllegalArgumentException("lineNumber 값은 0~99 사이의 값이어야 합니다.");
        }
    }
}
