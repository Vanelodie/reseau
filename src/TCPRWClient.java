import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.Socket;


public class TCPRWClient {
	private StringBuffer msT; private int time; 
	public void WriteVote(Socket s, String vote){
		try{
		String msOut = vote; 
		OutputStream out = s.getOutputStream(); 
		out.write(msOut.getBytes()); 
		out.flush();    
		out.close();
		}
		catch(IOException e)
		{
			System.out.println("Erreur WriteVote");
			System.out.println(e.getMessage());
		}
	}
	public String ReadCandidates (Socket s,int size){
		try{
		InputStream in = s.getInputStream(); 
		byte[] buffer = setByteBuffer(size); 
		int count = in.read(buffer); 
		String msIn = new String(buffer,0,count) ; 
		StringBuffer buff= new StringBuffer ("Les candidats sont: \n");
		while (count!=-1)
		{
			msIn = new String (buffer,0,count)+"\n"; 
			buff.append(msIn);
			count = in.read(buffer); 
		}			
		in.close();
		return buff.toString();
		
		}
		catch(IOException e)
		{
			System.out.println("Erreur ReadCandidates serveur");
			System.out.println(e.getMessage());
			return null;
		}
	}
	public byte[] setByteBuffer(int size)
	{
		byte[] buffer = new byte[size];
		return buffer;
	}
}

