import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class Fila {

    private Queue<Cliente> fila;
    private String nome;

    public Fila(String nome) {
        this.fila = new LinkedBlockingDeque<Cliente>();
        this.nome = nome;
    }

    public Queue<Cliente> getFila() {
        return fila;
    }

    public String getNome() {
        return nome;
    }

    public void inserir(Cliente cliente) {
        fila.add(cliente);
    }

    public Cliente removerDaFila() {
        Cliente retorna = fila.remove();
        return retorna;
    }

    public int size() {
        return fila.size();
    }

    public boolean isEmpty() {
        return (size() == 0);
    }

}