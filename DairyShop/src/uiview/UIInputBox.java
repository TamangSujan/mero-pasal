package uiview;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class UIInputBox {
	private JTextField inputBox;
	public UIInputBox() {
		inputBox = new JTextField("Enter Customer Name:");
		initListener();
	}
	
	private void initListener() {
		inputBox.addFocusListener(new FocusListener() {		
			@Override
			public void focusLost(FocusEvent e) {
				if(inputBox.getText().equals("")) {
					inputBox.setText("Enter Customer Name:");
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(inputBox.getText().equals("Enter Customer Name:")) {
					inputBox.setText("");
				}
			}
		});
	}
	
	public JTextField getInputBox() {
		return this.inputBox;
	}
}
