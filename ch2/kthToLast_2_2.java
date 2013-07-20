/*
 * Question:
 * Implement an algorithm to find the nth to last element of a singly linked list
 * 
 * Date:2013/07/15
 * @author Tang Li
 * 
 * Test result:
 * LinkedList:[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20]
 * The 4th to last element is:[16]
 */
package Careercup.ch2;
import java.util.Random;

import Careercup.careerCupLibrary.LinkNode;
public class KthToLast_2_2 {
	
	public static <E> LinkNode<E>  findKthToLast(LinkNode<E> head,int k){
		LinkNode<E> target=head;
		LinkNode<E> runner=head;
		for(int n=0;n<k;n++){
			runner=runner.next;
		}
		while(runner.next!=null){
			target=target.next;
			runner=runner.next;
		}
		return target;
	}

	public static void main(String[] args) {
		LinkNode<Integer> head=new LinkNode<Integer>(null);
		Random r=new Random();
		for(int n=1;n<21;n++){
			//Integer i=new Integer(r.nextInt(10)%10);
			LinkNode<Integer> ln=new LinkNode<Integer>(n);			
			LinkList.addtoList_Singly(head,ln);
		}
		System.out.println("LinkedList:"+LinkList.toString(head));
		System.out.println("The 4th to last element is:["+findKthToLast(head,4).value.toString()+"]");
	}

}
