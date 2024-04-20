public class Galeteria {

    public static void main(String[] args) {

        System.out.println("Galeteria Aberta: \n");

        Fila filaEspera = new Fila("Rua");
        Fila CaixaUm = new Fila("Caixa De Atendimento 1");
        Fila CaixaDois = new Fila("Caixa De Atendimento 2");
        Fila CaixaPrefencial = new Fila("Caixa De Reserva");

        Contador cont = new Contador();

        Thread esperar = new Thread(new EntraNaFila(filaEspera));
        Thread distribuir = new Thread(new Distribui(CaixaUm, CaixaDois, CaixaPrefencial, filaEspera));

        Thread c1 = new Thread(new Caixa(CaixaUm, cont));
        Thread c2 = new Thread(new Caixa(CaixaDois, cont));
        Thread cp = new Thread(new Caixa(CaixaPrefencial, cont));

        esperar.start();
        distribuir.start();

        c1.start();
        c2.start();
        cp.start();

        /*
         * entrar  = 1500 (+900) +- = (2400)
           fila    = 3000 (+900) +- = (3900) 
           bancada = 4000 (+900) +- = (4900) 
           sair    = 6000 (+900) +- = (6900) 
         */

    }
    
}