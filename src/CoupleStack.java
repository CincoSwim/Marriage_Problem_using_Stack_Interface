public class CoupleStack implements CoupleStackInterface {
    int top;
    Couples stack[];

    public CoupleStack(int size) {
        stack = new Couples[size];
        top = -1;
    }

    public void pop() {
        //if empty throw exception
        stack[top] = null;
        top--;
    }

    public Couples top() {
        return stack[top];
    }

    public void push(Couples pair) {
        top++;
        stack[top] = pair;

    }

    public boolean IsFull() {
        if (top == stack.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean IsEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }


    }}
