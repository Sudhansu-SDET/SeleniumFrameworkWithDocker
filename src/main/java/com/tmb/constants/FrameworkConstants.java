package com.tmb.constants;

public final class FrameworkConstants {
    /**
     * The class lista all the framework constants that are used across the application
     */
    private FrameworkConstants(){} // private constructor
    private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources/" ;
    private static final String CHROMEDRIVERPATH = RESOURCESPATH + "Executables/chromedriver.exe" ;
    private static final String CONFIGFILEPATH  = RESOURCESPATH + "config/config.properties" ;
    private static final String TESTDATAFILEPATH  = RESOURCESPATH + "excel/TestData.xlsx" ;
    private static final int EXPLICITWAIT = 10;

    private static final String EXTENTREPORTPATH = System.getProperty("user.dir") + "ExtentReports/index.html" ;

    public static String getCHROMEDRIVERPATH() { return CHROMEDRIVERPATH; }
    public static String getCONFIGFILEPATH() {
        return CONFIGFILEPATH;
    }
    public static int getEXPLICITWAIT() { return EXPLICITWAIT; }
    public static String getTESTDATAFILEPATH() { return TESTDATAFILEPATH; }
    public static String getEXTENTREPORTPATH() { return EXTENTREPORTPATH; }

}
