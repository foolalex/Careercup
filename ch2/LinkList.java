package Careercup.ch2;
import Careercup.careerCupLibrary.LinkNode;
public class LinkList {
	public static <E> void addtoList_Singly(LinkNode<E> headNode,LinkNode<E> newNode){
		LinkNode<E> n=headNode;
		while(n.next!=null){
			n=n.next;
		}
		n.next=newNode;
		newNode.prev=n;
		newNode.next=null;
		return;
	}

	public static <E> String toString(LinkNode<E> head){
		if(head.next==null) 
			return null;
		LinkNode<E> n=head.next;
		String res="[";		
		while(n!=null){
			res+=n.value.toString();
			if(n.next!=null)
				res+=" -> ";
			else res+="]";
			n=n.next;			
		}
	    return res;
	}
}
