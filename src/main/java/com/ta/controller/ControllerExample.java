package com.ta.controller;
import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.ta.Service.TestControllerImpl;

@RestController
@RequestMapping("/gayu/")

public class ControllerExample {
	String calculation;
//	@Autowired TestControllerImpl obj;
    @Value("${fpath}")
    private String filepath ;
   

//	@RequestMapping(value = "testAPI", method = RequestMethod.GET)
//	
//	public ResponseEntity<?> testApi(@RequestParam Map<String,String> requestParams)
//			throws Exception {
//		int ans=0;
//		String Status="Success";
//		try
//		{
//			Logger log = LogManager.getLogger("GETBatch");
//			log.debug("testAPI started: " + requestParams);
//			log.info("testAPI started: " + requestParams);
//
//		System.out.println(requestParams);
//		
//		String operation = requestParams.get("operation");
//		int n1 = Integer.parseInt(requestParams.get("number1"));
//		System.out.println("Number1"+n1);
//		int n2 = Integer.parseInt(requestParams.get("number2"));
//		System.out.println( "Number2"+n2);
//
//		switch (operation) {
//		case "add":
//			ans = obj.add(n1, n2);
//			break;
//		case "sub":
//			ans = obj.sub(n1, n2);
//			break;
//		case "multiply":
//			ans = obj.multiplication(n1, n2);
//			break;
//		case "division":
//
//			ans = obj.division(n1, n2);
//			break;
//
//		}
//		}catch(Exception e)
//		{
//			Status="Failiure";
//			System.out.println(e);
//		}
//		requestParams.put("Status", Status);
//		requestParams.put("Answer",ans+"");
//		
//		
//
//		return new ResponseEntity<>(requestParams, HttpStatus.OK);
//		
//	}
	
@RequestMapping(value = "loadProperties", method = RequestMethod.GET)
	
	public ResponseEntity<?> loadProperties(@RequestParam Map<String,String> requestParams)
			throws Exception {
	System.out.println("Filepath= "+filepath);
	Properties p =new Properties();

			try
		{
				
				Logger log = LogManager.getLogger("GETBatch");
				log.debug("testAPI started: " + requestParams);
				log.info("testAPI started: " + requestParams);

				
				
				FileInputStream file=new FileInputStream(filepath);
				p.load(file);
			
		
		}catch(Exception e)
		{
						System.out.println(e);
		}
		
		

		return new ResponseEntity<>(p, HttpStatus.OK);
		
	}




}
