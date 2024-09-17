//KyleHix
//Copyright 2024
//HW04
import java.io.File;
import java.util.Scanner;
public class Main 
{
	static Scanner keyboard=new Scanner(System.in);

	public static void main(String[] args) 
	{
		//User Prompts
		System.out.println("Enter the name of a Java source file to check.");
		String fileName=keyboard.nextLine();
		
		MyStack<CharacterInFile> fileStack = new MyStack<CharacterInFile>();
		CharacterInFile openSymbol=null;
		int lineNumber=0;
		
		//Taking in Data
		try 
		{
			Scanner inputFile = new Scanner(new File(fileName));
			while(inputFile.hasNext())
			{
				String temp=inputFile.nextLine();
				lineNumber++;
				for(int i=0;i<temp.length();i++)
				{
					char tempChar=temp.charAt(i);
					
					//Pushing Open Group Symbols onto Stack
					if(temp.charAt(i)=='('||temp.charAt(i)=='{'||temp.charAt(i)=='[')
					{
						openSymbol=new CharacterInFile(tempChar, lineNumber, i);
						fileStack.Push(openSymbol);
					}
					
					//Check if Closing match
					
					//"()"
					if(temp.charAt(i)==')')
					{
						CharacterInFile peek = fileStack.Peek();
						if(peek==null)
						{
							System.out.println(temp.charAt(i)+ " on line "+lineNumber+" in column "+(i+1)+" is invalid."+
									" It has no corresponding open character to close.");
							System.exit(0);
						}
						else 
						{
							char peekValue=peek.getCharacter();
							int peekLine=peek.getLineNumber();
							int peekColumn=peek.getCharColumn()+1;
								
							if(peekValue=='(')
							{
								fileStack.Pop();
							}
							else
								{
									System.out.println(temp.charAt(i)+" on line "+lineNumber+" in column "+(i+1)+""
											+ " is invalid. Expected a close for the character "+peekValue+" on line "+peekLine+
											" in column "+ peekColumn );
									System.exit(0);

								}//Inner else
						}//Outer else
					}//end of if
					
					
					//"{}"
					if(temp.charAt(i)=='}')
					{
						CharacterInFile peek = fileStack.Peek();
						if(peek==null)
						{
							System.out.println(temp.charAt(i)+ " on line "+lineNumber+" in column "+(i+1)+" is invalid."+
									" It has no corresponding open character to close.");
							System.exit(0);

						}
						else 
						{
							char peekValue=peek.getCharacter();
							int peekLine=peek.getLineNumber();
							int peekColumn=peek.getCharColumn()+1;
							if(peekValue=='{')
							{
								fileStack.Pop();
							}
							else
							{
								System.out.println(temp.charAt(i)+" on line "+lineNumber+" in column "+(i+1)+""
										+ " is invalid. Expected a close for the character "+peekValue+" on line "+peekLine+
										" in column "+ peekColumn );
								System.exit(0);

							}//Inner else
						}//Outer else
					}//end of else if
					
					
					//"[]"
					if(temp.charAt(i)==']')
					{
						CharacterInFile peek = fileStack.Peek();
						if(peek==null)
						{
							System.out.println(temp.charAt(i)+ " on line "+lineNumber+" in column "+(i+1)+" is invalid."+
									" It has no corresponding open character to close.");
							System.exit(0);

						}
						else 
						{
							char peekValue=peek.getCharacter();
							int peekLine=peek.getLineNumber();
							int peekColumn=peek.getCharColumn()+1;
							if(peekValue=='[')
							{
								fileStack.Pop();
							}
							else
							{
								System.out.println(temp.charAt(i)+" on line "+lineNumber+" in column "+(i+1)+""
										+ " is invalid. Expected a close for the character "+peekValue+" on line "+peekLine+
										" in column "+ peekColumn );
								System.exit(0);

							}//Inner else
						}//Outer else
					}//end of else if
					
				//Checking for Unclosed grouping symbols
					
					
				}//End of For Loop				
				
				
			}//End of While loop
			CharacterInFile peek=fileStack.Peek();
			if(peek!=null)
			{
				//CharacterInFile peek=fileStack.Peek();
				char peekValue=peek.getCharacter();
				int peekLine=peek.getLineNumber();
				int peekColumn=peek.getCharColumn()+1;
				System.out.println("Missing closing symbol for character "+peekValue+" on line "+ peekLine+" in column "+peekColumn);
			}
			else
				System.exit(0);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
		
	}//End of Main Method

}//End of Class
