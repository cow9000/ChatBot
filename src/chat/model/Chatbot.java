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
		this.content = "I love money";
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
		
		input = input.replace(" ", "");
		String[] htmlArray = input.split("");
		
		//These are if it has the "<",">" and "<","/",">"
		boolean hasOpeningOpenBracket = false;
		
		boolean hasHtmlElementOpen = false;
		
		
		boolean hasEquals = false;
		
		boolean hasOpenQuote = false;
		boolean hasCloseQuote = false;
		
		
		
		
		boolean hasOpeningCloseBracket = false;
		boolean hasEndingOpenBracket = false;
		boolean hasEndingSlash = false;
		
		boolean hasHtmlElementClose = false;
		
		boolean hasEndingCloseBracket = false;
		
		boolean cancel = false;
		
		
		//Check if it has any equals, then check if they all have "" in that section

		
		for(int i = 0; i < htmlArray.length; i++) {
			
			if(!cancel) {
			
				//First check if it has an opening bracket
				if(!hasOpeningOpenBracket) {
					
					if(htmlArray[i].equalsIgnoreCase("<")) {
						hasOpeningOpenBracket = true;
					}
					
					
				}
				
				else if(hasOpeningOpenBracket) {
					
					//CHECK IF HTML ELEMENT IS INSIDE and Equals has already been defined
					
					if(!hasHtmlElementOpen && !hasEquals) {
						if(!htmlArray[i].equalsIgnoreCase(">") || !htmlArray[i].equalsIgnoreCase("=") || !htmlArray[i].equalsIgnoreCase("/")) {
							hasHtmlElementOpen = true;
						}else {
							//This tag is invalid
							cancel = true;
						}
					}
					//IF IT DOES HAVE A HTML ELEMENT
					else if(hasHtmlElementOpen) {
						//IF it has an equal sign in it
						if(htmlArray[i].equalsIgnoreCase("=") && !hasOpeningCloseBracket) {
							//So if the HTML element has not been closed yet
							if(!hasEquals) {
								hasEquals = true;
							}
						}
						//If it has an equals sign in it and an opening/ending quote
						else if(htmlArray[i].equalsIgnoreCase("\"") && hasEquals && !hasOpeningCloseBracket) {
							//If it does have an open quote
							if(!hasOpenQuote) {
								hasOpenQuote = true;
							}
							//If it has an open quote but doesn't have a close quote
							else if(!hasCloseQuote) {
								hasCloseQuote = true;
							}
							 
						}
						
						//If it has a closing
						else if(htmlArray[i].equalsIgnoreCase(">") && !hasOpeningCloseBracket) {
							hasOpeningCloseBracket = true;
						}
						
						
						//Finally if it does have a close bracket
						if(hasOpeningCloseBracket) {
							
							//If it does not have a close bracket
							if(!hasEndingOpenBracket) {
								//Check if it does have an Opening Close Bracket
								if(htmlArray[i].equalsIgnoreCase("<")) {
									hasEndingOpenBracket = true;
								}
							}
							//If it does have a close Bracket Opening
							else if(hasEndingOpenBracket) {
								
								//if it doesn't have a slash check
								if(!hasEndingSlash && !hasHtmlElementClose) {
									if(htmlArray[i].equalsIgnoreCase("/")) {
										hasEndingSlash = true;
									}
								}
								
								//If it does have an ending slash
								else if(hasEndingSlash) {
									//If it doesnt have the html element close
									if(!hasHtmlElementClose) {
										
										//Check if it has the html element
										if(!htmlArray[i].equalsIgnoreCase(">")) {
											hasHtmlElementClose = true;
										}
									}
									
									//If it does have the html element close
									else if(hasHtmlElementClose) {
										//Check for close
										if(htmlArray[i].equalsIgnoreCase(">")) {
											hasEndingCloseBracket = true;
										}
									}
									
								}
								
							}
							
							
							
							
							
						}
						
						
						
						
						
					}
					
					
				}
			
			}
	
			
		}
		
		if(hasOpeningOpenBracket) {
			System.out.println("1");
			if(hasHtmlElementOpen) {
				System.out.println("2");
				if(hasOpeningCloseBracket) {
					System.out.println("3");
					if(hasEndingOpenBracket) {
						System.out.println("4");
						if(hasEndingSlash) {
							System.out.println("5");
							if(hasHtmlElementClose) {
								System.out.println("6");
								if(hasEndingCloseBracket) {
									System.out.println("7");
									
									if(hasEquals) {
										if(hasOpenQuote) {
											if(hasCloseQuote) {
												isHTML = true;
											}
										}
									}else {
										isHTML = true;
									}
								}
							}
						}
					}
				}
			}
		}
		
		
		
		
		return isHTML;
	}
	
	public boolean userNameChecker(String input)
	{
		boolean response = false;
		if(input != null) {
			//@ <- in @@@@h2
			if(input.startsWith("@")) {
				response = true;
				int count = 0;
				char symbol = '@';
				//Count Symbol
				for(int i = 0; i < input.length(); i++) {
					
					if(input.charAt(i) == symbol) {
						count+=1;
					}
				}
				
				//If it does
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
		if(contentCheck != null) {
			
			String[] contentArray = contentCheck.split(" ");
			
			if(contentArray.length > 1) {
				response = true;
			}
		}
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
		//Loop through
		for(String item : shoppingList) {
			//Check
			if(shoppingItem.contains(item)) {
				response = true;
				break;
			}
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
