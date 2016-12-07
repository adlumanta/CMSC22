
public class Viking extends Hero {
	public static final int POWER = 20;

	public Viking(String name) {
		super(name, "the Viking", 100 , POWER);
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
