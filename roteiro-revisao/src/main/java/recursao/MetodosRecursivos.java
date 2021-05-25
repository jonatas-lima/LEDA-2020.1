package recursao;

public class MetodosRecursivos {

	public int calcularSomaArray(int[] array){
		return calcularSomaArrayRecursive(array, 0);
	}
	
	private int calcularSomaArrayRecursive(int[] array, int index) {
		int soma = 0;
		if (index == array.length - 1)
			return array[index];
		soma += array[index] + calcularSomaArrayRecursive(array, index + 1);
		return soma;
	}
	
	public long calcularFatorial(int n) {
		if (n == 0 || n == 1)
			return 1;
		
		return n * calcularFatorial(n - 1);
	}

	public int calcularFibonacci(int n) {
		if (n <= 2)
			return 1;
		
		return calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
	}

	public int countNotNull(Object[] array) {
		return countNotNullRecursive(array, 0);
	}
	
	private int countNotNullRecursive(Object[] array, int index) {
		int countNotNull = 0;
		if (index == array.length - 1) {
			if (array[index] != null) {
				return 1;
			}
		} else {
			if (array[index] != null)
				countNotNull = 1;
			countNotNull += countNotNullRecursive(array, index + 1);
		}
		return countNotNull;
	}

	public long potenciaDe2(int expoente) {
		if (expoente == 0)
			return 1;

		return 2 * potenciaDe2(expoente - 1);
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		if (n == 1)
			return termoInicial;
		
		return razao + progressaoAritmetica(termoInicial, razao, n - 1);
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		if (n == 1)
			return termoInicial;
		
		return razao * progressaoGeometrica(termoInicial, razao, n - 1);
	}
	
	
}
