
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;


public class TCPClientMsg extends TCPClientBuilder implements Runnable {
	public void run() {
		 try {
		 setSocket();
		 s.connect(isA);
		 int size = 100;
		 System.out.println("client connected");
		 s.setReceiveBufferSize(size);
		 System.out.println(ReadCandidates(s,size));
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Pour quellles personnes souhaitait vous voter ? \n Saisissez son numero ! ");
		 String str = sc.nextLine();
		 s.close();
		 
		 setSocket();
		 s.connect(isA);
         WriteVote(s,str);
		 s.close();
		 }
		 catch(IOException e)
		 { 
			 System.out.println("TCPClientMsg");
			 System.out.println(e.getMessage());
			 System.out.println("IOException TCPClient"); }
		 } 
	public static void main(String[] args) {
		
		new Thread(new TCPServerMsg()).start();
		new Thread(new TCPClientMsg()).start();
	}
}