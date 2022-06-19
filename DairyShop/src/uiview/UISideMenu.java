package uiview;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import mainview.CardView;
import res.UIColor;

public class UISideMenu {
	private JPanel panel;
	private UIButton dashBoard, sales, printPreview;
	public UISideMenu(CardLayout cardLayout, CardView cardView){
		this.panel = new JPanel();
		this.panel.setBackground(UIColor.uiDarkBlueColor);
		this.panel.setLayout(new GridLayout(10,1));
		init();
		addItems();
		initListener(cardLayout, cardView);
	}
	
	private void init() {
		dashBoard = new UIButton("dashboard.png", "Dashboard", 0, 0, Color.white, UIColor.uiDarkBlueColor, Color.white, UIColor.uiLavenderColor, 0, 10, false, false);
		sales = new UIButton("cash.png", "Sell", 0, 0, Color.white, UIColor.uiDarkBlueColor, Color.white, UIColor.uiLavenderColor, 0, 10, false, false);
		printPreview = new UIButton("print_preview_s.png", "Print Preview", 0, 0, Color.white, UIColor.uiDarkBlueColor, Color.white, UIColor.uiLavenderColor, 0, 10, false, false);
	}
	
	private void addItems() {
		this.panel.add(dashBoard.getButton());
		this.panel.add(sales.getButton());
		this.panel.add(printPreview.getButton());
	}
	
	private void initListener(CardLayout cardLayout, CardView cardView) {
		dashBoard.getButton().addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardView.getView(), cardView.getDashboardName());
			}
		});
		sales.getButton().addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardView.getView(), cardView.getSellboardName());
			}
		});
		printPreview.getButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cardView.getPrintboard().getPagePrinter().refresh();
				cardLayout.show(cardView.getView(), cardView.getPrintboardName());
			}
		});
	}
	
	public JPanel getSideMenu() {
		return this.panel;
	}
}
