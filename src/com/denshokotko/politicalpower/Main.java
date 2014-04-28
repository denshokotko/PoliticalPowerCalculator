package com.denshokotko.politicalpower;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

public class Main {

	private static final boolean FORMATTED_PRINT = true;
	
	public static void main(String... args) {
		Integer i = null;
		
		System.out.println(i);
		
		
		List<Voter> simpleVoters = new ArrayList<>();
		simpleVoters.add(new Voter("first", 50));
		simpleVoters.add(new Voter("second", 49));
		simpleVoters.add(new Voter("third", 1));
		VotingSystemProcessor.calculateTotalBanzhafPowerOfVoters(simpleVoters, 51);
		VotingSystemProcessor.calculateJohnstonPowerOfVoters(simpleVoters, 51);
		VotingSystemProcessor.calculateDeeganPackelPowerOfVoters(simpleVoters, 51);
		/*
		
		Helper.printPoliticalPower(simpleVoters, FORMATTED_PRINT);

		System.out.println("\n------------ EEC 1958 -----------------\n");
		VotingSystem system1954 = getEuropeanCommunity1954VotingSystem();
		VotingSystemProcessor.calculatePoliticalPowerForVoters(system1954.getVoters(), system1954.getQuota(), FORMATTED_PRINT);
		VotingSystemProcessor.calculateTotalBanzhafPowerOfVoters(system1954.getVoters(), system1954.getQuota());
		VotingSystemProcessor.calculateJohnstonPowerOfVoters(system1954.getVoters(), system1954.getQuota());
		VotingSystemProcessor.calculateDeeganPackelPowerOfVoters(system1954.getVoters(), system1954.getQuota());
		

		Helper.printPoliticalPower(system1954.getVoters(), FORMATTED_PRINT);

		System.out.println("\n------------ EEC 1973 -----------------\n");

		VotingSystem europe1973 = getEuropianVotingSystemFrom1973();
		VotingSystemProcessor.calculatePoliticalPowerForVoters(
				europe1973.getVoters(), europe1973.getQuota(), false);
		VotingSystemProcessor.calculateTotalBanzhafPowerOfVoters(europe1973.getVoters(), europe1973.getQuota());
		VotingSystemProcessor.calculateJohnstonPowerOfVoters(europe1973.getVoters(), europe1973.getQuota());
		VotingSystemProcessor.calculateDeeganPackelPowerOfVoters(europe1973.getVoters(), europe1973.getQuota());
		Helper.printPoliticalPower(europe1973.getVoters(), FORMATTED_PRINT);
		*/

	}

	private static VotingSystem getEuropeanCommunity1954VotingSystem() {

		List<Voter> voters = new ArrayList<>();
		Voter france = new Voter(4);
		Voter german = new Voter(4);
		Voter italy = new Voter(4);
		Voter netherlands = new Voter(2);
		Voter belgium = new Voter(2);
		Voter luxemburg = new Voter(1);

		voters.add(france);
		voters.add(german);
		voters.add(italy);
		voters.add(netherlands);
		voters.add(belgium);
		voters.add(luxemburg);

		VotingSystem votingSystem = new VotingSystem();
		votingSystem.setTitle("European Community 1954");
		votingSystem.setQuota(12);
		votingSystem.setTotalVotersWeight(17);
		votingSystem.setVoters(voters);

		return votingSystem;
	}

	private static VotingSystem getEuropianVotingSystemFrom1973() {

		List<Voter> voters = new ArrayList<>();

		voters.add(new Voter("France", 10));
		voters.add(new Voter("Germany", 10));
		voters.add(new Voter("Italy", 10));
		voters.add(new Voter("Belgium", 5));
		voters.add(new Voter("Netherlands", 5));
		voters.add(new Voter("Luxembourg", 2));
		voters.add(new Voter("England", 10));
		voters.add(new Voter("Denmark", 3));
		voters.add(new Voter("Ireland", 3));

		VotingSystem votingSystem = new VotingSystem();
		votingSystem.setTitle("European Community 1973");
		votingSystem.setQuota(41);
		votingSystem.setVoters(voters);

		return votingSystem;
	}

}
