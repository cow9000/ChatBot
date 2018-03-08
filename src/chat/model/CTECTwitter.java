package chat.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import chat.controller.ChatbotController;
import chat.controller.IOController;
import twitter4j.Paging;
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
		
		return mostCommon;
	}
	
	private void removeBlanks() {
		
	}
	
	private void generateWordCount() {
		
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
			String tweetText = currentStatus.getText();
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
	
}
