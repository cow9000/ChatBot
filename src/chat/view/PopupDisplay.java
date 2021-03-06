package chat.view;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PopupDisplay
{
	
	private ImageIcon icon;
	private String windowTitle;
	
	
	public PopupDisplay() {
		icon = new ImageIcon(getClass().getResource("images/chatbot.png"));
		windowTitle = "Chatbot says";
	}
	/**
	 * displays a text box with the selected message
	 * @param message Message to be shown in the box
	 */
	public void displayText(String message) {
		JOptionPane.showMessageDialog(null, message, windowTitle, JOptionPane.INFORMATION_MESSAGE, icon);
	}
	
	public String collectResponse(String question){
		String answer = "";
		answer += JOptionPane.showInputDialog(null, question, windowTitle, JOptionPane.PLAIN_MESSAGE, icon, null, "");
		return answer;
	}
	
}
