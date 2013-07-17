/*
 * Qustion:
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 *  
 * Date:2013/07/15
 * @author Tang Li
 *  
 * Test result:
 * Before:[0]->[3]->[4]->[6]->[1]->[8]->[2]->[2]->[6]->[9]->[3]->[9]->[1]->[8]->[4]->[1]->[7]->[5]->[5]->[2]
 * After :[0]->[3]->[4]->[6]->[1]->[8]->[2]->[9]->[7]->[5]
 */
package Careercup.ch2;
import java.util.*;
import Careercup.careerCupLibrary.LinkNode;

public class delDups_2_1 {
	public static void main(String[] args) {
		LinkNode<Integer> head=new LinkNode<Integer>(null);
		Random r=new Random();
		for(int n=1;n<21;n++){
			Integer i=new Integer(r.nextInt(10)%10);
			LinkNode<Integer> ln=new LinkNode<Integer>(i);			
			LinkList.addtoList(head,ln);
		}
		System.out.println("Before:"+LinkList.toString(head));
		delDupsA(head);
		System.out.println("After :"+LinkList.toString(head));
}
	//use hash set as temporary buffer.
	public static void delDupsA(LinkNode<Integer> head){
		HashSet<Integer> hashSet=new HashSet<Integer>();
		if(head.next==null) return;
		LinkNode<Integer> n=head.next;
		hashSet.add(n.value);
		while(n.next!=null){
			if(hashSet.contains(n.next.value)){
				n.next=n.next.next;
			}else {
				hashSet.add(n.next.value);
				n=n.next;
			}
		}
		
	}
	//when temporary buffer is not allowed.
	public static void delDupsB(LinkNode<Integer> head){
		LinkNode<Integer> n=head;
		if(n.next==null) 	
			return;
		n=n.next;
		while(n!=null){
			Integer i=n.value;
			LinkNode<Integer> j=n.next;
			while(j!=null){
				if(j.value.equals(i)){
					j=j.remove();
				}else		
					j=j.next;
			}
			n=n.next;
		}
		return;
	}

}
