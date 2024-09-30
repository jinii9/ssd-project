public class Parser {

    public Method getMethod(String inputMethod) {
        try {
            return Method.valueOf(inputMethod);  // Enum에 존재하는지 확인
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("명령어는 W, R 중 하나로 입력해주세요.");
        }
    }

    public String getValue(String inputValue) {
        validateStartsWith0x(inputValue);   // 0x로 시작하는지 검증
        validateLength(inputValue);         // 길이가 10자리인지 검증
        validateHexFormat(inputValue);      // 뒤 8자리가 숫자인지 검증

        return inputValue; // 모든 검증을 통과하면 원본 값 반환
    }

    // 1. 입력값이 0x로 시작하는지 확인
    private void validateStartsWith0x(String inputValue) {
        if (!inputValue.startsWith("0x")) {
            throw new IllegalArgumentException("inputValue 입력값은 '0x'로 시작해야합니다.");
        }
    }

    // 2. 입력값의 길이가 10자리인지 확인
    private void validateLength(String inputValue) {
        if (inputValue.length() != 10) {
            throw new IllegalArgumentException("inputValue 입력값은 10 자리 값이어야 합니다.");
        }
    }

    // 3. 입력값의 뒤 8자리가 16진수 숫자인지 확인
    private void validateHexFormat(String inputValue) {
        String hexPart = inputValue.substring(2); // "0x" 다음의 8자리 추출
        if (!hexPart.matches("[0-9A-Fa-f]{8}")) {
            throw new IllegalArgumentException(
                    "inputValue의 8 자리는 16진수 값으로 선언되어야 합니다.");
        }
    }
}
