
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: abychko
 * Date: 07.09.13
 * Time: 16:17
 * To change this template use File | Settings | File Templates.
 */
public class Define implements Command {
    @Override
    public void execute(String command[], Stack mStack, Map<String, Double> defines) {
        String var = command[1];
        if (command.length == 3) {
            if (var.matches("^[a-zA-Z_]\\w*")) {
                defines.put(var, Double.valueOf(command[2]));
                System.out.println(" * " + var + " = " + command[2]);
            } else {
                System.out.println(" * Mailformed variable: " + var);
            }
        } else {
            System.out.println(" * Mailformed define command");
        }
    }
}
