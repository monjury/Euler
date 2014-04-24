/*
 * The prime factors of 13195 are 5, 7, 13 and 29. What is the largest
 * prime factor of the number 600851475143 ?
 */

import java.util.HashMap;

public class P003 {

	public static void calculate() {
		long n = 600851475143L;
		HashMap<Long, Boolean> map = new HashMap<Long, Boolean>();
		long largest = 0;
		long start = (long) Math.sqrt(n);
		if (start % 2 == 0) {
			start++;
		}
		for (long i = start; i > 2; i -= 2) {
			if (n % i == 0 && isPrime(i, map)) {
				largest = i;
				break;
			}
		}
		System.out.println(largest);
	}

	private static boolean isPrime(long n, HashMap<Long, Boolean> map) {
		if (map.get(n) != null && map.get(n) == true) {
			return true;
		}
		for (int i = 3; i < Math.sqrt(n); i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		map.put(n, true);
		return true;
	}
}
