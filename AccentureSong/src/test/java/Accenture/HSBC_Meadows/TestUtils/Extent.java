package Accenture.HSBC_Meadows.TestUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
public class Extent {
    static ExtentTest test;
   public static ExtentTest getTest()
   {
       return test;
   }
  public static void setTest(ExtentTest test){
       Extent.test=test;
  }
}
