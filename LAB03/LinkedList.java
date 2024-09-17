//KyleHix
//Copyright 2024
//Lab03-LinkedList

import java.io.File;
import java.util.Scanner;

public class LinkedList <T>
{
		private class Node
		{
			//Instance Variables
			private T value;
			private Node next; 
			
			//Constructors
			public Node(T v, Node link)
			{
				this.value=v;
				this.next=link;
			}
			
			//toString Method
			public String toString()
			{
				return this.value.toString();
			}
		}//End of Node Class
	
	
	//Instance Variables
		private Node head;
		private Node tail;
		private Node current;
		private Node previous;
		
	//Default Constructor
		public LinkedList()
		{
			this.head=this.tail=this.previous=this.current = null;
		}
		
	//toString Method
		public String toString() 
		{
			String theList="";
			Node n=this.head;
			while(n!=null)
			{
				theList+=n.toString()+"\t";
				n=n.next;
			}
			return theList;
		}
		
	//Adding element to the beginning of linked list
		public void addToHead(T v)
		{	
			if(this.head==null)
			{
				this.head=this.tail=this.current=new Node(v, this.head);
			}
			else
				this.head=new Node(v, this.head);
		}
		
	//Adding element to the end of the linked list
		public void addToTail(T val)
		{	
			if(this.head==null)
			{
				this.head=this.tail=this.current=new Node(val, null);
				return;
			}
			this.tail.next=new Node(val, null);
			this.tail=this.tail.next;
		}
	//Adding and element after the current node
		public void addAfterCurrent(T val)
		{
			if(this.head==null)
				this.head=this.tail=this.current=new Node(val, null);
			if(this.tail==this.current)
			{
				addToTail(val);
			}
			this.current.next=new Node(val, this.current.next);
		}
	//Returns the value held in the current node	
		public T getCurrentValue()
		{
			if(this.current==null)
				return null;
			return this.current.value;
		}
		
		//Moving the current node forward
		public T moveCurrentNode()
		{
			this.previous=this.current;
			this.current=this.current.next;
			return current.value;
		}
		//Sets current node to the head;
		public void setCurrentToHead()
		{
			this.previous=this.current;
			this.current=this.head;
		}
		
		//Removing the current Node from the Linked List
		public T removeCurrent()
		{
			//If current is null
			if(this.current==null)
			{
				return null;
			}
			
			//if current is head, move the head down
			if(this.current==this.head)
				this.head=this.current.next;
			//If current is tail
			if(this.current==this.tail)
				this.tail=this.previous;
			
			
			
			T toReturn=this.current.value;
			//link the previous node to the one after the current node (current's next)
			if(this.previous!=null)
				this.previous.next=this.current.next;
			//move current to current's next
			this.current=this.current.next;
			return toReturn;

		}//End of remove
		
		//Searching Linked List for a value.
		public boolean findValue(T userValue)
		{
			this.current=this.head;
			//this.previous=this.current;
			while(current!=null&&!current.value.equals(userValue))
			{
				this.previous=this.current;
				this.current=this.current.next;
			}
			if(this.current==null)
				return false;
			if(current.value.equals(userValue))
			{
				return true;
			}
			else
				return false;
		
		}//End of findValue
	
		
		//Main
		public static void main(String[] args) 
		{
			LinkedList<String> Colors = new LinkedList<String>();
			try {
				Scanner file= new Scanner(new File("lab3input.txt"));
				while(file.hasNext())
				{
					String nextColor=file.nextLine();
					Colors.addToHead(nextColor);
				}
			}//end of try
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			//User Prompts
			
				System.out.println("Enter a color: ");
				Scanner keyboard=new Scanner(System.in);
				String userColor=keyboard.nextLine();
				boolean inList=Colors.findValue(userColor);
				boolean gameOver=false;
				while(gameOver==false)
				{
					if(inList==false)
					{
						
						System.out.println("Would you like to: \n"
								+ "1 - add "+userColor+" as the first value in the list\n"
								+ "2 - add "+userColor+" as the last value in the list\n"
								+ "3 - neither (don't add "+userColor+" to the list)");
						int editList=keyboard.nextInt();
						
						if(editList==1)
						{
							Colors.addToHead(userColor);
							System.out.println(Colors.toString());
							
							
						}
						else if(editList==2)
						{
							Colors.addToTail(userColor);
							System.out.println(Colors.toString());
							
							
						}
						else if(editList==3)
						{
							System.out.println(Colors.toString());
							
						}
						else
							System.out.println("Invalid option. Pick again");
						
						System.out.println("Would you like to enter another color?");
						String jump=keyboard.next();
						if (jump.equalsIgnoreCase("yes"))
						{
							System.out.println("Enter a color: ");
							userColor=keyboard.next();
							inList=Colors.findValue(userColor);
						}
						else
						{
							System.out.println("Good-bye!");
							System.exit(0);
						}
					
						
					}//End of While Loop
					
				if(inList==true)
				{
					System.out.println("Would you like to remove the item from the list?");
					String removeAnswer=keyboard.next();
					if(removeAnswer.equalsIgnoreCase("yes"))
					{
						Colors.removeCurrent();
						System.out.println(Colors.toString());
					}
					
					
					
					System.out.println("Would you like to enter another color?");
					String jump=keyboard.next();
					if (jump.equalsIgnoreCase("yes"))
					{
						System.out.println("Enter a color: ");
						userColor=keyboard.next();
						inList=Colors.findValue(userColor);
					}
					else
					{
						System.out.println("Bye!");
						System.exit(0);
					}
				}
				
				
				}

			
			
		}//End of Main
	
	
	
	
	

}//End of Class
