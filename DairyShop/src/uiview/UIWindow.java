package uiview;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;

import mainview.CardView;

public class UIWindow {
	private JFrame frame;
	private UITitleBar titleBar;
	private UISideMenu sideMenu;
	private CardLayout cardLayout;
	private CardView cardView;
	
	public UIWindow(String title, int width, int height, String iconLocation) {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setSize(width, height);
		frame.setLayout(new BorderLayout());
		addTitleBar(iconLocation, title, width, height);
		addSideMenu();
	}
	
	public void resize(boolean value) {
		this.frame.setResizable(value);
	}
	
	public void show(boolean value) {
		this.frame.setVisible(value);
	}
	
	private void addTitleBar(String icon, String title, int width, int height) {
		this.titleBar = new UITitleBar(this.frame, icon, title);
		this.titleBar.addMinimize("minimize_s.png");
		this.titleBar.addRestore("maximize_s.png");
		this.titleBar.addClose("close.png");
		this.frame.add(titleBar.getTitleBar(), BorderLayout.NORTH);
	}
	
	private void addSideMenu() {
		addMainView();
		this.sideMenu = new UISideMenu(cardLayout, cardView);
		this.frame.add(this.sideMenu.getSideMenu(), BorderLayout.WEST);
	}
	
	private void addMainView() {
		cardLayout = new CardLayout();
		cardView = new CardView(cardLayout);
		this.frame.add(this.cardView.getView());
	}
}
