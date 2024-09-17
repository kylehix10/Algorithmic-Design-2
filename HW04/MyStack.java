//KyleHix
//Copyright 2024
//HW04


public class MyStack<T> implements StackInterfaceHW<T> 
{
	private class Node
	{
		//Variables
		T value;
		Node next;
		
		//Constructors
		Node(T value, Node next)
		{
			this.value=value;
			this.next=next;
		}
	}
	//Variables
	private Node top;
	
	//Constructors
	public MyStack()
	{
		this.top=null;
	}
	
	//Stack Methods
	
	public void Push(T value) 
	{
		this.top=new Node(value, this.top);
	}

	public T Pop() 
	{
		if(this.top==null)
			return null;
		T temp = this.top.value;
		this.top=this.top.next;
		return temp;
	}

	@Override
	public T Peek() 
	{
		if( this.top==null)
			return null;
		return this.top.value;
	}
	
	//toString
	public String toString()
	{
		String toReturn="";
		Node i=this.top;
		while(i!=null)
		{
			toReturn +=i.value+"\n";
			i=i.next;
		}
		return toReturn;
	}

	
	
	
}//End of MyStack
