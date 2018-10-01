import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Escalonador {

	private Processo[] processos; // Lista de todos os processos
	private int fatiaDeTempo, nextArrival, execTime, recursionQuit, IOExecutionTime, restrict; // Dados. recursionQuit e
	// restrict servem para evitar
	// loop infinito no código
	private boolean preemp = false, noMultiContext = false; // Condicionais para execução (melhor demonstrados em
															// ação)
	private LinkedList<Integer> procPorTempoDeChegada; // Lista de TODOS os tempos de chegada ordenados
	private LinkedList<String> printProcess, printIO; // Gráficos para serem impressos no final
	private LinkedList<Processo> availableProcess, roundRobinEffect; // Listas auxiliares que analisam processos que
																		// podem ser executados/rodiziados
	private Processo currentProcess, IOProcess; // Objetos de auxílio que servem como ponteiros que apontam para um
												// processo

	public Escalonador() {

	}

	public void readFile() throws FileNotFoundException, IOException {

		Scanner s = new Scanner(System.in);
		System.out.println("Digite o nome do arquivo de entrada (sem extensão .txt)");
		String enter = s.nextLine();
		System.out.println();
		System.out.println("====================================================================================");
		BufferedReader in = new BufferedReader(new FileReader(enter + ".txt"));
		String line;
		int procCount = 0;

		line = in.readLine();
		processos = new Processo[Integer.parseInt(line)];
		
		line= in.readLine();
		fatiaDeTempo = Integer.parseInt(line);

		while ((line = in.readLine()) != null) {
			String aux[] = line.split(" ");
			processos[procCount] = new Processo(fatiaDeTempo, Integer.parseInt(aux[0]), Integer.parseInt(aux[1]), Integer.parseInt(aux[2])); //Cria o processo
			
			for(int i=3;i< aux.length; i++) {
				processos[procCount].insertIOTime(Integer.parseInt(aux[i]));
			}
			processos[procCount].setId(procCount+1); //Número de identificação do processo
            procCount++;
		}
		in.close();

	}
	
	public void ordenaOrdemChegada() {
		for(int i=0; i<processos.length;i++) {
			procPorTempoDeChegada.add(processos[i].getTempoDeChegada());
			Collections.sort(procPorTempoDeChegada);
		}
	}
	
	public LinkedList<Integer> getListaOrdenada(){return procPorTempoDeChegada;}

}
