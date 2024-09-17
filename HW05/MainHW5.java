//Kyle Hix
//Copyright 2024
import java.util.Random;
import java.util.Scanner;

public class MainHW5 {

	public static void main(String[] args) 
	{
		//Initializing some things
		Child child =new Child();
		BinarySearchTreeHW5<Child> kidList= new BinarySearchTreeHW5<Child>();
		Scanner keyboard= new Scanner(System.in);
		Random r = new Random();
		
		//Collecting Children Names and giving them candy
		boolean off=false;
		while(!off)
		{
			
			
			System.out.println("Enter the next child's name or quit to exit.");
			String childName= keyboard.nextLine();
			if(childName.equalsIgnoreCase("quit"))
			{
				off=true;
			}
			else 
			{
				int numOfCandy=r.nextInt(0, 20);
				child=new Child(childName, numOfCandy);
				kidList.AddValue(child);
			}
			
		}
		
		
		boolean halloweenNight=false;
		while(!halloweenNight)
		{
		//Putting the Kids in order from least to most candy
		kidList.inorder();
		
		//Assigning a Max and Min child 
		Child maxKid= kidList.maxChild();
		Child minKid=kidList.minChild();
		
		//Outputting Information and Asking
		System.out.println("A child with the most candy is: "+maxKid);
		System.out.println("A child with the fewest candy is: "+minKid);
		System.out.println("Would "+maxKid.getName()+" be willing to give any candy to "+minKid.getName()+". "
				+ "\nEnter Yes or No");
		String choice=keyboard.nextLine();
		
		if(choice.equalsIgnoreCase("yes"))
		{
			System.out.println("How many pieces (0 - "+maxKid.getNumberOfCandy()+")?");
			int giveCandy=keyboard.nextInt();
			keyboard.nextLine();
			//Giving Candy
			int tempCandygive=minKid.getNumberOfCandy()+giveCandy;
			int tempCandytake=maxKid.getNumberOfCandy()-giveCandy;
			String tempNamegive=minKid.getName();
			String tempNametake=maxKid.getName();
			
			kidList.remove(maxKid);
			kidList.remove(minKid);
			Child new1=new Child(tempNamegive, tempCandygive);
			Child new2=new Child(tempNametake, tempCandytake);
			kidList.AddValue(new1);
			kidList.AddValue(new2);
			
			
			//Resorting
			kidList.inorder();
			System.out.println("Full list:\n");
			System.out.println(kidList.inorder());
		}
		else
		{
			System.out.println("Final list:");
			System.out.println(kidList.descendOrder());
			System.exit(0);
		}
		}
		
		

		
		

		
		

	}//End of Main

}//End of Class
