//KyleHix
//CopyRight 2024
public class SearchTerm implements Comparable<SearchTerm>
{
	//Instance Variables
	private String term;
	private int numOfSearchs;
	
	//Constructors
	public SearchTerm()
	{
		this.term="null";
		this.numOfSearchs=0;
	}
	//Parameters
	public SearchTerm(String aT, int aNum)
	{
		this.term=aT;
		this.numOfSearchs=aNum;
	}
	//Accessors and Mutators
	//Term
	public String getTerm() 
	{
		return term;
	}
	public void setTerm(String term) 
	{
		this.term = term;
	}
	//NumOfSearchs
	public int getNumOfSearchs() 
	{
		return numOfSearchs;
	}
	public void setNumOfSearchs(int numOfSearchs) 
	{
		if(numOfSearchs>=0)
			this.numOfSearchs = numOfSearchs;
		else
			this.numOfSearchs=0;
	}
	//toString
	public String toString()
	{
		return  
				"Term: "+this.term +
				" | Number of Searchs: "+ this.numOfSearchs;
	}
	//equals method
	public boolean equals(SearchTerm ST)
	{
		return ST!=null&&
				this.term.equals(ST.getTerm())&&
				this.numOfSearchs==(ST.getNumOfSearchs());
		
	}
	//Comparable Method
		public static SearchTerm sort;
		public int compareTo(SearchTerm ST)
		{
			return 
					this.term.compareTo(ST.term);
		}
	
	
	
	
}//End of Class
