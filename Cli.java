import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.Map;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Cli {

    public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)
		System.out.print("> "); // Prompt

		while (true) { // Infinite loop
			String command = scanner.nextLine(); // Get input from console as a string
			StringBuilder output = new StringBuilder();
			String[] parts = command.split(" ");
			int nbrElems = parts.length;

			if (command.equals("exit") || command.equals("logout")) {
				break; // Forces exit of the while loop
			} else {

				if (command.equals("date")) {
					output.append(LocalDate.now()); // print date
				} else if (command.equals("time")) {
					output.append(LocalTime.now()); // print date
				} else if (command.equals("datetime")) {
					output.append(LocalDateTime.now()); // print date and time
				} else if (command.equals("useraccount")) {
					output.append(System.getProperty("user.name")); // print name
				} else if (command.equals("userhome")) {
					output.append(System.getProperty("user.home")); // print home
				} else if (command.equals("os")) {
					output.append(System.getProperty("os.name")).append(" (").append(System.getProperty("os.version")).append(")"); // print OS
				} else if (parts[0].equals("printenv")) {
					if (nbrElems < 2) {
        					Map<String, String> variables = System.getenv();
        					for (String key : variables.keySet()) {
            						output.append(key).append("=").append(variables.get(key)).append(System.lineSeparator());
      						}
					} else {
						String homeValue = System.getenv(parts[1]);
						if (homeValue == null) {
							output.append("");
						} else {
							output.append(homeValue);
						}
					}
        			} else if (parts[0].equals("echo") || parts[0].equals("print")) {
					if (nbrElems < 2) {
						output.append("");
					} else {						
						for (int i = 1; i < nbrElems; i++) {
							output.append(parts[i]).append(" ");
						}
					}
				} else if (parts[0].equals("ls")) {
					if (nbrElems < 2) {
						output.append("Not a directory");
					} else {
						String filePath = parts[1];
						
        					File path = new File(filePath);

						if (!path.exists()) {
							output.append("Not a directory");
						} else {
							File[] liste = path.listFiles();

      							for(File item : liste) {
        							if(item.isFile()) {
									output.append(String.format("%s%n", item.getName()));
        							} else if(item.isDirectory()) {
									output.append(String.format("%s%n", item.getName()));
        							} 
      							}
						}
					}
				} else {
					output.append("Command '").append(parts[0]).append("' not found.");
				}
			}
			System.out.println(output); // Print with new line (ln)
			System.out.print("> "); // Prompt
		}
		scanner.close(); // Best practice, always close a stream when no more needed
		System.out.println("Bye !");
    }

}

