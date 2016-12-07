
public class TheGreatMonster extends Character {
	public static final int POWER = 35;
	
	public TheGreatMonster() {
		super("Super", "Monster", 100);
	}
	
	@Override
	public int attack() {
		return POWER;
	}

	@Override
	public int takeDamage(int damage) {
		int health = getHealth() - damage;
		setHealth(health);
		return getHealth();
	}

}
