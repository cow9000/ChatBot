package chat.view;

import javax.swing.JPanel;

import chat.controller.ChatbotController;

public class ChatPanel extends JPanel
{

	ChatbotController baseController;
	
	public ChatPanel(ChatbotController chatbotController)
	{
		this.baseController = chatbotController;
	}

}
