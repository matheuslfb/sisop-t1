
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Leitor {

    public final int entradaSaida = 4;

    public int fatiaDeTempo;

    private List<Processo> listaProcessos = new ArrayList<>();

    public Leitor(int fatiaDeTempo){
        this.fatiaDeTempo = fatiaDeTempo;
    }

    public void addProcesso(Processo p){
        listaProcessos.add(p);
    }

    public List<Processo> getListaProcessos(){
        for(Processo p : listaProcessos) {
            System.out.println( p.toString());
        }
        return listaProcessos;
    }

    public boolean isEmpty(){
        return !listaProcessos.isEmpty();
    }

    public int getFatiaDeTempo(){
        return fatiaDeTempo;
    }

    public List<Processo> getPorTempo(int t){
        List<Processo> res = new ArrayList<Processo>();

        for (Processo p : listaProcessos)
            if (p.getTempoDeChegada() == t)
                res.add(p);

        for (Processo p : res)
            listaProcessos.remove(p);

        return res;
    }

    

    @Override
    public String toString() {
        return
                "entradaSaida=" + entradaSaida +
                "\nfatiaDeTempo=" + fatiaDeTempo +
                "\nlistaProcessos=" + listaProcessos +
                '}';
    }
}
