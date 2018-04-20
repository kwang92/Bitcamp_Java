package d01;

public class RobotTest {
	public static void main(String[] args) {
		// 로봇만들기, 로봇을 싸우게 하는 프로그램
		Transformer tf = new Transformer();
		tf.fight();
		
		System.out.println("------------");
		
		TaekwonV tv = new TaekwonV();
		tv.fight();
	}
}
