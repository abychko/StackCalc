import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: abychko
 * Date: 07.09.13
 * Time: 15:40
 * To change this template use File | Settings | File Templates.
 */
public class Push implements Command {
    @Override
    public void execute(String cmd, Stack stack, Map<String, Double> defines) {
        String[] tokens = cmd.split("\\s+");
        try {
            double value = Double.valueOf(tokens[1]);
            stack.push(value);
        } catch (NumberFormatException ne) {
            System.out.println(" * Not a Number: " + tokens[1]);
        } catch (ArrayIndexOutOfBoundsException ae) {
            System.out.println(" * No value for " + tokens[0]);
        }

    }
}
