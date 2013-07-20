/*
 * 
 * Given a circular linked list, implement an algorithm which returns the node at
 * the beginning of the loop.
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points
 * to an earlier node, so as to make a loop in the linked list.
 * EXAMPLE
 * Input: A ->B->C->D->E-> C [the same C as earlier]
 * Output: C
 * 
 * Date:2013/07/18
 * @author Tang Li
 * 
 * Test result: 
 * The singly link list before the loop is:[1 -> 2 -> 3 -> 4]
 * The Loop is:[4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> 11]
 * The begin of the circle is:4
 */
package Careercup.ch2;
import java.util.Random;

import Careercup.careerCupLibrary.*;
public class CircularLinkedList_2_6 {
	public static <E> LinkNode<E> findCircularHead(LinkNode<E> head){
		if(head.next==null)
			return null;
		LinkNode<E> slow=head.next;
		LinkNode<E> fast=head.next;		
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast)
				break;
		}
		if(fast==null && fast.next==null){
			return null;
		}		
		slow=head.next;
		while(slow!=fast){
			slow=slow.next;
			fast=fast.next;
		}		
		return slow;
		
	}
	public static void main(String[] args) {
		LinkNode<Integer> head=new LinkNode<Integer>(null);
		Random r=new Random();
		LinkNode<Integer> ln=null;	
		for(int n=1;n<5;n++){
			Integer i=new Integer(r.nextInt(10)%10);
			ln=new LinkNode<Integer>(n);			
			LinkList.addtoList_Singly(head,ln);
		}
		System.out.println("The singly link list before the loop is:"+LinkList.toString(head));
		LinkNode<Integer> cHead=new LinkNode<Integer>(null);
		cHead.next=ln;		
		for(int n=5;n<11;n++){
			LinkNode<Integer> i=new LinkNode<Integer>(n);			
			LinkList.addtoList_Singly(cHead,i);
		}		
		LinkNode<Integer> tail=new LinkNode<Integer>(new Integer(11));
		LinkList.addtoList_Singly(cHead,tail);		
		System.out.println("The Loop is:"+LinkList.toString(cHead));
		tail.next=cHead;
		cHead.prev=tail;				
		System.out.println("The begin of the circle is:"+findCircularHead(head).value.toString());
	}

}
