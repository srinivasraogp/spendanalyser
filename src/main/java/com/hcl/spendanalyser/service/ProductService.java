package com.hcl.spendanalyser.service;

import java.util.List;

import com.hcl.spendanalyser.dto.ProductMonthlyReportDTO;

public interface ProductService {

	List<ProductMonthlyReportDTO> getMonthlyReport(Long prodId);
}
