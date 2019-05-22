package com.hcl.spendanalyser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.spendanalyser.dto.ProductMonthlyReportDTO;
import com.hcl.spendanalyser.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<ProductMonthlyReportDTO> getMonthlyReport(Long prodId){
		return productRepository.getMonthlyReport(prodId);
	}
}