package mainview;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import res.UIColor;

public class Dashboard {
	private JPanel board;
	private InfoBox totalSales, totalItems;
	private GridBagConstraints gridBagConstraints;
	public Dashboard() {
		board = new JPanel();
		GridBagLayout gridBagLayout = new GridBagLayout();
		board.setLayout(gridBagLayout);
		gridBagConstraints = new GridBagConstraints();
		//gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		totalSales = new InfoBox("Total Sales", "0", Color.white, UIColor.uiLightRedColor);
		totalItems = new InfoBox("Total Items", "0", Color.white, UIColor.uiLightRedColor);
		addItems();
	}
	
	public void gridPos(int x, int y, int px, int py) {
		gridBagConstraints.gridx = x;
		gridBagConstraints.gridy = y;
		gridBagConstraints.ipadx = px;
		gridBagConstraints.ipady = py;
	}
	
	public void addItems() {
		gridPos(0, 0, 100, 100);
		this.board.add(totalSales.getInfoBox(), gridBagConstraints);
		gridPos(1, 0, 100, 100);
		this.board.add(totalItems.getInfoBox(), gridBagConstraints);
	}
	
	public JPanel getBoard() {
		return this.board;
	}
	
	public String getClassName() {
		return "Dashboard";
	}
}
