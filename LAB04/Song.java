//Kyle Hix
//Copyright 2024
//Song Class Lab04
public class Song 
{
	//Instance Variables
	private String title;
	private String genre;
	private String artist;
	private int songLength;
	
	//Constructors
	public Song()
	{
		this.title="Unknown";
		this.genre="Unknown";
		this.artist="Unknown";
		this.songLength=1;
	}
	
	//Parameterized Constructors
	public Song(String aT, String aG, String aA, int sL)
	{
		this.title=aT;
		this.genre=aG;
		this.artist=aA;
		this.songLength=sL;
	}
	
	//Accessors and Mutators
		//title
	public String getTitle() 
	{
		return title;
	}
	public void setTitle(String title) 
	{	if(this.title.equals(null))
			{this.title="Unknown";}
		else
			this.title = title;
	}
		//genre
	public String getGenre() 
	{
		return genre;
	}
	public void setGenre(String genre) 
	{	if(this.genre.equals(null))
			this.genre="Unknown";
		else
			this.genre = genre;
	}
		//Artist
	public String getArtist() 
	{
		return artist;
	}
	public void setArtist(String artist) 
	{	if(this.artist.equals(null))
			this.artist="Unknown";
		else
			this.artist = artist;
	}
		//SongLength
	public int getSongLength() 
	{
		return songLength;
	}
	public void setSongLength(int songLength) 
	{	if(this.songLength<=0)
			this.songLength=1;
		else
			this.songLength = songLength;
	}
	
	//toString
	public String toString()
	{
		return this.title +"\t" + this.genre+"\t " +this.artist+"\t" +this.songLength+"s"+"\n";
	}
	
	
	//Equals
	public boolean equals(Song aS)
	{
		return aS!=null &&
				this.title.equals(aS.getTitle())&&
				this.genre.equals(aS.getGenre())&&
				this.artist.equals(aS.getArtist())&&
				this.songLength==aS.getSongLength();
	}
	
	

}//End of class
