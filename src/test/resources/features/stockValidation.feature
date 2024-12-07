Feature: Stock Data Validation

  Scenario: Validate financial data for a stock
    Given I open the browser and navigate to Yahoo Finance  
     And I search for stock "AAPL"
    When I fetch stock data for "AAPL"
    And I launch new url "https://groww.in/us-stocks/aapl"
    #And I search for stock "AAPL"
    When I fetch stock data for "AAPL" from Groww
    Then I validate the stock data with external source
    And I generate an Extent Report
