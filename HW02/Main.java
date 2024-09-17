//Kyle Hix
//Copyright 2024
//HW2

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		Scanner keyboard= new Scanner(System.in);
		//Opening File and Storing into an Array
		SearchTerm [] SearchTermArray= null;
		try 
		{
			Scanner inputFile= new Scanner(new File("searchTerms.txt"));
			String nextSearchTerm = inputFile.nextLine();//Taking in first row. 
			int numSearchTerms=Integer.parseInt(nextSearchTerm);//Changing String to Int
			SearchTermArray = new SearchTerm[numSearchTerms];//Setting the initial array to 
			int i=0;
			while (inputFile.hasNext() ) 
			{
				nextSearchTerm=inputFile.nextLine();
				String[] fields = nextSearchTerm.split("\t");
				SearchTermArray[i]=new SearchTerm(fields[0], Integer.parseInt(fields[1]));
						
				i++;
			}
			inputFile.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		//Sorting in Ascending order
		InsertionSortAscending(SearchTermArray);
		for(int i=0; i<SearchTermArray.length;i++)
		{
			System.out.println(SearchTermArray[i].toString());
		}	
		
		//User Input
		boolean over=false;
		while(!over)
		{
			System.out.println("Enter a search term to find, or type 'quit' to exit.");
			String userTerm=keyboard.nextLine();
			if(userTerm.toLowerCase().equals("quit"))
			{
				System.out.println("Good-bye!");
				over=true;
				System.exit(0);
			}
			
				for(int i=0; i<SearchTermArray.length;i++)
				{ 
					//Alternative Search Method - Struggled with Binary Search for hours, drafted this instead.
					String temp=SearchTermArray[i].getTerm();
					if(userTerm.toLowerCase().equals(temp.toLowerCase()))
					{
						System.out.println(userTerm+" has been searched for "+SearchTermArray[i].getNumOfSearchs()+" times.");
						int newCount=SearchTermArray[i].getNumOfSearchs();
						newCount++;
						SearchTermArray[i].setNumOfSearchs(newCount);
						BubbleSortDescending(SearchTermArray);
						
						//Updating File - 
						try {
							PrintWriter outputFile = new PrintWriter(new FileOutputStream(new File("updatedSearchTerms.txt")));
							for(int k=0; k<15; k++)
								{
								outputFile.println(SearchTermArray[k]);
								//outputFile.close();
								}
							outputFile.close();

						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			
		}//End of While loop
		
		
	}//End of Main Method





//Not the most efficient sort, but made this prior to Big O lesson on Quick Sort
public static <T extends Comparable<T>> void InsertionSortAscending(T[] array)
	{
        for (int i = 1; i < array.length; i++) 
        {
            T temp = array[i];
            int j = i - 1;

            while (j >= 0 && array[j].compareTo(temp) > 0) 
            {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = temp;
        }
	}//End of Insertion Sort


public static void BubbleSortDescending(SearchTerm[] array) 
{
	boolean swapped;
    for (int i = 0; i < array.length - 1; i++) 
    {
    	swapped=false;
        for (int j = 0; j < array.length - 1 - i; j++) 
        {
            if (array[j].getNumOfSearchs() < array[j + 1].getNumOfSearchs()) 
            {
                SearchTerm temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
                swapped=true;
            }
        }
        if(!swapped)
        	break;
    }
}//End of Bubble Sort


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
}


}//End of Class

