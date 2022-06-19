package uiview;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import lib.Configuration;

public class UIButton{
	private JButton button;
	private boolean focus;
	private Cursor normalCursor, handCursor;
	public UIButton(String image, String name, int width, int height, Color fg, Color bg, Color hoverFg, Color hoverBg, int padTB, int padLR, boolean transparent, boolean focus) {
		ImageIcon icon = new ImageIcon(Configuration.GET_RESOURCE_PATH+image);
		handCursor = new Cursor(Cursor.HAND_CURSOR);
		normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
		if(image!=null) {
			this.button = new JButton(name, icon);
		}else {
			this.button = new JButton(name);
		}
		
		this.button.setMargin(new Insets(padTB, padLR, padTB, padLR));
		if(width!=0 || height!=0) {
			this.button.setPreferredSize(new Dimension(width, height));
		}
		this.button.setContentAreaFilled(!transparent);
		this.focus = focus;
		this.button.setBorderPainted(false);
		this.button.setFocusPainted(false);
		button.setBackground(bg);
		button.setForeground(fg);
		setHover(fg, bg, hoverFg, hoverBg);
	}
	
	public JButton getButton() {
		return this.button;
	}
	
	private void setHover(Color foreground, Color background, Color hoverForeground, Color hoverBackground) {
		this.button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(focus) {
					//button.setFocusPainted(true);
					button.setBorderPainted(true);
					button.setCursor(handCursor);
				}
				if(hoverForeground!=null) {
					button.setBackground(hoverForeground);
				}
				if(hoverBackground!=null) {
					button.setBackground(hoverBackground);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button.setFocusPainted(false);
				button.setBorderPainted(false);
				button.setBackground(background);
				button.setForeground(foreground);
				button.setCursor(normalCursor);
			}
		});
	}
	
	public void addPadding(int top, int right, int bottom, int left) {
		button.setBorder(new EmptyBorder(top, left, bottom, right));
	}
}
