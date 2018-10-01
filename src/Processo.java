import java.util.LinkedList;
import java.util.Collections;

/**
 *
 * @author Gabriel Franzoni 15105090
 */
 
 // Esta classe representa um processo de todos os de entrada. Todos os seus dados estão guardados aqui
public class Processo {

    private String id; //Identificação do processo
    private int tempoDeChegada, tempoDeExecucao, prioridade, fatiaDeTempo, executedTime; //Dados de entrada. sliceTime é a partição e executedTime é quantos segundos o mesmo executou.
    private boolean roundRobin = true; //Este boolean serve para permitir rodízio entre processo de mesma prioridade
    private LinkedList<Integer> IOTimeList; //Lista de processos de Entrada/Saída (caso ele possua)

    // Construtor
    public Processo(int sliceTime, int arrivalTime, int executionTime, int priority){
    	this.fatiaDeTempo = sliceTime;
    	this.tempoDeChegada = arrivalTime;
    	this.tempoDeExecucao = executionTime;
    	this.prioridade = priority;
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
    
    public int getPriority(){
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
    
    //Métodos essenciais para execução do Round Robin para que o rodízio seja feito efetivamente
    
    public void fillSlice(int n){
        fatiaDeTempo = n;
        setRR();
    }
    
    public void reduceSlice(){
        fatiaDeTempo--;
    }
    
    public int getSlice(){
        return fatiaDeTempo;
    }
    
    private void setRR(){
        roundRobin = false;
    }
    
    public void desetRR(){
        roundRobin = true;
    }
    
    public boolean getRR(){
        return roundRobin;
    }
}
