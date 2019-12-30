package me.santipingui58.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {

	private List<Team> teams = new ArrayList<Team>();
	private List<League> leagues = new ArrayList<League>();
	
	public List<League> getLeagues() {
		return this.leagues;
	}
	
	public List<Team> getTeams() {
		return this.teams;
	}
	
	public Team getTeam(String name) {
		for (Team t : teams) {
			if (t.getName().equalsIgnoreCase(name)) {
				return t;
			}
		}
		return null;
	}
	
	
	public boolean doesTeamExist(String name) {
		for (Team t : teams) {
			if (t.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	} 
	public boolean doesLeagueExist(String name) {
		for (League l : leagues) {
			if (l.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	
	public void loadData() {
		Table table = loadTable("/data/database.csv");
		
		//Cargar todos los equipos
		for (int i = 0; i< table.getRowCount();i++) {
			String steam1 = table.getString(i,0);
			String steam2 = table.getString(i,3);		
			if (!doesTeamExist(steam1)) {
				Team team1 = new Team(steam1);
			}
			if (!doesTeamExist(steam2)) {
				Team team2 = new Team(steam2);
			}
		}
		
		
		//Cargar todos los torneos
		for (int i = 0;i < table.getRowCount();i++) {
			String league_name = table.getString(i,6);
			if (!doesLeagueExist(league_name)) {
				Team winner = getTeam(table.getString(i,7));
				Team second = getTeam(table.getString(i,8));
				League league = new League(league_name,winner,second);
			}
		}
		
		
	}
	
	
	
	public void playMatches() {
		
	}
	
	public HashMap<String,Integer> getTop(boolean calculate) {		
		HashMap<String,Integer> teamsELO = new HashMap<String,Integer>();
		
		for (Team t : teams) {
			teamsELO.put(t.getName(), t.getCurrentELO());
		}
		
		GFG gfg = new GFG();
		teamsELO =  gfg.sortByValue(teamsELO);
		if (calculate) {
		int pos = 1;		
		for (Map.Entry<String, Integer> entry : teamsELO.entrySet()) {
			   String key = entry.getKey();
			    Team t = getTeam(key);		 
			    if (pos<=15) {
			    t.setFutureY(420+(40*(pos-1)));						    		    
			    pos++;
			    } else {
			    	break;
			    }
		}
		}
		
		return teamsELO;
	}
	
	
	public int elo(Team local,Team visitante, int score1, int score2) {
		//El valor variable de k dependerá de la diferencia del resultado,
		//y en caso de empate, se dará un valor menor de k y el partido "ganado" para el de menor ELO
		Team winner = null;
		Team loser = null;
		boolean draw = false;
		int k = 48;
		int dif = 0;
		
		if (score1>score2) {
			winner = local;
			loser = visitante;
			dif = score1-score2;
		} else if (score2>score1) {
			winner = visitante;
			loser = local;
			dif = score2-score1;
		} else {
			draw = true;
		}		
		if (draw) {
			k = 12;
			
		} else {
			k =  32 + (2*(dif-1));
		 if (winner==visitante) {
			 k = k+16;
		 }
		}
		
			//Fórmula de ELO
		 	double p1 = ((double) winner.getCurrentELO()/ (double) 400); 
		    double p1_ = Math.pow(10, p1); 
		    
		    double p2 = ((double)loser.getCurrentELO()/(double)400); 
		    double p2_ = Math.pow(10, p2);
		     
		    double d = p1_ + p2_;
		    
		    double ex1 = (double)p1_/(double)d;   
		    double a1 = ((double)k*(1-(double)ex1));
		    return (int) a1;
	}
}
