public class Candidates {
   private String name;
   private int id;
   private int votesNumbers;
   
   public Candidates(){
	   name = new String();
	   id=0;
	   votesNumbers=0;
   }
   public Candidates(String name, int id){
	   this.name = new String(name);
	   this.id=id;
	   votesNumbers=0;
   }
   public String getName(){
	   return this.name;
   }
   public int getId(){
	   return this.id;
   }
   public int getNbVotes(){
	   return this.votesNumbers;
   }
   public void setName(String name){
	   this.name=name;
   }
   public void setId(int id){
	   this.id=id;
   }
   public void setNbVotes(int nbVotes){
	   this.votesNumbers=nbVotes;
   }
}
