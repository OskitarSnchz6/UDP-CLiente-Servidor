package UniHilo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

class Client {
	public static void main(String argv[]) throws Exception	{
		String sentence;
		String modifiedSentence;
		
		// Create a client socket, connect to server
		Socket clientSocket = new Socket("127.0.0.1", 2010);
		System.out.println("Cliente conectado desde el puerto " + clientSocket.getPort() + "\n");
		
		// Create an output stream attached to the socket
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		// Create an input stream
		BufferedReader inFromServer =	new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		for (int i=1; i < 100; i++)	{
			Thread.sleep(1000);
		
			sentence = i + " hola";
			
			// Send a line to server
			outToServer.writeBytes(sentence + '\n');
			
			System.out.println("Palabra recogida por el teclado : " + sentence + '\n');
			
			// Read a line from server
			modifiedSentence = inFromServer.readLine();
	
			System.out.println("Palabra recibida por el servidor: " + modifiedSentence);
			
			}
		clientSocket.close();
		}
	}