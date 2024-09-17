//Kyle Hix
//Copyright 2024
public class Assignment implements Comparable<Assignment>
{
	private String title;
	private int number;
	private double gradePercent;
	
	//enum
	public enum Values{
		TITLE, ASSIGNMENT_NUMBER, PERCENT_OF_GRADE}
	public static Values data = Values.TITLE;
	
	//compareTo method
	public int compareTo(Assignment a) 
	{
		if(data == Values.TITLE)
		{
			return this.title.compareTo(a.title);
		}
		if(data==Values.ASSIGNMENT_NUMBER)
			{
				if(this.number==a.number)
					return 0;
				else if(this.number>a.number)
					return 1;
				else
					return -1;
			}
		if(data==Values.PERCENT_OF_GRADE)
		{
			if(this.gradePercent==a.gradePercent)
				return 0;
			else if(this.gradePercent>a.gradePercent)
				return 1;
			else
				return -1;
		}
		return 0;
		}
			//return this.title.compareTo(a.title);
		
			
 
		
			
	
			
	
	//Constructors
	public Assignment()
	{
		this.title="null";
		this.number=0;
		this.gradePercent=0.0;
	}
	//Parameters
	public Assignment(String aT, int aN, double aSG) 
	{
		this.setTitle(aT);
		this.setNumber(aN);
		this.setGradePercent(aSG);
	}
	//Accessors and Mutators
	
	//Title
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	//Number
	public int getNumber() {
		return this.number;
	}
	public void setNumber(int number) {
		if (number<0)
			this.number=0;
		else
			this.number = number;
	}
	//Grade-Percent
	public double getGradePercent() {
		return this.gradePercent*100.0;
	}
	public void setGradePercent(double gradePercent) 
	{	if(gradePercent<0||gradePercent>1)
			this.gradePercent=0.0;
		else
			this.gradePercent = gradePercent*100;
	}
	//toString Method
	public String toString()
	{
		return 
		"Title:" +this.title +
		" | Assignment Number: "+ this.number +
		" | Percent of Grade: "+ this.gradePercent+"%"; 
	}
	public boolean equals(Assignment aC)
	{
		return aC!=null&&
				this.title.equals(aC.getTitle())&&
				this.number==(aC.getNumber())&&
				this.gradePercent==(aC.getGradePercent());
	}
	
	
	
	
	
}
