package Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalParametersReading {

	public static void main(String[] args) throws IOException {
		// Getting the global parameters values from properties files to java file
		
		Properties prop = new Properties();
		FileInputStream InputfileStream=new FileInputStream("E:\\Rahul-eclipse-workspace\\TestNG\\src\\data.properties");
		prop.load(InputfileStream);
		System.out.println("Browser name is "+prop.getProperty("browser"));
		System.out.println("URL is "+prop.getProperty("URL"));
		
		// Updating property at run time. but this will not change property value in property file.
		
		prop.setProperty("browser", "firefox");
		System.out.println("Browser name is "+prop.getProperty("browser"));
		
		//To update the value in property file
		FileOutputStream OutputfileStream=new FileOutputStream("E:\\Rahul-eclipse-workspace\\TestNG\\src\\data.properties");
		prop.store(OutputfileStream,"Updated browser Information ");
	}

}
