import java.util.Arrays;

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
        return Arrays.asList(allowedCmds).contains(tokens[0]);
    }

    private boolean getPair() {
        if (mStack.getCursor() > 0) {
            for (int i = 0; i < 2; i++) {
                pair[i] = mStack.pop();
            }
            return true;
        }
        System.out.println(" * Not enough values");
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
                    } catch (ArrayIndexOutOfBoundsException ae) {
                        System.out.println(" * No value for " + action);
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
                System.out.println(" * Available commands are: " + Arrays.toString(allowedCmds));
            }
        }
    }
}
