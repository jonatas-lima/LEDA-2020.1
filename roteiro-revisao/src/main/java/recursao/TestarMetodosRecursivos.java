package recursao;

public class TestarMetodosRecursivos {
	public static void main(String[] args) {
		// preencha esse metodo com codigo para testar a classe MetodosRecursivos.
		MetodosRecursivos m = new MetodosRecursivos();
		
		long fatorial = m.calcularFatorial(5); // 120
		System.out.println(fatorial);
		
		int somaArray = m.calcularSomaArray(new int[] {1, 1, 1, 1, 1}); // 5
		System.out.println(somaArray);
		
		System.out.println("=== fib ===");
		long fib = m.calcularFibonacci(7);
		System.out.println(fib);
		System.out.println("----");
		
		long potencia2 = m.potenciaDe2(0); // 1
		System.out.println(potencia2);
		System.out.println(m.potenciaDe2(2));
		System.out.println(m.potenciaDe2(5));
		
		double pa = m.progressaoAritmetica(1, 10, 5);
		System.out.println(pa);
		
		double pg = m.progressaoGeometrica(2, 2, 5);
		System.out.println(pg);
	}
}
