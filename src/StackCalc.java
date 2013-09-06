/**
 * Created by nerff on 06.09.13.
 */
public class StackCalc {
    public static void main(String args[]) {
        Stack mStack = new Stack(10);
        Input myInput;
        Command mCommand;

        if (args.length < 1) {
            myInput = new Input();
        } else {
            myInput = new Input(args[0]);
        }

        while (!myInput.isDone()) {
            mCommand = new Command(myInput.getNextLine(), mStack);
            mCommand.execute();
        }

    }
}
