package org.ssglobal.training.codes;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FunList {
	private BufferedReader bufferedReader;
	
	public FunList(String filename) {
		try {
			bufferedReader = Files.newBufferedReader(Paths.get(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public long countWords() {	
		return bufferedReader.lines().flatMap((str) -> {
					return Arrays.stream(str.split(" "));
		}).count();
	}
	
	public boolean enableDisplay() {
		if(bufferedReader.lines().toArray(String[]::new).length > 0) {
			showLines();
			return true;
		}
		return false;
	}
	
	void showLines() {
		bufferedReader.lines().forEach(line -> {
			System.out.println(line);
		});
	}
	
	public List<String> getContentList(){
		return bufferedReader.lines().collect(Collectors.toList());
	}
	
	public String[] getContentArray() {
		// return bufferedReader.lines().toArray(String[]::new);
		return (String[]) bufferedReader.lines().toArray();
	}
}

class Word {
	
	
}