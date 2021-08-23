package org.ssglobal.training.codes;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;
import java.util.stream.Collectors;

public class FunList {
	private BufferedReader bufferedReader;
	@SuppressWarnings("unused")
	private Word word; // Injectables
	
	// Step 1: Create a logger
	private static Logger logger = Logger.getLogger(FunList.class.getName());
	
	{
		// Step 1B: Set the logging level
		logger.setLevel(Level.INFO); // Only done once
		
		// Step 2: Creating another handler
		// Step 3: Format the message
		try {
			FileHandler fileHandler = new FileHandler("./src/log/funlist.log", true);
			fileHandler.setEncoding("UTF-8"); // always do this
			fileHandler.setLevel(Level.INFO); 
			
			SimpleFormatter formatter = new SimpleFormatter();
			fileHandler.setFormatter(formatter);
			
			logger.addHandler(fileHandler);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public FunList(String filename) {
		try {
			bufferedReader = Files.newBufferedReader(Paths.get(filename));
		} catch (IOException e) {
			// Step 1C:
			logger.severe("Error message: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public FunList() {
		
	}

	public long countWords() {	
		logger.info("execute countWords");
		long temp = bufferedReader.lines().flatMap((str) -> {
					return Arrays.stream(str.split(" "));
								}).count();
		logger.info("exit without errors countWords");
		return temp;
	}
	
	@SuppressWarnings("deprecation")
	public boolean enableDisplay() {
		logger.info("execute enableDisplay");
		
		logger.warning("custom Date is deprecated");
		Date xmas = new Date(121, 11, 25);

		try {
			if(bufferedReader.lines().toArray(String[]::new).length > 0) {
				showLines();
				logger.info("exit without errors enableDisplay");
				return true;
			}
		} catch (Exception e) {
			logger.severe("Error message: " + e.getMessage());
		}
		logger.info("exit with errors enableDisplay");
		return false;
	}
	
	public void showLines() {
		logger.info("execute showLines");
		bufferedReader.lines().forEach(line -> {
			System.out.println(line);
		});
		logger.info("exit without error showLines");
	}
	
	public List<String> getContentList(){
		logger.info("execute getContentList");
		List<String> temp = bufferedReader.lines().collect(Collectors.toList());
		logger.info("exit showLines without error");
		return temp;
	}
	
	public String[] getContentArray() {
		// return bufferedReader.lines().toArray(String[]::new);
		return (String[]) bufferedReader.lines().toArray();
	}
	
	public String processStr(String str1, String str2) {
		return String.join(" ", str1, str2);
	}
}

class Word {
	
	
}