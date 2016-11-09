import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerBuilder extends TCPRWServer {
	 protected ServerSocket ss;
	 protected InetSocketAddress isA;
	 TCPServerBuilder() {
	 ss = null ;
	 isA = new InetSocketAddress("localhost",5050);
	 }
	 protected Socket s;
	 void setSocket() throws IOException
		{ s = new Socket(); /* we can include more setting, later … */} 
}
