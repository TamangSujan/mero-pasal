package lib;

import java.awt.Font;

public class Configuration {
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static final String SHOP_NAME_STRING = "Mero Pasal";
	public final static String GET_RESOURCE_PATH = System.getProperty("user.dir")+"/src/res/";
	public final static String GET_SOURCE_PATH = System.getProperty("user.dir")+"/src/";
	public final static String GET_DOCS_PATH = System.getProperty("user.dir")+"/src/docs/";
	public final static Font calibriNormal = new Font("calibri", Font.PLAIN, 16);
	public final static Font calibriLarge = new Font("calibri", Font.PLAIN, 42);
}
