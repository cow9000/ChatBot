package chat.view;

import java.awt.ComponentOrientation;
import java.awt.Dimension;

import javax.swing.JFrame;

import chat.controller.ChatbotController;

public class ChatFrame extends JFrame 
{
	
	ChatbotController baseController;
	ChatPanel panel;
	
	
	public ChatFrame(ChatbotController chatbotController)
	{
		this.baseController = chatbotController;
		this.panel = new ChatPanel(chatbotController);

		setSettings();
	}
	
	private void setSettings() {
		this.setContentPane(panel);
		
		this.setTitle("Chatbot");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setMinimumSize(getSize());
		this.setSize(getPreferredSize());
		
		this.setResizable(false);
		this.applyComponentOrientation(
			    ComponentOrientation.getOrientation(
			            panel.getLocale()));
		this.setVisible(true);
		
		
		pack();
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
