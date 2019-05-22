package com.hcl.spendanalyser.service.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.spendanalyser.dto.ProductMonthlyReportDTO;
import com.hcl.spendanalyser.repository.ProductRepository;
import com.hcl.spendanalyser.service.ProductServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductServiceTest.class)
public class ProductServiceTest {

	@Mock
	private ProductRepository productRepository;
	
	@InjectMocks
	private ProductServiceImpl service;
	
	@Test
	public void monthlyReportSuccess() throws Exception {

		List<ProductMonthlyReportDTO> mockData = new ArrayList<ProductMonthlyReportDTO>();
		ProductMonthlyReportDTO data1 = new ProductMonthlyReportDTO(111l, "March", new BigDecimal(1500));
		ProductMonthlyReportDTO data2 = new ProductMonthlyReportDTO(111l, "April", new BigDecimal(1500));
		
		mockData.add(data1);
		mockData.add(data2);
		
		Mockito.when(
				productRepository.getMonthlyReport(111l)).thenReturn(mockData);

		//test
        List<ProductMonthlyReportDTO> monthlyreportResult = service.getMonthlyReport(111l);
         
        assertEquals(2, monthlyreportResult.size());
        verify(productRepository, times(1)).getMonthlyReport(111l);
        
	}
	
}
