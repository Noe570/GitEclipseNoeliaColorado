package ies;

//import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Aplicacion para realizar las pruebas necesarias para que no haya errores
 *
 */
public class JUnitTestUtilArraysApp {

	/**
	 * Declaracion de los atributos necesarios
	 */
	private final static int lista[] = {6, 8, 22, 56, 95, 33, 62, 45, 11, 29};
	
	private static int listaGrande[];
	
	private static final int NUM_ELEMS = 20;
	
	/**
	 * Metodo para crear un array aleatoriamente
	 * Se ejecuta antes de realizar las pruebas 
	 */
	@BeforeClass
	public static void crearLista() {
		listaGrande = new int [NUM_ELEMS];
		
		UtilidadesArrays.rellenarArray(listaGrande, 9999, 1);
		System.out.println("***Contenido del Array***");
		UtilidadesArrays.imprimirArray(listaGrande);
		
	}
	
	/**
	 * Test para comprobar la ordenacion mediante BubbleSort
	 */
	@Test (timeout=1000)
	public void testOrdenarBurbujaArray() {
		//Copias de la lista original
		int listaOrdenadaConSort[] = Arrays.copyOf(listaGrande, listaGrande.length);
		int listaOrdenadaConOrdenarBurbuja[] = Arrays.copyOf(listaGrande, listaGrande.length);
		
		//La primera la vamos a ordenar con el metodo Sort 
		Arrays.sort(listaOrdenadaConSort);
		
		//La segunda la ordenamos con el metodo burbuja
		UtilidadesArrays.ordenarBurbujaArray(listaOrdenadaConOrdenarBurbuja);
		
		//Comprobamos si las dos listas son iguales
		Assert.assertArrayEquals(listaOrdenadaConSort, listaOrdenadaConOrdenarBurbuja);
	}
	
	/**
	 * Test para comprobar la ordenacion mediante QuickSort
	 */
	@Test
	public void testOrdenarQuicksortArray() {
		//Copias de la lista original
		int listaOrdenadaConSort[] = Arrays.copyOf(listaGrande, listaGrande.length);
		int listaOrdenadaConQuickSort[] = Arrays.copyOf(listaGrande, listaGrande.length);
		int izq = 0;
		int der = listaOrdenadaConQuickSort.length-1; 
		
		
		//La primera la vamos a ordenar con el metodo Sort 
		Arrays.sort(listaOrdenadaConSort);
		
		//La segunda la vamos a ordenar con el metodo Quicksort
		UtilidadesArrays.ordenarQuicksortArray(listaOrdenadaConQuickSort,izq,der);
		
		//Comprobamos si las dos listas son iguales
		Assert.assertArrayEquals(listaOrdenadaConSort, listaOrdenadaConQuickSort);
		
	}
	
	/**
	 * Test de la busqueda secuencial de un valor en un array 
	 */
	@Test
	public void testBuscarSecArray() {
	int posObtenida = UtilidadesArrays.buscarSecArray(lista, 8);
	Assert.assertEquals(1, posObtenida);
	}
	
	/**
	 * Test de la busqueda binaria de un valor en un array
	 */
	@Test
	public void testBuscarBinArray() {
		//Copia de la lista original 
		int listaBuscarBin[] = Arrays.copyOf(lista, lista.length);
		
		//Ordenamos la lista
		Arrays.sort(listaBuscarBin);
		
		//Declaramos la izquierda y la derecha del array
		int izq = 0;
		int der = listaBuscarBin.length-1;
		
		//Primer elemento del Array 
		int posObtenida = UtilidadesArrays.buscarBinRecArrays(listaBuscarBin, 6, izq, der);
		Assert.assertEquals(0, posObtenida);
		
		//Ultimo elemento del Array 
		posObtenida = UtilidadesArrays.buscarBinRecArrays(listaBuscarBin, 95, izq, der);
		Assert.assertEquals(listaBuscarBin.length-1, posObtenida);
		
		//Elemento que no se encuentra en el Array
		posObtenida = UtilidadesArrays.buscarBinRecArrays(listaBuscarBin, 112, izq, der);
		Assert.assertEquals(-1, posObtenida);
		
	}
}
 	
