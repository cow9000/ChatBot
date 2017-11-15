package chat.view;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import chat.controller.ChatbotController;

public class ChatPanel extends JPanel
{

	ChatbotController appController;

	SpringLayout appLayout;
	
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
		this.appLayout = new SpringLayout();
		
		
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	
	private void setupPanel() {
		this.setLayout(appLayout);
	}
	
	private void setupLayout() {
		
	}
	
	private void setupListeners() {
		
	}
	

}
