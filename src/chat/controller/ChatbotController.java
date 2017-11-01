package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatFrame;
import chat.view.PopupDisplay;

public class ChatbotController
{
	Chatbot chatbot;
	PopupDisplay display;
	ChatFrame frame;
	
	public void start() {
		display = new PopupDisplay();
		chatbot = new Chatbot("username goes here");
		//frame = new ChatFrame(this);
	}

	public String interactWithChatbot(String string)
	{
		String message = "hi";
		
		return message;
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
		return frame;
	}
}
