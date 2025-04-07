package inter;

import java.util.Deque;
import java.util.LinkedList;

class Solution {


    static class MyStack{
        Deque<Integer> deque = new LinkedList<>();

        public Integer push(Integer num){
            deque.addFirst(num);
            return num;
        }

        public Integer pop(){
            return deque.removeFirst();
        }

    }

    public static void main(String[] args) {

        MyStack myStack = new MyStack();
        myStack.push(1);

    }


}