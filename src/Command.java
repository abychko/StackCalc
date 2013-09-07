import java.util.Map;

interface Command {
    abstract void execute(String command, Stack mStack, Map<String, Double> defines);
}