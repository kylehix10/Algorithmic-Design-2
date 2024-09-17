//KyleHix
//Copyright 2024

public class RequestedItem<T extends Comparable<T>>
{
	//Instance Variables
	String requestorName;
	String itemName;
	double price;
	
	//Constructors
	public RequestedItem()
	{
		requestorName="Unknown";
		itemName="Unknown";
		price=1.0;
	}
	//Parameterized Constructors
	public RequestedItem(String rN, String iN, double aP)
	{
		this.requestorName=rN;
		this.itemName=iN;
		this.price=aP;
	}
	
	//Accessors and Mutators
	public String getRequestorName() {
		return requestorName;
	}

	public void setRequestorName(String requestorName) 
	{	if(this.requestorName.equals(null))
			this.requestorName="Unknown";
		else
			this.requestorName = requestorName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		if(this.itemName.equals(null))
			this.itemName="Unknown";
		else
			this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) 
	{	if(this.price<0)
			this.price=1.0;
		else
			this.price = price;
	}
	
	//toString
	public String toString()
	{
		return this.requestorName+" "+this.itemName+" "+this.price;
	}
	
	public int compareTo(RequestedItem R)
	{
		if(this.price==R.price)
			{
			if(this.itemName.equals(R.itemName))
				return 0;
			else if(this.itemName.compareTo(R.itemName)>0)
				return 1;
			else 
				return -1;
			}
		else if(this.price>R.price)
			return 1;
		else 
			return -1;
		
	}
	
	
	
}//end of class
