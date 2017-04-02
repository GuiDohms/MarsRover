import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.Test;
import org.junit.Before;
import org.junit.Test;

public class RollingOnMars {
	private Rover rover;
	
	@Before
	public void setUp() throws Exception {
		Plateau plateau = new Plateau(5, 5);
		this.rover = new Rover(1, 2, "N", plateau);
	}
	
	@Test
	public void testGetPosX() {
		assertEquals(1, this.rover.getPosX());
	}
	
	@Test
	public void testGetPosY() {
		assertEquals(1, this.rover.getPosY());
	}
	
	@Test
	public void testGetCardinal(){
		assertEquals("N", this.rover.getCardinal());
	}
	
	@Test
	public void testTurnLeft() {
		this.rover.turnLeft();
		assertEquals("W", this.rover.getCardinal());
		this.rover.turnLeft();
		assertEquals("S", this.rover.getCardinal());
		this.rover.turnLeft();
		assertEquals("E", this.rover.getCardinal());
		this.rover.turnLeft();
		assertEquals("N", this.rover.getCardinal());
	}
	
	@Test
	public void testTurnRight() {
		this.rover.turnRight();
		assertEquals("E", this.rover.getCardinal());
		this.rover.turnRight();
		assertEquals("S", this.rover.getCardinal());
		this.rover.turnRight();
		assertEquals("W", this.rover.getCardinal());
		this.rover.turnRight();
		assertEquals("N", this.rover.getCardinal());
	}
	
	@Test
	public void moonWalk() {
		this.rover.moonWalk();
		this.rover.moonWalk();
		this.rover.moonWalk();
		this.rover.moonWalk();
		this.rover.moonWalk();
		this.rover.moonWalk();
		assertEquals(2, this.rover.getPosX());
		assertEquals(5, this.rover.getPosY());

		this.rover.moonWalk();
		this.rover.moonWalk();
		this.rover.moonWalk();
		this.rover.moonWalk();
		assertEquals(5, this.rover.getPosX());
		assertEquals(5, this.rover.getPosY());

		this.rover.turnRight();;
		this.rover.moonWalk();
		this.rover.moonWalk();
		this.rover.moonWalk();
		this.rover.moonWalk();
		this.rover.moonWalk();
		this.rover.moonWalk();
		assertEquals(5, this.rover.getPosX());
		assertEquals(0, this.rover.getPosY());

		this.rover.turnRight();
		this.rover.moonWalk();
		this.rover.moonWalk();
		this.rover.moonWalk();
		this.rover.moonWalk();
		this.rover.moonWalk();
		this.rover.moonWalk();
		assertEquals(0, this.rover.getPosX());
		assertEquals(0, this.rover.getPosY());
	}
}
