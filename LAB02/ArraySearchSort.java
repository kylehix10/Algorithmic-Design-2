//Kyle Hix
//Copyright 2024
import java.util.Arrays;
import java.io.*;
import java.util.Scanner;

public class ArraySearchSort {
	
	//Selection Sort
	public static <T extends Comparable<T>> void SelectionSort( T[] numbers ) 
	{
		for ( int positionToFix = 0;positionToFix < numbers.length; ++positionToFix ) 
		{
			int smallestPosition = positionToFix;
				for (int i = positionToFix; i < numbers.length; ++i) 
				{
					if ( numbers[i].compareTo(numbers[smallestPosition])<0 )
						smallestPosition = i;
				}
			T temp = numbers[positionToFix];
			numbers[positionToFix] = numbers[smallestPosition];
			numbers[smallestPosition] = temp;
		
		}
	}//End of Selection Sort
	
	//Linear Search
	public static <T extends Comparable<T>> int LinearSearch(Double[] doubles, int length, Double compareArray)  
	{
		for(int i=0; i<length;i++)
		{
			if(doubles[i]==length)
				return i;
		}
		return -1;
			
	}//End of Linear Search
	
	//Bubble Sort
	public static <T extends Comparable<T>> void BubbleSort(T[] array )
	{
		int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) 
        {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) 
            {
                if (array[j].compareTo(array[j + 1]) > 0) 
                {
                    // Swap array[j] and array[j + 1]
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (!swapped) 
            	break;
                   
        }
	}//End of Bubble Sort
	
	//Insertion Sort
	public static <T extends Comparable<T>> void InsertionSort(T[] array)
	{
		int m=0;    
		for (int i = 1; i < array.length; i++) 
	        {
	            T key = array[i];
	            int j = i - 1;

	            while (j >= 0 && array[j].compareTo(key) > 0) 
	            {
	                array[j + 1] = array[j];
	                j = j - 1;
	            }
	            array[j + 1] = key;
	            m++;
	        }
	 }//End of Insertion Sort
	
	//Binary Search
	public static <T extends Comparable<T>> int BinarySearch(T [] values,T searchValue, int bottom, int top)
		{
			if(bottom > top)
				return -1;
			int middle= (top+bottom)/2;
			if(values[middle].equals(searchValue))
				return middle+1;
			if(values[middle].compareTo(searchValue)>0)
				return BinarySearch(values, searchValue, bottom, middle-1);
			else
				return BinarySearch(values, searchValue, middle+1,top);
		}//End of Binary Search
		
	//Merge Sort
	public static <T extends Comparable<T>> void MergeSort(T[] values)
	{
		if(values.length<2)
		{
			return;
		}
		T[] leftside=Arrays.copyOfRange(values, 0, values.length/2);
		MergeSort(leftside);
		T[] rightside=Arrays.copyOfRange(values, values.length/2, values.length);
		MergeSort(rightside);
		int iLeft=0;
		int iRight=0;
		for (int i=0; i<values.length; i++)
		{
			if(iLeft>=leftside.length)
				values[i]=rightside[iRight++];
			else if (iRight>=rightside.length)
				values[i]=leftside[iLeft++];
			else if (leftside[iLeft].compareTo(rightside[iRight])<0 )
				values[i]=leftside[iLeft++];
			else
				values[i]=rightside[iRight++];
		}
			
	}//MergeSort
		
