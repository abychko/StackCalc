package my.calc.cmd;

import my.calc.Stack;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: abychko
 * Date: 07.09.13
 * Time: 15:40
 * To change this template use File | Settings | File Templates.
 */
public class Push implements Cmd {

    @Resource(type = "Stack")
    Stack mStack;
    @Resource(type = "DefMap")
    Map<String, Double> defines;

    @Override
    public void execute(String command[]) {
/*  */
        double value;
        boolean found = false;

        if (command.length == 2) {
            if (command[1].matches("^[a-zA-Z_]\\w*")) { //var is set?
                //looking for already defined variable
                for (String key : defines.keySet()) {
                    if (key.equals(command[1])) {
                        // System.out.println("Found: " + key);
                        value = defines.get(key);
                        found = true;
                        mStack.push(value);
                    }
                }
                if (!found) {
                    System.out.println("Variable " + command[1] + " is not defined");
                    return;
                }
            } else { // set as digit or empty
                try {
                    value = Double.valueOf(command[1]);
                    mStack.push(value);
                } catch (NumberFormatException ne) {
                    System.out.println(" * Not a Number: " + command[1]);
                    return;
                } catch (ArrayIndexOutOfBoundsException ae) {
                    System.out.println(" * No value for " + command[0]);
                }

            }
        }
    }
}
