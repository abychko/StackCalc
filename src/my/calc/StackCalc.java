package my.calc;

import my.calc.cmd.Cmd;

import java.util.Map;

/**
 * Created by nerff on 06.09.13.
 */
public class StackCalc {

    public static void main(String args[]) {

        Input myInput;
        Map<String, Double> defines;
        Map<String, Cmd> cmdMap;

        if (args.length < 1) {
            myInput = new Input();
        } else {
            myInput = new Input(args[0]);
        }

        CmdCreator mCreator = new CmdCreator();
        mCreator.createCommands();
        cmdMap = mCreator.getCmdMap();
        defines = mCreator.getDefines();


        while (!myInput.isDone()) {
            String cmd = myInput.getNextLine();
            String[] tokens = cmd.trim().split("\\s+");
            if (!((cmd.isEmpty()) || (cmd.startsWith("#")))) {
                if (!cmd.equals("END")) {
                    boolean cmdFound = false;
                    for (String key : cmdMap.keySet()) {
                        if (key.equals(tokens[0])) {
                            cmdMap.get(key).execute(tokens);
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
