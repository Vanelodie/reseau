import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.Socket;
import java.util.ArrayList;


public class TCPRWServer {
	private StringBuffer msT; private int time; 
	private ArrayList<Candidates> candidatesList;
		public void WriteCandidates(Socket s, int size){
			try{
				readCandidates();
				String msOut =new String(); 
				for (int i=0; i< candidatesList.size(); i++){
					msOut = msOut+candidatesList.get(i).getId()+"  "+candidatesList.get(i).getName()+"\n";
				}
			
			OutputStream out = s.getOutputStream(); 
			out.write(msOut.getBytes()); 
			out.flush();    
			out.close();
			}
			catch(IOException e)
			{
    			System.out.println("writeCandidates ");
    			System.out.println(e.getMessage());
			}
		}
		public void readCandidates(){
        	try {
    			int nbCandidates;
    			candidatesList=new ArrayList<Candidates>(0);
    			//Open the file
    			InputStream inputStream=new FileInputStream("data/list.txt"); 
    			InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
    			BufferedReader bufferRead=new BufferedReader(inputStreamReader);
    			String line=bufferRead.readLine();
    			boolean end=false;
    			int i=1;
    			//Get the number of department
    			
    			//For each department/line
    			while(end==false){
    				//Get the line
    				line= line.substring(0,line.length()-1);
    				Candidates C= new Candidates(line,i);
    				candidatesList.add(C);
    				line=bufferRead.readLine();
    				if(line==null){
    					end=true;
    				}
    				i++;
    			}
    			//Close the flow
    			bufferRead.close();

    		} catch (IOException e){
    			System.out.println("readCandidates ");
    			System.out.println(e.getMessage());
    		}
        }
		public String ReadVote (Socket s){
			try{
			InputStream in = s.getInputStream(); 
			byte[] buffer = new byte[8192]; 
			int count = in.read(buffer); 
			String msIn = new String(buffer,0,count) ; 
			int id= Integer.parseUnsignedInt(msIn.toString());
			if(id-1<candidatesList.size()){
				candidatesList.get(id-1).setNbVotes(candidatesList.get(id-1).getNbVotes()+1);
			}
			in.close();
			PrintList();
			return msIn;
			
			}
			catch(IOException e)
			{
				System.out.println("Erreur ReadVote ");
				System.out.println(e.getMessage());
				return null;
			}
		}
		public void PrintList(){
			for (int i=0; i<candidatesList.size(); i++){
				System.out.println(candidatesList.get(i).getName()+ "  "+ candidatesList.get(i).getNbVotes());
			}
		}
		public byte[] setByteBuffer(int size)
		{
			byte[] buffer = new byte[size];
			return buffer;
		}
}

