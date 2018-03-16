import java.util.Scanner;

public class Player {
	Scanner sc = new Scanner(System.in);
	public Player(){
		
	}
	public char[] play(){
		System.out.println("Vous>");
		char[] res = new char[4];
		String answer = sc.nextLine();
		answer = answer.toUpperCase();
		if(answer.length() != 4){
			System.out.println("Vous ne devez rentrer que 4 couleurs!");
			return play();
		}
		else{
			for(int i = 0;i<4;i++){
				res[i] = answer.charAt(i);
			}
		}
		return res;
	}
}
