package helloworld;

import java.util.List;

public class LinkedList {
    //链表反转 (iteration)
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

    //链表反转 (recursion)
    public ListNode reverse1(ListNode head){
        if(head.next == null){
            return head;
        }
        ListNode subHead = reverse(head.next);
        ListNode next = head.next;
        next.next = head;
        head.next = null;
        return subHead;
    }


    // 找到链表的中间节点
    public ListNode findMiddleNode(ListNode head){
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null || fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
       return slow;
    }

    //查明链表是否存在cycle
    public boolean hasCycle(ListNode head){
        if(head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null || fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    //插入一个节点
    public ListNode insertNode(ListNode head, int target){
        ListNode newHead = new ListNode(target);
        if(head == null || head.value > target){
            newHead.next = head;
            return newHead;
        }
        ListNode prev = head;
        while(prev.next != null && prev.next.value < target){
           prev = prev.next;
        }
        newHead.next = prev.next;
        prev.next =  newHead;
        return head;
    }

    //合并链表
    public ListNode mergeLL(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(1);
        ListNode curr = dummy;
        ListNode curr1 = head1;
        ListNode curr2 = head2;
        while(curr1 != null && curr2 != null){
            if(curr1.value <= curr2.value){
                curr.next = curr1;
                curr = curr.next;
                curr1 = curr1.next;
            }else{
                curr.next = curr2;
                curr = curr.next;
                curr2 = curr2.next;
            }
        }
        if(curr1 != null){
            curr.next = curr1;
            curr = curr.next;
            curr1 = curr1.next;
        }
        if (curr2 != null){
            curr.next = curr2;
            curr = curr.next;
            curr2 = curr2.next;
        }
        return dummy.next;
    }

    // Partition List
    public ListNode partition(ListNode head, int target){
        if(head == null){
            return head;
        }
        ListNode dummy1 = new ListNode(722);
        ListNode dummy2 = new ListNode(666);
        ListNode curr1 = dummy1;
        ListNode curr2 = dummy2;
        ListNode curr = head;
        while(curr != null){
            if(curr.value <= target){
                curr1.next = curr;
                curr = curr.next;
                curr1 = curr1.next;
            }else {
                curr2.next = curr;
                curr = curr.next;
                curr2 = curr2.next;
            }
        }
        curr1.next = dummy2.next;
        curr2.next = null;
        return dummy1.next;
    }

}


