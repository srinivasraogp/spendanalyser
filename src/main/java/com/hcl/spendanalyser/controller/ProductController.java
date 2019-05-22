package com.hcl.spendanalyser.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.spendanalyser.dto.ProductMonthlyReportDTO;
import com.hcl.spendanalyser.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService productService;

	@GetMapping("/product/spends/monthly/{prod_id}")
	public ResponseEntity<List<ProductMonthlyReportDTO>> retrieveMonthluySpends(@PathVariable Long prod_id) {
		logger.info("===retrieveMonthluySpends=========");
		List<ProductMonthlyReportDTO> results = productService.getMonthlyReport(prod_id);
		logger.info("===results========="+results);
		return new ResponseEntity<List<ProductMonthlyReportDTO>>(results, HttpStatus.OK);
	}

}
