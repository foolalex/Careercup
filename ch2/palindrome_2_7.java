/*
 * Question:
 * Implement a function to check if a linked list is a palindrome.
 * 
 * Date:2013/07/20
 * @author Tang Li
 * 
 * Test result:
 * List:[1 -> 3 -> 2 -> 1] is not a palindrome.
 * List:[1 -> 2 -> 3 -> 4 -> 4 -> 3 -> 2 -> 1] is a palindrome.
 * List:[1 -> 1] is a palindrome.
 * List:null is not a palindrome.
 * List:[1 -> 2 -> 3 -> 2 -> 1] is a palindrome.
 */
package Careercup.ch2;
import java.util.Random;

import Careercup.careerCupLibrary.LinkNode;
public class palindrome_2_7 {
	public static boolean isPalindrome(LinkNode<Integer> head){
		if(head.next==null)
			return false;
		if(head.next.next==null)
			return true;
		LinkNode<Integer> lastNode=head.next;
		LinkNode<Integer> firstNode=head.next;
		int size=1;
		while(lastNode.next!=null){
			lastNode=lastNode.next;
			size++;
		}
		for(int n=0;n<size/2;n++){
			if(!firstNode.value.equals(lastNode.value))
				return false;
			firstNode=firstNode.next;
			lastNode=lastNode.prev;
		}
		return true;
	}
	public static void printTestResult(int leftSize,int rightSize){
		LinkNode<Integer> head=new LinkNode<Integer>(null);
		for(int n=1;n<leftSize+1;n++){
			LinkNode<Integer> ln=new LinkNode<Integer>(n);			
			LinkList.addtoList_Singly(head,ln);
		}
		for(int n=rightSize;n>0;n--){
			LinkNode<Integer> ln=new LinkNode<Integer>(n);			
			LinkList.addtoList_Singly(head,ln);
		}
		System.out.print("List:"+LinkList.toString(head));
		if(isPalindrome(head))
			System.out.println(" is a palindrome.");
		else System.out.println(" is not a palindrome.");
	}
	public static void main(String[] args) {
		printTestResult(1,3);
		printTestResult(4,4);
		printTestResult(1,1);
		printTestResult(0,0);
		printTestResult(3,2);
		
	}

}
