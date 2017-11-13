package chat.view;

import java.awt.Dimension;

import javax.swing.JFrame;

import chat.controller.ChatbotController;

public class ChatFrame extends JFrame 
{
	
	ChatbotController appController;
	ChatPanel panel;
	
	
	public ChatFrame(ChatbotController chatbotController)
	{
		
		super();
		this.appController = chatbotController;
		this.panel = new ChatPanel(chatbotController);

		setupFrame();
	}
	
	private void setupFrame() {
		this.setContentPane(panel);
		
		this.setTitle("");
		this.setSize(100,100);
		
		this.setVisible(true);
	}

	
	
	public ChatbotController getBaseController()
	{
		return appController;
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
