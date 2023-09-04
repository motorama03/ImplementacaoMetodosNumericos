package comrço;

public class AlgoritmoMatrixial {

    public void chama() {

        // Aqui é definida a matriz A e o vetor y
        double[][] A = {{1, 3, 2}, 
        				{3, 5, 4}, 
        				{2, 1, 1}};
        
        double[] y = {2, 4, -10}; // Resultado das equações ( = n )
        
        
        if(VerificaConvergencia(A)) {
        	System.out.println("O sistema é convergente");
        }else
        	System.out.println("O sistema informado poderá não convergir");

        int n = A.length;
        double[] x = new double[n];
        
        apresentaMatriz(A);
        
        // Troca linhas para que a diagonal principal contenha os maiores valores
        for (int k = 0; k < n; k++) {
            int linha_maior = k;

            // Encontrar a linha com o maior elemento na coluna k
            for (int i = k; i < n; i++) {
                if (Math.abs(A[i][k]) > Math.abs(A[linha_maior][k])) {
                    linha_maior = i;
                }
            }

            // Trocar as linhas
            double[] tempRow = A[k];
            A[k] = A[linha_maior];
            A[linha_maior] = tempRow;

            double tempB = y[k];
            y[k] = y[linha_maior];
            y[linha_maior] = tempB;

            for (int j = k + 1; j < n; j++) {
                double factor = A[j][k] / A[k][k];
                for (int z = k; z < n; z++) {
                    A[j][z] -= factor * A[k][z];
                }
                y[j] -= factor * y[k];
            }
        }
        
        // Mostra a matriz após as trocas de linhas
        apresentaMatriz(A);
        
        // Aplicar Retrossubstituição
        int limite = 0;
        for (int k = n - 1; k >= 0; k--) {
            double s = 0;
            for (int j = k + 1; j < n; j++) {
            	limite++;
            	if(limite >= 200) {
            		System.out.println("Limite de iterações atingido");
            		return;
            	}
                s = s + A[k][j] * x[j];
            }
            x[k] = (y[k] - s) / A[k][k];
        }

        mostraMatriz(n, x);

        return;
    }

    // Exibir os resultados
    public void mostraMatriz(int n, double[] x) {
        System.out.println("Soluções do sistema:");
        for (int i = 0; i < n; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
    
    // Mostra a matriz
    public void apresentaMatriz(double [][] A){
    	for(int x = 0; x < 3; x++) {
    		System.out.println();
    		for(int z = 0; z < 3; z++) {
    			System.out.print(A[x][z]+" ");
    		}
    	}
    }
    
 // Método para verificar se a matriz é diagonalmente dominante
    public boolean VerificaConvergencia(double[][] A) {
        int n = A.length;
        boolean convergente = true;

        for (int i = 0; i < n; i++) {
            double soma = 0.0;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    soma += Math.abs(A[i][j]);
                }
            }
            if (Math.abs(A[i][i]) <= soma) {
                convergente = false;
                break;
            }
        }
        return convergente;
    }
}
