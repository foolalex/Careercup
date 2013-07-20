/*
 * Question:
 * You have two numbers represented by a linked list, where each node contains a
 * single digit. The digits are stored in reverse order, such that the Ts digit is at the
 * head of the list. Write a function that adds the two numbers and returns the sum
 * as a linked list.
 * EXAMPLE
 * Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is, 617 + 295.
 * Output: 2 -> 1 -> 9.That is, 912.
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * EXAMPLE
 * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is, 617 + 295.
 * Output: 9 -> 1 -> 2.That is, 912.
 * 
 * Date:2013/07/17
 * @author Tang Li
 * 
 * Test result: 
 * List no.1:null
 * List no.2:[6 -> 3 -> 7 -> 5 -> 4]
 * The sum of the two lists(the digits stored in reverse order) is:
 * 0+45736=45736
 * The sum of the two lists(the digits stored in reverse order) is:
 * 0+63754=63754
 */
package Careercup.ch2;
import java.util.Random;
import Careercup.careerCupLibrary.*;

public class SumOfLinkList_2_5 {
	public static String sumOfLinkList_Reverse(LinkNode<Integer> head1,LinkNode<Integer> head2){
		int sum1=0;
		int sum2=0;
		if(head1.next==null){ }
		else{
			LinkNode<Integer> n=head1.next;
			int place=1;
			while(n!=null){
				sum1+=n.value.intValue()*place;
				place*=10;
				n=n.next;
			}
		}
		if(head2.next==null){ }
		else{
			LinkNode<Integer> n=head2.next;
			int place=1;
			while(n!=null){
				sum2+=n.value.intValue()*place;
				place*=10;
				n=n.next;
			}
		}	
		return sum1+"+"+sum2+"="+(sum1+sum2);
	}
	public static String sumOfLinkList_Forward(LinkNode<Integer> head1,LinkNode<Integer> head2){
		int sum1=0;
		int sum2=0;
		if(head1.next==null){ }
		else{
			LinkNode<Integer> n=head1.next;
			int place=-1;
			while(n!=null){
				place++;
				n=n.next;
			}
			n=head1.next;
			while(n!=null){
				sum1+=n.value.intValue()*Math.pow(10,place);
				place--;
				n=n.next;
			}
		}
		if(head2.next==null){ }
		else{
			LinkNode<Integer> n=head2.next;
			int place=-1;
			while(n!=null){
				place++;
				n=n.next;
			}
			n=head2.next;
			while(n!=null){
				sum2+=n.value.intValue()*Math.pow(10,place);
				place--;
				n=n.next;
			}			
		}	
		return sum1+"+"+sum2+"="+(sum1+sum2);
	}
	
	public static void main(String[] args) {
		LinkNode<Integer> head1=new LinkNode<Integer>(null);
		Random r=new Random();
		for(int n=1;n<1;n++){
			Integer i=new Integer(r.nextInt(10)%10);
			LinkNode<Integer> ln=new LinkNode<Integer>(i);			
			LinkList.addtoList_Singly(head1,ln);
		}
		LinkNode<Integer> head2=new LinkNode<Integer>(null);
		for(int n=1;n<6;n++){
			Integer i=new Integer(r.nextInt(10)%10);
			LinkNode<Integer> ln=new LinkNode<Integer>(i);			
			LinkList.addtoList_Singly(head2,ln);
		}
		System.out.println("List no.1:"+LinkList.toString(head1));
		System.out.println("List no.2:"+LinkList.toString(head2));
		System.out.println("The sum of the two lists(the digits stored in reverse order) is:\n"+sumOfLinkList_Reverse(head1,head2));
		System.out.println("The sum of the two lists(the digits stored in reverse order) is:\n"+sumOfLinkList_Forward(head1,head2));
	}

}
