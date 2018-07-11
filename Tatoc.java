import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.interactions.Actions;



public class Tatoc {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "G:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://10.0.1.86/tatoc");
		driver.findElement(By.xpath("/html/body/div/div[2]/a[1]")).click();
		driver.findElement(By.className("greenbox")).click();
		
		driver.switchTo().frame("main");
		String box1=driver.findElement(By.cssSelector("#answer")).getAttribute("class");
		driver.switchTo().frame("child");
		String box2=driver.findElement(By.cssSelector("#answer")).getAttribute("class");
		System.out.println(box1);
		System.out.println(box2);
		
		while(!box1.equals(box2))
		{
			driver.switchTo().defaultContent();
			driver.switchTo().frame("main");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.linkText("Repaint Box 2")).click();
			driver.switchTo().frame("child");
			box2=driver.findElement(By.cssSelector("#answer")).getAttribute("class");
			System.out.println(box2);
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		driver.findElement(By.linkText("Proceed")).click();
		
		
		WebElement element = driver.findElement(By.id("dragbox"));
		WebElement target = driver.findElement(By.id("dropbox"));

		(new Actions(driver)).dragAndDrop(element, target).perform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			driver.findElement(By.linkText("Proceed")).click();
			
			
			
			
			driver.findElement(By.linkText("Launch Popup Window")).click();
			 String firstWinHandle = driver.getWindowHandle();
	            for(String webHand: driver.getWindowHandles()){
	                driver.switchTo().window(webHand);
	             }
	           try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	            driver.findElement(By.cssSelector("input#name")).sendKeys("Daksha");
	            try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            driver.findElement(By.cssSelector("input#submit")).click();
	            driver.switchTo().window(firstWinHandle);
	            driver.findElement(By.linkText("Proceed")).click();
			
			
			
			driver.findElement(By.linkText("Generate Token")).click();
		        String Cookie_val = driver.findElement(By.id("token")).getText();
		        String Cookie = Cookie_val.substring(7);
		        Cookie cookie = new Cookie("Token", Cookie);
		        driver.manage().addCookie(cookie);
		        driver.findElement(By.linkText("Proceed")).click();

	}

}
