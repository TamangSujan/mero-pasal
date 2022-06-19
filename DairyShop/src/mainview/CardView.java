package mainview;

import java.awt.CardLayout;
import javax.swing.JPanel;

public class CardView {
	private JPanel mainView;
	private Dashboard dashboard;
	private Sellboard sellboard;
	private PrintPreviewBoard previewBoard;
	
	public CardView(CardLayout layout) {
		mainView = new JPanel(layout);
		dashboard = new Dashboard();
		sellboard = new Sellboard();
		previewBoard = new PrintPreviewBoard();
		addItems();
	}
	public String getDashboardName() {
		return dashboard.getClassName();
	}
	public String getSellboardName() {
		return sellboard.getClassName();
	}
	public String getPrintboardName() {
		return previewBoard.getClassName();
	}
	public Dashboard getDashboard() {
		return dashboard;
	}
	public Sellboard getSellboard() {
		return sellboard;
	}
	public PrintPreviewBoard getPrintboard() {
		return previewBoard;
	}
	public void addItems() {
		mainView.add(this.dashboard.getBoard(), dashboard.getClassName());
		mainView.add(this.sellboard.getBoard(), sellboard.getClassName());
		mainView.add(this.previewBoard.getBoard(), previewBoard.getClassName());
	}
	public JPanel getView() {
		return this.mainView;
	}
}
