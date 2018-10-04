import java.io.IOException;

public class Main {

    public static void main(String[] args)throws IOException {

    	Processo[] listaProcessos = null;
    	
    	
       
        Escalonador esc = new Escalonador();
        esc.readFile();
        //esc.ordenaOrdemChegada();
        esc.getListaOrdenada();
        
        listaProcessos = esc.getProcessos();
        imprimeVetor(listaProcessos);

       
    }
    
  
    
  //Recebe a lista de processos populada e lê seus valores
  	public static void imprimeVetor(Processo[] listaProcessos) {
  		System.out.print("Processo:\t");
  		for(int i = 1; i <= listaProcessos.length; i++){
  			System.out.print("P"+ i +"\t");
  		}
  		
  		System.out.print("\nChegada:\t");
  		for(int i = 0; i < listaProcessos.length; i++){
  			System.out.print("["+listaProcessos[i].getTempoDeChegada()+"]\t");
  		}
  		
  		System.out.print("\nExecução:\t");
  		for(int i = 0; i < listaProcessos.length; i++){
  			System.out.print("["+listaProcessos[i].getTempoDeExecucao()+"]\t");
  		}
  		
  		System.out.print("\nPrioridade:\t");
  		for(int i = 0; i < listaProcessos.length; i++){
  			System.out.print("["+listaProcessos[i].getPrioridade()+"]\t");
  		}
  	}
}
