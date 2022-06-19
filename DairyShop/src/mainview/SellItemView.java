package mainview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import res.UIColor;
import uiview.UIButton;
import uiview.UILabel;

public class SellItemView {
	private JPanel mainView;
	private UIButton addButton, subButton, deleteButton;
	private int counter, id;
	private double price;
	private String name;
	private UILabel image, nameLabel, priceLabel, count;
	private GridBagConstraints mainConstraints;
	private SellItemView temp;
	public SellItemView(int id,int width, String name, int price) {
		this.temp = this;
		this.id = id;
		this.name = name;
		this.price = price;
		this.mainView = new JPanel(new GridBagLayout());
		this.mainView.setBackground(Color.white);
		mainConstraints = new GridBagConstraints();
		mainConstraints.fill = GridBagConstraints.HORIZONTAL;
		
		this.nameLabel = new UILabel(null, name, Color.black, Color.white);
		this.nameLabel.getLabel().setHorizontalAlignment(SwingConstants.RIGHT);
		this.nameLabel.addPadding(0, 10, 0, 10);
		this.image = new UILabel(null, "None", Color.black, Color.white);
		this.image.getLabel().setHorizontalAlignment(SwingConstants.CENTER);
		this.image.addPadding(0, 10, 0, 10);
		this.priceLabel = new UILabel(null, "Nrs. "+price, Color.black, Color.white);
		this.priceLabel.getLabel().setHorizontalAlignment(SwingConstants.RIGHT);
		this.priceLabel.addPadding(0, 10, 0, 10);
		this.count = new UILabel(null, "0", Color.black, Color.white);
		this.count.getLabel().setHorizontalAlignment(SwingConstants.CENTER);
		this.count.addPadding(0, 10, 0, 10);
		this.addButton = new UIButton(null, "+", 32, 32, Color.white, UIColor.uiDarkBlueColor, Color.white, UIColor.uiBlueColor, 0, 0, false, false);
		this.subButton = new UIButton(null, "-", 32, 32, Color.white, UIColor.uiDarkBlueColor, Color.white, UIColor.uiBlueColor, 0, 0, false, false);
		this.deleteButton = new UIButton("red_cross_s.png", "", 32, 32, null, null, null, null, 0, 0, true, true);
		this.counter = Integer.parseInt(this.count.getLabel().getText());
		this.mainView.setMaximumSize(new Dimension(width, 64));
		addItems();
		initButtonListeners();
	}
	
	private void addItems() {
		setGridValues(0, 0, 1, 2, 0.2, 1.0);
		this.mainView.add(this.deleteButton.getButton(), this.mainConstraints);
		setGridValues(1, 0, 1, 2, 0.2, 1.0);
		this.mainView.add(this.count.getLabel(), this.mainConstraints);
		setGridValues(2, 0, 1, 2, 0.2, 1.0);
		this.mainView.add(this.image.getLabel(), this.mainConstraints);
		setGridValues(4, 0, 1, 1, 1.0, 0.5);
		this.mainView.add(this.priceLabel.getLabel(), this.mainConstraints);
		setGridValues(4, 1, 1, 1, 1.0, 0.5);
		this.mainView.add(this.nameLabel.getLabel(), this.mainConstraints);
		setGridValues(5, 0, 1, 1, 0.1, 1.0);
		this.mainView.add(this.addButton.getButton(), this.mainConstraints);
		setGridValues(5, 1, 1, 1, 0.1, 1.0);
		this.mainView.add(this.subButton.getButton(), this.mainConstraints);
	}
	
	public void setGridValues(int x, int y, int columnSpan, int rowSpan, double weightX, double weightY) {
		this.mainConstraints.gridx = x;
		this.mainConstraints.gridy = y;
		this.mainConstraints.gridwidth = columnSpan;
		this.mainConstraints.gridheight = rowSpan;
		this.mainConstraints.weightx = weightX;
		this.mainConstraints.weighty = weightY;
	}
	
	public JPanel getItemView() {
		return this.mainView;
	}
	
	public int getId() {
		return id;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getCount() {
		return this.counter;
	}
	
	private void initButtonListeners() {
		this.addButton.getButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				counter++;
				count.getLabel().setText(""+counter);
				Sellboard.totalAmount.getLabel().setText(Sellboard.calculate());
				
			}
		});
		this.subButton.getButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(counter>0) {
					counter--;
					count.getLabel().setText(""+counter);
					Sellboard.totalAmount.getLabel().setText(Sellboard.calculate());
				}
			}
		});
		this.deleteButton.getButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Sellboard.listSet.remove(temp);
				Sellboard.listView.remove(temp.getItemView());
				Sellboard.totalAmount.getLabel().setText(Sellboard.calculate());
				Sellboard.update();
			}
		});
	}
}
