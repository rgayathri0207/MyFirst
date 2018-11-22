package JavaPractise;

public class Challenge14 {

	public static void main(String[] args) {
		int n=25;
		int sum=0;
		for (int i = 3; i <n; i++) {
			if (i%3==0 || i%5==0) {
				sum=sum+i;
			}
			
		}
		System.out.println(sum);

	}

}
