//KyleHix
//Copyright 2024
//Lab04
import java.io.*;
import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		//Part 1: Uploading Songs from Text and Storing into a Playlist
		Song inputSong=null;
		Queue<Song> songList=new Queue<Song>();
		try 
		{
		Scanner inputFile = new Scanner(new File("playlist.txt"));
			while(inputFile.hasNext())
			{

				String nextSong=inputFile.nextLine();//Reading each line
				
				//Array for file data
				String [] fields=nextSong.split("\t");//Storing name and info into separate chunks
				inputSong=new Song(fields[0], fields[1], fields[2], Integer.parseInt(fields[3]));
				songList.enqueue(inputSong);
			}//End of While

		inputFile.close();
		
		}//End of Try
		catch (Exception e)
		{
			e.printStackTrace();
		}//End of catch

		//Part 2:
		//User Prompts
		Scanner keyboard=new Scanner(System.in);
			//Creating user-playlist
		Queue<Song> playlist=new Queue<Song>();
		Queue<Song> exPlaylist=new Queue<Song>();
		
		System.out.println("How long of a playlist do you need (in minutes)?");
		double userTime=keyboard.nextDouble();
		userTime=userTime*60;//Converting to seconds
		
		System.out.println("Is there any song, artist, or genre of music you don't want to hear?");
		String exclusionAnswer=keyboard.next();
		
		String exSong=null;
		String exArtist=null;
		String exGenre=null;
		if(exclusionAnswer.equalsIgnoreCase("yes"))
		{
			System.out.println("Enter 1 to exclude a song, 2 to exclude an artist, or 3 to exclude a genre");
			int exclusionType=keyboard.nextInt();
			keyboard.nextLine();
			
			switch(exclusionType) 
			{
			case(1):
				System.out.println("Enter the song to exclude.");
				exSong=keyboard.nextLine();
				break;
			case(2):
				System.out.println("Enter the artist to exclude.");
				exArtist=keyboard.nextLine();
				break;
			case(3):
				System.out.println("Enter the genre to exclude.");
				exGenre=keyboard.nextLine();
				break;
			}//End of Switch
		
		}//End of if yes or no
		else
		{
			
		}
		
		//Adding songs to the user-playlist

		double playListTime = 0;
		while(playListTime<=userTime)
		{
		
		Song temp=songList.peek();
		if(temp==null)
			break;
		if(temp.getTitle().equalsIgnoreCase(exSong)||temp.getArtist().equalsIgnoreCase(exArtist)||temp.getGenre().equalsIgnoreCase(exGenre))
		{
			exPlaylist.enqueue(temp);
			songList.dequeue();
			playListTime=playListTime+temp.getSongLength();
		}
		else
		{
			playlist.enqueue(temp);
			songList.dequeue();
			playListTime=playListTime+temp.getSongLength();
		}

		}//End of While
		double fTime=playListTime/60;
		System.out.println("The playlist created for you in the file userplaylist.text is "+fTime+" minutes long");
		
		
		//Exporting
				try {
					PrintWriter outputFile = new PrintWriter(new FileOutputStream(new File("userplaylist.txt")));
				
						outputFile.println(playlist);
					
					
					outputFile.close();

				}
				catch (Exception e) {
					e.printStackTrace();
				}
				try {
					PrintWriter outputFile = new PrintWriter(new FileOutputStream(new File("unexaminedsongs.txt")));
				
						outputFile.println(songList);
					
					
					outputFile.close();

				}
				catch (Exception e) {
					e.printStackTrace();
				}
				try {
					PrintWriter outputFile = new PrintWriter(new FileOutputStream(new File("excludedsongs.txt")));
				
						outputFile.println(exPlaylist+"\t");
					
					
					outputFile.close();

				}
				catch (Exception e) {
					e.printStackTrace();
				}
				
				System.exit(0);
		
	}//End of Main

}//End of Class
