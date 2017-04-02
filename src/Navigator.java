import java.util.*;

public class Navigator {
	private Scanner scanner;
	private Plateau plateau;
	private ArrayList<Rover> rovers;
	private ArrayList<String> direction;
	private ArrayList<String> input;
	private List<String> validDirections;
	private List<String> validMove;
	
	public Navigator() {
		this.scanner = new Scanner(System.in);
		this.validDirections = Arrays.asList("N", "W", "E", "S");
		this.validMove = Arrays.asList("L", "R", "M");
		this.direction = new ArrayList<String>();
		this.rovers = new ArrayList<Rover>();
		this.input = new ArrayList<String>();
	}
	
	public void readInput(){
		this.input.clear();
		String move = "";
		
		System.out.println("----------------------------");
		System.out.println("--------MARS ROVER----------");
		System.out.println("----------------------------");
		System.out.println("-----SHOW ME YOUR MOVE------");
		System.out.println("----------------------------");
		System.out.println("Exemple:" + '\n' + "5 5" + '\n' + "1 2 N" + '\n' + "LMLMLMLMM" + '\n' + "Then press dot and Enter");
		
		while(!move.equals(".")){
			move = scanner.nextLine();
			if(!move.equals(".")){
				this.input.add(move);
			}
		}
	}
	
	public void setIput(String input){
		this.input.clear();
		
		String[] lines = input.split(System.lineSeparator());
		for (int c = 0; c < lines.length; c++) {
			this.input.add(lines[c]);
		}
	}
	
		public boolean parseInput() {
			if (this.input.size() > 1 && this.input.size() % 2 == 1) {
				try {
					// Plateau
					String[] plateau_dimensions = new String[2]; //sets a plateau with two values (X, Y)
					plateau_dimensions = this.input.remove(0).split(" ");
					int plateau_max_x = Integer.parseInt(plateau_dimensions[0]);
					int plateau_max_y = Integer.parseInt(plateau_dimensions[1]);

					if (plateau_max_x > 0 && plateau_max_y > 0) {
						this.plateau = new Plateau(plateau_max_x, plateau_max_y);
					} else {
						return false;
					}

					// Rovers
					String[] rover_deployment = new String[3];//sets a rover in a determined point (x,y) facing a cardinal direction(n,s,w,e)
					String command;
					int rover_deployment_x;
					int rover_deployment_y;
					String rover_deployment_orientation;

					for (int n = 0; n < this.input.size(); n += 2) {
						command = this.input.get(n);

						rover_deployment = command.split(" ");
						rover_deployment_x = Integer.parseInt(rover_deployment[0]);
						rover_deployment_y = Integer.parseInt(rover_deployment[1]);
						rover_deployment_orientation = rover_deployment[2];

						if (rover_deployment_x >= 0 && rover_deployment_x <= plateau_max_x && rover_deployment_y >= 0
								&& rover_deployment_y <= plateau_max_y
								&& this.validDirections.contains(rover_deployment_orientation)) {
							this.rovers.add(new Rover(rover_deployment_x, rover_deployment_y, rover_deployment_orientation,
									this.plateau));
						} else {
							return false;
						}
					}

					// Movements
					String movement;
					for (int n = 1; n < this.input.size(); n += 2) {
						movement = this.input.get(n);
						for (char c : movement.toCharArray()) {
							if (!this.validMove.contains(String.valueOf(c))) {
								return false;
							}
						}
						this.direction.add(movement);
					}

					return true;
				} catch (Exception e) {
					return false;
				}
			} else {
				return false;
			}
		}

		public void executeMovements() {
			Rover rover;
			String movement;

			for (int n = 0; n < this.rovers.size(); n++) {
				rover = this.rovers.get(n);
				movement = this.direction.get(n);
				for (char c : movement.toCharArray()) {
					switch (c) {
					case 'L':
						rover.turnLeft();
						break;
					case 'R':
						rover.turnRight();
						break;
					case 'M':
						rover.moonWalk();
						break;
					}
				}
			}
		}

		public ArrayList<Rover> getRovers() {
			return this.rovers;
		}

		public void showOutput() {
			System.out.println("Saída de dados:");
			for (Rover rover : this.rovers) {
				System.out.println(rover.getPosX() + " " + rover.getPosY() + " " + rover.getCardinal());
			}
		}
}
