public class Distribui implements Runnable {

    private Fila filaNormal1;
    private Fila filaNormal2;
    private Fila filaPreferencial;
    private Fila distribuir;

    public Distribui(Fila filaNormal1, Fila filaNormal2, Fila filaPreferencial, Fila distribuir) {
        this.filaNormal1 = filaNormal1;
        this.filaNormal2 = filaNormal2;
        this.filaPreferencial = filaPreferencial;
        this.distribuir = distribuir;
    }

    @Override
    public void run() {

        int cont = 0;

        while (cont < 30) {
            if (!distribuir.isEmpty()) {

                Cliente clienteTemp = distribuir.removerDaFila();
                if (clienteTemp.getReserva() == true) {
                    filaPreferencial.inserir(clienteTemp);
                    try {
                        Thread.sleep((int) (Math.random() * 900) + 3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Cliente " + clienteTemp.getFicha() + " entrou na fila de (Reserva)\n");

                } else {
                    int chanceFila = (int) (Math.random() * 2);
                    if (chanceFila == 0) {
                        filaNormal1.inserir(clienteTemp);
                        try {
                            Thread.sleep((int) (Math.random() * 900) + 3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Cliente " + clienteTemp.getFicha() + " entrou na fila (Caixa De Atendimento 1)\n");

                    } else if (chanceFila == 1) {
                        filaNormal2.inserir(clienteTemp);
                        try {
                            Thread.sleep((int) (Math.random() * 900) + 3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Cliente " + clienteTemp.getFicha() + " entrou na fila (Caixa De Atendimento 2)\n");
                    }
                }
                cont++;

            }

        }

    }

}