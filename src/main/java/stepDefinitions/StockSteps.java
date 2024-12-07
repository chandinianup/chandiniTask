package stepDefinitions;

import java.util.HashMap;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.StockPage;
import utilities.LoggerUtil;
import org.apache.logging.log4j.Logger;

public class StockSteps {
    WebDriver driver;
    StockPage stockPage;
    ExtentReports extentReports;
    ExtentTest test;
    private static final Logger logger = LoggerUtil.getLogger(StockSteps.class);
    // Initialize ExtentReports and WebDriver
    static HashMap<String,String> mapYahoo=new HashMap<String,String>();
    static HashMap<String,String> mapGrow=new HashMap<String,String>();
    @Given("I open the browser and navigate to Yahoo Finance")
    public void i_open_the_browser_and_navigate_to_yahoo_finance() {
        // Initialize WebDriverManager and set up the driver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
        // Open Yahoo Finance with the given stock symbol
        driver.get("https://finance.yahoo.com/");
        logger.info("Url launched");
        
        // Initialize the StockPage class
        stockPage = new StockPage(driver);
        
        // Set up Extent Reports
        extentReports = new ExtentReports();
        test = extentReports.createTest("Open Yahoo Finance");
    }

    @When("I fetch stock data for {string}")
    public void i_fetch_stock_data(String stockName) {
        // Fetch stock data using the StockPage class
    	
    	mapYahoo=stockPage.fetchStockDataFromYahoo();
        test.info("Fetching stock data for: " + stockName);
    }
    @When("I fetch stock data for {string} from Groww")
    public void i_fetch_stock_data_for(String stockSymbol) {
        // Fetch stock data using the StockPage class
    	mapGrow=stockPage.fetchStockDataFromGroww();
        test.info("Fetching stock data for: " + stockSymbol);
    }
    @When("I search for stock {string}")
    public void i_search_for_stock(String stockName) throws InterruptedException {
        // Fetch stock data using the StockPage class
        stockPage.serachForStock(stockName);
        test.info("user enter stock name on Search filed as "+stockName);
        stockPage.clickOnSearchButton();
        test.info("user clicked on Search button");
    }

    @Then("I validate the stock data with external source")
    public void i_validate_the_stock_data_with_external_source() {
      
        try {
        // Validate the fetched stock data with external source
        Assert.assertTrue(mapYahoo.equals(mapGrow));
        test.pass("Stock data validated successfully!");
        }catch(Exception e) {
        	e.printStackTrace();
        	test.fail("Stock data not equal");
        }
    }

    // This method generates the extent report after the test is completed
    @Then("I generate an Extent Report")
    public void i_generate_an_extent_report() {
        // Flush the extent report
        extentReports.flush();
    }
    @Then("I launch new url {string}")
    public void i_launch_new_url(String url) {
        // Flush the extent report
    	stockPage.luanchUrl(url);
    }

    // Quit the WebDriver after each scenario to clean up
    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
