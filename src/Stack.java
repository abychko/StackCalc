


public class Stack {

    private double[] stack;
    private int cursor;

    Stack(int size) {
        stack = new double[size];
        cursor = -1;
    }

    int getCursor() {
        return cursor;
    }

    boolean isEmpty() {
        if (cursor == -1) {
            System.out.println(" * Stack is empty");
            return true;
        }
        return false;
    }

    boolean isFull() {
        if (cursor == (stack.length - 1)) {
            System.out.println(" * Stack is full");
            return true;
        }
        return false;
    }

    double top() {
        if (!isEmpty()) {
            return stack[cursor];
        }
        return 0;
    }

    double pop() {
        if (!isEmpty()) {
            return stack[cursor--];
        }
        return 0;
    }

    void push(double value) {
        if (!isFull()) {
            stack[++cursor] = value;
            //System.out.println("Pushed " + value);
        }
    }
}
