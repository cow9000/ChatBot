package chat.view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import chat.controller.ChatbotController;

public class ChatPanel extends JPanel
{

	ChatbotController baseController;
	
	JButton sendText;
	JTextArea displayTextArea;
	SpringLayout layout;
	
	public ChatPanel(ChatbotController chatbotController)
	{
		this.baseController = chatbotController;
		this.layout = new SpringLayout();
		this.setLayout(layout);
	
		
		
		addComponents();
	}
	
	private void addComponents() {
		
		sendText = new JButton();
		sendText.setText("Send Message");
		
		
		
		displayTextArea = new JTextArea("Chatbot");
		displayTextArea.setEditable(false);
		displayTextArea.setCaretPosition(displayTextArea.getDocument().getLength());
		
		
		
		
		
		
		this.add(displayTextArea);
		this.add(sendText);
		
	}

}
