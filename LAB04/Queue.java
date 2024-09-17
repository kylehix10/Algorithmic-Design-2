//KyleHix
//Copyright 2024
//Lab04
//Queue methods from lecture
public class Queue<T> implements QInterface<T>
{
	//Instance Variables 
	private T [] values;
	private int beginning;
	private int end;
	private int numberOfItemsInTheQueue;
	
	//Constructors
	public Queue()
	{	//Creating a generic type array
		//Object superclass and cast it as an array of our generic type
		
		this.values=(T[])(new Object[10]);
		this.beginning=this.end=this.numberOfItemsInTheQueue=0;
	}
	//toString 
	public String toString()
	{
		String strqueue=" ";
		for(int i=0;i<this.numberOfItemsInTheQueue;i++)
		{
			strqueue+=values[(this.beginning+i)%this.values.length]+" ";
		}
		return strqueue;
	}
	
	//Peek
	public T peek()
	{
		if(this.numberOfItemsInTheQueue==0)
			return null;
		return this.values[this.beginning];
		
	}
	//Enqueue
	public void enqueue(T val)
	{
		if(this.numberOfItemsInTheQueue==this.values.length)
		{
			T [] newqueue = (T[])(new Object[this.values.length*2]);
			
			for(int i=0;i<this.numberOfItemsInTheQueue;i++)
			{
				newqueue[i]=this.values[(i+this.beginning)%this.numberOfItemsInTheQueue];
			}
			
			newqueue[this.numberOfItemsInTheQueue++]=val;
			this.beginning=0;
			this.end=this.numberOfItemsInTheQueue;
			this.values=newqueue;
			
			
		}
		else
		{
			this.values[this.end++]=val;
			this.end%=this.values.length; 
			this.numberOfItemsInTheQueue++;
		}
	}
	
	//Dequeue
	public T dequeue()
	{
		if(this.numberOfItemsInTheQueue==0)
			return null;
		T toReturn=this.values[this.beginning];
		this.beginning++;
		
		this.beginning %=this.values.length;
		return toReturn;
				
	}
	
	
	
	
	
}//end of class
