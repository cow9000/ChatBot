package chat.view;

import java.awt.Dimension;

import javax.swing.JFrame;

import chat.controller.ChatbotController;

public class ChatFrame extends JFrame 
{
	
	ChatbotController appController;
	ChatPanel appPane;
	
	/**
	 * This is the constructor, it holds all the defined variables. The controllhas defined appController
	 * @param appController Links the panel, frame and controller
	 */
	public ChatFrame(ChatbotController appController)
	{
		
		super();
		this.appController = appController;
		this.appPane = new ChatPanel(appController);

		setupFrame();
	}
	/**
	 * This method sets up the frame needed to put the GUI code into
	 */
	private void setupFrame() {
		this.setContentPane(appPane);
		
		this.setResizable(false);
		this.setTitle("Chatbot 2017");
		this.setSize(getPreferredSize());
		
		this.setVisible(true);
	}

	/**
	 * This method gets the appController
	 * @return returns the appController
	 */
	
	public ChatbotController getBaseController()
	{
		return appController;
	}
	
	
	@Override
	public Dimension getMinimumSize() {
		Dimension size = new Dimension(600,600);
		return size;
	}
	
	
	@Override
	public Dimension getPreferredSize() {
		Dimension size = new Dimension(600,600);
		return size;
	}
	
	@Override
	public Dimension getMaximumSize() {
		Dimension size = new Dimension(800,800);
		return size;
	}
	


}
