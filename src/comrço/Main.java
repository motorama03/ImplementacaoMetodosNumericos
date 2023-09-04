package comrço;

public class Main {

	public static void main(String[] args) {
		
		int[] tamanhosEntrada = {1000000};
		
		// Executa algoritmo para cada tamanho de entrada
		for(int tamanho : tamanhosEntrada) {
			AlgoritmoMatrixial MetodoDeGaus = new AlgoritmoMatrixial(); 
			
			// Marca o tempo de início
			long inicio = System.nanoTime();
			
			// Chama o algoritmo a ser testado
			MetodoDeGaus.chama();
			
			// Marca o tempo de fim
			long fim = System.nanoTime();
			
			// Calcula o tempo de execução em milissegundos
			double tempoExecucao = (fim - inicio)/1000000.0;
			
			System.out.println("\nTempo de execução para tamanho "+ tamanho +" : "+ tempoExecucao+" ms");
		}
	}

}
