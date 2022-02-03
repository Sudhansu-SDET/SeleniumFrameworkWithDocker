package com.tmb.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private DriverManager(){}

    private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

//    private static ThreadLocal<WebDriver> dr = ThreadLocal.withInitial(()->{
//        System.setProperty("webdriver.chrome.driver", getCHROMEDRIVERPATH());
//        return new ChromeDriver();
//    });

    public static  WebDriver getDriver(){
        return dr.get();
    }

    public static void setDriver(WebDriver driverreference){
        dr.set(driverreference);
    }

    public static void unload(){
        dr.remove();
    }


}
