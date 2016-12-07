
public class Spartan extends Hero {
	public static final int POWER = 30;
	
	public Spartan(String name) {
		super(name, "the Spartan", 100, POWER);
	}

	@Override
	public int attack() {
		return getPower();
	}

	@Override
	public int takeDamage(int damage) {
		int health = getHealth() - damage;
		setHealth(health);
		return getHealth();
	}

}
