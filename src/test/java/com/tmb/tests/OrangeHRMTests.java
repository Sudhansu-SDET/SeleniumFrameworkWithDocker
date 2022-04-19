package com.tmb.tests;

import com.tmb.driver.DriverManager;
import com.tmb.pages.OrangeHRMLoginPage;
import com.tmb.pages.OrangeHRMHomePage;
import com.tmb.reports.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static com.tmb.constants.FrameworkConstants.getTESTDATAFILEPATH;
/**
 * hello .. this is javadoc for orangehrmtests
 */
public class OrangeHRMTests extends BaseTest {

    private OrangeHRMTests(){}

    @Test(dataProvider = "LoginTestDataProvider")
    public void logInLogOutTest(Map<String,String> map) throws Exception {

        ExtentManager.getExtentTest().assignAuthor("sudhansu").assignCategory("smoke");

        OrangeHRMLoginPage loginpageObj = new OrangeHRMLoginPage();
        loginpageObj.enterUserName(map.get("UserName")).enterPassword(map.get("Password")).clickLogin();
        Thread.sleep(3000);
        OrangeHRMHomePage orangeHRMHomePageObj = new OrangeHRMHomePage();
        orangeHRMHomePageObj.clickWelcome();
        Thread.sleep(3000);
        orangeHRMHomePageObj.clickLogOut();
    }

    @DataProvider(name = "LoginTestDataProvider",parallel = true)
    public Object[] getData() throws IOException {

        FileInputStream fs = new FileInputStream(getTESTDATAFILEPATH());
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheet("AllTestData");

        int rowcount = sheet.getLastRowNum();
        int columncount = sheet.getRow(0).getLastCellNum();

        Object[] data = new Object[rowcount];
        Map<String,String> map;

        for(int i=1;i<=rowcount;i++){
            map = new HashMap<String, String>();
            for (int j=0; j<columncount; j++){
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value = sheet.getRow(i).getCell(j).getStringCellValue();
                map.put(key,value);
                data[i-1] = map;
            }
        }
        return data;
    }
}
