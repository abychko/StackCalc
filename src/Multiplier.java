import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: abychko
 * Date: 07.09.13
 * Time: 16:13
 * To change this template use File | Settings | File Templates.
 */
public class Multiplier implements Command {
    private double[] pair = new double[2];

    @Override
    public void execute(String command, Stack mStack, Map<String, Double> defines) {
        if (mStack.getCursor() > 0) {
            for (int i = 0; i < 2; i++) {
                pair[i] = mStack.pop();
            }
            if (!mStack.isFull()) {
                mStack.push(pair[0] * pair[1]);
            }
        }
        System.out.println(" * Not enough values");
    }
}
