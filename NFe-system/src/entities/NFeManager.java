package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NFeManager {
	
	Scanner sc = new Scanner(System.in);
	private Map<String, List<NFe>> dataSystem = new HashMap<>();
	
	
	public void readerNFeFile(String path) {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
				String[] data = line.split(" ");
				this.addNFe(data[0], data[1], data[2], data[3]);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	
	public void registerNFe() {
		System.out.println("NFe registration started...");
		System.out.println("Enter '1 1 1 1' to end the registration.");
		while (true) {
			String date = sc.next();
			String series = sc.next();
			String number = sc.next();
			String description = sc.next();
			sc.nextLine();
			if (date.equals("1")) {
				break;
			} else {
				this.addNFe(date, series, number, description);
			}
		} System.out.println("Registration closed.");
	}
	
	
	private void addNFe(String date, String series, String number, String description) {
		if (!this.dataSystem.containsKey(date)) {
			this.dataSystem.put(date, new LinkedList<>());
			this.dataSystem.get(date).add(new NFe(number, series, date, description));
		} else {
			this.dataSystem.get(date).add(new NFe(number, series, date, description));
		}
	}


	public void searchNFe() {
		System.out.println("Search started...");
		System.out.println("Enter '1 1 1 1' to end the search.");
		
		String result = "NFe not found: ";
		while (true) {
			String number = sc.next();
			String series = sc.next();
			String date = sc.next();
			String description = sc.next();
			sc.nextLine();
			if (number.equals("1")) {
				break;
			} else {
				result += this.searchNFe(number, series, date, description);
			}
		} System.out.println("Search closed.");
		System.out.println(result);
	}
	
	
	private String searchNFe(String number, String series, String date, String description) {
		String result = "";
		if (this.numberVerification(number)) {
			if (!this.dataSystem.containsKey(date)) {
				result = " " + number + "-" + series + "-" + date;
			} else if (!this.dataSystem.get(date).contains(new NFe(number, series, date, description))) {
				result = " " + number + "-" + series + "-" + date;
			}
		} return result;
	}
	
	
	private boolean numberVerification(String number) {
		boolean result = true;
		 try {
			 Integer.parseInt(number);
	     } catch (NumberFormatException e){
	         result = false;
	     } return result;
	}
	
}
