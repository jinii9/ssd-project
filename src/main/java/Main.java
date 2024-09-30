import java.io.FileWriter;

public class Main {

    public static void main(String[] args) {
        Parser parser = new Parser();

        Method method;
        int nandIndex;
        String inputValue;

        if (args.length == 2) {
            method = parser.getMethod(args[0]);
            nandIndex = Integer.parseInt(args[1]);
        }

        if (args.length == 3) {
            method = parser.getMethod(args[0]);
            nandIndex = Integer.parseInt(args[1]);
            inputValue = parser.getValue(args[2]);
        }


    }
}
