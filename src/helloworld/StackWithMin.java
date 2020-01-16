package helloworld;

import java.util.Deque;
import java.util.LinkedList;

public class StackWithMin {
    //Enhance the stack implementation to support min() operation. min() should return the current minimum value in the stack. If the stack is empty, min() should return -1.
        private Deque<Integer> stack;
        private Deque<Integer> minStack; // member(instance) variable

        public StackWithMin() {
            // write your solution here
            stack = new LinkedList<>();
            minStack = new LinkedList<>(); //init. 也可以在定义成员变量处初始化，但是不推荐。LinkedList是实现stack的一种方式，方式并不唯一。
        }

        public int pop() {
            if(stack.isEmpty()){
                return -1;
            }
               minStack.pollFirst();
            return stack.pollFirst();

        }

        public void push(int element) {
         stack.offerFirst(element);

         if(minStack.isEmpty()){
             minStack.offerFirst(element);
         }else{
             minStack.offerFirst(Math.min(element,minStack.peek()));
         }

        }

        public int top() {
            if(stack.isEmpty()){
            return -1;
            }else{
                return (stack.peekFirst());
            }
        }

        public int min() {
            if(minStack.isEmpty()){
                return -1 ;
            }else{
                return (minStack.peekFirst());
            }
        }

        public static void main(String[] args) {
            StackWithMin stackWithMin = new StackWithMin();
            stackWithMin.push(1);
            stackWithMin.push(2);
            stackWithMin.push(3);
            stackWithMin.push(0);
            System.out.println(stackWithMin.min());
            System.out.println(stackWithMin.pop());
            System.out.println(stackWithMin.min());

        }
    }

