package me.santipingui58.com;

public class ArgentinaELOHistory {

private Interface i;
private Data data;
private Time time;

void setup() {
	 i = new Interface();
	 data = new Data();
	 time = new Time(31,5,1931);
	 //Velocidad del programa
		frameRate(200);
	i.interfaceSetup();
	data.loadData();	
}


void draw() {
	i.doBackground();
}
	
	
}
