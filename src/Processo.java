import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Processo implements Comparable<Object> {

        List<Integer> inOut;

        private int id;
        private int tempoDeChegada;
        private int tempoDeExecucao;
        private int prioridade;
        private int tempoRodando = 0; // tempo da fatia de tempo
        private int tempoRodandoTotal = 0;
        private int tempoDeInicioInOut;
        private int tempoDeEspera = 0;
        private int tempoDeResposta = -1;

    public Processo(int tempoDeChegada, int tempoDeExecucao, int prioridade, int id, List<Integer> inOut) {
        	this.id = id;
		this.tempoDeChegada = tempoDeChegada;
		this.tempoDeExecucao = tempoDeExecucao;
		this.prioridade = prioridade;
		this.inOut = inOut;

		if (inOut != null)
            Collections.sort(inOut);
}

public int getTempoDeChegada(){return tempoDeChegada;}

    @Override
    public int compareTo(Object arg0) {
        int prioridade = ((Processo) arg0).prioridade;

        return this.prioridade - prioridade;
    }

    public static void sortByPriority(List<Processo> running) {
        Collections.sort(running, new Comparator<Processo>() {
            @Override
            public int compare(Processo p1, Processo p2) {
                return p1.prioridade - p2.prioridade;
            }
        });
    }
}
