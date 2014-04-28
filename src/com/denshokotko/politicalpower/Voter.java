package com.denshokotko.politicalpower;

public class Voter {

	private String name;

	private int weight;

	private int pivotalPlayerTimes;

	private double politicalPowerPercent;
	
	private int totalBanzhafPower;
	
	private double totalBanzhafPowerPercent;

	private double johnstonPower;
	
	private double johnstonPowerPercent;
	
	private double deeganPackelPower;
	
	private double deeganPackelPowerPercent;

	public double getDeeganPackelPower() {
		return deeganPackelPower;
	}

	public void setDeeganPackelPower(double deeganPackelPower) {
		this.deeganPackelPower = deeganPackelPower;
	}

	public double getDeeganPackelPowerPercent() {
		return deeganPackelPowerPercent;
	}

	public void setDeeganPackelPowerPercent(double deeganPackelPowerPercent) {
		this.deeganPackelPowerPercent = deeganPackelPowerPercent;
	}

	public double getJohnstonPower() {
		return johnstonPower;
	}

	public void setJohnstonPower(double johnstonPower) {
		this.johnstonPower = johnstonPower;
	}

	public double getJohnstonPowerPercent() {
		return johnstonPowerPercent;
	}

	public void setJohnstonPowerPercent(double johnstonPowerPercent) {
		this.johnstonPowerPercent = johnstonPowerPercent;
	}

	public double getTotalBanzhafPowerPercent() {
		return totalBanzhafPowerPercent;
	}

	public void setTotalBanzhafPowerPercent(double totalBanzhafPowerPercent) {
		this.totalBanzhafPowerPercent = totalBanzhafPowerPercent;
	}

	public int getTotalBanzhafPower() {
		return totalBanzhafPower;
	}

	public void setTotalBanzhafPower(int totalBanzhafPower) {
		this.totalBanzhafPower = totalBanzhafPower;
	}

	public double getPoliticalPowerPercent() {
		return politicalPowerPercent;
	}

	public void setPoliticalPowerPercent(double politicalPowerPercent) {
		this.politicalPowerPercent = politicalPowerPercent;
	}

	public int getPivotalPlayerTimes() {
		return pivotalPlayerTimes;
	}

	public Voter(int weight) {
		super();
		this.weight = weight;
	}

	public Voter(String name, int weight) {
		super();
		this.name = name;
		this.weight = weight;
	}

	public void setPivotalPlayerTimes(int pivotalPlayerTimes) {
		this.pivotalPlayerTimes = pivotalPlayerTimes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void incrementPivotalPlayerNumber() {
		pivotalPlayerTimes++;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Voter [name=");
		builder.append(name);
		builder.append(", weight=");
		builder.append(weight);
		builder.append(", pivotalPlayerTimes=");
		builder.append(pivotalPlayerTimes);
		builder.append(", politicalPowerPercent=");
		builder.append(politicalPowerPercent);
		builder.append("]");
		return builder.toString();
	}

	public void increaseBanzhafPower() {
		totalBanzhafPower++;
	}

	public void decreaseBanzhafPower() {
		totalBanzhafPower--;		
	}

	public void addToJohnstonPower(double n) {
		johnstonPower += n;
	}
	
	public void addToDeeganPackelPower(double n) {
		deeganPackelPower += n;
	}
}
