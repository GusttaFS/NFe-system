package application;

import java.util.Scanner;

import entities.NFeManager;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		NFeManager manager = new NFeManager();
		
		final String MENU = "Enter 'register' to insert a NFe in the system;" +
							"\nEnter 'search' to find a NFe in the system;" +
							"\nEnter 'exit' to close the system.";
		
		System.out.println("System started...");
		System.out.println(MENU);
		manager.readerNFeFile("C:\\Users\\gusta\\OneDrive\\Documentos\\NFeDataSystem.txt");
		while (true) {
			String command = sc.next();
			sc.nextLine();
			if (command.equals("exit")) {
				break;
			} else if (command.equals("register")) {
				manager.registerNFe();
			} else if (command.equals("search")) {
				manager.searchNFe();
			}
		} System.out.println("System closed.");
		
		sc.close();
	}

}
