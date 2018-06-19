import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Demo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe"); //
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://10.0.1.86/tatoc");
		driver.findElement(By.xpath("/html/body/div/div[2]/a[1]")).click();
		driver.findElement(By.className("greenbox")).click();
		
		/*String actualAnswer = driver.findElement(By.id("answer")).getAttribute("class");		
		Boolean condition = true;
		while(condition) {
			driver.findElement(By.cssSelector("body > center > a:nth-child(7)")).click();
			WebElement childDiv = driver.findElement(By.id("child"));
			driver.switchTo().frame(childDiv);
			String expectedAnswer = driver.findElement(By.id("answer")).getAttribute("class");
			driver.switchTo().parentFrame();
			if(actualAnswer.equals(expectedAnswer)) {
				condition = false;
			}
		}
		driver.findElement(By.cssSelector("body > center > a:nth-child(9)")).click();
		driver.switchTo().defaultContent();
		*/
		//WebElement e1 = driver.findElement(By.className("main"));
		
		
	}

}
