package testScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class LoginTest {
	 WebDriver driver;
	 Properties prop;
	 
  @BeforeMethod
  public void Setup() throws IOException {
	  prop = new Properties();
	  String path = System.getProperty("user.dir") + "//src//test//resources//configFiles//config.properties";
	  FileInputStream fin = new FileInputStream(path);
	  prop.load(fin);
	  String Browser = prop.getProperty("browser");
	  
	  if(Browser.equalsIgnoreCase("chrome")) {
		  driver = new ChromeDriver();
	  }
	  else if (Browser.equalsIgnoreCase("edge")) {
		  driver = new EdgeDriver();
	  }
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  driver.manage().window().maximize();
  }
  
  @DataProvider(name="getData")
  public Object[][] getData() throws CsvValidationException, IOException {
	  
	  String path = System.getProperty("user.dir") + "//src//test//resources//testData//loginData.csv";
	  CSVReader reader = new CSVReader(new FileReader (path));
	  String cols[];
	  
	  ArrayList<Object> dataList = new ArrayList<Object> ();
	  while ((cols = reader.readNext()) != null) {
		  Object record[] = { cols[0], cols[1] };
		  dataList.add(record);
	  }
	  reader.close();
	return dataList.toArray(new Object[dataList.size()][]);
  }
  
  
  
  @Test(dataProvider = "getData")
  public void LoginApp (String user, String Passwd) {
	  driver.get(prop.getProperty("url"));
	  WebElement name = driver.findElement(By.id(readObjPath("loginuser")));
	  name.sendKeys(user);
	  WebElement passwd = driver.findElement(By.id(readObjPath("loginpwd")));
	  passwd.sendKeys(Passwd);
	  WebElement loginbtn = driver.findElement(By.className(readObjPath("loginBtn")));
	  loginbtn.click();
  }
  
  
  public String readObjPath(String objName) {
	  String objPath = "";
	  String path = System.getProperty("user.dir") + "//src//test//resources//testData//LoginRepo.xlsx";
	  
	  FileInputStream fin;
	  XSSFWorkbook wrkBook = null;
	  
	  try {
		fin = new FileInputStream(path);
		wrkBook = new XSSFWorkbook(fin);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  XSSFSheet sheet = wrkBook.getSheet("loginPage");
	  int RowNum = sheet.getLastRowNum();
	  for(int i = 1; i <= RowNum; i++ ) {
		  XSSFRow row = sheet.getRow(i);
		  
		  if (row.getCell(0).getStringCellValue().equalsIgnoreCase(objName)){
			  objPath = row.getCell(1).getStringCellValue();
		  }
		  
	  }
	 return objPath; 
  }
  
  @AfterMethod
  public void tearDown() {
//	  driver.quit();
  }
  
  
}
