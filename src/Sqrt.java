import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: abychko
 * Date: 07.09.13
 * Time: 15:55
 * To change this template use File | Settings | File Templates.
 */
public class Sqrt implements Command {
    @Override
    public void execute(String command[], Stack mStack, Map<String, Double> defines) {
        if (!mStack.isEmpty()) {
            double value = mStack.pop();
            double res;
            res = Math.sqrt(value);
            mStack.push(res);
            System.out.println(" * SQRT(" + value + ") = " + res);
        }
    }
}
