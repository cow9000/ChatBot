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
		buildTopics();
		buildFollowups();
		buildQuestions();
		buildShoppingList();
		
		buildMovieList();
		
		buildCuteAnimals();
		
		
		
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
	
	public void buildTopics() {
		topics[0] = "John Cena";
		topics[1] = "Harry Potter";
		topics[2] = "Donald Trump";
		topics[3] = "Tuna";
	}
	
	public void buildFollowups() {
		followUps[0] = "";
		followUps[1] = "";
		followUps[2] = "";
		followUps[3] = "";
		followUps[4] = "";
	}

	private void buildMovieList()
	{
		movieList.add(new Movie("Lord Of The Rings"));
		movieList.add(new Movie("Lord Of The Rings"));
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
		cuteAnimalMemes.add("floofer");
	}
	
	private void buildQuestions()
	{
		questions[0] = "Whats your name?";
		questions[1] = "What do you do?";
		questions[2] = "You know English?";
		questions[3] = "Do you eat food?";
		questions[4] = "What's your favorite food?";
		questions[5] = "Monkey or Dogeroni?";
		questions[6] = "Llama or Camel?";
		questions[7] = "Do you like me?";
		questions[8] = "Who are you?";
		questions[9] = "What is wrong with you?";

	}
	
	private String buildChatbotResponse() {
		String response = "I ";
		
		int random = (int) (Math.random() * verbs.length);
		
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		
		response += " " + topics[random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		return response;
	}
	
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse += "You said:" + "\n" + input + "\n";
		
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
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
		boolean response = false;
		
		return response;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		boolean response = false;
		for(String meme : cuteAnimalMemes) {
			if(meme.equalsIgnoreCase(input)) {
				response = true;
			}
		}
		return response;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		boolean response = false;
		if(!shoppingItem.equalsIgnoreCase("slug bait")) {
			response = true;
		}
		return response;
	}
	
	public boolean movieTitleChecker(String title)
	{
		boolean response = false;
		if(title != null) {
			if(!title.equals("")) {
				if((title.length() > 0)) {
					response = true;
				}
			}
		}
		return response;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		boolean response = false;
		if(genre != null) {
			if(!genre.equals("")) {
				if((genre.length() > 0)) {
					response = true;
				}
			}
		}
		return response;
	}

	public boolean quitChecker(String exitString)
	{
		boolean response = false;
		if(exitString != null) {
			if(exitString.equalsIgnoreCase("quit")) {
				response = true;
			}
		}
		return response;
	}

	public boolean keyboardMashChecker(String sample)
	{
		boolean response = false;
		
		String keyMash = "qwertyuiop[]\\asdfghjkl;'zxcvbnm,./";
		
		
		if(sample.length() < 4) {
			
			for(int i = 0; i < keyMash.length(); i++) {
				String keyMashType = Character.toString(keyMash.charAt(i));
				
				
				if(keyMashType.equalsIgnoreCase(Character.toString(sample.charAt(0)))) {
					
					if(Character.toString(sample.charAt(1)).equalsIgnoreCase(Character.toString(keyMash.charAt(i+1)))) {
						if(Character.toString(sample.charAt(2)).equalsIgnoreCase(Character.toString(keyMash.charAt(i+2)))) {
							response = true;
						}
					}
					else if(Character.toString(sample.charAt(1)).equalsIgnoreCase(Character.toString(keyMash.charAt(i-1)))) {
						if(Character.toString(sample.charAt(2)).equalsIgnoreCase(Character.toString(keyMash.charAt(i-2)))) {
							response = true;
						}
					}
					
					
					
				}
			}
		
		}
		
		return response;
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
		return questions;
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
		return intro;
	}
	
	public LocalTime getCurrentTime()
	{
		currentTime = LocalTime.now();
		return currentTime;
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
