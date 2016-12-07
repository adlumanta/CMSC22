
public abstract class Hero extends Character {
	private int power;
	
	public Hero(String name, String type, int health, int power) {
		super(name, type, health);
		this.power = power;
	}

	public int getPower() {
		return power;
	} 
	
	public void setPower(int power) {
		this.power = power;
	}
}
