import java.util.Arrays;

/**
 * Created by nerff on 06.09.13.
 */
public class Command {
    private String command;
    private String[] tokens;
    private String[] allowedCmds = {"+", "-", "*", "/", "END", "PRINT", "PUSH", "POP", "SQRT"};
    private Stack mStack;
    private double[] pair = new double[2];

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

    private boolean getPair() {
        for (int i = 0; i < 2; i++) {
            if (mStack.isEmpty()) {
                return false;
            } else {
                pair[i] = mStack.pop();
            }
        }
        return true;
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
                        double value = mStack.pop();
                        mStack.push(Math.sqrt(value));
                    }
                }
                if (action.equals("+")) {
                    if (getPair()) {
                        if (!mStack.isFull()) {
                            mStack.push(pair[0] + pair[1]);
                        }
                    }
                }
                if (action.equals("-")) {
                    if (getPair()) {
                        if (!mStack.isFull()) {
                            mStack.push(pair[0] - pair[1]);
                        }
                    }
                }
                if (action.equals("/")) {
                    if (getPair()) {
                        if (!mStack.isFull()) {
                            mStack.push(pair[0] / pair[1]);
                        }
                    }
                }
                if (action.equals("*")) {
                    if (getPair()) {
                        if (!mStack.isFull()) {
                            mStack.push(pair[0] * pair[1]);
                        }
                    }
                }

            } else {
                System.out.println(" * Command " + tokens[0] + " is not implemented");
            }
        }
    }
}
