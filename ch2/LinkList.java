package Careercup.ch2;
import Careercup.careerCupLibrary.LinkNode;
public class LinkList {
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
	public static <E> String toString(LinkNode<E> head){
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
