package mainview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import lib.PrintTemplate;
import res.UIColor;
import uiview.UIButton;
import uiview.UIInputBox;
import uiview.UILabel;

public class Sellboard {
	private JPanel board, rightOption, bottomOption;
	protected static JPanel listView;
	private JScrollPane listScroller, optionScroller;
	public static HashSet<SellItemView> listSet;
	protected HashSet<ListOptionButton> optionSet;
	public static UILabel totalAmount;
	private UIInputBox inputBox;
	private UIButton sell, sellAndPrint;
	public Sellboard() {
		this.board = new JPanel(new BorderLayout());
		this.rightOption = new JPanel();
		this.rightOption.setLayout(new BoxLayout(this.rightOption, BoxLayout.Y_AXIS));
		this.bottomOption = new JPanel();
		this.bottomOption.setLayout(new BoxLayout(this.bottomOption, BoxLayout.X_AXIS));
		initList();
		totalAmount = new UILabel(null, "Nrs. 0", UIColor.uiDarkBlueColor, Color.white);
		totalAmount.addPadding(10, 10, 10, 10);
		inputBox = new UIInputBox();
		sell = new UIButton(null, "Sell", 0, 0, Color.white, UIColor.uiDarkBlueColor, Color.white, UIColor.uiBlueColor, 0, 0, false, false);
		sell.addPadding(10, 10, 10, 10);
		sellAndPrint = new UIButton(null, "Sell & Print", 0, 0, Color.white, UIColor.uiDarkBlueColor, Color.white, UIColor.uiBlueColor, 0, 0, false, false);
		sellAndPrint.addPadding(10, 10, 10, 10);
		addItems();
	}
	
	public void addItems() {
		this.board.add(listScroller);
		this.board.add(optionScroller, BorderLayout.EAST);
		this.board.add(bottomOption, BorderLayout.SOUTH);
		Iterator<SellItemView> listIterator = listSet.iterator();
		while(listIterator.hasNext()) {
			listView.add(listIterator.next().getItemView());
		}
		Iterator<ListOptionButton> optionIterator = optionSet.iterator();
		while(optionIterator.hasNext()) {
			rightOption.add(optionIterator.next().getButton());
		}
		//Bottom
		this.bottomOption.add(totalAmount.getLabel());
		this.bottomOption.add(this.inputBox.getInputBox());
		this.bottomOption.add(this.sell.getButton());
		this.bottomOption.add(this.sellAndPrint.getButton());
		initBottomListener();
	}
	
	private void initList(){
		listView = new JPanel();
		listView.setLayout(new BoxLayout(listView, BoxLayout.Y_AXIS));
		this.listScroller = new JScrollPane(listView);
		
		listSet = new SellItemHashSet();
		
		this.optionScroller = new JScrollPane(this.rightOption);
		this.optionSet = new SellOptionHashSet();
		this.optionSet.add(new ListOptionButton(14258, 120, null, "Curd", 0, 0, Color.white, UIColor.uiDarkBlueColor, Color.white, UIColor.uiBlueColor, 0, 0, false, false));
		this.optionSet.add(new ListOptionButton(14259, 220, null, "Milk", 0, 0, Color.white, UIColor.uiDarkBlueColor, Color.white, UIColor.uiBlueColor, 0, 0, false, false));                    
	}
	
	public JPanel getBoard() {
		return this.board;
	}
	
	public String getClassName() {
		return "Sellboard";
	}

	public static String calculate() {
		Iterator<SellItemView> iterator = listSet.iterator();
		SellItemView temp;
		double result = 0;
		while(iterator.hasNext()) {
			temp = iterator.next();
			result += temp.getPrice()*temp.getCount();
		}
		return "Nrs. "+result;
	}
	
	private void initBottomListener() {
		this.sell.getButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		this.sellAndPrint.getButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(listSet.size()!=0) {
					String username = inputBox.getInputBox().getText();
					if(!username.equals("")){
						new PrintTemplate().print(username);
					}
				}
			}
		});
	}
	
	
	public static void update() {
		listView.revalidate();
		listView.repaint();
	}
}
