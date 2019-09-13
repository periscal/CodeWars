package CodeWars;
public class Positive{

	/** ======= SUM OF POSITIVE =============
	 * You get an array of numbers, return the sum of all of the positives ones.
		Example [1,-4,7,12] => 1 + 7 + 12 = 20
		Note: if there is nothing to sum, the sum is default to 0.
	 * @param arr
	 * @return
	 */
	
	public static int sum(int[] arr){
		int suma = 0;
		for(int i= 0; i<arr.length; i++) suma += arr[i]>=0? arr[i] : 0;
		return suma;
	}

}
