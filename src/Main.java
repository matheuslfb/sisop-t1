import java.io.IOException;

public class Main {

    public static void main(String[] args)throws IOException {

        Leitor leitor = Leitor.readFile("Example-w-io-1.txt");
        Escalonador escalonador = new Escalonador(leitor);

        System.out.println(leitor.toString());

    }
}
