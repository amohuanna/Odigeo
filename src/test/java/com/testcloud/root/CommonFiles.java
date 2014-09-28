package com.testcloud.root;

import java.io.IOException;
import java.util.Properties;

public class CommonFiles {
	public Properties getProperties()
	{
		try
			{
				Properties propiedades = new Properties();
				propiedades.load(getClass().getClassLoader().getResourceAsStream("application.properties"));
				if (!propiedades.isEmpty())
					{                
						return propiedades;
					}
				else
					{
						return null;
					}
			} 
		catch (IOException ex)
			{
				return null;
			}
	}
}
