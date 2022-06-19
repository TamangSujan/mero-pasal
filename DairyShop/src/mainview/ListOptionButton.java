package mainview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EmptyBorder;

import uiview.UIButton;

public class ListOptionButton extends UIButton{
	private String name;
	public ListOptionButton(int id, int price, String image, String name, int width, int height, Color fg, Color bg, Color hoverFg,
			Color hoverBg, int padTB, int padLR, boolean transparent, boolean focus) {
		super(image, name, width, height, fg, bg, hoverFg, hoverBg, padTB, padLR, transparent, focus);
		this.name = name;
		this.getButton().setBorder(new EmptyBorder(10, 25, 10, 25));
		this.getButton().setMaximumSize(new Dimension(Integer.MAX_VALUE, this.getButton().getMinimumSize().height));
		this.getButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SellItemView view = new SellItemView(id, 800, name, price);
				if(Sellboard.listSet.add(view)) {
					Sellboard.listView.add(view.getItemView());
				}
				Sellboard.update();
			}
		});
	}
	
	public String getName() {
		return this.name;
	}
}
