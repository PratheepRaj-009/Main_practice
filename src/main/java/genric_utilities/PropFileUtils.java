package genric_utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropFileUtils 
{
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(PathsConstants.propPath);
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}
}
