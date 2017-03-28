
public class Rover {
	private char cardinal;
	private int posY, posX;
	
	
	public Rover(int posY, int posX, char cardinal){
		this.posY = posY;
		this.posX = posX;
		this.cardinal = cardinal;
	}


	public char getCardinal() {
		return cardinal;
	}


	public void setCardinal(char cardinal) {
		this.cardinal = cardinal;
	}


	public int getPosY() {
		return posY;
	}


	public void setPosY(int posY) {
		this.posY = posY;
	}


	public int getPosX() {
		return posX;
	}


	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	public String toString(){
		return ("Rover Positon: " + posY + ", " + posX + ". Facing: " + cardinal);
			
	}
}