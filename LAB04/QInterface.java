//KyleHix
//Lab04
//Copyright 2024
public interface QInterface<T> 
{
	public void enqueue(T value);//add value to end of the queue
	public T dequeue();//Removes from the front
	public T peek();//Returns the front value
	
}
