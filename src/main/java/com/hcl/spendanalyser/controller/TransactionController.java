package com.hcl.spendanalyser.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.spendanalyser.model.Transaction;
import com.hcl.spendanalyser.service.TransactionService;
import com.hcl.spendanalyser.util.CsvUtils;

@RestController
@RequestMapping("/api")
public class TransactionController {
	
	Logger logger = LoggerFactory.getLogger(TransactionController.class);
	
	@Autowired
	TransactionService transactionService;
	
	
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
	
//	@PostMapping(value = "/transactions", consumes="text/csv")
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
}
