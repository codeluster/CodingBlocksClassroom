package June19.Stack;

public class Stack {

    protected int[] dataSource;
    private int top_of_stack = -1;

    // Creates a new stack with default size of 5
    public Stack() {
        dataSource = new int[5];
    }

    //Creates a stack with custom capacity
    public Stack(int capacity) {
        dataSource = new int[capacity];
    }

    public int size() {

        return top_of_stack + 1;

    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(int x) throws Exception {
        if (this.size() == dataSource.length) {
            throw new Exception("The stack is full!");
        } else {
            this.top_of_stack++;
            dataSource[this.top_of_stack] = x;
        }

    }

    public int pop() throws Exception {
        if (this.size() == 0) {
            throw new Exception("The stack is empty!");
        } else {
            int return_value = dataSource[top_of_stack];
            dataSource[top_of_stack] = 0;
            top_of_stack--;
            return return_value;
        }
    }

    public int peek() throws Exception {
        if (this.size() == 0) {
            throw new Exception("The stack is empty!");
        } else {
            return dataSource[top_of_stack];
        }
    }

    public void display() {
        System.out.println("-----");
        for (int x = top_of_stack; x >= 0; x--) {
            System.out.println(dataSource[x]);
        }
        System.out.println("-----");
    }

}
