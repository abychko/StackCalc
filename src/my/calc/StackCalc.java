package my.calc;

import my.calc.cmd.Cmd;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nerff on 06.09.13.
 */
public class StackCalc {

    public static void main(String args[]) {
        Stack mStack = new Stack(10);
        Input myInput;
        Map<String, Double> defines = new HashMap<String, Double>();
        Map<String, Cmd> cmdMap = new HashMap<String, Cmd>();

        if (args.length < 1) {
            myInput = new Input();
        } else {
            myInput = new Input(args[0]);
        }

        CmdCreator mCreator = new CmdCreator();
        mCreator.createCommands(cmdMap, mStack);

        while (!myInput.isDone()) {
            String cmd = myInput.getNextLine();
            String[] tokens = cmd.trim().split("\\s+");
            if (!((cmd.isEmpty()) || (cmd.startsWith("#")))) {
                if (!cmd.equals("END")) {
                    boolean cmdFound = false;
                    for (String key : cmdMap.keySet()) {
                        if (key.equals(tokens[0])) {
                            // System.out.println("Executing: " + key);
                            cmdMap.get(key).execute(tokens, mStack, defines);
                            cmdFound = true;
                            break;
                        }
                    }
                    if (!cmdFound) {
                        System.out.println("Command " + tokens[0] + " is not implemented");
                        System.out.println("Available commands are: " + cmdMap.keySet().toString() + ", END to exit");
                    }
                }
            }
        }
    }
}
