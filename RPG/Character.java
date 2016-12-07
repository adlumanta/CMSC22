
public abstract class Character {
	private String name;
	private String type;
	private int health;
	
	public Character(String name, String type, int health) {
		this.name = name;
		this.type = type;
		this.health = health;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public boolean isAlive() {
		return health > 0 ? true : false;
	}
	
	public abstract int attack();
	public abstract int takeDamage(int damage);
	
	@Override
	public String toString() {
		return "| HP | " +  health + " | " + name + " " + type;
	}
	
	public String newString () {
		return name + " " + type;
	}
	
}
