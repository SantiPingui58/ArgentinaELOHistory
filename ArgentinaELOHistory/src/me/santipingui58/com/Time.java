package me.santipingui58.com;

public class Time {

	private int day;
	private int month;
	private int year;
	
	public Time(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public void time() {
		int hmddtmh = howManyDaysDoesThisMonthHave(this.day);
		if (this.day<=hmddtmh) {
			this.day++;
		} else {
			this.day = 1;
			if (this.month<=12) {
				this.month++;
			} else {
				this.month = 1;
				this.year++;
			}
		}
	}
	
	public int howManyDaysDoesThisMonthHave(int month) {
		if (month==1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month==12) {
			return 31;
		} else if (month== 4 || month ==6 || month == 9 || month ==11) {
			return 30;
		} else {
			return 28;
		}
	}
	public String getMonthName() {
		if (month==1) {
			return "Enero";
		} else if (month==2) {
			return "Febrero";
		} else if (month==3) {
			return "Marzo";
		} else if (month==4) {
			return "Abril";
		} else if (month==5) {
			return "Mayo";
		} else if (month==6) {
			return "Junio";
		} else if (month==7) {
			return "Julio";
		} else if (month==8) {
			return "Agosto";
		} else if (month==9) {
			return "Septiembre";
		} else if (month==10) {
			return "Octubre";
		} else if (month==11) {
			return "Noviembre";
		} else if (month==12) {
			return "Diciembre";
		}
		return null;
	}
	
	public int getDay() {
		return this.day;
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public int getYear() {
		return this.year;
	}
}
