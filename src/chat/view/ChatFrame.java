package chat.view;

import javax.swing.JFrame;

import chat.controller.ChatbotController;

public class ChatFrame extends JFrame 
{
	
	ChatbotController baseController;
	
	public ChatFrame(ChatbotController chatbotController)
	{
		this.baseController = chatbotController;
	}

	
	
	public ChatbotController getBaseController()
	{
		return baseController;
	}

}
