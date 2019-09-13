import java.math.BigInteger;
import java.util.ArrayList;

public class JomoPipi{
    
    public static BigInteger pipi(int n) {
    
        ArrayList<BigInteger>  pipis = new ArrayList<BigInteger>();
        pipis.add(0, BigInteger.valueOf(0));
        
        BigInteger aux;
        
        for(int i=0; i<=n; i++){
          
          aux = BigInteger.valueOf(i);
          
          for(int j=0; j<i; j++){
          
            aux = aux.subtract(pipis.get(j)); 
            aux = aux.pow(2);
            
            }
            pipis.add(i,aux);
        }
        return pipis.get(n);
    }
}