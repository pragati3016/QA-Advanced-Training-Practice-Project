package mvn.mvnproject;

// https://www.guru99.com/object-repository-selenium.html
//jars to download - search and use mvn links
// jaxen.jar - https://mvnrepository.com/artifact/jaxen/jaxen/1.2.0
//dom4j-1.6.jar - https://mvnrepository.com/artifact/org.dom4j/dom4j/2.1.3
		
import java.io.*;		
import org.dom4j.*;		
import org.dom4j.io.SAXReader;		
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.chrome.ChromeDriver;		

public class XML_OR {				

public static void main(String[] args) throws DocumentException {										
// Creating WebDriver Instance		
    WebDriver driver;			
    System.setProperty("webdriver.chrome.driver","C:\\Users\\Pragati\\eclipse\\chromedriver_win32\\chromedriver.exe");					
    driver = new ChromeDriver();					
    driver.get("http://demo.guru99.com/test/guru99home/");					
    driver.manage().window().maximize();			
// Reading XML File    		
    File inputFile = new File(System.getProperty("user.dir") +"\\src\\Excel"+"\\XML_OR.xml");									
    SAXReader saxReader = new SAXReader();					
    Document document = saxReader.read(inputFile);							
    String mobileTesting = document.selectSingleNode("//menu/mobiletesting").getText();							
    String emailTextBox = document.selectSingleNode("//menu/email").getText();							
    String signUpButton = document.selectSingleNode("//menu/signup").getText();		
    String quizepath = document.selectSingleNode("//menu/quizepath").getText();
    
    System.out.println(mobileTesting+"|"+emailTextBox+"|"+signUpButton + "|" + quizepath);
    
    //Navigating to Mobile Testing and back		
    driver.findElement(By.xpath(mobileTesting)).click();					
    driver.navigate().back();			
    //Entering Form Data		
    driver.findElement(By.id(emailTextBox)).sendKeys("testguru99@gmail.com");						
    //driver.findElement(By.id(signUpButton)).click();				
    driver.findElement(By.xpath(quizepath)).click();
	}		
}