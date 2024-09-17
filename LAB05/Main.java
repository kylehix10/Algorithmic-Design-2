//KyleHix
//Copyright2024
//Lab05
import java.util.Random;
import java.io.*;
import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) 
	{	
		//Taking name of file
		Scanner keyboard= new Scanner(System.in);
		System.out.println("Enter the name of a file to read.");
		String filename=keyboard.next();
		
		BinarySearchTree<Package> Delivery = new BinarySearchTree<Package>();
		Package inputPackage=null;
		
		//User choices for sorting
				System.out.println("Would you like to compare the packages by volume, weight, or the recipient's name?");
				String userSort=keyboard.next();
				if(userSort.equalsIgnoreCase("name"))
					Package.userSort=Package.userSort.NAME;
				else if(userSort.equalsIgnoreCase("volume"))
					Package.userSort=Package.userSort.VOLUME;
				else if(userSort.equalsIgnoreCase("weight"))
					Package.userSort=Package.userSort.WEIGHT;
				
				
		//Opening file and storing in BST
		try
		{
		Scanner inputFile = new Scanner(new File(filename));
		while(inputFile.hasNext())
			{
				String nextPackage= inputFile.nextLine();
				
				String [] fields=nextPackage.split("\t");
				inputPackage=new Package(fields[0], Double.parseDouble(fields[1]), Double.parseDouble(fields[2]));
				Delivery.AddValue(inputPackage);

			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		boolean off=false;
		while(!off)
		{
			//User Choices Post Sort
		System.out.println("Would you like to\n"
				+ "1) Print the packages in sorted order to the screen\n"
				+ "2) Add a package\n"
				+ "3) Remove a package\n"
				+ "4) Exit and output the currently held packages to a tab-delimited file named updatedpackages.txt");
		int userOption=keyboard.nextInt();
		keyboard.nextLine();
		
		//Option 1
		if(userOption==1)
		{
			System.out.println(Delivery.inorder());
		}
		
		//Option 2
		else if (userOption==2)
		{
			System.out.println("Enter the recipient's name");
			String addName=keyboard.nextLine();
			System.out.println("Enter the package's volume");
			double addVolume=keyboard.nextDouble();
			System.out.println("Enter the package's weight");
			double addWeight=keyboard.nextDouble();
			
			Package addPackage=new Package(addName,addVolume,addWeight);
			Delivery.AddValue(addPackage);
		}
		
		//Option 3
		else if (userOption==3)
		{
			if(userSort.equalsIgnoreCase("name"))
			{
				System.out.println("Enter the name of the recipient to remove.");
				String remove=keyboard.nextLine();
				Package removeP= new Package(remove, 0, 0);
				Delivery.remove(removeP);
			}
			else if(userSort.equalsIgnoreCase("volume"))
			{
				System.out.println("Enter the volume of the package to remove.");
				double remove=keyboard.nextDouble();
				Package removeP= new Package("", remove, 0);
				Delivery.remove(removeP);
			}
			else if(userSort.equalsIgnoreCase("weight"))
			{
				System.out.println("Enter the weight of the package to remove.");
				double remove=keyboard.nextDouble();
				Package removeP= new Package("", 0, remove);
				Delivery.remove(removeP);
			}
			
		}
		
		//Option 4
		else
		{
			try {
				PrintWriter outputFile = new PrintWriter(new FileOutputStream(new File("updatedpackages.txt")));
			
					outputFile.println(Delivery.inorder());
				
				
				outputFile.close();

			}
			catch (Exception e) {
				e.printStackTrace();
			}
			System.exit(0);
		}
		
		
		
		
		
		
		}//End of While

		
	}//End of Main

}//End of Class
