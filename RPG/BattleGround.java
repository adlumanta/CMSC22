import java.util.Random;
import java.util.Scanner;

public class BattleGround {
	private Random rand;
	
	public BattleGround() {
		this.rand = new Random();
	}
	
	public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
	
	public int randInt(int min, int max) {
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
	
	public int hit() {
        return randInt(1, 3);
    }
	
	public boolean fight(Character attacker, Character defender) {
        int damage = attacker.attack();
        int remHealth = 0;
        int attackStrength = hit();
        sleep(2000);
       
        if (attackStrength == 3) {
        	System.out.printf("-+ " + defender.newString() + " is critically hit! Health points minus %d.\n", attacker.attack());
        	
        	remHealth = defender.takeDamage(damage);
        	if (remHealth <= 0) {
            	defender.setHealth(0);
            	System.out.println("-+ " + defender.newString() + " is KILLED! by " + attacker.newString());
            	return true;
            }
        }
        if (attackStrength == 2) {
        	System.out.printf("-+ " + defender.newString() + " is hit! Health minus %d.\n", attacker.attack() - (damage/4));
        	remHealth = defender.takeDamage(damage - damage/4);
        	if (remHealth <= 0) {
            	defender.setHealth(0);
            	System.out.println(defender.newString() + " is KILLED! by " + attacker.newString() + ".");
            	System.out.println(attacker.newString() + " WINS!");
            	return true;
            }
        }
        if (attackStrength == 1) {
        	System.out.println("-+ MISSED!");
        }
        return false;
    }
	
	public static void main(String[] args) {
		BattleGround arena = new BattleGround();
		Character monster = new TheGreatMonster();
		Scanner s = new Scanner(System.in);
		System.out.println("BEAT THE MONSTER!!!\n"
				+ "Enter your name: ");
		String name = s.next();
		System.out.println("Select type of Hero:\n1. Viking\n2. Gladiator\n3. Spartan");
		byte hero = s.nextByte();
		System.out.println("Can you beat the monster? Let's find out.");
		sleep(2000);
		
		if (hero == 1) {
			Character player = new Viking(name);
			System.out.println("THE BATTLE STARTS NOW!");
			sleep(1000);
			System.out.printf("%s\n%s\n", player, monster);
			int count = 0;
	        while (true) {
	            System.out.println("*****ROUND " + ++count + " *****");
	            sleep(1000);
	            System.out.println("*****FIGHT !******");
	            sleep(1000);
	            System.out.println("- " + player.newString()+"'s turn.");
	            boolean monsterIsDead = arena.fight(player, monster);
	            if (monsterIsDead) break;

	            sleep(1000);
	            System.out.printf("--------------------\n%s\n%s\n--------------------\n", player, monster);
	            sleep(1000);
	            
	            System.out.println("- " + monster.newString()+"'s turn.");
	            boolean heroIsDead =arena.fight(monster, player);
	            if (heroIsDead) break;
	            System.out.printf("%s\n%s\n\n", player, monster);
	        }

	        System.out.printf("%s\n%s\n", player, monster);
		}
		if (hero == 2) {
			Character player = new Gladiator(name);
			System.out.println("THE BATTLE STARTS NOW!");
			sleep(1000);
			System.out.printf("%s\n%s\n", player, monster);
			int count = 0;
	        while (true) {
	            System.out.println("*****ROUND " + ++count + " *****");
	            sleep(1000);
	            System.out.println("*****FIGHT !******");
	            sleep(1000);
	            System.out.println("- " + player.newString()+"'s turn.");
	            boolean monsterIsDead = arena.fight(player, monster);
	            if (monsterIsDead) break;
	            
	            sleep(1000);
	            System.out.printf("--------------------\n%s\n%s\n--------------------\n", player, monster);
	            sleep(1000);

	            System.out.println("- " + monster.newString()+"'s turn.");
	            boolean heroIsDead =arena.fight(monster, player);
	            if (heroIsDead) break;
	            System.out.printf("%s\n%s\n\n", player, monster);
	        }

	        System.out.printf("%s\n%s\n", player, monster);
		}
		if (hero == 3) {
			Character player = new Spartan(name);
			System.out.println("THE BATTLE STARTS NOW!");
			sleep(1000);
			System.out.printf("%s\n%s\n", player, monster);
			int count = 0;
	        while (true) {
	            System.out.println("*****ROUND " + ++count + " *****");
	            sleep(1000);
	            System.out.println("*****FIGHT !******");
	            sleep(1000);
	            boolean monsterIsDead = arena.fight(player, monster);
	            if (monsterIsDead) break;
	            
	            sleep(1000);
	            System.out.printf("--------------------\n%s\n%s\n--------------------\n", player, monster);
	            sleep(1000);

	            System.out.println("- " + monster.newString()+"'s turn.");
	            boolean heroIsDead =arena.fight(monster, player);
	            if (heroIsDead) break;
	            System.out.printf("%s\n%s\n\n", player, monster);
	        }

	        System.out.printf("%s\n%s\n", player, monster);
		}
		
		
	}
}
