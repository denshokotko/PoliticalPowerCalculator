package com.denshokotko.politicalpower;

import java.util.ArrayList;
import java.util.List;

public class VotingSystem {

	private String title;
	
	private int quota;
	
	private int totalVotersWeight;
	
	public List<Voter> getVoters() {
		return voters;
	}

	public void setVoters(List<Voter> voters) {
		this.voters = voters;
	}

	private List<Voter> voters;
	
	public void addVoter(Voter voter) {
		if (voters == null) {
			voters = new ArrayList<Voter>();
		}
		voters.add(voter);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getQuota() {
		return quota;
	}

	public void setQuota(int quota) {
		this.quota = quota;
	}

	public int getTotalVotersWeight() {
		return totalVotersWeight;
	}

	public void setTotalVotersWeight(int totalVotersWeight) {
		this.totalVotersWeight = totalVotersWeight;
	}
	
}
