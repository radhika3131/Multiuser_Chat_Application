package com.radhika.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.radhika.chatapp.utils.Configreader;

@SuppressWarnings("unused")
public class Server {
	
	ServerSocket serverSocket;

	ArrayList<ServerWorker> workers = new ArrayList<ServerWorker>();
	@SuppressWarnings("unused")
	public Server() throws IOException
	{
		int PORT = Integer.parseInt(Configreader.getValue("PORTNO"));
		serverSocket = new ServerSocket(PORT);
		System.out.println("Server Start and Waiting for the clients to join...");
		handleClientRequest();
	}
	
	
	//Multiple client handshaking
	public void handleClientRequest() throws IOException
	{
		while(true)
		{	
		Socket clientSocket = serverSocket.accept();//Handshaking
		//Per Client Per Thread
		ServerWorker serverWorker = new ServerWorker(clientSocket,this);//Creating a new Worker/Thread
		workers.add(serverWorker);
		serverWorker.start();
		}
	}
		
	
	
	
	
	
	
	//constructor
	/* FOr single client */
	/*public Server() throws IOException{
		int PORT = Integer.parseInt(configReader.getValue("PORTNO"));
		serverSocket = new ServerSocket(PORT);
		System.out.println("Server Started and waiting for the client connection.....");
		Socket socket = serverSocket.accept() ;// HandShaking
		System.out.println("Client joins the Server");
		InputStream in =socket.getInputStream(); // reades bytes from the network
		byte arr[] = in.readAllBytes();
		String str = new String(arr); // bytes convert into string
		System.out.println("Message received from the Client\n"+str);
		in.close();
		socket.close();
	
	}*/

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		Server server = new Server();

	}

}
