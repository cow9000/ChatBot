package chat.view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import chat.controller.ChatbotController;

public class ChatPanel extends JPanel
{

	ChatbotController appController;

	SpringLayout appLayout;
	
	JButton chatButton;
	JTextField inputField;
	JTextArea chatArea;
	
	
	
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
		
		
		//Initalize GUI data members
		this.appLayout = new SpringLayout();
		this.chatButton = new JButton("Chat");
		this.chatArea = new JTextArea(10,25);
		this.inputField = new JTextField(20);
		
		
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
