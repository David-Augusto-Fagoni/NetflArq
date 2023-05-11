package view;

import controller.INetflixController;
import controller.NetflixController;

public class Principal {

	public static void main(String[] args) {
		NetflixController Net = new NetflixController();
		try {
			Net.chamarFila();
			Net.chamarLista();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
