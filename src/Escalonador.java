import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Escalonador {


    private List<Process> ready = new LinkedList<>();
    private List<Process> inOut = new ArrayList<>();
    private List<Process> done = new LinkedList<>();

    private Leitor leitor;
    private Processo p;

    public Escalonador(Leitor leitor){
        this.leitor = leitor;
    }

    public void printTeste(){

        System.out.print(leitor.getListaProcessos());
    }
}
