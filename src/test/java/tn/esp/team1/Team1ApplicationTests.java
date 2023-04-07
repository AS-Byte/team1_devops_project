package tn.esp.team1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import tn.esp.team1.entities.Stock;
import tn.esp.team1.repositories.StockRepository;
import tn.esp.team1.services.StockServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class Team1ApplicationTests {

    @Test
    void contextLoads() {
    }
    @InjectMocks
	private StockServiceImpl stockService;
	@Mock
	private StockRepository stockRepository;
	
	@Test
	@DisplayName("should save the stock to database")
	void addStock() {
		
		Stock stock= new Stock();
		stock.setLibelleStock("stock test");
		stock.setQte(10);
		stock.setQteMin(5);
		when(stockRepository.save(any())).thenReturn(stock);
		Stock newStock=stockService.addStock(stock);
		assertNotNull(newStock);
		assertThat(newStock.getLibelleStock()).isEqualTo("stock test");
	}
	
	
	@Test
	@Order(1)
	@DisplayName("should return list of stock")
	void getAllStock() {
		
		Stock stock1= new Stock();
		stock1.setLibelleStock("stock 1 test");
		stock1.setQte(11);
		stock1.setQteMin(5);
		
		Stock stock2= new Stock();
		stock2.setLibelleStock("stock 2 test");
		stock2.setQte(12);
		stock2.setQteMin(5);
		
		List<Stock> list = new ArrayList<>();
		list.add(stock1);
		list.add(stock2);
		
		when(stockRepository.findAll()).thenReturn(list);
		List<Stock> listStock= stockService.retrieveAllStocks();
		assertEquals(2, listStock.size());
		assertNotNull(listStock);
	}
	
	@Test
	@DisplayName("should get the stock by id")
	void retrieveStock() {
		
		Stock stock= new Stock();
		stock.setIdStock(1L);
		stock.setLibelleStock("stock test");
		stock.setQte(10);
		stock.setQteMin(5);
		when(stockRepository.findById(anyLong())).thenReturn(Optional.of(stock));
		Stock existingStock=stockService.retrieveStock(1L);
		assertNotNull(existingStock);
		assertThat(existingStock.getIdStock()).isEqualTo(1L);
		
	}
	
}
