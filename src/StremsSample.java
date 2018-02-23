import java.util.ArrayList;
import java.util.Random;

public class StremsSample {
	public static int f(int n){
		for (int i = 1; i < 10000; i++) {
			n = (n^i) % i;
			if (n<= 0)
				n = 10;
		}
		return n;
	}

	public static void main(String[] args) {
		Random rnd = new Random();
		ArrayList<Integer> data = new ArrayList<>();
		for (int i = 0; i < 100000; i++) {
			data.add(rnd.nextInt());
		}
		System.out.println("Starting"); 
		
	//	int result = 0;
	//	for (int i : data){
	//		result += f(i);
	//	}
	//	System.out.println(result);
		
	//	int result = data.stream().map(i -> f(i)).reduce(Integer::sum).get();
		int result = data.parallelStream().map(i -> f(i)).reduce(Integer::sum).get();
		System.out.println(result);
	}

}
