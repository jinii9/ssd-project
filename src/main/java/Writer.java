import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    public void write(String filename, String inputValue) {
        try {
            FileWriter fileWriter = new FileWriter(filename);
            fileWriter.write(inputValue);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
