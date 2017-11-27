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
	JButton checkerButton;
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
		this.checkerButton = new JButton("Check");

		this.chatArea = new JTextArea(10,25);
		

		this.inputField = new JTextField(20);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatArea);
		
 

		
		
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
		this.add(checkerButton);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
	}
	/**
	 * Sets up the positioning for the GUI components.
	 */
	private void setupLayout() {
		appLayout.putConstraint(SpringLayout.NORTH, chatArea, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatArea, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, chatArea, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, checkerButton, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.EAST, checkerButton, -6, SpringLayout.WEST, chatButton);
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
		
		checkerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				String userText = inputField.getText();
				String displayText =  appController.useCheckers(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
				
		});
		
	}
	

}
