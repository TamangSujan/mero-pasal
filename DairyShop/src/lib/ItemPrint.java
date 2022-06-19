package lib;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import uiview.UILabel;

public class ItemPrint {
	private JPanel itemLayout;
	private UILabel sn, itemName, qty, pricePerItem, totalPrice; 
	public ItemPrint(String sn, String name, String qty, String pricePerItem, String totalPrice) {
		this.sn = new UILabel(null, sn, Color.black, Color.white);
		this.itemName = new UILabel(null, name, Color.black, Color.white);
		this.qty = new UILabel(null, qty, Color.black, Color.white);
		this.pricePerItem = new UILabel(null, pricePerItem, Color.black, Color.white);
		this.totalPrice = new UILabel(null, totalPrice, Color.black, Color.white);
		this.itemLayout = new JPanel(null);
		this.itemLayout.setBackground(Color.white);
		this.itemLayout.setSize(384, 32);
		addItems();
	}
	
	private void addItems() {
		//Align Center
		this.sn.getLabel().setHorizontalAlignment(SwingConstants.CENTER);
		this.itemName.getLabel().setHorizontalAlignment(SwingConstants.CENTER);
		this.qty.getLabel().setHorizontalAlignment(SwingConstants.CENTER);
		this.pricePerItem.getLabel().setHorizontalAlignment(SwingConstants.CENTER);
		this.totalPrice.getLabel().setHorizontalAlignment(SwingConstants.CENTER);
		
		this.sn.getLabel().setLocation(0, 0);
		this.sn.getLabel().setSize(32, 32);
		this.itemLayout.add(this.sn.getLabel());
		
		this.itemName.getLabel().setLocation(32, 0);
		this.itemName.getLabel().setSize(64, 32);
		this.itemLayout.add(this.itemName.getLabel());
		
		this.qty.getLabel().setLocation(128, 0);
		this.qty.getLabel().setSize(32, 32);
		this.itemLayout.add(this.qty.getLabel());
		
		this.pricePerItem.getLabel().setLocation(160, 0);
		this.pricePerItem.getLabel().setSize(96, 32);
		this.itemLayout.add(this.pricePerItem.getLabel());
		
		this.totalPrice.getLabel().setLocation(256, 0);
		this.totalPrice.getLabel().setSize(128, 32);
		this.itemLayout.add(this.totalPrice.getLabel());
	}

	
	public JPanel getItemLayout() {
		return this.itemLayout;
	}
}
