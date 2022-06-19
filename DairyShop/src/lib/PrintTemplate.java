package lib;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.qoppa.pdfWriter.PDFPrinterJob;

import mainview.SellItemView;
import mainview.Sellboard;
import uiview.UILabel;

public class PrintTemplate implements Printable{
	private JPanel template;
	private PDFPrinterJob printer;
	private int locX, locY;
	public PrintTemplate() {
		this.template = new JPanel();
		this.template.setBackground(Color.white);
		//this.template.setSize(384, 200);
		this.template.setBounds(0, 0, 384, 608);
		setPos(0, 0);
		printer = (PDFPrinterJob) PDFPrinterJob.getPrinterJob();
		refresh();
		}
	
	private void setPos(int x, int y) {
		this.locX = x;
		this.locY = y;
	}
	
	public void refresh() {
		setPos(0, 0);
		this.template.removeAll();
		JPanel item = new ItemPrint("Sn.", "Item", "Qty", "Price", "Total Price").getItemLayout();
		item.setLocation(locX, locY);
		this.template.add(item);
		Iterator<SellItemView> iterator = Sellboard.listSet.iterator();
		SellItemView tempView;
		double totalAmount = 0;
		int index = 1;
		while(iterator.hasNext()) {
			tempView = iterator.next();
			JPanel item_iterate = new ItemPrint(""+index, tempView.getName(), ""+tempView.getCount(), ""+tempView.getPrice(), ""+(tempView.getCount()*tempView.getPrice())).getItemLayout();
			setPos(this.locX, this.locY+32);
			item_iterate.setLocation(this.locX, this.locY);
			this.template.add(item_iterate);
			totalAmount += tempView.getCount()*tempView.getPrice();
			index++;
		}
		setPos(this.locX, this.locY+32);
		JLabel labelDashOne = new UILabel(null, "-------------------", Color.black, Color.white).getLabel();
		labelDashOne.setLocation(this.locX, this.locY);
		labelDashOne.setSize(384, 32);
		labelDashOne.setHorizontalAlignment(SwingConstants.RIGHT);
		this.template.add(labelDashOne);
		
		setPos(this.locX, this.locY+32);
		JLabel totalPrice = new UILabel(null, "Total Amount: "+totalAmount, Color.black, Color.white).getLabel();
		totalPrice.setLocation(this.locX, this.locY);
		totalPrice.setSize(384, 32);
		totalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		this.template.add(totalPrice);
		
		setPos(this.locX, this.locY+32);
		JLabel labelDashTwo = new UILabel(null, "-------------------", Color.black, Color.white).getLabel();
		labelDashTwo.setLocation(this.locX, this.locY);
		labelDashTwo.setSize(384, 32);
		labelDashTwo.setHorizontalAlignment(SwingConstants.RIGHT);
		this.template.add(labelDashTwo);
		
		setPos(this.locX, this.locY+32);
		JLabel thankyou = new UILabel(null, "Thank you for shopping in "+Configuration.SHOP_NAME_STRING, Color.black, Color.white).getLabel();
		thankyou.setLocation(this.locX, this.locY);
		thankyou.setSize(384, 32);
		thankyou.setHorizontalAlignment(SwingConstants.CENTER);
		this.template.add(thankyou);
		this.template.revalidate();
		this.template.repaint();
	}
	
	public JPanel getTemplate() {
		return this.template;
	}

	public void print(String username) {
		this.printer.setPrintable(new PrintTemplate());
		this.printer.setCopies(1);
		try {
	    	refresh();
			this.printer.print(Configuration.GET_DOCS_PATH+username+".pdf");
		} catch (PrinterException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		if(pageIndex==0) {
			 // translate the graphics for margins
	    	 graphics.translate(0, 0);
	    	 template.print(graphics);
	    	 return Printable.PAGE_EXISTS;
		}
		return Printable.NO_SUCH_PAGE;
	}
}
