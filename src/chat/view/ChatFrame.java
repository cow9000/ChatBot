package chat.view;

import java.awt.Dimension;

import javax.swing.JFrame;

import chat.controller.ChatbotController;

public class ChatFrame extends JFrame 
{
	
	ChatbotController baseController;
	ChatPanel panel;
	
	
	public ChatFrame(ChatbotController chatbotController)
	{
		
		super();
		this.baseController = chatbotController;
		this.panel = new ChatPanel(chatbotController);

		setupFrame();
	}
	
	private void setupFrame() {
		
	}

	
	
	public ChatbotController getBaseController()
	{
		return baseController;
	}
	
	
	@Override
	public Dimension getMinimumSize() {
		Dimension size = new Dimension(800,800);
		return size;
	}
	
	
	@Override
	public Dimension getPreferredSize() {
		Dimension size = new Dimension(800,800);
		return size;
	}
	
	@Override
	public Dimension getMaximumSize() {
		Dimension size = new Dimension(800,800);
		return size;
	}
	


}
