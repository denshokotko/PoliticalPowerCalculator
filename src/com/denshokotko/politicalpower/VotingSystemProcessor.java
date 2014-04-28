package com.denshokotko.politicalpower;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

public class VotingSystemProcessor {
	
	
	public static void calculateDeeganPackelPowerOfVoters(List<Voter> voters,
			int quota) {

		ICombinatoricsVector<Voter> initialVector = Factory
				.createVector(voters);
		double currentDeeganPackelPower = 0;
		
		for (int i = 1; i <= voters.size(); i++) {
			Generator<Voter> gen = Factory.createSimpleCombinationGenerator(
					initialVector, i);

			for (ICombinatoricsVector<Voter> coalition : gen) {
				if (isWinningCoalition(coalition.getVector(), quota)) {
					if (getCoalitionPower(coalition.getVector()) == quota) {
						currentDeeganPackelPower = 1d / coalition.getVector().size();
						for (Voter voter: coalition.getVector()) {
							voter.addToDeeganPackelPower(currentDeeganPackelPower);
						}
					}
				}
			}
		}

		double totalDeeaganPackelPower = getTotalDeeaganPackelPower(voters);
		
		System.out.println("--- " + totalDeeaganPackelPower);
		
		for (Voter voter : voters) {
			double deeganPackelPowerPercent = ((double) voter.getDeeganPackelPower() / totalDeeaganPackelPower) * 100;
			
			System.out.println("==== " + deeganPackelPowerPercent);
			
			voter.setJohnstonPowerPercent(deeganPackelPowerPercent);
		}
	}
	
	
	private static double getTotalDeeaganPackelPower(List<Voter> voters) {
		double sum = 0;
		for (Voter v: voters) {
			sum += v.getDeeganPackelPower();
		}
		return sum;
	}


	public static void calculateJohnstonPowerOfVoters(List<Voter> voters,
			int quota) {

		ICombinatoricsVector<Voter> initialVector = Factory
				.createVector(voters);

		for (int i = 1; i <= voters.size(); i++) {
			Generator<Voter> gen = Factory.createSimpleCombinationGenerator(
					initialVector, i);

			for (ICombinatoricsVector<Voter> coalition : gen) {
				if (isWinningCoalition(coalition.getVector(), quota)) {
					calculateJohnstonNumberForWinningCoalition(coalition, quota);
				}
			}
		}

		double totalJohnstonPower = getTotalJohnstonPower(voters);
		for (Voter voter : voters) {
			double johnstonPowerPercent = ((double) voter.getJohnstonPower() / totalJohnstonPower) * 100;
			voter.setJohnstonPowerPercent(johnstonPowerPercent);
		}
	}

	private static double getTotalJohnstonPower(List<Voter> voters) {
		double sum = 0;
		for (Voter v: voters) {
			sum += v.getJohnstonPower();
		}
		return sum;
	}

	private static void calculateJohnstonNumberForWinningCoalition(
			ICombinatoricsVector<Voter> coalition, int quota) {
		
		int coalitionWeight = getCoalitionPower(coalition.getVector());
		
		List<Voter> criticalVoters = new LinkedList<>();
		
		for (Voter voter: coalition.getVector()) {
			
			if (isCriticalVoter(voter, coalitionWeight, quota)) {
				criticalVoters.add(voter);
			}
		}
		
		if (criticalVoters.size() > 0) {
			double currentJohnstonIndex = 1d / criticalVoters.size();
			for (Voter criticalVoter: criticalVoters) {
				criticalVoter.addToJohnstonPower(currentJohnstonIndex);
			}
		}
		
		
	}

	private static boolean isCriticalVoter(Voter voter, int coalitionWeight,
			int quota) {
		
		return (coalitionWeight - voter.getWeight()) < quota;
	}

	private static int getCoalitionPower(List<Voter> voters) {

		int power = 0;
		for (Voter v: voters) {
			power += v.getWeight();
		}
		return power;
	}

	public static void calculateTotalBanzhafPowerOfVoters(List<Voter> voters,
			int quota) {

		ICombinatoricsVector<Voter> initialVector = Factory
				.createVector(voters);

		for (int i = 1; i <= voters.size(); i++) {
			Generator<Voter> gen = Factory.createSimpleCombinationGenerator(
					initialVector, i);

			for (ICombinatoricsVector<Voter> combination : gen) {
				if (isWinningCoalition(combination.getVector(), quota)) {
					calculateBanzhafPowerForWinningCombination(voters,
							combination);
				}
			}
		}

		int totalBanzhafPower = getTotalBanzhafPower(voters);
		for (Voter voter : voters) {
			double tbpPercent = ((double) voter.getTotalBanzhafPower() / totalBanzhafPower) * 100;
			voter.setTotalBanzhafPowerPercent(tbpPercent);
		}
	}

