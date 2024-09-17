//KyleHix
//Copyright2024
public class CharacterInFile 
{
	//Instance Variables
	private char character;
	private int lineNumber;
	private int charColumn;
	
	//Constructors
	public CharacterInFile()
	{
		this.character='a';
		this.lineNumber=1;
		this.charColumn=1;		
	}
	
	//Parameterized Constructors
	public CharacterInFile(char aC, int lN, int cC)
	{
		this.character=aC;
		this.lineNumber=lN;
		this.charColumn=cC;
	}
	
	//Accessors and Mutators
	
	//Character
	public char getCharacter() 
	{
		return character;
	}

	public void setCharacter(char character) 
	{
		this.character = character;
	}

	//Line Number
	public int getLineNumber() 
	{
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) 
	{
		if(this.lineNumber<=0)
			this.lineNumber=1;
		else
			this.lineNumber = lineNumber;
	}

	//Character Column
	public int getCharColumn() 
	{
		return charColumn;
	}

	public void setCharColumn(int charColumn) 
	{
		if(this.charColumn<=0)
			this.charColumn=1;
		else
			this.charColumn = charColumn;
	}
	//toString (for testing purposes)
	public String toString()
	{
		return "char " + this.character+ " lNum "+this.lineNumber+" cNum "+this.charColumn;
	}	

}//End of Class
