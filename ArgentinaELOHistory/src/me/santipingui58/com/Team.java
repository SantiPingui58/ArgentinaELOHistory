package me.santipingui58.com;

public class Team {

	private String name;
	private PImage escudo;
	
	private int wins;
	private int draws;
	private int loses;
	
	private int currentELO;
	private int futureELO;
	
	private int currentY;
	private int futureY;
	
	private int totaldaysintop1;
	private int totaldaysintop10;
	private int daysinrowtop1;
	private int daysinrowtop10;
	
	private int _1stPosition;
	private int _2ndPosition;
	private int _3rdPosition;
	
	public Team(String name) {
		name = name.replaceAll("\\s", "");
		this.name = name;		
		String escudoName = name.replaceAll(" ", "");
		escudo = loadImage("/data/escudos/"+escudoName+".png");		
		
		this.currentELO = 1000;
		this.futureELO = 1000;
		
		Data data = new Data();
		data.getTeams().add(this);
	}
	
	public void resetDaysInRowTop10() {
		this.daysinrowtop10 = 0;
	}
	
	public void addDaysInRowTop10() {
		this.daysinrowtop10 = this.daysinrowtop10 + 1;
	}
	
	public int getDaysInRowTop10() {
		return this.daysinrowtop10;
	}
	
	public void resetDaysInRowTop1() {
		this.daysinrowtop1 = 0;
	}
	
	public void addDaysInRowTop1() {
		this.daysinrowtop1 = this.daysinrowtop1 + 1;
	}
	
	public int getDaysInRowTop1() {
		return this.daysinrowtop1;
	}
	
	public void addDayInTop10() {
		this.totaldaysintop10 = this.totaldaysintop10 +1;
	}
	
	public int getDaysInTop10() {
		return this.totaldaysintop10;
	}
	
	public void addDayInTop1() {
		this.totaldaysintop1 = this.totaldaysintop1 + 1;
	}
	
	
	public int getDaysInTop1() {
		return this.totaldaysintop1;
	}
	
	
	public int getFutureY() {
		return this.futureY;
	}
	
	public void setFutureY(int i) {
		this.futureY = i;
	}
	public void setCurrentY(int i) {
		this.currentY = i;
	}
	
	public int getCurrentY() {
		return this.currentY;
	}
	
	public void setFutureELO(int i) {
		this.futureELO = i;
	}
	
	public int getFutureELO() {
		return this.futureELO;
	}
	
	public void setCurrentELO(int i) {
		this.currentELO = i;
	}
	
	public int getCurrentELO() {
		return this.currentELO;
	}
	
	public int getGames() {
		return this.wins+this.loses;
	}
	
	public void addLose() {
		this.loses = this.loses+1;
	}
	
	public int getLoses() {
		return this.loses;
	}
	
	public void addWin() {
		this.wins = this.wins+1;
	}
	
	public int getWins() {
		return this.wins;
	}
	public void addDraw() {
		this.draws = this.draws + 1;
	}
	
	public int getDraws()
	{
		return this.draws;
	}
	public PImage getEscudo() {
		return this.escudo;
	}
	
	public String getName() {
		return this.name;
	}
}
