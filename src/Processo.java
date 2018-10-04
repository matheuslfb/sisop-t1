import java.util.LinkedList;
import java.util.Collections;

/**
 *
 * @author Matheus Lima Ferreira 122019482
 * @author Geovane Paz
 */
 
 // Esta classe representa um processo de todos os de entrada. Todos os seus dados estão guardados aqui
public class Processo {

    private String id; //Identificação do processo
    private int tempoDeChegada, tempoDeExecucao, prioridade, fatiaDeTempo, executedTime; 

    // Construtor
    public Processo(int fatiaDeTempo, int tempoDeChegada, int tempoDeExecucao, int prioridade){
    	this.fatiaDeTempo = fatiaDeTempo;
    	this.tempoDeChegada = tempoDeChegada;
    	this.tempoDeExecucao = tempoDeExecucao;
    	this.prioridade = prioridade;
        executedTime = 0;
    	IOTimeList = new LinkedList<>();
    }
    
    //Métodos GET e SET (se necessário) de Id
    
    public String getId(){
        return id;
    }
    
    public void setId(int n){
        id = String.valueOf(n);
    }
    
    //Métodos GET e SET (se necessário) de arrivalTime
    
    public int getTempoDeChegada(){
        return tempoDeChegada;
    }
    
    //Métodos GET e SET (se necessário) de executionTime
    
    public int getTempoDeExecucao(){
        return tempoDeExecucao;
    }
    
    //Métodos GET e SET (se necessário) de priority
    
    public int getPrioridade(){
        return prioridade;
    }
    
    //Método GET de executionTime e chamada para quando um segundo deste processo é executado
    
    public void executeSecond(){
        executedTime++;
    }
    
    public int getExecutedTime(){
        return executedTime;
    }
    
    //Chamada e criação da lista de IO (nota-se que ele ordena caso sejam inseridos fora de ordem no arquivo de entrada)
    
    public void insertIOTime(int n){
    	IOTimeList.add(n);
        Collections.sort(IOTimeList);
    }
    
    public LinkedList<Integer> getIOTimeList(){
        return IOTimeList;
    }
    
    //Este método evita duplicatas na lista de IO
    
    public boolean IORepetition(){
        for(int i = 0; i < IOTimeList.size()-1; i++){
            if(IOTimeList.get(i) == IOTimeList.get(i+1)) return true;
        }
        return false;
    }
   
}
