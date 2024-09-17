//Kyle Hix
//Copyright 2024
import java.io.*;

import java.util.Scanner;

public class Main {

	public static <T extends Comparable<T>> void SelectionSort( T[] numbers )
	{
		for ( int positionToFix = 0; positionToFix < numbers.length; ++positionToFix ) 
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
	}
	
	public static void main(String[] args) 
	{	
		//Instructing user to input a name for CSV file
		Scanner keyboard=new Scanner(System.in);
		System.out.println("Please input a name for the text file.");
		String txtName= keyboard.next();
		
		//Try and Catch Block to open file
		Assignment [] agnmtArray=null;
		try {
			//NewFile Name
			Scanner inputFile = new Scanner(new File(txtName+".txt"));
			String nextAssignment = inputFile.nextLine();
			int numAssignments=Integer.parseInt(nextAssignment);
			agnmtArray = new Assignment[numAssignments];
			int i=0;
			while(inputFile.hasNext())
			{
				nextAssignment=inputFile.nextLine();
				//Array for file data
				String [] fields=nextAssignment.split("\t");
				agnmtArray[i]=new Assignment(fields[0]+" ", Integer.parseInt(fields[1]),Double.parseDouble(fields[2]) );
				System.out.println(agnmtArray[i].toString());
				i++;
			}
			
			inputFile.close();//always close the file when finished
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	
		//Sorting Data By Title
		Assignment.data=Assignment.Values.TITLE;
		SelectionSort(agnmtArray);
		//Output Data to a file
			try {
				PrintWriter outputFile = new PrintWriter(new FileOutputStream(new File("ByTitle.txt")));
				for(int i=0; i<agnmtArray.length;i++)
				{
					outputFile.println(agnmtArray[i]);
					
				}
				outputFile.close();//always close the file when finished
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			//Sorting Data By AssignmentNumber
			
			Assignment.data=Assignment.Values.ASSIGNMENT_NUMBER;
			SelectionSort(agnmtArray);
				
			//Output Data to a file
				try {
					PrintWriter outputFile = new PrintWriter(new FileOutputStream(new File("ByAssignmentNumber.txt")));
					for(int i=0; i<agnmtArray.length;i++)
					{
						outputFile.println(agnmtArray[i]);
						
					}
					outputFile.close();//always close the file when finished
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				
				//Sorting Data By Grade Percent
				Assignment.data=Assignment.Values.PERCENT_OF_GRADE;
				SelectionSort(agnmtArray);
				
				//Output Data to a file
					try {
						PrintWriter outputFile = new PrintWriter(new FileOutputStream(new File("ByPercentOfGrade.txt")));
						for(int i=0; i<agnmtArray.length;i++)
						{
							outputFile.println(agnmtArray[i]);
						}
						outputFile.close();//always close the file when finished
					}
					catch (Exception e) {
						e.printStackTrace();
					}
		
		
		
		
		
		
	}

}
