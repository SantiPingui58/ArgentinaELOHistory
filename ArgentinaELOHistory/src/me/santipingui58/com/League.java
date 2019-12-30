package me.santipingui58.com;

public class League {

	public String name;
	public Team winner;
	public Team second;
	
	public League(String name, Team winner,Team second) {
		this.name = name;
		Data data = new Data();
		data.getLeagues().add(this);
	}
	
	public String getName() {
		return this.name;
	}
	
	public Team getWinner() {
		return this.winner;
	}
	
	public Team getSecond() {
		return this.second;
	}
}
