package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utilidades {
	
	public static Properties getProperties() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\Thomas\\workspace\\properties\\dados.properties");
		prop.load(file);
		
		return prop;		
	}
}
