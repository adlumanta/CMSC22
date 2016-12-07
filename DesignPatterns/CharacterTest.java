package DesignPatterns;

public class CharacterTest {
	public static void main(String[] args) {
		Character king = new King();
		king.setWeapon(new KnifeBehaviour());
		king.fight();
		
		Character queen = new Queen();
		queen.setWeapon(new BowAndArrowBehaviour());
		queen.fight();
		
		
		Character knight = new Knight();
		knight.setWeapon(new SwordBehaviour());
		knight.fight();
		
		Character troll = new Troll();
		troll.setWeapon(new AxeBehaviour());
		troll.fight();
		
		Character queen2 = new Queen();
		queen2.setWeapon(new AxeBehaviour());
		queen2.fight();
	}
}
