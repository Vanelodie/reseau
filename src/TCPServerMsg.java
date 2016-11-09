import java.io.IOException;
import java.net.ServerSocket;


public class TCPServerMsg extends TCPServerBuilder implements Runnable{

	 public void run( ) {
		 try {
			 int size = 100;
			ss = new ServerSocket();
			ss.bind(isA); 
			s = ss.accept();
			s.setReceiveBufferSize(size);
			ss.setReceiveBufferSize(size);
		
			//Création des sockets et sockets serveur et connection avec le client
			 System.out.println("server connected");
			 //Lis le contenu du message
			 s.setSendBufferSize(size);
			 WriteCandidates(s,size);	
			 s = ss.accept();
				s.setReceiveBufferSize(size);
			 ReadVote(s);
			 s.close();
			 ss.close() ;
		 }
		 catch(IOException e)
		 { 
			 System.out.println("TCPServerMsg");
			 System.out.println(e.getMessage());
			 System.out.println("IOException TCPServer "); }
		 }
}