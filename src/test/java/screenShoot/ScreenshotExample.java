package screenShoot;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;






	   
public class ScreenshotExample {
	//@Test
	
	 public  void main() throws IOException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://www.facebook.com/reg");
		
		
		LocalDateTime CurrentDateTime =LocalDateTime.now();
		
		String convertedDateTime = CurrentDateTime.toString().replace(":", "-").replace(".", "-");
		
			        
			        // Take a screenshot and save it to memory
			        File CapturedScreenshot = ((TakesScreenshot)   driver).getScreenshotAs(OutputType.FILE);
			        
			        //Take screenshot and provide a name
			        
			        FileUtils.copyFileToDirectory(CapturedScreenshot,new File("./target/Screenshots/"+convertedDateTime+ ".png") );
			        
//			        try {
//						FileUtils.copyFileToDirectory(CapturedScreenshot,new File("./target/Screenshots/"+convertedDateTime+ ".jpg") );
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
			     			           
//			       driver.quit();
			        
			        
			        
			        
			    }//main
			}//class
