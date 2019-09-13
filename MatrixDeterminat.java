    
    public static int determinant(int[][] matrix) {
        int determinante = 0;
        
        int dimension = matrix.length;
        int columna;
        int mult_diag_der;
        int mult_diag_izq;
        
        switch(dimension){
        case 1:
            determinante = matrix[0][0]; break;
        case 2:
            determinante = matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0]; break;
        default:
            for(int diagonal = 0; diagonal < dimension; diagonal++){
              mult_diag_der = matrix[0][diagonal];
              mult_diag_izq = matrix[0][dimension -1 - diagonal];
              columna = (diagonal+1) % dimension;
              
              for(int fila = 1; fila < dimension; fila++){
               //(((fila + diagonal) % dimension)+dimension)%dimension;//Para escoger la solución positiva del modulo de un núemro negativo
                mult_diag_der *= matrix[fila][columna];
                mult_diag_izq *= matrix[fila][dimension -1 -columna];  
                columna = (columna+1) % dimension;
              }
              determinante += (mult_diag_der - mult_diag_izq);
            }
            break;
        }
        return determinante;
    }
}