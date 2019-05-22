//package com.hcl.spendanalyser.controller.test;
//
//import java.math.BigDecimal;
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import com.hcl.spendanalyser.controller.ProductController;
//import com.hcl.spendanalyser.dto.ProductMonthlyReportDTO;
//import com.hcl.spendanalyser.service.ProductService;
//
//import junit.framework.Assert;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(value = ProductController.class, secure = false)
////@ComponentScan(basePackages = "com.hcl.spendanalyser.controller")
//public class ProductControllerTest {
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@MockBean
//	private ProductService productService;
//
//	ProductMonthlyReportDTO ProductMonthlyReportDTO = new ProductMonthlyReportDTO(111l, "April", new BigDecimal(1500));
//	List<ProductMonthlyReportDTO> mockData = Arrays.asList(ProductMonthlyReportDTO);
//	
//	@Test
//	public void retrieveMonthluySpendsSuccess() throws Exception {
//
//		Mockito.when(
//				productService.getMonthlyReport(Mockito.anyLong())).thenReturn(mockData);
//
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
//				"/spendanalyser/api/product/spends/monthly/{prod_id}", new Long(111)).accept(
//						MediaType.APPLICATION_JSON);
//
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		System.out.println("Results========"+result.getResponse().getStatus());
//
//		Assert.assertEquals(200, result.getResponse().getStatus());
//		
//		Assert.assertEquals("[{'prod_id': 111,'transaction_month': 'April';'amount': 1500}]", result.getResponse().getContentAsString());
//		//
//		//		System.out.println("Results========"+result.getResponse().getContentAsString());
//		//		Assert.assertEquals(3, result.getResponse().getContentLength());
//
//
//		//		this.mockMvc.perform(get("/spendanalyser/api//spends/monthly/111l"))
//		//        .andExpect(status().isOk())
//		//		.andExpect((ResultMatcher)content().json("[{'prod_id': 111,'transaction_month': 'April';'amount': 1500}]"));
//
//
//	}
//
//}