		//Quick Sort
		public static <T extends Comparable<T>> void QuickSort(T values[])
		{
			QuickSort(values, 0, values.length-1);
		}
		public static<T extends Comparable<T>> void QuickSort(T values[], int start, int end)
		{
			//If the collection has a single item, it’s sorted
			if(start>=end)
				return;
			
			int findBig=start+1;
			int findSmall=end;
			while(findBig<findSmall) 
			{
				
				while(values[findBig].compareTo(values[start])<0 && findBig <findSmall) 
				{
					findBig++;
				}
				while(values[findSmall].compareTo(values[start])>0 && findSmall>start) 
				{
					findSmall++;
				}
				if(findBig<findSmall)
				{
					T temp = values[findBig];
					values[findBig]=values[findSmall];
					values[findSmall]=temp;
				}
			}//End of outer while loop
			if(values[start].compareTo(values[findSmall])>0)
			{
				T temp = values[start];
				values[start]=values[findSmall];
				values[findSmall]=temp;
			}
	
			
			QuickSort(values, start,findSmall -1);
			QuickSort(values, findSmall+1, end);
		}//End of quick sort
		
		
		
		
		
		
		//Main Method
		public static void main(String[] args) 
		{
			Double [] Doubles = null;
			try {
				Scanner file= new Scanner(new File("realnumbers.txt"));
				String nextNum=file.nextLine();
				int numOfNumbers=Integer.parseInt(nextNum);
				Doubles= new Double[numOfNumbers];
				int i=0;
				while(file.hasNext())
				{
					nextNum=file.nextLine();
					Doubles[i]=Double.parseDouble(nextNum);
					i++;
				}
			}//end of try
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			//Opening Second File
			Double [] compareArray = null;
			try {
				Scanner file2= new Scanner(new File("searchnumbers.txt"));
				String nextNum=file2.nextLine();
				int numOfNumbers=Integer.parseInt(nextNum);
				compareArray= new Double[numOfNumbers+3];
				int i=0;
				while(file2.hasNext())
				{
					nextNum=file2.nextLine();
					compareArray[i]=Double.parseDouble(nextNum);
					i++;
				}
			}//end of try
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			
			//User Prompts
		Scanner keyboard= new Scanner(System.in);
		System.out.println("Select one of the following options:\n"
				+ "1) Sort using bubble sort\n"
				+ "2) Sort using selection sort\n"
				+ "3) Sort using insertion sort\n"
				+ "4) Sort using quick sort\n"
				+ "5) Sort using merge sort\n"
				+ "6) Leave unsorted");
		int choice =keyboard.nextInt();
		switch(choice)
		{
		case 1://Done
			ArraySearchSort.BubbleSort(Doubles);
			for(int i=0;i<Doubles.length;i++)
				System.out.println(Doubles[i].toString());
			break;
		case 2://Done
			ArraySearchSort.SelectionSort(Doubles);
			for(int i=0;i<Doubles.length;i++)
				System.out.println(Doubles[i].toString());
			break;
		case 3://Done
			ArraySearchSort.InsertionSort(Doubles);
			for(int i=0;i<Doubles.length;i++)
				System.out.println(Doubles[i].toString());
			break;
		case 4://out of bounds error
			ArraySearchSort.QuickSort(Doubles);
			for(int i=0;i<Doubles.length;i++)
				System.out.println(Doubles[i].toString());
			break;
		case 5://Done
			ArraySearchSort.MergeSort(Doubles);
			for(int i=0;i<Doubles.length;i++)
				System.out.println(Doubles[i].toString());
			break;
		case 6://Done
			for(int i=0;i<Doubles.length;i++)
				System.out.println(Doubles[i].toString());
			break;
		}
		//Searching Logic/Output
		int index=0;
		if(choice<=5)
			{ 
				for(int j=0;j<Doubles.length;j++)
				{
					index=BinarySearch(Doubles, compareArray[j], 0, Doubles.length);
					if(index!=-1)
					{
						System.out.println(compareArray[j]+" found at position "+index);
					}
					else
						System.out.println(compareArray[j]+" is not in the array" );
				}
			}
		else if(choice==6)
		{
			for(int j=0;j<Doubles.length;j++)
			{
				index=LinearSearch(Doubles, Doubles.length, compareArray[j]);
				
				if(index==-1)
				{
					System.out.println(compareArray[j]+" found at position "+j);
				}
				else
					System.out.println(compareArray[j]+" is not in the array" );
			}
		}
			
		}//End of Main


}//End of Class

