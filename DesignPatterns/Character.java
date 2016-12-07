package DesignPatterns;

public abstract class Character {
	WeaponBehaviour weapon;
	
	public void setWeapon(WeaponBehaviour w) {
		this.weapon = w;
	}
	
	public void fight() {
		System.out.print(this.getClass().getName() + " ---> ");
		weapon.useWeapon();
	}
}
