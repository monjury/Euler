/*
 * 2520 is the smallest number that can be divided by each of 
 * the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20? ?
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P005 {

	public static void calculate() {
		Map<Integer, Integer> powerOfFactorsMap = new HashMap<Integer, Integer>();
		for (int i = 2; i <= 20; i++) {
			List<Integer> primeFactorList = getPrimeFactors(i);
			addUniquePrimeFactors(powerOfFactorsMap, primeFactorList);
		}
		int lcm = calculateLowestCommonMultiple(powerOfFactorsMap);
		System.out.println(lcm);
	}

	private static List<Integer> getPrimeFactors(int n) {
		List<Integer> primeFactorList = new ArrayList<Integer>();
		int factor = 2;
		while(n > 1) {
			while(n % factor == 0){
				primeFactorList.add(factor);
				n /= factor;
			}
			factor = getNextPrime(factor);
		}
		return primeFactorList;
	}

	private static void addUniquePrimeFactors(Map<Integer, Integer> powerOfFactorsMap, List<Integer> primeFactorList) {
		int power = 1;
		if(powerOfFactorsMap != null && primeFactorList != null){
			Set<Integer> uniquePrimeFactorList = new HashSet<Integer>(primeFactorList);
			for(int primeFactor : uniquePrimeFactorList) {
				if(powerOfFactorsMap.containsKey(primeFactor)) {
				    power = Collections.frequency(primeFactorList, primeFactor);
				    if(powerOfFactorsMap.get(primeFactor) > power) {
				    	power = powerOfFactorsMap.get(primeFactor);
				    }
				}
				powerOfFactorsMap.put(primeFactor, power);
			}
		}
	}

	private static int calculateLowestCommonMultiple(Map<Integer, Integer> powerOfFactorsMap) {
		int lcm = 1;
		if(powerOfFactorsMap != null && powerOfFactorsMap.size() > 0) {
			Set<Integer> factorSet = powerOfFactorsMap.keySet();
			for(int factor : factorSet) {
				lcm *= (Math.pow(factor, powerOfFactorsMap.get(factor)));
			}
		}
		return lcm;
	}
	
	private static int getNextPrime(int n) {
		HashMap<Long, Boolean> map = new HashMap<Long, Boolean>();
		n++;
		while(!isPrime(n, map)) {
			n++;
		}
		return n;
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

	public static void main(String[] args) {
		P005.calculate();
	}
}
