import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: abychko
 * Date: 07.09.13
 * Time: 15:22
 * To change this template use File | Settings | File Templates.
 */
public class Pop implements Command {
    @Override
    public void execute(String command[], Stack mStack, Map<String, Double> defines) {
        if (!mStack.isEmpty()) {
            mStack.pop();
        }
    }
}
