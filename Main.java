public class Main {

	public static void main(String[] args) {
		String affichage = "";
		Mastermind m = new Mastermind();
		char[] letters = m.getletters();
		Player p = new Player();
		System.out.println("Pret pour une partie de mastermind!\nA vous de jouer!");
		System.out.println("Veuillez rentrez 4 couleurs parmis {R,J,B,V,O}\n");
		m.set_player_answer(p.play());
		
		
		while(!m.check_win() && m.gettime() <10){
			
			
			while(!m.canplay()){
				m.set_player_answer(p.play());
			}
			
			
			
			
			System.out.println(m.affichage());
			
			if(!m.check_win()){
				m.set_player_answer(p.play());
			}
			m.timeplus();
			
		}
		if(m.check_win()){
			System.out.println("Félicitation, vous avez gagné!");
		}
		else{
			System.out.println("Vous avez perdu :'(");
		}
		
	}
	
}
