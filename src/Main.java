import java.io.IOException;

public class Main {

    public static void main(String[] args)throws IOException {

       
        Escalonador esc = new Escalonador();
        esc.readFile();
        esc.ordenaOrdemChegada();
        esc.getListaOrdenada();

       
    }
}
