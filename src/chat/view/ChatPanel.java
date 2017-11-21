package chat.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	
	/**
	 * This is the constructor for the ChatPanel, defines the GUI data members in here
	 * @param appController appController links the appController into the Panel
	 */
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
	/**
	 * Sets up the Panel into the number of components I want.
	 */
	private void setupPanel() {
		this.setBackground(Color.BLUE);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatArea);
		
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
	}
	/**
	 * Sets up the positioning for the GUI components.
	 */
	private void setupLayout() {
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 6, SpringLayout.SOUTH, chatArea);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatArea);
		appLayout.putConstraint(SpringLayout.NORTH, chatArea, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatArea, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, chatArea, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 10, SpringLayout.WEST, chatArea);
	}
	/**
	 * 
	 */
	private void setupListeners() {
		chatButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click)
			{
				{
					String userText = inputField.getText();
					String displayText = appController.interactWithChatbot(userText);
					chatArea.append(displayText);
					inputField.setText("");
				}
			}

		});
		
	}
	

}
