/*
 * Question:
 * Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
 * EXAMPLE
 * Input: the node c from the linked list a->b->c->d->e
 * Result: nothing is returned, but the new linked list looks like a->b->d->e
 * 
 * Date:2013/07/16
 * @author Tang Li
 * 
 * Test result:
 * Before:[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20]
 * The last element is:[19]
 * After delete the last :[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,20]
 */
package Careercup.ch2;
import java.util.Random;
import Careercup.careerCupLibrary.LinkNode;

public class DelNode_2_3 {
	public static void main(String[] args) {
		LinkNode<Integer> head=new LinkNode<Integer>(null);
		Random r=new Random();
		for(int n=1;n<21;n++){
			LinkNode<Integer> ln=new LinkNode<Integer>(n);			
			LinkList.addtoList_Singly(head,ln);
		}
		System.out.println("Before:"+LinkList.toString(head));
		System.out.println("The last element is:["+KthToLast_2_2.findKthToLast(head,1).value.toString()+"]");
		KthToLast_2_2.findKthToLast(head,1).remove();
		System.out.println("After delete the last :"+LinkList.toString(head));
		
	}

}
