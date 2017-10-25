package chat.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import chat.controller.ChatbotController;

public class ChatPanel extends JPanel
{

	ChatbotController baseController;
	
	JButton sendText;
	JTextArea displayTextArea;
	
	public ChatPanel(ChatbotController chatbotController)
	{
		this.baseController = chatbotController;
		
		this.setLayout(new SpringLayout());
		
		sendText = new JButton();
		sendText.setText("Send Message");
		
		
		displayTextArea = new JTextArea("Chatbot");
		displayTextArea.setEditable(false);
		displayTextArea.setCaretPosition(displayTextArea.getDocument().getLength());
		
		
		addComponents();
	}
	
	private void addComponents() {
		
		this.add(displayTextArea);
		this.add(sendText);
	}

}
