package chat.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Chatbot
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.currentTime = LocalTime.now();
		this.questions = new String[10];
		this.username = username;
		this.content = "";
		this.intro = "";
		this.topics = new String[4];
		this.verbs = new String[4];
		this.followUps = new String[5];
		
		buildVerbs();
		buildMovieList();
		buildShoppingList();
		buildCuteAnimals();
		buildQuestions();
		
	}
	
	public String toString() {
		String response = "YOU ARE A CHICKEN";
		return response;
	}
	
	private void buildVerbs() {
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalent about";
		verbs[3] = "am thinking about";
	}
	

	private void buildMovieList()
	{
		movieList.add(new Movie("Lord Of The Rings"));
		movieList.add(new Movie("Lord Of The Rings"));
		movieList.add(new Movie("Lord Of The Rings"));
		movieList.add(new Movie("Lord Of The Rings"));
		movieList.add(new Movie("Lord Of The Rings"));
	}
	
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protein");
		shoppingList.add("garbage");
		shoppingList.add("CHOCOLATE");
		shoppingList.add("Tuna");
		shoppingList.add("garbage");
		shoppingList.add("monkies");
		shoppingList.add("pizza");
		shoppingList.add("money");
		shoppingList.add("ham");
		shoppingList.add("turkey");
	}
	
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("pupper");
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("kittie");
	}
	
	private void buildQuestions()
	{
		questions[0] = "Whats your name?";
		questions[1] = "What do you do?";
		questions[2] = "You know English?";
		questions[3] = "Do you eat food?";
		questions[4] = "What's your favorite food?";
		questions[5] = "Monkey or Dogeroni?";
		questions[6] = "Llama of Camel?";
		questions[7] = "Do you like me?";
		questions[8] = "This is a sentence?";
		questions[9] = "This isn't a sentence?";

	}
	
	public String processConversation(String input)
	{
		return null;
	}
	
	public boolean lengthChecker(String input)
	{
		boolean longEnough = false;
		
		if(input != null && input.length() > 2) {
			longEnough = true;
		}
		
		
		
		return longEnough;
	}
	
	public boolean htmlTagChecker(String input)
	{
		
		boolean isHTML = false;
		
		
		
		
		return isHTML;
	}
	
	public boolean userNameChecker(String input)
	{
		boolean response = false;
		if(input != null) {
			if(input.startsWith("@")) {
				response = true;
				int count = 0;
				char symbol = '@';
				for(int i = 0; i < input.length(); i++) {
					
					if(input.charAt(i) == symbol) {
						count+=1;
					}
				}
				
				if(count > 1) {
					System.out.print(count);
					response = false;
				}
				
				
			}
		}
		return response;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		return false;
	}
	
	public boolean movieTitleChecker(String title)
	{
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

	public boolean quitChecker(String exitString)
	{
		return false;
	}

	public boolean keyboardMashChecker(String sample)
	{
		return false;
	}
	
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		return null;
	}
	
	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return null;
	}
	
	public LocalTime getCurrentTime()
	{
		return null;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}
