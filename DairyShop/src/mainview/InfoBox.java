package mainview;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lib.Configuration;
import res.UIColor;

public class InfoBox {
	private JPanel box;
	private JLabel titleBox, valueBox;
	public InfoBox(String title, String value, Color fg, Color bg) {
		box = new JPanel();
		box.setBackground(UIColor.uiBlueColor);
		//Padding
		box.setBorder(new EmptyBorder(10, 10, 10, 10));
		box.setLayout(new BorderLayout());
		box.setBackground(bg);
		titleBox = new JLabel(title);
		valueBox = new JLabel(value, JLabel.CENTER);
		valueBox.setFont(Configuration.calibriLarge);
		titleBox.setForeground(fg);
		valueBox.setForeground(fg);
		addItems();
	}
	
	private void addItems() {
		this.box.add(titleBox, BorderLayout.NORTH);
		this.box.add(valueBox);
	}
	public JPanel getInfoBox() {
		return this.box;
	}
}
