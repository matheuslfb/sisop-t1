
import java.io.BufferedReader;
import java.io.FileNotFoundException;
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




    public static Leitor readFile(String fileURL)throws IOException {

        Leitor leitor;
        String line;
        int id = 1;
        List<Integer> inOut = null;

        try (BufferedReader br = new BufferedReader(new FileReader(fileURL))) {
            //LINHA 1: número de processos (ignorar)
            int numeroDeProcesso = Integer.parseInt(br.readLine());

            //LINHA 2: tamanho de fatia de tempo,
            int fatiaDeTempo = Integer.parseInt(br.readLine());

            leitor = new Leitor(fatiaDeTempo);

            //lê as linhas restantes
            //Para cada processo:
            for (int j = 0; j < numeroDeProcesso; j++) {
                inOut = null;

                //read the line
                line = br.readLine();

                //split
                String[] lineParts = line.split(" ");

                //1 = tempo de chegada,
                int tempoDeChegada = Integer.parseInt(lineParts[0]);

                //2 = tempo de execução,
                int tempoDeExecucao = Integer.parseInt(lineParts[1]);

                //3 = prioridade (1 até 9 - prioridade 1 é o melhor)
                int prioridade = Integer.parseInt(lineParts[2]);

                //3? =  tempos de acesso a operações de E/S.
                if (lineParts.length > 3) {
                    inOut = new ArrayList<Integer>();

                    for (int i = 3; i < lineParts.length; i++)
                        inOut.add(Integer.parseInt(lineParts[i]));
                }

                leitor.addProcesso(
                        new Processo(tempoDeChegada, tempoDeExecucao, prioridade, id++, inOut)
                );
            }

        }
        return leitor;
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
