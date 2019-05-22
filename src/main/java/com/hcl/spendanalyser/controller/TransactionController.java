package com.hcl.spendanalyser.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.spendanalyser.beans.TransactionDailyResponse;
import com.hcl.spendanalyser.dto.MonthlyReportDTO;
import com.hcl.spendanalyser.dto.WeeklyReportDTO;
import com.hcl.spendanalyser.model.Transaction;
import com.hcl.spendanalyser.service.TransactionService;
import com.hcl.spendanalyser.service.TransactionServiceReports;
import com.hcl.spendanalyser.util.CsvUtils;

@RestController
@RequestMapping("/api")
public class TransactionController {
	

	 private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);



	
	@Autowired
	TransactionService transactionService;
	
	 @Autowired
	 TransactionServiceReports transService;
	
	
	/*
	 * @PostMapping(value = "/devices/upload") //, produces = {
	 * MediaType.APPLICATION_JSON_VALUE } public ResponseEntity<Map<String, String>>
	 * handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException
	 * {
	 * 
	 * // Logger.info("DeviceController:handleFileUpload start"); String refId =
	 * String.valueOf(System.currentTimeMillis()); String fileName =
	 * file.getOriginalFilename(); Map<String, String> result = new HashMap<>();
	 * result.put("refId", refId); if (file.isEmpty()) { result.put("msg",
	 * "Empty File: " + fileName); return new ResponseEntity<>(result,
	 * HttpStatus.BAD_REQUEST); }
	 * 
	 * try (InputStream inStream = file.getInputStream()) { List<String> lines =
	 * IOUtils.readLines(inStream, "UTF-8");
	 * 
	 * try { deviceRegisterService.register(refId, fileName, lines); } catch
	 * (FileNotFoundException | SQLException e) {
	 * //LOGGER.error("Error while calling deviceRegisterService's register method "
	 * , e); } ////// }); ////// ////// result.put("msg", "Submitted File: " +
	 * fileName); ////// // LOGGER.info("DeviceController:handleFileUpload end");
	 * return new ResponseEntity<>(result, HttpStatus.OK); //// // } }
	 */
	

//	@PostMapping(value = "/transactions", consumes = "text/csv")
//    public ResponseEntity<List<Transaction>> uploadSimple(@RequestBody InputStream body) throws IOException {
//		List<Transaction> transactions = transactionService.saveTransactions(CsvUtils.read(Transaction.class, body));
//        return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.CREATED);
//    }
	
	

		
			@GetMapping("/dailyspend/{userId}")
			public ResponseEntity<List <TransactionDailyResponse>> dailySpendReport(@PathVariable Long userId){
				logger.debug("Getting Daily Transactions Starts ==========>> ");
			List<TransactionDailyResponse> dailyList = transService.getUserSpendDailyTransactions(userId);
			
			logger.debug("Getting Daily Transactions ends ==========>> " + dailyList);
			return new ResponseEntity<List<TransactionDailyResponse>>(dailyList, HttpStatus.OK);
			}

//	@PostMapping(value = "/transactions2", consumes="text/csv")
//	@ResponseBody
//    public ResponseEntity<List<Transaction>> uploadSimple(@RequestBody InputStream body) throws IOException {
//		logger.info("===uploadSimple=========");
//		
//		List<Transaction> transactions = transactionService.saveTransactions(CsvUtils.read(Transaction.class, body));
//        return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.CREATED);
//    }
	
	 @PostMapping(value = "/transactions", consumes = "multipart/form-data")
	    public ResponseEntity<List<Transaction>> uploadMultipart(@RequestParam("file") MultipartFile file) throws IOException {
		 logger.info("===uploadSimple=========");
		 List<Transaction> transactionRows = CsvUtils.read(Transaction.class, file.getInputStream());
		 List<Transaction> transactions = transactionService.saveTransactions(transactionRows);
		 return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.CREATED);
	    }

	 
	 @GetMapping("/spends/monthly/{user_id}")
		public ResponseEntity<List<MonthlyReportDTO>> retrieveMonthlySpends(@PathVariable Long user_id) {
			logger.info("===retrieveMonthluySpends=========");
			List<MonthlyReportDTO> results = transactionService.getMonthlyReport(user_id);
			logger.info("===results=========");
			return new ResponseEntity<List<MonthlyReportDTO>>(results, HttpStatus.OK);
		}
	 
	 @GetMapping("/spends/weekly/{user_id}")
		public ResponseEntity<List<WeeklyReportDTO>> retrieveWeeklySpends(@PathVariable Long user_id) {
			logger.info("===retrieveWeeklySpends=========");
			List<WeeklyReportDTO> results = transactionService.getWeeklyReport(user_id);
			logger.info("===results=========");
			return new ResponseEntity<List<WeeklyReportDTO>>(results, HttpStatus.OK);
		}
		
}
