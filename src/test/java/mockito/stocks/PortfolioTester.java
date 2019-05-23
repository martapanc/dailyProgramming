package mockito.stocks;

import mockito.stocks.Portfolio;
import mockito.stocks.Stock;
import mockito.stocks.StockService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PortfolioTester {

    private Portfolio portfolio;
    private StockService stockService = mock(StockService.class);

    @Before
    public void setUp() {

        portfolio = new Portfolio();
        portfolio.setStockService(stockService);
    }

    @Test
    public void testMarketValue() {

        List<Stock> stocks = new ArrayList<>();
        Stock googleStock = new Stock("1", "Google", 10);
        Stock microsoftStock = new Stock("2", "Microsoft", 100);

        stocks.add(googleStock);
        stocks.add(microsoftStock);

        portfolio.setStocks(stocks);

        when(stockService.getPrice(googleStock)).thenReturn(50.00);
        when(stockService.getPrice(microsoftStock)).thenReturn(1000.00);

        assertEquals(100500.0, portfolio.getMarketValue(), 0.01);
    }
}
