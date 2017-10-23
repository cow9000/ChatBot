package chat.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

import chat.controller.ChatbotController;

public class ChatFrame extends JFrame 
{
	
	ChatbotController baseController;
	ChatPanel panel;
	
	public ChatFrame(ChatbotController chatbotController)
	{
		this.baseController = chatbotController;
		
		panel = new ChatPanel(chatbotController);
		add(panel);
		pack();
		
		setTitle("Chatbot");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setMinimumSize(getSize());
		setSize(getPreferredSize());
		
		
		setVisible(true);
		
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
