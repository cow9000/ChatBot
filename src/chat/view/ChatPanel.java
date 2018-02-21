package chat.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import chat.controller.ChatbotController;

public class ChatPanel extends JPanel
{

	private ChatbotController appController;

	private SpringLayout appLayout;
	
	private JButton chatButton;
	private JButton searchButton;
	private JButton saveButton;
	private JButton loadButton;
	private JButton tweetButton;
	
	private JButton checkerButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private JLabel infoLabel;
	private JLabel chatLabel;
	
	private JScrollPane chatScrollPane;
	
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
		this.chatButton = new JButton("Chat", new ImageIcon(getClass().getResource("/chat/view/images/Chat.png")));
		this.searchButton = new JButton("Search", new ImageIcon(getClass().getResource("/chat/view/images/Search.png")));
		this.saveButton = new JButton("Save", new ImageIcon(getClass().getResource("/chat/view/images/Save.png")));

		this.loadButton = new JButton("Load", new ImageIcon(getClass().getResource("/chat/view/images/Load.png")));
		this.tweetButton = new JButton("Tweet", new ImageIcon(getClass().getResource("/chat/view/images/Tweet.png")));
		
		this.checkerButton = new JButton("Check");
		this.infoLabel = new JLabel("Type to chat with the chatbot");
		this.chatLabel = new JLabel("Press Enter or click \"" + this.chatButton.getText() + "\"");
		this.chatArea = new JTextArea(10,25);
		
		
		this.chatScrollPane = new JScrollPane();

		this.inputField = new JTextField(20);
		
 

		
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	
	
	/**
	 * Sets up the scroll pane for the Chat Area
	 */
	private void setupScrollPane() {
		chatScrollPane.setViewportView(chatArea);
		chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
	}
	
	
	/**
	 * Sets up the Panel into the number of components I want.
	 */
	private void setupPanel() {
		this.setBackground(Color.BLUE);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(searchButton);
		this.add(loadButton);
		this.add(saveButton);
		this.add(tweetButton);
		this.add(inputField);
		this.add(chatScrollPane);
		this.add(chatLabel);
		this.add(checkerButton);
		this.add(infoLabel);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
	}
	/**
	 * Sets up the positioning for the GUI components.
	 */
	private void setupLayout() {
		appLayout.putConstraint(SpringLayout.EAST, chatButton, -10, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, searchButton, -6, SpringLayout.WEST, chatButton);
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, 0, SpringLayout.SOUTH, chatButton);
		appLayout.putConstraint(SpringLayout.EAST, saveButton, -6, SpringLayout.WEST, loadButton);
		appLayout.putConstraint(SpringLayout.SOUTH, searchButton, -1, SpringLayout.NORTH, loadButton);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, 0, SpringLayout.SOUTH, loadButton);
		appLayout.putConstraint(SpringLayout.WEST, loadButton, 0, SpringLayout.WEST, searchButton);
		appLayout.putConstraint(SpringLayout.EAST, loadButton, 0, SpringLayout.EAST, searchButton);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 0, SpringLayout.WEST, tweetButton);
		appLayout.putConstraint(SpringLayout.NORTH, tweetButton, 0, SpringLayout.NORTH, searchButton);
		appLayout.putConstraint(SpringLayout.EAST, tweetButton, -6, SpringLayout.WEST, searchButton);
		appLayout.putConstraint(SpringLayout.SOUTH, checkerButton, -6, SpringLayout.NORTH, infoLabel);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, -15, SpringLayout.NORTH, infoLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, chatLabel, -64, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.WEST, checkerButton, 0, SpringLayout.WEST, inputField);
		appLayout.putConstraint(SpringLayout.NORTH, loadButton, -10, SpringLayout.NORTH, inputField);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 6, SpringLayout.SOUTH, chatLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, infoLabel, -6, SpringLayout.NORTH, chatLabel);
		appLayout.putConstraint(SpringLayout.WEST, infoLabel, 0, SpringLayout.WEST, inputField);
		appLayout.putConstraint(SpringLayout.WEST, chatLabel, 0, SpringLayout.WEST, inputField);
		appLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatScrollPane, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatScrollPane);
	}
	/**
	 * Adds actions to components of the screen
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
