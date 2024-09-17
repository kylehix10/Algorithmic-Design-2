//KyleHix
//Copyright 2024

import java.io.File;
import java.util.Scanner;

public class main {

	public static void main(String[] args) 
	{
		Scanner keyboard=new Scanner(System.in);
		
		System.out.println("Enter the name of the file to read.");
		String fileName=keyboard.nextLine();
		
		MinHeap <RequestedItem> wishList= new MinHeap<RequestedItem>();
		
		try 
		{
			Scanner inputFile = new Scanner(new File(fileName));
				while(inputFile.hasNext())
				{

					String next=inputFile.nextLine();//Reading each line
					
					//Array for file data
					String [] fields=next.split("\t");//Storing name and info into separate chunks
					RequestedItem inputItem=new RequestedItem(fields[0], fields[1], Double.parseDouble(fields[2]));
					wishList.add(inputItem);
				}

			inputFile.close();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

}//End of Class
