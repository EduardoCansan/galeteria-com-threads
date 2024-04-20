public class Contador {

	private volatile int contagem; 

	public synchronized final int getContagem() { 
		return contagem;
	}

	public synchronized final void incrementa() {
		this.contagem++;
	}
	
}
