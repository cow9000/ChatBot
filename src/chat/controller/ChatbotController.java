package chat.controller;

import chat.model.CTECTwitter;
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
	CTECTwitter myTwitter;
	Chatbot chatbot;
	PopupDisplay display;
	ChatFrame appFrame;
	
	/**
	 * This is the constructor for the ChatbotController
	 */
	public ChatbotController(){
		myTwitter = new CTECTwitter(this);
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
	
	/**
	 * Closes the chatbot application
	 */
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
	
	/**
	 * Returns the chatBot object
	 * @return chatbot object
	 */
	public Chatbot getChatbot()
	{
		return chatbot;
	}
	/**
	 * Get the popup display
	 * @return returns display
	 */
	public PopupDisplay getDisplay() {
		return display;
	}
	/**
	 * Return the chat frame for the GUI
	 * @return return appFrame
	 */
	public ChatFrame getChatFrame()
	{
		return appFrame;
	}
	/**
	 * Uses the checkers in the chatBot application
	 * @param text
	 * @return
	 */
	public String useCheckers(String text) {
		String response = "";
		
		if(chatbot.contentChecker(text)) {
			response += "This text matches the special content\n";
		}
		
		if(chatbot.cuteAnimalMemeChecker(text)) {
			response += "";
		}
		
		return response;
	}
	
	public void handleErrors(Exception error) {
		display.displayText(error.getMessage());
	}
	
	public void tweet(String text) {
		myTwitter.sendTweet(text);
	}
	
}
