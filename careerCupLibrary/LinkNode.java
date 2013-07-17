package Careercup.careerCupLibrary;

public class LinkNode<E> {
		public LinkNode<E> next=null;
		public LinkNode<E> prev=null;
		public E value;
		public LinkNode(E d){
			value=d;
		}
		public LinkNode<E> remove(){
			if(this.next==null){
				this.prev.next=null;
				return null;
			}else{
				this.prev.next=this.next;
				this.next.prev=this.prev;
				return this.next;
			}
		}



}