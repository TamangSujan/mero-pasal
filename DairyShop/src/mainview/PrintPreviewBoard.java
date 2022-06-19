package mainview;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import lib.PrintTemplate;
import res.UIColor;

public class PrintPreviewBoard{
	private JScrollPane paneBoard;
	private JPanel board;
	private PrintTemplate printer;
	public PrintPreviewBoard() {
		printer = new PrintTemplate();
		board = printer.getTemplate();
		board.setLayout(null);
		board.setBackground(UIColor.uiGrayColor);
		paneBoard = new JScrollPane(board);
	}
	
	public JScrollPane getBoard() {
		return this.paneBoard;
	}
	
	public String getClassName() {
		return "PrintPreviewBoard";
	}
	
	public PrintTemplate getPagePrinter() {
		return printer;
	}
}

