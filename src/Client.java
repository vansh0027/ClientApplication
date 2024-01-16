import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 8000);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			Scanner scanner = new Scanner(System.in);

			while (true) {

				System.out.println("Command: ");
				String command = scanner.nextLine();
				bufferedWriter.write(command);
				bufferedWriter.newLine();
				bufferedWriter.flush();

				String response = bufferedReader.readLine();
				System.out.println("Server Response" + response);
				if (command.equalsIgnoreCase("quit")) {
					break;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
