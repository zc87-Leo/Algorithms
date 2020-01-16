package helloworld;

import java.util.Deque;
import java.util.LinkedList;

public class StackWithMin1 {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public StackWithMin1(){
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }
    public void push(int element){
        stack.offerFirst(element);
        if(minStack.isEmpty() || element <= minStack.peekFirst()){
            minStack.offerFirst(element);
        }
    }
    public int pop(){
        if(stack.isEmpty()){
            return -1;
        }
        int res = stack.pollFirst();
        if(minStack.peekFirst() == res){
            minStack.pollFirst();
        }
        return res;
    }
    public int top(){
        if(stack.isEmpty()){
            return -1;
        }else{
        return (stack.peekFirst());
        }
    }
    public int min(){
        if(minStack.isEmpty()){
            return -1;
        }else{
            return (minStack.peekFirst());
        }

    }

    public static void main(String[] args) {
        StackWithMin1 stackWithMin1 = new StackWithMin1();
        stackWithMin1.push(1);
        stackWithMin1.push(2);
        stackWithMin1.push(3);
        stackWithMin1.push(0);
        System.out.println(stackWithMin1.min());
        System.out.println(stackWithMin1.pop());
        System.out.println(stackWithMin1.min());

    }

}
