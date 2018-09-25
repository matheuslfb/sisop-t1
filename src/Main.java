import java.io.IOException;

public class Main {

    public static void main(String[] args)throws IOException {

        Leitor leitor = Leitor.readFile("H:\\sisop\\sisop-t1\\trab-so1-teste1 SR.txt");
        Escalonador escalonador = new Escalonador(leitor);

        leitor.getListaProcessos();

    }
}
