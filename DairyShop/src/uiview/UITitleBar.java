package uiview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lib.Configuration;

public class UITitleBar {
	private JFrame frame;
	private JPanel titleBar, left, right;
	private JLabel title;
	private JLabel icon;
	private UIButton closeButton, minimizeButton, resizeButton;
	private int state;
	private int offSetX, offSetY;
	private Color backgroundColor;
	
	public UITitleBar(JFrame frame, String iconLocation, String title) {
		init(frame, iconLocation, title);
		addItems();
		setBackgroundColor();
		addMouseListener();
	}
	
	private void init(JFrame frame, String iconLocation, String title) {
		this.frame = frame;
		this.titleBar = new JPanel();
		this.titleBar.setLayout(new BorderLayout());
		this.backgroundColor = Color.getHSBColor(0.f, 0.f, 1.f);
		
		this.left = new JPanel();
		this.left.setLayout(new FlowLayout());
		this.right = new JPanel();
		this.right.setLayout(new FlowLayout());
		
		this.titleBar.add(this.left, BorderLayout.WEST);
		this.titleBar.add(this.right, BorderLayout.EAST);
		
		this.title = new JLabel(title);
		this.icon =  new JLabel(new ImageIcon(Configuration.GET_RESOURCE_PATH+iconLocation));
		this.offSetX = 0;
		this.offSetY = 0;
		this.state = 0;
	}
	
	public void addClose(String icon) {
		this.closeButton = new UIButton(icon, "", 16, 16, null, null, null, null, 0 ,0, true, true);
		this.right.add(this.closeButton.getButton());
		this.closeButton.getButton().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public void addMinimize(String icon) {
		this.minimizeButton = new UIButton(icon, "", 16, 16, null, null, null, null, 0 ,0, true, true);
		this.right.add(this.minimizeButton.getButton());
		this.minimizeButton.getButton().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setState(JFrame.ICONIFIED);
			}
		});
	}
	
	public void addRestore(String icon) {
		this.resizeButton = new UIButton(icon, "", 16, 16, null, null, null, null, 0 ,0, true, true);
		this.right.add(this.resizeButton.getButton());
		this.resizeButton.getButton().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				if(state==0) {
					frame.setExtendedState( frame.getExtendedState()|JFrame.MAXIMIZED_BOTH );
					state = 1;
					System.out.println("0");
				}else if(state==1) {
					frame.setExtendedState(JFrame.NORMAL );
					state = 0;
					System.out.println("1");
				}
					
			}
		});
	}
	
	public JPanel getTitleBar() {
		return this.titleBar;
	}
	
	private void addItems() {
		this.left.add(icon);
		this.left.add(title);
	}
	
	private void addMouseListener() {
		this.titleBar.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				frame.setLocation(e.getXOnScreen()-offSetX, e.getYOnScreen()-offSetY);
			}
		});
		
		this.titleBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				offSetX = e.getX() - titleBar.getX();
				offSetY = e.getY() - titleBar.getY();
			}
		});
	}
	
	private void setBackgroundColor() {
		this.titleBar.setBackground(this.backgroundColor);
		this.left.setBackground(this.backgroundColor);
		this.right.setBackground(this.backgroundColor);
	}
}
