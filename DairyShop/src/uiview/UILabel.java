package uiview;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import lib.Configuration;

public class UILabel {
	private JLabel uilabel;
	public UILabel(String image, String name, Color fg, Color bg) {
		ImageIcon icon = new ImageIcon(Configuration.GET_RESOURCE_PATH+image);
		if(image!=null) {
			this.uilabel = new JLabel(icon);
		}else {
			if(name==null || name=="") {
				this.uilabel = new JLabel("No name");
			}else {
				this.uilabel = new JLabel(name);
			}
		}
		this.uilabel.setOpaque(true);
		this.uilabel.setForeground(fg);
		this.uilabel.setBackground(bg);
	}
	public void addPadding(int top, int right, int bottom, int left) {
		this.uilabel.setBorder(new EmptyBorder(top, left, bottom, right));
	}
	public JLabel getLabel() {
		return this.uilabel;
	}
}
