//Kyle Hix
//Copyright 2024
//Lab05

public class Package implements Comparable<Package>
{
	//Instance variables
	private String name;
	private double volume;
	private double weight;
	
	
	//Constructors
	public Package()
	{
		this.name="Unknown";
		this.volume=1.0;
		this.weight=1.0;
	}
	
	//Parameterized Constructor
	public Package(String aN, double aV, double aW)
	{
		this.name=aN;
		this.volume=aV;
		this.weight=aW;
	}
	
	//Accessors and Mutators
	
	//Name
	public String getName() {
		return name;
	}

	public void setName(String name) 
	{ if(this.name.equals(null))
		this.name="Unknown";
	else
		this.name = name;
	}

	//Volume
	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) 
	{
		if(this.volume<=0.0)
			this.volume=1.0;
		else
			this.volume=volume;
	}

	//Weight
	public double getWeight() 
	{
		return weight;
	}

	public void setWeight(double weight) 
	{
		if(this.weight<=0.0)
			this.weight=1.0;
		else
			this.weight = weight;
	}
	
	//toString
	public String toString()
	{
		return "For: "+this.name+"; Volume: "+this.volume+"; Weight: "+this.weight+"\n";
	}

	
	//Pulled Enum idea from lab01
	public enum sortOptions
	{
		NAME, VOLUME, WEIGHT
	}
	public static sortOptions userSort=sortOptions.NAME;
	
	//CompareTo
	public int compareTo(Package P)
	{
		if(userSort==sortOptions.NAME)
		{
			return this.name.compareTo(P.name);
		}
		if(userSort==sortOptions.VOLUME)
		{
			if(this.volume==P.volume)
				return 0;
			else if(this.volume>P.volume)
				return 1;
			else
				return -1;
		}
		if(userSort==sortOptions.WEIGHT)
		{
			if(this.weight==P.weight)
				return 0;
			else if(this.weight>P.weight)
				return 1;
			else
				return -1;
		}
		return 0;
	}
	
	
	
	
	
	
}//End of Class
