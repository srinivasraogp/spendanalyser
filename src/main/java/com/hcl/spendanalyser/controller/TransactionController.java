package com.hcl.spendanalyser.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class TransactionController {
	
	@PostMapping(value = "/devices/upload")
	//, produces = { MediaType.APPLICATION_JSON_VALUE }
    public ResponseEntity<Map<String, String>> handleFileUpload(@RequestParam("file") MultipartFile file)
            throws IOException {
		
       // Logger.info("DeviceController:handleFileUpload start");
        String refId = String.valueOf(System.currentTimeMillis());
        String fileName = file.getOriginalFilename();
        Map<String, String> result = new HashMap<>();
        result.put("refId", refId);
        if (file.isEmpty()) {
            result.put("msg", "Empty File: " + fileName);
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

//        try (InputStream inStream = file.getInputStream()) {
//            List<String> lines = IOUtils.readLines(inStream, "UTF-8");
//            
//                try {
//                    deviceRegisterService.register(refId, fileName, lines);
//                } catch (FileNotFoundException | SQLException e) {
//                    //LOGGER.error("Error while calling deviceRegisterService's register method ", e);
//                }
//            });
//
//            result.put("msg", "Submitted File: " + fileName);
//           // LOGGER.info("DeviceController:handleFileUpload end");
            return new ResponseEntity<>(result, HttpStatus.OK);
      //  }
    }

}
