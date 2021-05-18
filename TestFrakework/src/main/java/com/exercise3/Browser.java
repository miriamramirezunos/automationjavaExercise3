package com.exercise3;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {
	public static WebDriver driver;
	
	public Browser(WebDriver driver){
		Browser.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	static By linkToCuenta = By.cssSelector("#nav-link-accountList"); 
	static By inputAmazonUser = By.cssSelector("#ap_email"); 
	static By btnCuentaContinuar = By.cssSelector("#continue"); 
	static By inputAmazonPw = By.cssSelector("#ap_password"); 
	static By btnAuthSignIn = By.cssSelector("#auth-signin-button");
	static By cerrarSesion = By.cssSelector("#nav-item-signout");
	static By inputSearchBar = By.cssSelector("#twotabsearchtextbox"); 
	static By btnSearchBar = By.cssSelector("#nav-search>form>div:nth-of-type(4)>div"); 
	static By sponsored = By.cssSelector("#search>div:nth-of-type(1)>div:nth-of-type(2)>div>span:nth-of-type(4)>div>div:nth-of-type(1)>div>span>div>div>div>div:nth-of-type(1)>div>div>div>div>div>div>div:nth-of-type(1)>div>span:nth-of-type(2)");
	static By strPriceGalaxySponsored = 	By.cssSelector("#search>div:nth-of-type(1)>div:nth-of-type(2)>div>span:nth-of-type(4)>div>div:nth-of-type(1)>div>span>div>div>div>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div>div>div>div>a>span:nth-of-type(1)>span:nth-of-type(1)");
	static By linkPriceGalaxySponsored =  	By.cssSelector("#search>div:nth-of-type(1)>div:nth-of-type(2)>div>span:nth-of-type(4)>div>div:nth-of-type(1)>div>span>div>div>div>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div>div>div>div>a");
	static By strPriceGalaxy = 				By.cssSelector("#search>div>div>div>div>span>div:nth-of-type(2)>div:nth-of-type(1)>div>span>div>div>div:nth-of-type(4)>div>a>span:nth-of-type(1)>span:nth-of-type(1)");
	static By linkPriceGalaxy =  			By.cssSelector("#search>div>div>div>div>span>div:nth-of-type(2)>div:nth-of-type(1)>div>span>div>div>div:nth-of-type(2)>h2>a");
	static By galaxyPrice = By.cssSelector("#price_inside_buybox"); 
	static By btnAddToCart = By.cssSelector("#add-to-cart-button");
	static By cartButton = By.cssSelector("#hlb-view-cart-announce"); 
	static By subTotal = By.cssSelector("#activeCartViewForm>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(4)>div>div:nth-of-type(2)>p>span"); 
	static By cartCount = By.cssSelector("#nav-cart-count"); 
	static By linkPriceAlienware =  By.cssSelector("#search>div>div>div>div>span>div:nth-of-type(2)>div:nth-of-type(2)>div>span>div>div>div:nth-of-type(2)>h2>a"); 
	
	public static void goTo(String url) throws Exception {
		try{
			System.setProperty("webdriver.chrome.driver", "C:\\Drivers2\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);	
			driver.manage().window().maximize();
		   }
		catch (Exception e) {
			throw(e);
		}
	}
	
	public static void loginAmazonUser(String strUser, String strPw) throws Exception{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			driver.findElement(linkToCuenta).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(inputAmazonUser)); 
			driver.findElement(inputAmazonUser).sendKeys(strUser);
			driver.findElement(btnCuentaContinuar).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(inputAmazonPw)); 
			driver.findElement(inputAmazonPw).sendKeys(strPw);
			driver.findElement(btnAuthSignIn).click();
		}
		catch (Exception e) {
			throw(e);
		}
	}
	
	public static void searchSamsung() throws Exception{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(inputSearchBar));
			driver.findElement(inputSearchBar).sendKeys("Samsung Galaxy S9 64GB");
			wait.until(ExpectedConditions.presenceOfElementLocated(btnSearchBar));
			driver.findElement(btnSearchBar).click();
		}	
		catch (Exception e) {
			throw(e);
		}	
	} 
	
	public static String selectFirstProduct() throws Exception{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(strPriceGalaxy));
			return driver.findElement(strPriceGalaxy).getAttribute("innerHTML");		
		}
		catch (Exception e) {
			throw(e);
		}
	}
	
	public static void clickFirstProduct() throws Exception{
		try{
			if(driver.findElements(sponsored).size() != 0) {
				driver.findElement(linkPriceGalaxySponsored).click();
			}else {
				driver.findElement(linkPriceGalaxy).click();
		}
		}
		catch (Exception e) {
			throw(e);
		}
	}
		
	public static String obtainDetailPrice() throws Exception{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(galaxyPrice));			
			return driver.findElement(galaxyPrice).getText(); 
		}
		catch (Exception e) {
			throw(e);
		}
	}
	
	public static void addToCart() throws Exception{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(btnAddToCart));
			driver.findElement(btnAddToCart).click();			
		}
		catch (Exception e) {
			throw(e);
		}
	}
	
	public static String subTotal() throws Exception{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(cartButton));	
			driver.findElement(cartButton).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(subTotal));			
			return driver.findElement(subTotal).getAttribute("innerHTML");
		}
		catch (Exception e) {
			throw(e);
		}
	}
	
	public static String cartCount()throws Exception{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(cartCount));			
			return driver.findElement(cartCount).getText(); 		
		}
		catch (Exception e) {
			throw(e);
		}
	}
	
	public static void searchAlienware() throws Exception{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(inputSearchBar));
			driver.findElement(inputSearchBar).sendKeys("Alienware Aw3418DW");
			driver.findElement(btnSearchBar).click();
		}	
		catch (Exception e) {
			throw(e);
		}	
	} 
	
	public static void clickAlienProduct() throws Exception{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(linkPriceAlienware));
			driver.findElement(linkPriceAlienware).click();
		}
		catch (Exception e) {
			throw(e);
		}
	}
	
	public static void close() throws Exception {
		try{
			Actions action = new Actions(driver);
			WebElement cuenta = driver.findElement(linkToCuenta); 
			action.moveToElement(cuenta).build().perform();
			driver.findElement(cerrarSesion).click();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver.quit();
		}
		catch (Exception e) {
			throw(e);
		}
	}

}
