package helloworld;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueStack {
    // How could we implement a queue by using 2 stacks.
    private Deque<Integer> in = new LinkedList<>();
    private Deque<Integer> out = new LinkedList<>();











    public static void main(String[] args) {
       /* Queue<Integer> q = new LinkedList<>(); // First in first out.(FIFO)
        q.offer(3); // add
        q.offer(1);
        q.offer(7);
        System.out.println(q.poll());//弹出3
        System.out.println(q.size());//2
        System.out.println(q.peek());//查看第一个数 1
        System.out.println(q.poll());//1
        System.out.println(q.poll());//7
        System.out.println(q.isEmpty());//true

        Deque<String> stack = new LinkedList<>();
        stack.offerFirst("111");
        stack.offerFirst("222");
        stack.offerFirst("333");
        System.out.println(stack.pollFirst());//333
        System.out.println(stack.peek());//222
        System.out.println(stack.pollFirst());//222
        System.out.println(stack.size());//1
        System.out.println(stack.isEmpty());//false*/
    }
}
