//KyleHix
//Copyright 2024
public class MinHeap<T extends Comparable<T>>
{
	private T[] values;
	private int numValuesInTheHeap;
	
	
	public MinHeap()
	{
		this.values= (T[]) (new Comparable[1]);
		this.numValuesInTheHeap=0;
	}
	
	//Constructor that uses an existing array to hold the heap's values
	public MinHeap(T[]a)
	{
		this.values=a;
		this.numValuesInTheHeap=0;
	}
	//Add Value
	//Average: log(N); Worst O(N)
	public void add(T val)
	{
		//make sure there is room
		//if we don't have enough room in current array
		if(this.numValuesInTheHeap==this.values.length)
		{
			T[] newarray = (T[]) new Comparable[this.values.length*2];
			
			//Copy the values over
			for(int i=0; i<this.numValuesInTheHeap;i++)
			{
				newarray[i]=this.values[i];
			}
			this.values=newarray;
		}
		
		if(this.numValuesInTheHeap<this.values.length) {
			
		//place in first open position
		this.values[this.numValuesInTheHeap]=val;
		//bubble up
		int current=this.numValuesInTheHeap++;
		while(current>0 && this.values[current].compareTo(this.values[(current-1)/2])>0)
		{
			//Swap with parent
			T temp=this.values[current];
			this.values[current]=this.values[(current-1)/2];
			this.values[(current-1)/2]=temp;
			//Move Up
			current=(current-1)/2;
		}
		
		}
	}
	//ToString
	public String toString()
	{
		String toReturn="";
		for(int i=0, j=1, poweroftwo=1; i<this.numValuesInTheHeap;i++,j++)
		{
			toReturn +=" "+this.values[i];
			if(j==poweroftwo) {
				toReturn+="\n";
				j=0;
				poweroftwo*=2;
			}
			else 
			{
				toReturn+=",";
			}
		}
		return toReturn;
	}
	
	//Remove
	//Replace the root with the last value in the tree
	public T remove()
	{
		if(this.numValuesInTheHeap==0)
			return null;
		T toReturn=this.values[0];
		this.values[0]=this.values[--this.numValuesInTheHeap];
		
		//Modification for the heap sort - place the removed root at the end
		this.values[this.numValuesInTheHeap]=toReturn;
		
		int current=0;
		while(2*current+1<this.numValuesInTheHeap )
		{
			int largerChild= 2*current+1;
			if(2*current +2<this.numValuesInTheHeap&&
					this.values[2*current+2].compareTo(this.values[largerChild])>0)
				largerChild=2*current+2;
			
			if(this.values[largerChild].compareTo(this.values[current])>0)
			{
				T temp=this.values[current];
				this.values[current]=this.values[largerChild];
				this.values[largerChild]=temp;
			}
			else
			{
				largerChild=this.numValuesInTheHeap;
			}
			current=largerChild;
		}
		
		return toReturn;
	}
	
	
	
	
	
	
	
	
	
	
}//