package proj;

import java.awt.*;

public class Cor{ 
	
	public Cor() {
	}
	
	public String findColor() {
		//classe que pega as posições do ponteiro do mouse
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		int x = (int) b.getX();
		int y = (int) b.getY();
		
		//pega a cor do pixel específico 
		try {
			Robot robot = new Robot();
	        Color color = robot.getPixelColor(x, y);
	        return this.nameColor(color);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "void";
		
	}
	
	private String nameColor(Color color) {
		int R = color.getRed();
		int G = color.getGreen();
		int B = color.getBlue();
		
		if(R < 64 && R == B && R == G) return "Preto";
		else if(R >= 64 && R < 128 && R == B && R == G) return "Cinza 50%";
		else if(R >= 128 && R < 200 && R == B && R == G) return "Cinza 25%";
		else if(R >= 200 && R == B && R == G) return "Branco";
		else if(R < 30) {
			if(G < 30) {
				if(B < 20) return "Preto";
				else return "Azul";
			} else if (G >= 20 && G < 60) {
				if(B < 60) return "Preto";
				else return "Azul";
			} else if (G >= 60 && G < 120) {
				if(B < G) return "Verde Escuro";
				else return "Azul";
			} else if (G >= 120 && G < 180) {
				if(B < G) return "Verde";
				else return "Azul";
			} else if (G >= 180) {
				if(B < G) return "Verde";
				else return "Azul";
			}
		} else if(R >= 30 && R < 60) {
			if(G < 30) {
				if(B < 20) return "Marrom";
				else if(B >= 20 && B < 40) return "Cinza 75%";
				else if(B >= 40) return "Azul";
			} else if (G >= 30 && G < 60) {
				if(B < 60) return "Verde Escuro";
				else if(B >= 60 && B < 120) return "Azul Escuro";
				else if(B >= 120 && B < 180) return "Azul Marinho";
				else if(B >= 180) return "Azul";
			} else if (G >= 60 && G < 120) {
				if(B < 60) return "Verde Floresta";
				else if(B >= 60 && B < 120) return "Verde Escuro";
				else if(B >= 120 && B < 180) return "Indigo";
				else if(B >= 180) return "Azul";
			} else if (G >= 120 && G < 180) {
				if(B < 60) return "Verde Oliva";
				else if(B >= 60 && B < 120) return "Verde";
				else if(B >= 120 && B < 180) return "Verde Desbotado";
				else if(B >= 180) return "Turquesa";
			} else if (G >= 180) {
				if(B < 60) return "Verde";
				else if(B >= 60 && B < 120) return "Verde";
				else if(B >= 120 && B < 180) return "Verde Oceano";
				else if(B >= 180) return "Azul Pérola";
			}
			
		} else if(R >= 60 && R < 120 ) {
			if(G < 60) {
				if(B < 60) return "Marrom";
				else if(B >= 60 && B < 120) return "Magenta";
				else if(B >= 120 && B < 180) return "Magenta";
				else if(B >= 180) return "Roxo Claro";
			} else if (G >= 60 && G < 120) {
				if(B < 60) return "Marrom";
				else if(B >= 60 && B < 120) return "Verde Escuro";
				else if(B >= 120 && B < 180) return "Azul Desbotado";
				else if(B >= 180) return "Azul";
			} else if (G >= 120 && G < 180) {
				if(B < 60) return "Verde";
				else if(B >= 60 && B < 120) return "Verde Desbotado";
				else if(B >= 120 && B < 180) return "Azul Piscina";
				else if(B >= 180) return "Azul";
			} else if (G >= 180) {
				if(B < 60) return "Verde";
				else if(B >= 60 && B < 120) return "Verde";
				else if(B >= 120 && B < 180) return "Verde Piscina";
				else if(B >= 180) return "Azul Piscina";
			}	
		} else if(R >= 120 && R < 180 ) {
			if(G < 60) {
				if(B < 60) return "Vermelho";
				else if(B >= 60 && B < 120) return "Magenta";
				else if(B >= 120 && B < 180) return "Rosa escuro";
				else if(B >= 180) return "Roxo";
			} else if (G >= 60 && G < 120) {
				if(B < 60) return "Marrom ferrugem";
				else if(B >= 60 && B < 120) return "Vermelho Claro";
				else if(B >= 120 && B < 180) return "Roxo Uva";
				else if(B >= 180) return "Roxo";
			} else if (G >= 120 && G < 180) {
				if(B < 60) return "Amarelo Escuro";
				else if(B >= 60 && B < 120) return "Amarelo Latão";
				else if(B >= 120 && B < 180) return "Cinza";
				else if(B >= 180) return "Azul Selvagem";
			} else if (G >= 180) {
				if(B < 60) return "Verde grama";
				else if(B >= 60 && B < 120) return "Verde grama";
				else if(B >= 120 && B < 180) return "Verde piscina";
				else if(B >= 180) return "Azul bebê";
			}	
		}else if(R >= 180 && R < 230) {
			if(G < 60) {
				if(B < 60) return "Vermelho";
				else if(B >= 60 && B < 120) return "Rosa Choque";
				else if(B >= 120 && B < 180) return "Rosa Choque";
				else if(B >= 180) return "Rosa Forte";
			} else if (G >= 60 && G < 120) {
				if(B < 60) return "Vermelho Tijolo";
				else if(B >= 60 && B < 120) return "Vermelho";
				else if(B >= 120 && B < 180) return "Rosa";
				else if(B >= 180) return "Lilás";
			} else if (G >= 120 && G < 180) {
				if(B < 60) return "Laranja";
				else if(B >= 60 && B < 120) return "Laranja Tangerina";
				else if(B >= 120 && B < 180) return "Rosa turquesa";
				else if(B >= 180) return "Lilás";
			} else if (G >= 180) {
				if(B < 60) return "Amarelo Mostarda";
				else if(B >= 60 && B < 120) return "Amarelo Queimado";
				else if(B >= 120 && B < 180) return "Verde Fumaça";
				else if(B >= 180 && B < 230) return "Cinza Claro";
				else if(B>230) return "Azul Bebê";
				
			} 
		}else if(R >= 230) {
			if(G < 70) {
				if(B < 70) return "Vermelho";
				else if(B >= 70 && B < 140) return "Rosa escuro";
				else if(B >= 140 && B < 230) return "Rosa Choque";
				else if(B >= 230) return "Rosa Forte";
			} else if (G >= 70 && G < 140) {
				if(B < 70) return "Laranja";
				else if(B >= 70 && B < 140) return "Vermelho Claro";
				else if(B >= 140 && B < 230) return "Rosa";
				else if(B >= 230) return "Lilás";
			} else if (G >= 140 && G < 230) {
				if(B < 70) return "Laranja claro";
				else if(B >= 70 && B < 140) return "Laranja claro";
				else if(B >= 140 && B < 230) return "Bege";
				else if(B >= 230) return "Rosa bebe";
			}  else if (G >= 230) {
				if(B < 70) return "Amarelo";
				else if(B >= 70 && B < 140) return "Amarelo desbotado";
				else if(B >= 140 && B < 230) return "Amarelo areia";
				else if(B >= 230) return "Branco";
			}
		} 
		
		return "Preto";
		
	}
}