	private static void calculateBanzhafPowerForWinningCombination(
			List<Voter> voters, ICombinatoricsVector<Voter> combination) {

		for (Voter voter : voters) {
			if (combination.contains(voter)) {
				voter.increaseBanzhafPower();
			} else {
				voter.decreaseBanzhafPower();
			}
		}

	}

	private static boolean isWinningCoalition(List<Voter> voters, int quota) {
		int coalitionPower = 0;
		for (Voter voter : voters) {
			coalitionPower += voter.getWeight();
			if (coalitionPower >= quota) {
				return true;
			}
		}
		return false;
	}

	/*
	 * public static void calculateTotalBanzhafPowerOfVoters(List<Voter> voters,
	 * int quota) { int[] coalition = new int[voters.size()];
	 * initStartArray(coalition); do {
	 * determineBanzhafPowerAndIncreaseCounter(voters, coalition, quota); } while
	 * (Helper.nextPermutation(coalition));
	 * 
	 * int totalBanzhafPower = getTotalBanzhafPower(voters);
	 * 
	 * for (Voter voter: voters) { double tbpPercent = ((double)
	 * voter.getTotalBanzhafPower() / totalBanzhafPower) * 100;
	 * voter.setTotalBanzhafPowerPercent(tbpPercent);
	 * 
	 * } }
	 */

	private static int getTotalBanzhafPower(List<Voter> voters) {

		int sum = 0;
		for (Voter v : voters) {
			sum += v.getTotalBanzhafPower();
		}
		return sum;
	}

	private static void determineBanzhafPowerAndIncreaseCounter(
			List<Voter> voters, int[] coalition, int quota) {

		if (isWinningCoalition(voters, coalition, quota)) {

			boolean wasCriticalPlayer = determineIsCriticalPlayerExistAndIncreaseItBanzhafPower(
					voters, coalition, quota);

			if (!wasCriticalPlayer) {
				int[] newCoalition = Arrays.copyOf(coalition,
						coalition.length - 1);
				determineBanzhafPowerAndIncreaseCounter(voters, newCoalition,
						quota);
			}

		}

	}

	private static boolean determineIsCriticalPlayerExistAndIncreaseItBanzhafPower(
			List<Voter> voters, int[] coalition, int quota) {
		boolean criticalPlayerExist = false;

		int coalitionPower = getCoalitionPower(voters, coalition);

		if (quota > coalitionPower) {
			throw new IllegalArgumentException(
					"Quota greater then coalition power");
		}

		int exeptCurrentVoterCoalitionPower = 0;
		for (int index : coalition) {
			exeptCurrentVoterCoalitionPower = coalitionPower
					- voters.get(index).getWeight();
			if (exeptCurrentVoterCoalitionPower < quota) {
				voters.get(index).increaseBanzhafPower();
				criticalPlayerExist = true;
			}
		}

		return criticalPlayerExist;

	}

	private static int getCoalitionPower(List<Voter> voters, int[] coalition) {
		int coalitionPower = 0;
		for (int index : coalition) {
			coalitionPower += voters.get(index).getWeight();
		}
		return coalitionPower;
	}

	private static boolean isWinningCoalition(List<Voter> voters,
			int[] coalition, int quota) {

		int power = 0;
		for (int position : coalition) {
			power += voters.get(position).getWeight();
			if (power > quota) {
				return true;
			}
		}

		return false;
	}

	public static void calculatePoliticalPowerForVoters(List<Voter> voters,
			int quota, boolean isPivotalNumberCalculated) {

		long availableCoalitionNumber = Helper.getFactorial(voters.size());

		if (availableCoalitionNumber < 0) {
			throw new IllegalStateException(
					"Sorry, cannot calculate available coalition number for this list of voters. It is very big to get factorial quickly.");
		}

		if (!isPivotalNumberCalculated) {
			calculatePivotalNumberForVoters(voters, quota);
		}

		for (Voter voter : voters) {
			double politicalPower = ((double) voter.getPivotalPlayerTimes() / availableCoalitionNumber) * 100;
			voter.setPoliticalPowerPercent(politicalPower);
		}

	}

	public static void calculatePivotalNumberForVoters(List<Voter> voters,
			int quota) {
		int[] coalition = new int[voters.size()];
		initStartArray(coalition);
		do {
			determinePivotalPlayerAndIncreaseHisCounter(voters, coalition,
					quota);
		} while (Helper.nextPermutation(coalition));
	}

	private static void determinePivotalPlayerAndIncreaseHisCounter(
			List<Voter> voters, int[] coalition, int quota) {

		int coalitionWeight = 0;
		Voter voter = null;
		for (Integer voterPosition : coalition) {
			voter = voters.get(voterPosition);
			coalitionWeight += voter.getWeight();
			if (coalitionWeight >= quota) {
				voter.incrementPivotalPlayerNumber();
				return;
			}
		}

	}

	private static void initStartArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
	}

}
