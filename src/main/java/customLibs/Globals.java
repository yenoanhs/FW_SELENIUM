package customLibs;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Globals {
	public static final Properties PROP = new Properties();
	static String strfile = "config.property";
	static
	{
		try {
			PROP.load(new FileInputStream(strfile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void loadFile() throws FileNotFoundException, IOException
	{
		PROP.load(new FileInputStream(strfile));
	}
}
