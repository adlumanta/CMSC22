
public class Gladiator extends Hero {
	public static final int POWER = 25;
	
	public Gladiator(String name) {
		super(name, "the Gladiator", 100, POWER);
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
