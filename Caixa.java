public class Caixa implements Runnable {

    private Fila filaAtendimento;
    private Contador cont;

    public Caixa(Fila filaAtendimento, Contador cont) {
        this.filaAtendimento = filaAtendimento;
        this.cont = cont;
    }

    public Fila getFilaAtendimento() {
        return filaAtendimento;
    }

    public Contador getCont() {
        return cont;
    }

    @Override
    public synchronized void run() {
        while (cont.getContagem() < 30) {
            if (!filaAtendimento.isEmpty()) {
                Cliente clienteTemp = filaAtendimento.removerDaFila();
                try {
                    Thread.sleep((int) (Math.random() * 900) + 4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Cliente " + clienteTemp.getFicha() + " saiu do caixa " + filaAtendimento.getNome() + " e foi retirar o galeto\n");

                try {
                    Thread.sleep((int) (Math.random() * 900) + 6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Cliente " + clienteTemp.getFicha() + " pegou o galeto!\n");
                cont.incrementa();
            }

        }

    }

}