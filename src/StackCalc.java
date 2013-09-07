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
        cmdMap.put("PUSH", mPop);
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
        mPop.execute("POP", mStack, defines);
        mPush.execute("PUSH 3", mStack, defines);
        mPrint.execute("PRINT", mStack, defines);
        mSqrt.execute("SQRT", mStack, defines);
        mPlus.execute("+", mStack, defines);
        mMinus.execute("-", mStack, defines);
        mMultiplier.execute("*", mStack, defines);
        mDivider.execute("/", mStack, defines);
        mDefine.execute("define a 3", mStack, defines);

        // while (!myInput.isDone()) {
        //   mCommand = new Command(myInput.getNextLine(), mStack);
        // mCommand.execute();
        //}

    }
}
