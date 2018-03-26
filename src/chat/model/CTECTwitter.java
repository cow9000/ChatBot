package chat.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import chat.controller.ChatbotController;
import chat.controller.IOController;
import twitter4j.GeoLocation;
import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class CTECTwitter
{
	private ChatbotController appController;
	private Twitter chatbotTwitter;
	private List<Status> searchedTweets;
	private List<String> tweetedWords;
	private long totalWordCount;
	private HashMap<String,Integer> wordsAndCount;
	
	public CTECTwitter(ChatbotController appController) {
		this.appController = appController;
		this.chatbotTwitter = TwitterFactory.getSingleton();
		
		this.searchedTweets = new ArrayList<Status>();
		this.tweetedWords = new ArrayList<String>();
		this.wordsAndCount = new HashMap<String,Integer>();
		this.totalWordCount = 0;
		
		
	}
	
	public void sendTweet(String textToTweet) {
		try
		{
			chatbotTwitter.updateStatus(textToTweet + " @ChatbotCTEC");
			
			
		}catch(TwitterException tweetError) {
			appController.handleErrors(tweetError);
		}catch(Exception otherError){
			appController.handleErrors(otherError);
		}
	}
	
	public String getMostCommonWord(String username) {
		String mostCommon = "";
		
		collectTweets(username);
		turnStatusesToWords();
		totalWordCount = tweetedWords.size();
		
		String[] boring = createIgnoredWordArray();
		
		trimTheBoringWords(boring);
		removeBlanks();
		generateWordCount();
		
		ArrayList<Map.Entry<String, Integer>> sorted = sortHashMap();
		
		String mostCommonWord = sorted.get(0).getKey();
		int maxWord = 0;
		
		maxWord = sorted.get(0).getValue();
		
		mostCommon = "The most common word in " + username + "'s " + searchedTweets.size() + " tweets is " + mostCommonWord + ", and it was used " + maxWord + " times.\n This is " + 
		(DecimalFormat.getPercentInstance().format(((double)maxWord)/totalWordCount)) + " of total words: " + totalWordCount + " and it " + (DecimalFormat.getPercentInstance().format(((double)maxWord)/wordsAndCount.size()))
		+ " of the unique words: " + wordsAndCount.size();
		
		mostCommon += "\n\n" + sortedWords();
		
		return mostCommon;
	}
	
	private String sortedWords() {
		String allWords = "";
		
		String[] words = new String[wordsAndCount.size()];
		ArrayList<String> wordList = new ArrayList<String>(wordsAndCount.keySet());
		
		for(int index = 0 ; index < wordsAndCount.size(); index++) {
			words[index] = wordList.get(index);
		}
		
		for(int index = 0; index < words.length - 1; index++) {
			int maxIndex = index;
			for(int inner = index+1; inner < words.length; index++) {
				if(words[inner].compareTo(words[maxIndex]) > 0) {
					maxIndex = inner;
				}
			}
			
			String tempMax = words[maxIndex];
			words[maxIndex] = words[index];
			words[index] = tempMax;
			
		}
		
		for (String word : words) {
			allWords += word = ", ";
		}
		
		
		return allWords;
	}
	
	private ArrayList<Map.Entry<String, Integer>> sortHashMap(){
		ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String,Integer>>(wordsAndCount.entrySet());
		entries.sort((entry1,entry2)->entry2.getValue().compareTo(entry1.getValue()));
		
		return entries;
	}
	
	private void removeBlanks() {
		for(int index = tweetedWords.size() - 1; index>=0; index--) {
			if(tweetedWords.get(index).trim().length() == 0) {
				tweetedWords.remove(index);
			}
		}
	}
	
	private void generateWordCount() {
		for (String word : tweetedWords) {
			if(word != null) {
				if(!wordsAndCount.containsKey(word.toLowerCase())) {
					wordsAndCount.put(word.toLowerCase(), 1);
				}else {
					wordsAndCount.replace(word.toLowerCase(), wordsAndCount.get(word.toLowerCase()) + 1);
				}
			}
		}
	}
	
	private void trimTheBoringWords(String [] boringWords){
		for(int index = tweetedWords.size() - 1; index >= 0; index--){
			for(int removeIndex = 0; removeIndex < boringWords.length; removeIndex++) {
				if(tweetedWords.get(index).equals(boringWords[removeIndex])){
					tweetedWords.remove(index);
					removeIndex = boringWords.length;
				}
			}
		}
	}
	
	private void collectTweets(String username) {
		searchedTweets.clear();
		tweetedWords.clear();
		Paging statusPage = new Paging(1,100);
		int page = 1;
		long lastID = Long.MAX_VALUE;
		
		while(page <= 10) {
			statusPage.setPage(page);
			try {
				ResponseList<Status> listedTweets = chatbotTwitter.getUserTimeline(username, statusPage);
				for(Status current : listedTweets) {
					if(current.getId() < lastID) {
						searchedTweets.add(current);
						lastID = current.getId();
					}
				}
			}catch(TwitterException searchTweetError) {
				appController.handleErrors(searchTweetError);
			}
			page++;
		}
	}
	
	private void turnStatusesToWords() {
		for(Status currentStatus : searchedTweets) {
			String tweetText = currentStatus.getText().toLowerCase();
			tweetText = tweetText.replace("\n", " ");
			String[] tweetWords = tweetText.split(" ");
			for(int i = 0; i < tweetWords.length; i++) {
				tweetedWords.add(removePunctuation(tweetWords[i]).trim());
			}
		}
	}
	
	private String removePunctuation(String currentString) {
		String scrubbedString = "";
		
		String punctuation = ".,'?!:;\"() {}^[]<>-";
		
		for(int i = 0; i < currentString.length(); i++) {
			if(punctuation.indexOf(currentString.charAt(i)) == -1) {
				scrubbedString += currentString.charAt(i);
			}
		}
		
		
		return scrubbedString;
	}
	
	private String [] createIgnoredWordArray() {
		String [] boringWords;
		String fileText = IOController.loadFromFile(appController, "commonWords.txt");
		int wordCount = 0;
		
		Scanner wordScanner = new Scanner(fileText);
		
		while(wordScanner.hasNextLine()) {
			wordScanner.nextLine();
			wordCount++;
		}
		
		boringWords = new String[wordCount];	
		wordScanner.close();
		
		wordScanner = new Scanner(this.getClass().getResourceAsStream("data/CommonWords.txt"));
		for(int i = 0; i < boringWords.length; i++) {
			boringWords[i] = wordScanner.nextLine();
		}
		
		wordScanner.close();
		return boringWords;
		
	}
	
	public String analyzeTwitterForTopic(String topic) {
		String results = "";
		int tempTweets = 0;
		
		searchedTweets.clear();
		Query twitterQuery = new Query(topic);
		
		int resultMax = 750;
		long lastId = Long.MAX_VALUE;
		twitterQuery.setGeoCode(new GeoLocation(40.7608,  111.8910), 1000, Query.MILES);
		twitterQuery.setLang("en");
		
		ArrayList<Status> matchingTweets = new ArrayList<Status>();
		
		while(searchedTweets.size() < resultMax) {
			
			System.out.println("Tweets - " + searchedTweets.size());
			
			if(resultMax - searchedTweets.size() > resultMax) {
				twitterQuery.setCount(resultMax);
			}else {
				twitterQuery.setCount(resultMax - searchedTweets.size());
			}
			
			
			try {
				QueryResult resultingTweets = chatbotTwitter.search(twitterQuery);
				
				for(Status tweets : resultingTweets.getTweets()) {
					System.out.println(tweets);
					searchedTweets.add(tweets);
					if(tweets.getId() < lastId) lastId = tweets.getId();
				}
			}
			catch(TwitterException error) {
				appController.handleErrors(error);
			}
			
			twitterQuery.setMaxId(lastId - 1);
			
			if(searchedTweets.size() == tempTweets) break;
			tempTweets = searchedTweets.size();
		}
		
		results += "talk about the search results";

		//results += "Find a tweet that will pass one of the checkers in chatbot";
		for(int i = 0; i < searchedTweets.size(); i++) {
			if(	appController.useCheckers(searchedTweets.get(i).getText()).length() > 0) {
				matchingTweets.add(searchedTweets.get(i));
			}
		}
		
		if(matchingTweets.size() > 0) {
			int randomTweet = (int) (Math.random()*matchingTweets.size());
			results += matchingTweets.get(randomTweet).getText();
		}
		
		return results;
	}
	
}
