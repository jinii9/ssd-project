import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Writer {

    public void writeSpecificLine(String fileName, int nandIndex, String inputValue) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("파일 읽기 중 오류가 발생했습니다: " + e.getMessage());
        }

        lines.set(nandIndex, inputValue); // 특정 줄 내용 변경

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();  // 줄바꿈 추가
            }
            System.out.println("파일이 성공적으로 수정되었습니다.");
        } catch (IOException e) {
            System.out.println("파일 쓰기 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

}
