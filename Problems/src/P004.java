
public class P004 {

	public static void calculate() {
		/*
		 * A palindromic number reads the same both ways. 
		 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 x 99.
		 * Find the largest palindrome made from the product of two 3-digit numbers. ?
		 */		
		int largest = 0;
		
		for(int i = 999; i > 99; i--) {
			for(int j = i - 1; j > 99; j--) {
				int product = i * j;
				if(isPalindrome(product) && product > largest) {
					largest = product;
				}
			}
		}
		System.out.println(largest);
	}

	private static boolean isPalindrome(int n) {
		String input = String.valueOf(n);
		for(int i = 0; i < input.length()/2; i++) {
			if(input.charAt(i) != input.charAt(input.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
		
	public static void main(String[] args) {
		P004.calculate();
	}
}
