
public class Mars {

	public static void main(String[] args) {
		Navigator navigator = new Navigator();
		navigator.readInput();
		if(navigator.parseInput()){
			navigator.executeMovements();
			navigator.showOutput();
		}else{
			System.out.println("NO CAN'T DO! TRY AGAIN SHERLOCK!");
		}
	}

}
