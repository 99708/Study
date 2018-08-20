package com.xyq.collection.list;

public class TestLinkedList2 {
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
	}
}
class Node{
	
	private Node pre;
	private Object date;
	private Node next;
	
	public Node getPre() {
		return pre;
	}
	
	public void setPre(Node pre) {
		this.pre = pre;
	}
	
	public Object getDate() {
		return date;
	}
	
	public void setDate(Object date) {
		this.date = date;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
}
class MyLinkedList{
	
	private Node first;
	private Node last;
	
	public Node getFirst() {
		return first;
	}
	
	public void setFirst(Node first) {
		this.first = first;
	}
	
	public Node getLast() {
		return last;
	}
	
	public void setLast(Node last) {
		this.last = last;
	}
	
	public void add(Object obj) {
		if(first == null) {
			Node node = new Node();
			node.setPre(null);
			node.setDate(obj);
			node.setNext(null);
			
			first = last = node;
		}else {
			
			Node node = new Node();
			node.setPre(last);
			node.setDate(obj);
			node.setNext(null);
			
			last.setNext(node);//指向下一个节点
			
			last = node;//下一个节点指向前一个节点
		}
	}
	
	
	
	
}