package com.denshokotko.politicalpower;

import java.text.DecimalFormat;
import java.util.List;

public class Helper {

	public static boolean nextPermutation(int[] p) {
		for (int a = p.length - 2; a >= 0; --a)
			if (p[a] < p[a + 1])
				for (int b = p.length - 1;; --b)
					if (p[b] > p[a]) {
						int t = p[a];
						p[a] = p[b];
						p[b] = t;
						for (++a, b = p.length - 1; a < b; ++a, --b) {
							t = p[a];
							p[a] = p[b];
							p[b] = t;
						}
						return true;
					}
		return false;
	}

	private static long[] factorial = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320,
			362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L,
			1307674368000L, 20922789888000L, 355687428096000L,
			6402373705728000L, 121645100408832000L, 2432902008176640000L };

	

	/**
	 * Gets factorial from predefined array. Maximum available factorial is
	 * factorial for number 21.
	 * 
	 * @param n
	 *            - the number (from 0 to 21)
	 * @return factorial of the number "n" or "-1" if there is no available
	 *         factorial for specified number.
	 */
	public static long getFactorial(int n) {
		if (n > 0 && n <= factorial.length) {
			return factorial[n];
		}
		return -1;
	}

	public static void printPoliticalPower(List<Voter> voters, boolean isNeedToFormat) {
		DecimalFormat df = null;
		if (isNeedToFormat) {
			df = new DecimalFormat("#.####");
		} else {
			df = new DecimalFormat();
		}

		System.out.println("Name - Weight - SSI Percent - TBP - TBP % - TJP - % TJP - TDPP - TDPP %");
		for (Voter voter : voters) {

			String name = voter.getName();
			if (name == null)
				name = " --- ";
			System.out.println(name + " - " + voter.getWeight() + " - "
					+ df.format(voter.getPoliticalPowerPercent()) + " - "
					+ voter.getTotalBanzhafPower() + " - % "
					+ df.format(voter.getTotalBanzhafPowerPercent()) + " - " 
					+ df.format(voter.getJohnstonPower()) + " - " 
					+ df.format(voter.getJohnstonPowerPercent()) + " - "
					+ df.format(voter.getDeeganPackelPower()) + " - " 
					+ df.format(voter.getDeeganPackelPowerPercent()));
		}
	}
}
