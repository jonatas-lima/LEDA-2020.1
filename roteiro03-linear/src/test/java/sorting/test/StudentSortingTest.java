package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.linearSorting.CountingSort;
import sorting.linearSorting.ExtendedCountingSort;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
	private Integer[] vetorNegativosTamPar;
	private Integer[] vetorNegativosTamImpar;
	private Integer[] vetorNegativosIguais;
	private Integer[] vetorNegativosRepetidos;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		populaVetorTamParNegativos(new Integer[] { 30, -28, 7, 29, 11, -26, 4, 22, -23,
				31 });
		populaVetorTamImparNegativos(new Integer[] { 6, -41, 32, 7, -26, 4, -37, 49,
				11, 18, 36 });
		populaVetorRepetidosNegativos(new Integer[] { -4, 9, 3, -4, 0, 5, 1, -4 });
		populaVetorIguaisNegativos(new Integer[] { -6, -6, -6, -6, -6, -6 });

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		// TODO O aluno deve instanciar sua implementação abaixo ao invés de
		// null
		this.implementation = new ExtendedCountingSort();
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamParNegativos(Integer[] arrayPadrao) {
		this.vetorNegativosTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamImparNegativos(Integer[] arrayPadrao) {
		this.vetorNegativosTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetidosNegativos(Integer[] arrayPadrao) {
		this.vetorNegativosRepetidos = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorIguaisNegativos(Integer[] arrayPadrao) {
		this.vetorNegativosIguais = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if (array.length > 0) {
			copy1 = Arrays.copyOf(array, array.length);
		}

		System.out.println("original array: " + Arrays.toString(array));

		implementation.sort(array);
		Arrays.sort(copy1);

		System.out.println("sorted (implementation) array: " + Arrays.toString(array));
		System.out.println("sorted (Arrays.sort) array: " + Arrays.toString(copy1));

		System.out.println("--------");
		Assert.assertArrayEquals(copy1, array);
	}

	public void genericTest(Integer[] array, int leftIndex, int rightIndex) {
		Integer[] copy1 = {};
		if (array.length > 0) {
			copy1 = Arrays.copyOfRange(array, leftIndex, rightIndex + 1);
		}

		System.out.println("original array: " + Arrays.toString(array));

		implementation.sort(array, leftIndex, rightIndex);

		Integer[] slicedArray = {};
		if (array.length > 0) {
			slicedArray = Arrays.copyOfRange(array, leftIndex, rightIndex + 1);
		}

		Arrays.sort(copy1);

		System.out.println("sorted (implementation) array: " + Arrays.toString(slicedArray));
		System.out.println("sorted (Arrays.sort) array: " + Arrays.toString(copy1));

		System.out.println("--------");
		Assert.assertArrayEquals(slicedArray, copy1);
	}


	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */

	@Test
	public void testSort06() {
		genericTest(vetorNegativosTamPar);
	}

	@Test
	public void testSort07() {
		genericTest(vetorNegativosTamImpar);
	}

	@Test
	public void testSort08() {
		genericTest(vetorNegativosRepetidos);
	}

	@Test
	public void testSort09() {
		genericTest(vetorNegativosIguais);
	}

	@Test
	public void testPartialSort01() {
		System.out.println("partial 01");
		genericTest(vetorTamPar, 0, 5);
	}

	@Test
	public void testPartialSort02() {
		System.out.println("partial 02");
		genericTest(vetorTamImpar, 0, 5);
	}

	@Test
	public void testPartialSort03() {
		System.out.println("partial 03");
		genericTest(vetorValoresIguais, 0, 5);
	}

	@Test
	public void testPartialSort04() {
		System.out.println("partial 04");
		genericTest(vetorVazio, 0, 5);
	}

	@Test
	public void testPartialSort05() {
		System.out.println("partial 05");
		genericTest(vetorValoresRepetidos, 0, 5);
	}

	@Test
	public void testPartialSort06() {
		System.out.println("partial 06");
		genericTest(vetorTamImpar, 0, 0);
	}

	@Test
	public void testPartialSort07() {
		System.out.println("partial 07");
		genericTest(vetorTamImpar, 10, 10);
	}

	@Test
	public void testPartialSort08() {
		System.out.println("partial 08");
		genericTest(vetorValoresRepetidos, 7, 7);
	}

	@Test
	public void testPartialSort09() {
		System.out.println("partial 09");
		genericTest(vetorValoresRepetidos, 0, 0);
	}

	@Test
	public void testPartialSort10() {
		System.out.println("partial 10");
		genericTest(vetorTamPar, 7, 7);
	}

	@Test
	public void testPartialSort11() {
		System.out.println("partial 11");
		genericTest(vetorTamPar, 0, 0);
	}

	@Test
	public void testPartialSort12() {
		System.out.println("partial 12");
		genericTest(vetorVazio, 7, 7);
	}

	@Test
	public void testPartialSort13() {
		System.out.println("partial 13");
		genericTest(vetorVazio, 0, 0);
	}

	@Test
	public void testPartialSort14() {
		System.out.println("partial 14");
		genericTest(vetorVazio, 7, 7);
	}

	@Test
	public void testPartialSort15() {
		System.out.println("partial 15");
		genericTest(vetorValoresIguais, 0, 0);
	}

	@Test
	public void testPartialSort16() {
		System.out.println("partial 16");
		genericTest(vetorValoresIguais, 5, 5);
	}

	@Test
	public void testPartialSort17() {
		System.out.println("partial 17");
		genericTest(vetorTamPar, 4, 8);
	}

	@Test
	public void testPartialSort18() {
		System.out.println("partial 18");
		genericTest(vetorTamImpar, 4, 10);
	}

	@Test
	public void testPartialSort19() {
		System.out.println("partial 19");
		genericTest(vetorValoresRepetidos, 2, 6);
	}

	@Test
	public void testPartialSort20() {
		System.out.println("partial 20");
		genericTest(vetorValoresIguais, 1, 5);
	}

	@Test
	public void testPartialSort21() {
		System.out.println("partial 21");
		genericTest(vetorNegativosIguais, 1, 5);
	}

	@Test
	public void testPartialSort22() {
		System.out.println("partial 22");
		genericTest(vetorNegativosTamImpar, 0, 5);
	}

	@Test
	public void testPartialSort23() {
		System.out.println("partial 23");
		genericTest(vetorNegativosTamPar, 5, 9);
	}

	@Test
	public void testPartialSort24() {
		System.out.println("partial 24");
		genericTest(vetorNegativosRepetidos, 1, 3);
	}

	@Test
	public void testPartialSort25() {
		System.out.println("partial 25");
		genericTest(vetorNegativosTamPar, 9, 9);
	}

	@Test
	public void testPartialSort26() {
		System.out.println("partial 26");
		genericTest(vetorNegativosTamPar, 0, 0);
	}
}