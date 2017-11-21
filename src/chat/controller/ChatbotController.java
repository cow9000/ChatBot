package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatFrame;
import chat.view.PopupDisplay;

/**
 * Manages the chatbot application ining the Model and Frame of the View package
 * @author Derek Vawdrey
 * @version 11/21/17
 */


public class ChatbotController
{
	Chatbot chatbot;
	PopupDisplay display;
	ChatFrame appFrame;
	
	/**
	 * This is the constructor for the ChatbotController
	 */
	public ChatbotController(){
		display = new PopupDisplay();
		chatbot = new Chatbot("username goes here");
		appFrame = new ChatFrame(this);
	}
	
	
	/**
	 * This asks the user what it wants to talk about and checks if it was a valid input
	 */
	public void start() {
		display.displayText("Testing");
		
	}
	
	/**
	 * Calls interactWithChatbot
	 * @param string input grabs the users input.
	 * @return returns the message
	 */

	public String interactWithChatbot(String string)
	{
		String message = "";
		
		if(chatbot.quitChecker(string)) {
			close();
		}
		
		message += chatbot.processConversation(string);
		
		return message;
	}
	
	
	private void close() {
		display.displayText("Peace mah homies");
		System.exit(0);
	}
	
	/**
	 * calls the popupChat
	 * @param chat Input from user
	 * @return returns what the chatbot says
	 */
	private String popupChat(String chat) {
		String chatbotSays = "";
		chatbotSays += chatbot.processConversation(chat);
		return chatbotSays;
	}
	

	public Chatbot getChatbot()
	{
		return chatbot;
	}
	
	public PopupDisplay getDisplay() {
		return display;
	}
	
	public ChatFrame getChatFrame()
	{
		return appFrame;
	}
}
