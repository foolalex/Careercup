/*
 * Question:
 * Write code to partition a linked list around a value x, such that all nodes less than
 * x come before all nodes greater than or equal to x.
 * 
 * Date:2013/07/16
 * @author Tang Li
 * 
 * Test result:
 * Origin:[7 -> 5 -> 2 -> 0 -> 9 -> 1 -> 2 -> 0 -> 6 -> 7 -> 6 -> 4 -> 5 -> 7 -> 4 -> 0 -> 2 -> 8 -> 2 -> 8]
 * The less-than-X list is:[2 -> 0 -> 1 -> 2 -> 0 -> 4 -> 4 -> 0 -> 2 -> 2]
 * The greater-than-X list is:[7 -> 5 -> 9 -> 6 -> 7 -> 6 -> 5 -> 7 -> 8 -> 8]
 * After partition:[2 -> 0 -> 1 -> 2 -> 0 -> 4 -> 4 -> 0 -> 2 -> 2 -> 7 -> 5 -> 9 -> 6 -> 7 -> 6 -> 5 -> 7 -> 8 -> 8]
 */
package Careercup.ch2;
import java.util.Random;

import Careercup.careerCupLibrary.LinkNode;

public class PartitionList_2_4 {
	public static void main(String[] args) {
		LinkNode<Integer> head=new LinkNode<Integer>(null);
		Random r=new Random();
		for(int n=1;n<3;n++){
			Integer i=new Integer(r.nextInt(10)%10);
			LinkNode<Integer> ln=new LinkNode<Integer>(i);			
			LinkList.addtoList_Singly(head,ln);
		}
		System.out.println("Origin:"+LinkList.toString(head));
		LinkNode<Integer> newHead=partitionList(head,5);
		System.out.println("After partition:"+LinkList.toString(newHead));
	}
	public static LinkNode<Integer> partitionList(LinkNode<Integer> head,int x){
		if(head.next==null) 
			return null;
		LinkNode<Integer> lessSideHead=new LinkNode<Integer>(null);
		LinkNode<Integer> lessSideTail=new LinkNode<Integer>(null);
		LinkNode<Integer> greaterSideHead=new LinkNode<Integer>(null);
		LinkNode<Integer> pointer=head.next;
		while(pointer!=null){
			LinkNode<Integer> n=new LinkNode<Integer>(pointer.value);
			if(pointer.value.intValue()>=x){
				LinkList.addtoList_Singly(greaterSideHead,n);
			}else {
				LinkList.addtoList_Singly(lessSideHead,n);
				lessSideTail.prev=n;
			}
			pointer=pointer.next;
		}
		if(lessSideHead.next!=null){
			System.out.println("The less-than-X list is:"+LinkList.toString(lessSideHead));
		} else 
			System.out.println("The less-than-X list have no node.");
		if(greaterSideHead.next!=null){
			System.out.println("The greater-than-X list is:"+LinkList.toString(greaterSideHead));
		} else 
			System.out.println("The greater-than-X have no node.");		
		lessSideTail.prev.next=greaterSideHead.next;
		return lessSideHead;
	}
}
