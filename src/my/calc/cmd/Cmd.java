package my.calc.cmd;

import my.calc.Stack;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

public interface Cmd {
    abstract void execute(String command[], Stack stack, Map<String, Double> defines);
}