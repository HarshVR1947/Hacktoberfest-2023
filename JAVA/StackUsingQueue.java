import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackUsingQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int element) {
        queue2.offer(element);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        if (queue1.isEmpty()) {
            return -1; // Stack is empty
        }
        return queue1.poll();
    }

    public int top() {
        if (queue1.isEmpty()) {
            return -1; // Stack is empty
        }
        return queue1.peek();
    }

    public boolean isEmpty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.top());  // Output: 3
        System.out.println(stack.pop());  // Output: 3
        System.out.println(stack.pop());  // Output: 2
        System.out.println(stack.isEmpty());  // Output: false
    }
}