package com.radhika.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JTextArea;

import com.radhika.chatapp.utils.Configreader;

@SuppressWarnings("unused")
public class Client {

	Socket socket;
	OutputStream out;
	InputStream in;
	ClientWorker worker;
	JTextArea textArea;
	public Client(JTextArea textArea) throws UnknownHostException, IOException
	{
		int PORT = Integer.parseInt(Configreader.getValue("PORTNO"));
		socket = new Socket(Configreader.getValue("SERVER_IP"),PORT);
		out = socket.getOutputStream();
		in = socket.getInputStream();
		this.textArea = textArea;
		readMessages();
		/*
		System.out.println("Client Comes");
		System.out.println("Enter the Message Send to the Server.....");  
		Scanner scanner = new Scanner(System.in);
		String message = scanner.nextLine();
		OutputStream out = socket.getOutputStream();//write bytes from the network
		out.write(message.getBytes());
		System.out.println("Message Send to the Server");
		scanner.close();
		out.close();
		socket.close();
		*/
	}
	
	public void sendMessage(String message) throws IOException
	{
		message = message +"\n";
		out.write(message.getBytes());
	}
	
	public void readMessages()
	{
		worker = new ClientWorker(in,textArea);//Calling a read thread
		worker.start();
	}
	
	
	//public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
     //   @SuppressWarnings("unused")
	//	Client client = new Client();
	//}

}
