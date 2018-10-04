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
	

	private int fatiaDeTempo, nextArrival, execTime, recursionQuit, IOExecutionTime, restrict; // Dados.
																								// recursionQuit
																								// e
	
	private LinkedList<Integer> procPorTempoDeChegada; // Lista de TODOS os
														// tempos de chegada
														// ordenados
	private LinkedList<String> printProcess, printIO; // Gráficos para serem
														// impressos no final
	private LinkedList<Processo> availableProcess, roundRobinEffect; // Listas
																		// auxiliares
																		// que
																		// analisam
																		// processos
																		// que
																		// podem
																		// ser
																		// executados/rodiziados
	private Processo currentProcess, IOProcess; // Objetos de auxílio que
												// servem como ponteiros que
												// apontam para um
												// processo

	public Escalonador() {

	}

	// le arquivo e cria a lista de processos a serem executados
	public void readFile() throws FileNotFoundException, IOException {

		Scanner s = new Scanner(System.in);
		System.out.println("Digite o nome do arquivo de entrada (sem extenscao .txt)");
		String enter = s.nextLine();
		System.out.println();
		System.out.println("====================================================================================");
		BufferedReader in = new BufferedReader(new FileReader(enter + ".txt"));
		String line;
		int procCount = 0;

		line = in.readLine();
		processos = new Processo[Integer.parseInt(line)];

		line = in.readLine();
		fatiaDeTempo = Integer.parseInt(line);

		while ((line = in.readLine()) != null) {
			String aux[] = line.split(" ");
			processos[procCount] = new Processo(fatiaDeTempo, Integer.parseInt(aux[0]), Integer.parseInt(aux[1]),
					Integer.parseInt(aux[2])); // Cria o processo

			
			processos[procCount].setId(procCount + 1); // id do processo
			procCount++;
		}
		in.close();

	}

	// ordena a lista de processos por tempo de chegada
	public void ordenaOrdemChegada() {
		for (int i = 0; i < processos.length; i++) {
			procPorTempoDeChegada.add(processos[i].getTempoDeChegada());
			Collections.sort(procPorTempoDeChegada);
		}
	}

	// retorna a lista de processos ordenando por tempo de chegada
	public LinkedList<Integer> getListaOrdenada() {
		return procPorTempoDeChegada;
	}

	public void executa(Processo[] processos){
		
	}
	
	public Processo[] getProcessos() {
		return processos;
	}
	
	
	

}

