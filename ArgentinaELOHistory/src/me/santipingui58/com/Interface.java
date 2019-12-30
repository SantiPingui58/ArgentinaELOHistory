package me.santipingui58.com;

public class Interface {
	
	PFont font;
	
	public void interfaceSetup() {
		//Tamaño y fondo del programa
		size(1920,1080);
		stroke(255);
	}
	
	
	public void doBackground() {
		
		//Fondo y fuente principal
		background(0);
		font = createFont()"Ziggurat-Black",20);
		textFont(font);
		pushStyle();
		fill(255,0,0);
		popStyle();
				
		//Posiciones del Ranking visuales
		for (int i = 1;i<=10;i++) {
			int a = 420 + (40*(i-1));
			String text = null;
			if (i==1) {
				text = "1st";
			} else if (i==2) {
				text = "2nd";
			} else if (i==3){
				text = "3rd";
			} else {
				text = i+"th";
			}
			if (i==10) {
				text(text,10,a);
			} else {
				text("   "+text,10,a);
			}
		}
	}
}
