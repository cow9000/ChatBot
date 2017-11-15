package chat.view;

import java.awt.Dimension;

import javax.swing.JFrame;

import chat.controller.ChatbotController;

public class ChatFrame extends JFrame 
{
	
	ChatbotController appController;
	ChatPanel appPane;
	
	
	public ChatFrame(ChatbotController appController)
	{
		
		super();
		this.appController = appController;
		this.appPane = new ChatPanel(appController);

		setupFrame();
	}
	
	private void setupFrame() {
		this.setContentPane(appPane);
		
		this.setResizable(false);
		this.setTitle("Chatbot 2017");
		this.setSize(getPreferredSize());
		
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
