import java.util.HashMap;
import java.util.Map;

/**
 * Created by nerff on 06.09.13.
 */
public class StackCalc {
    public static void main(String args[]) {
        Stack mStack = new Stack(10);
        Input myInput;
        Map<String, Double> cmdMap = new HashMap();


        //Command mCommand;

        if (args.length < 1) {
            myInput = new Input();
        } else {
            myInput = new Input(args[0]);
        }
        Command mPop = new Pop();
        Command mPush = new Push();
        Command mPrint = new Print();
        Command mSqrt = new Sqrt();
        Command mPlus = new Plus();
        Command mMinus = new Minus();
        Command mMultiplier = new Multiplier();
        Command mDivider = new Divider();
        Command mDefine = new Define();
        //
        mPop.execute("POP", mStack, cmdMap);
        mPush.execute("PUSH 3", mStack, cmdMap);
        mPrint.execute("PRINT", mStack, cmdMap);
        mSqrt.execute("SQRT", mStack, cmdMap);
        mPlus.execute("+", mStack, cmdMap);
        mMinus.execute("-", mStack, cmdMap);
        mMultiplier.execute("*", mStack, cmdMap);
        mDivider.execute("/", mStack, cmdMap);
        mDefine.execute("define a 3", mStack, cmdMap);

        // while (!myInput.isDone()) {
        //   mCommand = new Command(myInput.getNextLine(), mStack);
        // mCommand.execute();
        //}

    }
}
