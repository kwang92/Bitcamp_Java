package ex2;

import java.util.Random;

public class Generate_Animal {
	public static void main(String[] args) {
		Random ran = new Random();
		Animal[] animals = new Animal[5];
		for(int i = 0; i < 5; i++) {
			if((ran.nextInt(2)) == 0) {
				animals[i] = new Dog();  
			}else {
				animals[i] = new Cat();
			}
		}		
		for(Animal ani : animals) {
			ani.sound();
		}
	}
}