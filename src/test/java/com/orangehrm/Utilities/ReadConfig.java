package com.orangehrm.Utilities;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties pro;

public ReadConfig()  {
   File src = new File("P://TechStuffs//LetsKodeIt//inetbankingV1-master//OrangeHRMDemo//Configuration//configuration.properties");
    try {
        FileInputStream fis = new FileInputStream(src);
         pro = new Properties();
        pro.load(fis);
    }
    catch (Exception e) {
        System.out.println("Exception is " + e.getMessage());
    }

}

    public String getApplicationURL()
    {
        String url=pro.getProperty("baseURL");
        return url;
    }

    public String getUsername()
    {
        String username=pro.getProperty("username");
        return username;
    }

    public String getPassword()
    {
        String password=pro.getProperty("password");
        return password;
    }

}
