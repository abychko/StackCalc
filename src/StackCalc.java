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
        Map<String, Command> cmdMap = new HashMap<String, Command>();

        //Command mCommand;

        if (args.length < 1) {
            myInput = new Input();
        } else {
            myInput = new Input(args[0]);
        }
        Command mPop = new Pop();
        cmdMap.put("POP", mPop);
        //
        Command mPush = new Push();
        cmdMap.put("PUSH", mPush);
        //
        Command mPrint = new Print();
        cmdMap.put("PRINT", mPrint);
        //
        Command mSqrt = new Sqrt();
        cmdMap.put("SQRT", mSqrt);
        //
        Command mPlus = new Plus();
        cmdMap.put("+", mPlus);
        //
        Command mMinus = new Minus();
        cmdMap.put("-", mMinus);
        //
        Command mMultiplier = new Multiplier();
        cmdMap.put("*", mMultiplier);
        //
        Command mDivider = new Divider();
        cmdMap.put("/", mDivider);
        //
        Command mDefine = new Define();
        cmdMap.put("DEFINE", mDefine);
        //
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
