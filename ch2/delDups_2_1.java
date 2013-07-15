package Careercup.ch2;
import java.util.*;
import Careercup.careerCupLibrary.LinkNode;

public class delDups_2_1 {
	public static void main(String[] args) {
		LinkNode<Integer> head=new LinkNode<Integer>(null);
		Random r=new Random();
		for(int n=1;n<31;n++){
			Integer i=new Integer(r.nextInt(10)%10);
			LinkNode<Integer> ln=new LinkNode<Integer>(i);			
			addtoList(head,ln);
		}
		System.out.println("Before:"+printStr(head));
		delDupsB(head);
		System.out.println("After :"+printStr(head));
}
	public static void delDupsA(LinkNode<Integer> head){
		HashSet<Integer> set=new HashSet<Integer>();
		
	}
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
				}else			j=j.next;
			}
			n=n.next;
		}
		return;
	}
	public static <E> void addtoList(LinkNode<E> headNode,LinkNode<E> newNode){
		LinkNode<E> n=headNode;
		while(n.next!=null){
			n=n.next;
		}
		n.next=newNode;
		newNode.prev=n;
		newNode.next=null;
		return;
	}
	public static <E> String printStr(LinkNode<E> head){
		LinkNode<E> n=head.next;
		String res="";
		while(n.next!=null){
			res+="["+n.value.toString()+"]";
			n=n.next;
			if(n.next!=null)
				res+="->";
			else res+="->"+"["+n.value.toString()+"]";
		}
	    return res;
	}
}
