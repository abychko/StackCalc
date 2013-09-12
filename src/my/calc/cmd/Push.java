package my.calc.cmd;

import my.calc.Stack;

import javax.annotation.Resource;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: abychko
 * Date: 07.09.13
 * Time: 15:40
 * To change this template use File | Settings | File Templates.
 */
public class Push implements Cmd {

    //  @Resource (type = "Stack")
    //@Retention(RetentionPolicy.RUNTIME)
    //private Stack stack;

    //@Resource (type = "DefMap")
    //@Retention(RetentionPolicy.RUNTIME)
    //private Map<String, Double> defines;

    @Override
    public void execute(String command[], Stack stack, Map<String, Double> defines) {
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
                        stack.push(value);
                    }
                }
                if (!found) {
                    System.out.println("Variable " + command[1] + " is not defined");
                    return;
                }
            } else { // set as digit or empty
                try {
                    value = Double.valueOf(command[1]);
                    stack.push(value);
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
