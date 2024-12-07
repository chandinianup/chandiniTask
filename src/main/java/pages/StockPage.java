package pages;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StockPage {
    WebDriver driver;

    public StockPage(WebDriver driver) {
        this.driver = driver;
    }
    private By searchFiled = By.id("ybar-sbq");
    private By SearchButton = By.id("ybar-search");
    private By marketCap = By.xpath("//span[@title='Market Cap (intraday)']//following-sibling::span");
    private By PE_Ratio = By.xpath("//span[@title='PE Ratio (TTM)']//following-sibling::span");
    private By divident_Yield = By.xpath("//span[@title='Forward Dividend & Yield']//following-sibling::span");
    private By EPS_Ratio =   By.xpath("//span[@title='EPS (TTM)']//following-sibling::span");  
    private By current_Price = By.xpath("//*[contains(@data-testid,'qsp-price') and contains(@data-field,'MarketPrice')]");
    
 
    
	
	  private By marketCapGrow =
	  By.xpath("//td[text()='Market Cap']//following-sibling::td"); private By
	  PE_RatioGrow = By.xpath("//td[text()='P/E Ratio']//following-sibling::td");
	  private By divident_YieldGrow =
	  By.xpath("//td[text()='Div. Yield']//following-sibling::td"); private By
	  EPS_RatioGrow = By.xpath("//td[text()='EPS(TTM)']//following-sibling::td");
	  private By current_PriceGrow = By.
	  xpath("//h1[@title='Apple Inc']//parent::div//following-sibling::div/div/div[@class='valign-wrapper']"
	  );
	/* 
    
    private By marketCapGrow = By.xpath("//span[text()='Market Cap']//following-sibling::span[@class='SplitStats-price']");
    private By PE_RatioGrow = By.xpath("//span[text()='P/E (TTM)']//following-sibling::span[@class='Summary-value']");
    private By divident_YieldGrow = By.xpath("//span[text()='Dividend Yield']//following-sibling::span[@class='SplitStats-price']");
    private By EPS_RatioGrow = By.xpath("//span[text()='EPS (TTM)']//following-sibling::span[@class='Summary-value']");
    private By current_PriceGrow = By.xpath("//span[@class='QuoteStrip-lastPrice']");
  */
    static HashMap<String,String> map=new HashMap<String,String>();

    public void serachForStock(String stockName) throws InterruptedException {
    	driver.findElement(searchFiled).click();
    	Thread.sleep(4000);
    	driver.findElement(searchFiled).sendKeys(stockName);
    	Thread.sleep(4000);
    }
    public void clickOnSearchButton() throws InterruptedException {
    	driver.findElement(SearchButton).click();
    	Thread.sleep(10000);
    }
    public String getMarketCap() {
        return driver.findElement(marketCap).getText().replaceAll("$","");
    }   
    
    public String getCurrentStockPrice() {
        return driver.findElement(current_Price).getText().replaceAll("$","");
       
    } 
    public String getEPSRatio() {
        return driver.findElement(EPS_Ratio).getText().replaceAll("$","");
        
    }   
    public String getDividentYield() {
        return driver.findElement(divident_Yield).getText().replaceAll("$","");
        
    }
   
    
    public String getPERatio() {
        return driver.findElement(PE_Ratio).getText().replaceAll("$","");
        
    }
   public void luanchUrl(String Url) {
	   driver.get(Url);
	   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
   }
public HashMap<String,String> fetchStockDataFromYahoo() {
        //System.out.println("Market Cap: " + getMarketCap());
	HashMap<String,String> mapYahoo=new HashMap<String,String>();
        mapYahoo.put("Market Cap", getMarketCap());
        mapYahoo.put("PE Ratio", getPERatio());
        mapYahoo.put("Divident Yield", getDividentYield());
        mapYahoo.put("EPS Ratio", getEPSRatio());
        mapYahoo.put("Current Price", getCurrentStockPrice());
       System.out.println(mapYahoo);
        return mapYahoo;
    }
public String getMarketCapFromGrow() {
    String value= driver.findElement(marketCapGrow).getText().replaceAll("$","");
    return value;
}   

public String getCurrentStockPriceFromGrow() {
    String value=driver.findElement(current_PriceGrow).getText().replaceAll("$","");
    System.out.println(value);
   return value;
} 
public String getEPSRatioFromGrow() {
    
    		String value=driver.findElement(EPS_RatioGrow).getText().replaceAll("$","");
    return value;
}   
public String getDividentYieldFromGrow() {
    
  String value1=driver.findElement(divident_YieldGrow).getText().replaceAll("$","");
    return value1;
}


public String getPERatioFromGrow() {
     String value1=driver.findElement(PE_RatioGrow).getText().replaceAll("$","");
    return value1;
}
public HashMap<String,String> fetchStockDataFromGroww() {
	HashMap<String,String> mapGrow=new HashMap<String,String>();
    //System.out.println("Market Cap: " + getMarketCap());
    mapGrow.put("Market Cap", getMarketCapFromGrow());
    mapGrow.put("PE Ratio", getPERatioFromGrow());
    mapGrow.put("Divident Yield", getDividentYieldFromGrow());
    mapGrow.put("EPS Ratio", getEPSRatioFromGrow());
    mapGrow.put("Current Price", getCurrentStockPriceFromGrow());
    System.out.println(mapGrow);
    return mapGrow;
}
}
