import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPClientBuilder extends TCPRWClient {
	protected ServerSocket ss;
	 Socket s;
	 protected InetSocketAddress isA;
	 TCPClientBuilder() {
	 s = null;
	 isA = new InetSocketAddress("localhost",5050);
	 }
	 void setSocket() throws IOException
	{ s = new Socket(); /* we can include more setting, later … */} 
}
