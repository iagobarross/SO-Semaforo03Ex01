package view;

import controller.ThreadCarro;

public class Principal {

	public static void main(String[] args) {
		
		String[] sentido = {"norte", "sul", "leste", "oeste"};
		
		for(int i = 0; i < 4; i++) {
			Thread t = new ThreadCarro(sentido[i]);
			t.start();
		}
		
	}
}
