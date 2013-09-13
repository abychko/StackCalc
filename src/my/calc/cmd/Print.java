package my.calc.cmd;

import my.calc.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: abychko
 * Date: 07.09.13
 * Time: 15:50
 * To change this template use File | Settings | File Templates.
 */
public class Print implements Cmd {

    @Resource(type = "Stack")
    Stack mStack;

    @Override
    public void execute(String command[]) {
        if (!mStack.isEmpty()) {
            System.out.println(mStack.top());
        }
    }
}
