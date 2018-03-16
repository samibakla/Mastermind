import java.util.Random;

public class Mastermind {
	String affichage;
	private char[] letters = new char[]{'R','J','B','V','O'};
	private char[] answer = new char[4];
	Random rand = new Random();
	public char[] player_answer;
	int time;
	public Mastermind(){ 
		 int time = 0;
		 answer = create_answer();
		 affichage = "|-------------------|\n";
	}
	
	public int gettime(){
		return time;
	}
	public void timeplus(){
		time++;
	}
	
	public void set_player_answer(char[] player_answer){
		this.player_answer = player_answer;
	}
	public char[] getletters(){
		return answer;
	}
	private char[] create_answer(){
		
		char[] answer = new char[4];
		
		for(int i = 0;i<4;i++){
			answer[i] = this.letters[rand.nextInt(5)];
		}
		
		return answer;	
	}
	
	public int check_good_place(){
		int mem = 0;
		for(int i =0;i<4;i++){
			if(this.player_answer[i] == this.answer[i]){
				mem++;
			}
		}
		return mem;
	}
	
	public boolean is_in(char a, char[] t){
		boolean res = false;
		int i = 0;
		while(!res && i<t.length){
			if(a==t[i]){
				res = true;
			}
			i++;
		}
		
		return res;
	}
	
	public int check_wrong_place(){
		int mem = 0;
		for(int i = 0; i<4; i++){
			
			if(this.player_answer[i] != answer[i]){
				if(is_in(this.player_answer[i],answer))
					mem++;
			}
		}
		return mem;
	}
	
	public boolean check_win(){
		boolean res = true;
		int i = 0;
		while(i<4 && res){
			if(this.player_answer[i]!=this.answer[i]){
				res = false;
			}
			i++;
		}
		return res;
	}
	
	public boolean canplay(){
		boolean res = true;
		for(int i =0; i<4;i++){
			if(!this.is_in(this.player_answer[i], letters)){
				res = false;
			}
		}
		if(!res){
			System.out.println("Veuillez choisir vos couleurs parmis {R,J,B,V,O}");
		}
		return res;
	}
	
	public String affichage(){
		String ans = "";
		for(int i =0;i<4;i++){
			ans =ans + this.player_answer[i];
		}
		affichage += "|" +ans+ "| " +this.check_good_place() +" | "+this.check_wrong_place() + " | " + (this.time+1) +"/10"+ " |\n";
		
		return (affichage);
		
		
	}
}
