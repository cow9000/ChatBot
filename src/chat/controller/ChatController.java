package chat.controller;

import chat.view.PopupDisplay;

public class ChatController
{
	//Chatbot chatbot;
	PopupDisplay display;
	
	public void start() {
		display = new PopupDisplay();
		display.collectResponse("hu");
	}
}
