//Kyle Hix
//Copyright 2024
//HW03 

public class LinkedList <T> extends Contact
{
	private class Node
	{
		//Instance Variables
		private T value;
		private Node next; 
		
		//Constructors
		public Node(T v, Node link)
		{
			this.value=v;
			this.next=link;
		}
		
		//toString Method
		public String toString()
		{
			return this.value.toString();
		}
	}//End of Node Class


//Instance Variables
	private Node head;
	private Node tail;
	private Node current;
	private Node previous;
	
//Default Constructor
	public LinkedList()
	{
		this.head=this.tail=this.previous=this.current = null;
	}
	
//toString Method
	public String toString() 
	{
		String theList="";
		Node n=this.head;
		while(n!=null)
		{
			theList+=n.toString()+"\n";
			n=n.next;
		}
		return theList;
	}
	
//Adding element to the beginning of linked list
	public void addToHead(T v)
	{	
		if(this.head==null)
		{
			this.head=this.tail=this.current=new Node(v, this.head);
		}
		else
			this.head=new Node(v, this.head);
	}
	
//Adding element to the end of the linked list
	public void addToTail(T val)
	{	
		if(this.head==null)
		{
			this.head=this.tail=this.current=new Node(val, null);
			return;
		}
		this.tail.next=new Node(val, null);
		this.tail=this.tail.next;
	}
//Adding and element after the current node
	public void addAfterCurrent(T val)
	{
		if(this.head==null)
			this.head=this.tail=this.current=new Node(val, null);
		if(this.tail==this.current)
		{
			addToTail(val);
		}
		this.current.next=new Node(val, this.current.next);
	}
//Returns the value held in the current node	
	public T getCurrentValue()
	{
		if(this.current==null)
			return null;
		return this.current.value;
	}
	
	//Moving the current node forward
	public T moveCurrentNode()
	{	if(this.current==this.tail)
		{ this.previous=this.current=this.head;
		
		}
		if(this.current==null)
			return null;
		this.previous=this.current;
		this.current=this.current.next;
		return current.value;
	}
	//Sets current node to the head;
	public void setCurrentToHead()
	{
		this.previous=this.current;
		this.current=this.head;
	}
	
	//Removing the current Node from the Linked List
	public T removeCurrent()
	{
		//If current is null
		if(this.current==null)
		{
			return null;
		}
		
		//if current is head, move the head down
		if(this.current==this.head)
			this.head=this.current.next;
		//If current is tail
		if(this.current==this.tail)
			this.tail=this.previous;
		
		
		
		T toReturn=this.current.value;
		//link the previous node to the one after the current node (current's next)
		if(this.previous!=null)
			this.previous.next=this.current.next;
		//move current to current's next
		this.current=this.current.next;
		return toReturn;

	}//End of remove
	
	//Searching Linked List for a value.
	public boolean findValue(String userValue)
	{
		this.current=this.head;
		while(current!=null&&!current.value.equals(userValue))
		{
			this.previous=this.current;
			this.current=this.current.next;
		}
		if(this.current==null)
			return false;
		if(current.value.equals(userValue))
		{
			return true;
		}
		else
			return false;
	
	}//End of findValue
	
	public int getCount()
    {
        Node temp = this.head;
        int count = 0;
        while (temp != null) 
        {
            count++;
            temp = temp.next;
        }
        return count;
    }



}
