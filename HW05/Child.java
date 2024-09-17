//KyleHix
//Copyright 2024
public class Child  implements Comparable<Child>
{
	
	//Variables
	private String name;
	private int numberOfCandy;
	
	//Constructors
	public Child()
	{
		this.name="Unknown";
		this.numberOfCandy=0;
	}
	
	public Child(String aN, int aC)
	{
		this.name=aN;
		this.numberOfCandy=aC;
	}

	//Accessors and Mutators
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		if(this.name==null)
			this.name="Unknown";
		else
			this.name = name;
	}

	public int getNumberOfCandy() {
		return numberOfCandy;
	}

	public void setNumberOfCandy(int numberOfCandy) 
	{
		if(numberOfCandy<0)
			this.numberOfCandy=0;
		else
			this.numberOfCandy = numberOfCandy;
	}

	//toString
	public String toString() 
	{
		return this.name+" has "+ this.numberOfCandy+" pieces of candy.\n ";
	}
	
	//Equals
	public boolean equals(Child aC)
	{
		return aC!=null&&
				this.name.equals(aC.getName())&&
				this.numberOfCandy==(aC.getNumberOfCandy());
	}
	
	//CompareTo
	public int compareTo(Child C)
	{
		if(this.numberOfCandy==C.numberOfCandy)
			return 0;
		else if(this.numberOfCandy>C.numberOfCandy)
			return 1;
		else
			return -1;
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
}//End of Class
