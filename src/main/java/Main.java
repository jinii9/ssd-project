import java.io.FileWriter;

public class Main {

    public static void main(String[] args) {
        Parser parser = new Parser();

        CommandData commandData = parser.getCommandData(args);

        Reader reader = new Reader();
        Writer writer = new Writer();

        switch (commandData.method()) {
            case R -> {
                //
                String readValue = reader.readFromFile(commandData.lineNumber());
                // writer.writeResult("result.txt", readValue);
            }
            case W -> {
                writer.writeSpecificLine("nand.txt", commandData.lineNumber(),
                        commandData.inputValue());
            }
        }
    }
}
