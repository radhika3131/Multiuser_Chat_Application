package com.radhika.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.net.Socket;

//Thread = work
//Worker need a Job to perform
//For Job u give runnable 
//Once job  is created via Runnable so write the job logic inside a run function
// Assign the job to a Thread/Worker
//public class ServerWorker implements Runnable {
	
public class ServerWorker extends Thread{
	
	@SuppressWarnings("unused")
	private Socket clientSocket;
	@SuppressWarnings("unused")
	private InputStream in;
	@SuppressWarnings("unused")
	private OutputStream out;
	private Server server;
	public ServerWorker(Socket clientSocket, Server server) throws IOException {
		// TODO Auto-generated constructor stub
		this.server = server;
		this.clientSocket = clientSocket;
		in = clientSocket.getInputStream();// Client Data Read
		out = clientSocket.getOutputStream(); // Client Data Write
		System.out.println("New Client Comes");
	}

	@Override
	public void run()
	{
		//Read Data from the Client and BroadCast the data to all
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String line;
				try {
				while(true)
				{
					
						line = br.readLine();
						System.out.println("Line read.."+line);
						if(line.equalsIgnoreCase("Quit"))
						{
							break; // Client chat End
						}
						//out.write(line.getBytes());//Client send
						//Broadcast to all
						for(ServerWorker serverWorker : server.workers)
						{
							line = line +"\n";
							serverWorker.out.write(line.getBytes());
						}
					}
				}catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					}
				finally
				{
					try {
					if(br != null)
					{
						br.close();
					}
					if(in!= null)
					{
						in.close();
					}
					if(out!= null)
					{
						out.close();
					}
					if(clientSocket!= null)
					{
						clientSocket.close();
					}
					     }
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
					
				}
				
	}
	


}
