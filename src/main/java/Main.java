import java.io.FileWriter;

public class Main {

    public static void main(String[] args) {
        Parser parser = new Parser();

        CommandData commandData = parser.getCommandData(args);

        switch (commandData.method()) {
            case R -> {

            }
            case W -> {

            }
        }
    }
}
