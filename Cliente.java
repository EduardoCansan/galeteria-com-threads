public class Cliente {

    private int ficha;
    private boolean reserva;

    public Cliente(int ficha) {
        this.ficha = ficha;
        this.reserva = getRandomBoolean();
    }

    public int getFicha() {
        return ficha;
    }

    public boolean getReserva() {
        return reserva;
    }

    public static boolean getRandomBoolean() {
        int prob = (int)(Math.random() * 3) ;
        return prob == 0;
    }

}