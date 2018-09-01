package org.dispatcher.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropUtils
{
    private static Map<String, Map<String, String>> PROPERTIES = new HashMap<String, Map<String, String>>();

    public static Map<String, String> getKeyPairs(String file)
    {
        if (PROPERTIES.containsKey(file))
        {
            return PROPERTIES.get(file);
        }

        Properties prop=new Properties();
        try
        {
            prop.load(new FileInputStream("\\" + file));
        }
        catch (FileNotFoundException ex)
        {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
        catch (IOException ex)
        {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }

        return null;
    }

}
