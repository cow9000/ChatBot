package chat.view;

import javax.swing.JOptionPane;

public class PopupDisplay
{
	public void displayText(String textToDisplay) {
		JOptionPane.showMessageDialog(null, textToDisplay);
	}
	
	public String getResponse(String question){
		String answer = "";
		answer = JOptionPane.showInputDialog(null, question);
		return answer;
	}
	
}
