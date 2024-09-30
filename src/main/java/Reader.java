import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    // 특정 줄을 읽어오는 함수
    public String readFromFile(int lineNumber) {
        String result = "0x00000000"; // 읽은 적이 없는 경우 기본 값

        try (BufferedReader br = new BufferedReader(new FileReader("nand.txt"))) {
            String line; // 파일에서 읽어들인 한 줄의 내용을 저장하는 변수
            int currentLine = 0; // 현재 파일에서 읽고 있는 줄 번호
            while ((line = br.readLine()) != null) { // 파일의 끝에 도달하면 br.readLine()이 null을 반환하며, 루프가 종료
                if (currentLine == lineNumber) {
                    result = line;
                    break;
                }
                currentLine++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    // 전체 파일을 읽는 함수
    public List<String> readFromFile2(String fileName) {

        List<String> arr = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line; // 파일에서 읽어들인 한 줄의 내용을 저장하는 변수

            while ((line = br.readLine()) != null) { // 파일의 끝에 도달하면 br.readLine()이 null을 반환하며, 루프가 종료
                arr.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }

}

// 함수 테스트 코드
//public class Reader {
//    public String readFromFile(int lineNumber) {
//        String result = "0x00000000"; // 읽은 적이 없는 경우 기본 값
//
//        try (BufferedReader br = new BufferedReader(new FileReader("nand.txt"))) {
//            String line; // 파일에서 읽어들인 한 줄의 내용을 저장하는 변수
//            int currentLine = 1; // 현재 파일에서 읽고 있는 줄 번호
//            while ((line = br.readLine()) != null) { // 파일의 끝에 도달하면 br.readLine()이 null을 반환하며, 루프가 종료
//                if (currentLine == lineNumber) {
//                    result = line;
//                    break;
//                }
//                currentLine++;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//        Reader test = new Reader();
//        String result = test.readFromFile(4);
//
//        System.out.println("4번째 줄 읽은 값: " + result); // 예상 결과: 0x44444444
//
//    }
//}
