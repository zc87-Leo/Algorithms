package helloworld;

public class LinkedList {
    public ListNode reverse(ListNode head){
     ListNode prev = null;
     ListNode curr = head;
     ListNode next = null;
     while(curr != null){
         next = curr.next; // 记录下一个被翻转的节点。
         curr.next = prev;// 翻转箭头。
         prev = curr;// prev往前移动。
         curr = next; // curr往前移动，反复， 当前curr指向上一个curr。
     }
     return prev;
    }

}


