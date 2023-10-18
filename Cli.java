import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.Map;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Cli {

    public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)
		System.out.print("> "); // Prompt

		while (true) { // Infinite loop
			String command = scanner.nextLine(); // Get input from console as a string
			String output = ""; // A variable named output of type String
			String[] parts = command.split(" ");
			int nbrElems = parts.length;

			if (command.equals("exit") || command.equals("logout")) {
				break; // Forces exit of the while loop
			} else {

				if (command.equals("date")) {
					output = "" + LocalDate.now(); // print date
				} else if (command.equals("time")) {
					output = "" + LocalTime.now(); // print date
				} else if (command.equals("datetime")) {
					output = "" + LocalDateTime.now(); // print date and time
				} else if (command.equals("useraccount")) {
					output = System.getProperty("user.name"); // print name
				} else if (command.equals("userhome")) {
					output = System.getProperty("user.home"); // print home
				} else if (command.equals("os")) {
					output = System.getProperty("os.name") + " (" + System.getProperty("os.version") + ")"; // print OS
				} else if (command.equals("printenv")) {
					Map<String, String> env = System.getenv();
        				
					for (String envName : env.keySet()) {
            					System.out.format("%s%n", env.get(envName));
        				}
        			} else if (parts[0].equals("echo") || parts[0].equals("print")) {
					if (nbrElems < 2) {
						output = "";
					} else {						
						String result = "";

						for (int i = 1; i < nbrElems; i++) {
							result = result + parts[i] + " ";
						}
						output = result;
					}
				} else {
					output = "Command '" + command + "' not found.";
				}
			}
			System.out.println(output); // Print with new line (ln)
			System.out.print("> "); // Prompt
		}
		scanner.close(); // Best practice, always close a stream when no more needed
		System.out.println("Bye !");
    }

}

