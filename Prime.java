package exercise;

public class Prime {

	public static void main(String[] args) {
		int num=2 ;
		boolean isPrime=true;
		if(num<=1)
		{
			isPrime=false;
		}else {
			for(int i=2;i<=Math.sqrt(num);i++){
				if (num%i==0) {
					isPrime=false;
					break;
				}
			}
		}
		if (isPrime) {
			System.out.println("Prime");
		}
		else {
			System.out.println("Not Prime");
		}
	}

}
