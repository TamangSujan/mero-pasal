package view;

import lib.Configuration;
import uiview.UIWindow;

public class Launcher {
	public static void main(String[] args) {
		UIWindow window = new UIWindow(Configuration.SHOP_NAME_STRING, Configuration.WINDOW_WIDTH, Configuration.WINDOW_HEIGHT, "logo_s.png");
		window.show(true);	
	}
}
