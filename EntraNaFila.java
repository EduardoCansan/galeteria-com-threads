public class EntraNaFila implements Runnable{
	
	private Fila fila;
	private int contadorCliente = 0;
	
	public EntraNaFila(Fila fila) {
		contadorCliente = 0;
		this.fila = fila;
	}

	@Override
	public void run() {

		try {
			while (contadorCliente < 30) {
				Thread.sleep((int) (Math.random() * 900) + 2000);
				contadorCliente++;
				fila.inserir(new Cliente(contadorCliente));
				System.out.println("Cliente " + contadorCliente + " entrou na Galeteria\n");
			}
			
		} catch (InterruptedException e) {
		}
	
	}
    
}