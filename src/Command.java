import java.util.Arrays;

/**
 * Created by nerff on 06.09.13.
 */
public class Command {
    private String command;
    private String[] tokens;
    private String[] allowedCmds = {"END", "PRINT", "PUSH", "POP", "SQRT"};
    private Stack mStack;

    Command(String cmd, Stack stack) {
        command = cmd.trim();
        mStack = stack;
    }

    boolean validate() {
        tokens = command.split("\\s+");
        if (Arrays.asList(allowedCmds).contains(tokens[0])) {
            return true;
        }
        return false;
    }

    void execute() {
        if (!((command.startsWith("#")) || (command.isEmpty()))) {
            if (validate()) {
                String action = tokens[0];
                System.out.println("Executing command: " + action);
                //
                if (action.equals("PUSH")) {
                    try {
                        double value = Double.valueOf(tokens[1]);
                        mStack.push(value);
                    } catch (NumberFormatException ne) {
                        System.out.println(" * Not a Number: " + tokens[1]);
                    }
                } //PUSH
                if (action.equals("POP")) {
                    mStack.pop();
                }
                if (action.equals("PRINT")) {
                    if (!mStack.isEmpty()) {
                        System.out.println(mStack.top());
                    }
                }
                if (action.equals("SQRT")) {
                    if (!mStack.isEmpty()) {
                        System.out.println(Math.sqrt(mStack.top()));
                    }
                }

            } else {
                System.out.println(" * Command " + tokens[0] + " is not implemented");
            }
        }
    }
}
