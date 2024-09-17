//Kyle Hix
//Copyright 2024
//HW03


public class Contact 
{
	//Instance Variables
	private String name;
	private String contactInfo;
	
	//Constructors
	public Contact()
	{
		this.name="Unknown";
		this.contactInfo="Unknown";
	}
	
	//Parameterized Constructor
	public Contact(String aN, String cI)
	{
		this.name=aN;
		this.contactInfo=cI;
	}
	//Accessors and Mutators
	//Name
	public String getName() 
	{
			return name;
	}

	public void setName(String name) 
	{	if(this.name==null)
			this.name="Unknown";
		else
			this.name = name;
	}
	//Contact Info
	public String getContactInfo() 
	{
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) 
	{
		if(this.contactInfo==null)
			this.contactInfo="Unknown";
		else
			this.contactInfo = contactInfo;
	}
	//toString Method
	public String toString()
	{
		return "Contact Name: "+
				this.name +
				", Info: "+
				this.contactInfo;
	}
	//Equals Method
	public boolean equals(Contact aC)
	{
		return aC!=null&&
				this.name.equals(aC.getName())&&
				this.contactInfo.equals(aC.getContactInfo());
	}
	


}//End of Class
