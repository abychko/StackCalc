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
    public void execute(String command, Stack mStack, Map<String, Double> defines) {
        String[] cmd = command.split("\\s+");
        if (cmd.length > 2) {
            defines.put(cmd[1], Double.valueOf(cmd[2]));
            System.out.println(" * Define is done");
        }
    }
}
