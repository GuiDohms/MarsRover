
public class Rover {
	private String cardinal;
	private int posY, posX;
	private Plateau plateau;
	
	public Rover(int posY, int posX, String cardinal, Plateau plateau){
		this.posY = posY;
		this.posX = posX;
		this.cardinal = cardinal;
		this.plateau = plateau;
	}


	public String getCardinal() {
		return cardinal;
	}


	public void setCardinal(String cardinal) {
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
	
	public void turnRight(){
		switch(this.cardinal){
		case "N":
			this.cardinal = "E";
			break;
		case "E":
			this.cardinal = "S";
			break;
		case "S":
			this.cardinal = "W";
			break;
		case "W":
			this.cardinal = "N";
			break;
		}
	}
	
	public void turnLeft(){
		switch(this.cardinal){
		case "N":
			this.cardinal = "W";
			break;
		case "W":
			this.cardinal = "S";
			break;
		case "S":
			this.cardinal = "E";
			break;
		case "E":
			this.cardinal = "N";
			break;
		}
	}
	public boolean moonWalk(){
		if (this.cardinal.equals("N")) {
			if (this.posY < this.plateau.getMaxY()) {
				this.posY++;
				return true;
			}
		} else if (this.cardinal.equals("S")) {
			if (this.posY > 0) {
				this.posY--;
				return true;
			}
		} else if (this.cardinal.equals("W")) {
			if (this.posX > 0) {
				this.posX--;
				return true;
			}
		} else if (this.cardinal.equals("E")) {
			if (this.posX < this.plateau.getMaxX()) {
				this.posX++;
				return true;
			}
		}
		return false;
	}
	
	public String toString(){
		return ("Rover Positon: " + posY + ", " + posX + ". Facing: " + cardinal);
			
	}
}