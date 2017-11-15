package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatFrame;
import chat.view.PopupDisplay;

public class ChatbotController
{
	Chatbot chatbot;
	PopupDisplay display;
	ChatFrame appFrame;
	
	public ChatbotController(){
		display = new PopupDisplay();
		chatbot = new Chatbot("username goes here");
		appFrame = new ChatFrame(this);
	}
	
	public void start() {
		//String response = display.collectResponse("What do you want to talk about?");
		
		/*while(chatbot.lengthChecker(response) && !chatbot.quitChecker(response)) {
			response = popupChat(response);
			response = display.collectResponse(response);
		}*/
		
	}

	public String interactWithChatbot(String string)
	{
		String message = "Sorry, I don't understand";
		
		if(string != null) {
			
		}
		
		return message;
	}
	
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
