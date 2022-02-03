package com.tmb.constants;

public final class FrameworkConstants {

    private FrameworkConstants(){} // private constructor
    private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources/" ;
    private static final String CHROMEDRIVERPATH = RESOURCESPATH + "Executables/chromedriver.exe" ;
    private static final String CONFIGFILEPATH  = RESOURCESPATH + "config/config.properties" ;

    public static String getCHROMEDRIVERPATH()
    {
        return CHROMEDRIVERPATH;
    }
    public static String getCONFIGFILEPATH() {
        return CONFIGFILEPATH;
    }

}
