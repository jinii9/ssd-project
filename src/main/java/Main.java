import java.io.FileWriter;

public class Main {

    public static void main(String[] args) {
        Parser parser = new Parser();

        Method method;
        int lineNumber;
        String inputValue;

        // Read
        if (args.length == 2) {
            method = parser.getMethod(args[0]);
            lineNumber = parser.getLineNumber(args[1]);
        }

        // Write
        if (args.length == 3) {
            method = parser.getMethod(args[0]);
            lineNumber = parser.getLineNumber(args[1]);
            inputValue = parser.getValue(args[2]);
        }

    }
}
