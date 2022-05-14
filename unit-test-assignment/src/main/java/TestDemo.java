import java.util.Random;
public class TestDemo {

	
	
	public Integer addPositive(Integer a, Integer b) {
		if(a <= 0 || b <= 0) {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
		return a + b;
		
	}
	public Integer randomNumberSquared() {
		int a = generateRandomPositiveInteger();
		int b = generateRandomPositiveInteger();
		
		return addPositive(a, b);
	}
	public int generateRandomPositiveInteger() {
		return getRandomInt(); 
	}
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
}


