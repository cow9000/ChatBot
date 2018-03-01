package chat.model;

import java.util.ArrayList;
import java.util.List;

import chat.controller.ChatbotController;
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
	
}
