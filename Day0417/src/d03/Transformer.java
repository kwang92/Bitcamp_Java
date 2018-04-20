package d03;

public class Transformer extends Robot{
	public Transformer(Attackable attack, Moveable move) {
		this.name = "트랜스포머";
		this.attack = attack;
		this.move = move;
	}
	public void attack() {
		attack.attack();
	}
	public void move() {
		move.move();
	}

}
