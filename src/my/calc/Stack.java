package my.calc;

public class Stack {

    private double[] stack;
    private int cursor;

    Stack(int size) {
        stack = new double[size];
        cursor = -1;
    }

    public int getCursor() {
        return cursor;
    }

    public boolean isEmpty() {
        if (cursor == -1) {
            System.out.println(" * Stack is empty");
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (cursor == (stack.length - 1)) {
            System.out.println(" * Stack is full");
            return true;
        }
        return false;
    }

    public double top() {
        if (!isEmpty()) {
            return stack[cursor];
        }
        return 0;
    }

    public double pop() {
        if (!isEmpty()) {
            return stack[cursor--];
        }
        return 0;
    }

    public void push(double value) {
        if (!isFull()) {
            stack[++cursor] = value;
            //System.out.println("Pushed " + value);
        }
    }
}
