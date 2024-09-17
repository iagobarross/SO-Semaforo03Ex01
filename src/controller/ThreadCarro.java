/*1. Fazer uma aplicação, console, que gerencie a figura abaixo:
Para tal, usar uma variável sentido, que será alterado pela Thread que controla cada carro
com a movimentação do carro. Quando a Thread tiver a possibilidade de ser executada, ela
deve imprimir em console o sentido que o carro está passando. Só pode passar um carro por
vez no cruzamento. Usar threadId() ou getId() para identificar os carros.
*/
package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread {

	private int idCarro;
	private static Semaphore semaforo = new Semaphore(1);
	private String sentido;

	public ThreadCarro(String sentido) {
		this.idCarro = (int) threadId();
		this.sentido = sentido;
	}

	@Override
	public void run() {
		try {
			semaforo.acquire();
			System.out.println("Carro #" + idCarro + " passou no sentido " + sentido);
			Thread.sleep(500);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			semaforo.release();
		}
	}

}
