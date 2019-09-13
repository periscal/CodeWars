package CodeWars;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static List<String> singlePermutations(String s) {
		List<String> permutaciones = new ArrayList<>();
		List<Character> lista = new ArrayList<Character>();
		
		for(Character c : s.toCharArray()) lista.add(c);
		
		arbolPermutacion( lista,"",permutaciones);
		
		List<String> l =  List.copyOf(permutaciones);
		for(String per : l) if(per.length()!=s.length()) l.remove(per);
		return l;
	}

	public static void arbolPermutacion(List<Character> lista, String p, List<String> permutaciones) {

		// Al final del metodo comprueba el tamaño del array pasado por parametro, 
		// si solo tenia 1 elemento, entonces se ha llegado a un nodo hijo del arbol,
		// si no el metodo se ejecuta recursivamente
		for(Character c : lista) {

			String pCopia = p + c;
			
			if(lista.size()>1) {
				List<Character> lcopia = new ArrayList<Character>(lista);
				lcopia.remove(c);
				arbolPermutacion(lcopia,pCopia,permutaciones);
				
			}else {
				if(!permutaciones.contains(pCopia)) permutaciones.add(pCopia);
			}
		}
	}
}
