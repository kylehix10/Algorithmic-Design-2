//Kyle Hix
//Copyright 2024
//HW03

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		Scanner keyboard= new Scanner(System.in);
		LinkedList<Contact> contactList= new LinkedList<Contact>();
	
		//Taking in File Data
		try 
		{
			Scanner inputFile = new Scanner(new File("samplecontacts.txt"));
			System.out.println("Current Contact List:");
				while(inputFile.hasNext())
				{

					String nextContact=inputFile.nextLine();//Reading each line
					
					//Array for file data
					String [] fields=nextContact.split("\t");//Storing name and info into separate chunks
					Contact inputContact=new Contact(fields[0], fields[1]);//Combining the data with the Contact class.
					contactList.addToHead(inputContact); //Adding each contact to the linkedList.
				}
				System.out.println(contactList.toString());

			
			inputFile.close();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
		
		//User Prompts
		boolean on=false;
		while(!on)
		{
			System.out.println("Enter 1 to add a contact, 2 to update a contact, or 3 to exit");
			int userchoice=keyboard.nextInt();
			keyboard.nextLine();//Absorbing the space left behind by nextInt >:(
			
			
			
			switch(userchoice)
			{
			case 1: //Adding new contacts
				System.out.println("Enter the new contact's name.");
				String newContactName=keyboard.nextLine();
				System.out.println("Enter the new contact's contact information.");
				String newContactInfo=keyboard.nextLine();
				
				Contact inputContact=new Contact(newContactName, newContactInfo);
				contactList.addToHead(inputContact);
				System.out.println("Current Contact List:");
				System.out.println(contactList.toString());
	
				break;
				
				
			case 2://Searching and Updating Contacts
				System.out.println("Enter 1 to search by name or 2 to search by contact information.");
				int updatechoice=keyboard.nextInt();
				keyboard.nextLine();
				
				//Searching by Name
				if(updatechoice==1)
				{
					System.out.println("Enter the contact's name.");
					String searchName=keyboard.nextLine();
					
					int size=contactList.getCount();//found a method to count a linked list on Geeks-for-Geeks.org
													//added to LinkedList class.
					Contact position=contactList.getCurrentValue();
					contactList.setCurrentToHead();
	
					for(int i=0;i<size;i++)
					{
						position=contactList.getCurrentValue();
						contactList.moveCurrentNode();
						if(position.getName().equalsIgnoreCase(searchName))
							{
							System.out.println("Enter the updated contact name.");
							String newName=keyboard.nextLine();//New name
							position.setName(newName);//Setting name
							System.out.println("Enter the updated contact information.");
							String newInfo=keyboard.nextLine();
							position.setContactInfo(newInfo);//Setting information
							contactList.addToHead(position);
							
							//Moving to the proper position for removal
							for(int j=0;j<size-1;j++)
							{
								contactList.moveCurrentNode();
							}
							contactList.removeCurrent();
							System.out.println(contactList.toString());
							
							break;
							}
					
						
					}//End of for
				}//End of If
				else
				{
					System.out.println("Enter the contact's contact information.");
					String searchInfo=keyboard.nextLine();
					
					int size=contactList.getCount();
					Contact position=contactList.getCurrentValue();
					contactList.setCurrentToHead();
	
					for(int i=0;i<size;i++)
					{
						position=contactList.getCurrentValue();
						contactList.moveCurrentNode();
						if(position.getContactInfo().equalsIgnoreCase(searchInfo))
							{
							System.out.println("Enter the updated contact name.");
							String newName=keyboard.nextLine();
							position.setName(newName);
							System.out.println("Enter the updated contact information.");
							String newInfo=keyboard.nextLine();
							position.setContactInfo(newInfo);
							contactList.addToHead(position);
							for(int j=0;j<size-1;j++)
							{
								contactList.moveCurrentNode();
							}
							contactList.removeCurrent();
							System.out.println(contactList.toString());
							break;
							}
					}
					
				}//End of Else
							
				break;
			case 3:
				
				System.out.println("Good-bye!");
				on=true;
				break;
			
				
			}//End of switch
		}//End of While
		
		//Exporting updated Contacts
		try {
			PrintWriter outputFile = new PrintWriter(new FileOutputStream(new File("updatedcontacts.txt")));
		
				outputFile.println(contactList);
			
			
			outputFile.close();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		System.exit(0);

		

		
		
	}//Main method


}//End of class
