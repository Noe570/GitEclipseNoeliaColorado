package ies;

/**
 * Metodos necesarios para la realizacion de la aplicacion
 *
 */

public class UtilidadesArrays {

	/**
	 * Metodo para rellenar un array aleatoriamente 
	 */
	public static int[] rellenarArray(int listaGrande[], int desde, int hasta) {
	
		for(int i = 0; i < listaGrande.length;i++) {
			listaGrande[i] = (int)(Math.random()*desde)+hasta;
		}
		return listaGrande;
	}
	
	/**
	 * Metodo para imprimir un Array
	 */
	public static void imprimirArray(int listaGrande[]) {
		
		for(int i = 0; i < listaGrande.length;i++) {
			System.out.println("El numero es:" +listaGrande[i]);
		}
		
	}
	
	/**
	 * Metodo para ordenar un Array por el Metodo Burbuja
	 */
	
	public static void ordenarBurbujaArray(int lista[]) {
		boolean ordenado = false;
		 
			while(ordenado == false) {
				ordenado = true;
				for(int i=0; i<lista.length-1;i++) {
					if(lista[i]>lista[i+1]) {
						int aux=lista[i];
						lista[i]=lista[i+1];
						lista[i+1]=aux;
						ordenado = false;
					}
				}
			}
		
	}
	/**
	 * Metodo para ordenar un Array por el metodo QuickSort
	 */
	public static void ordenarQuicksortArray(int lista[],int izq,int der) {
		int i = izq;
		int j =der;
		int pivote = lista[(izq+der)/2];
		
			do {
				while(lista[i]<pivote) {
					i++;
				}
				while(lista[j]>pivote) {
					j--;
				}
				
				if(i<=j) {
					int aux = lista[i];
					lista[i] = lista[j];
					lista[j] = aux;
					i++;
					j--;
				}
			}while(i<=j);
			
			if(izq < j) {
				ordenarQuicksortArray(lista,izq,j);
			}
			if(i < der) {
				ordenarQuicksortArray(lista, i, der);
			}
	}
	/**
	 * Metodo para buscar la posicion de un valor en un array por busqueda secuencial
	 */
	public static int buscarSecArray(int lista[], int valor) {
		int posicion = -1;
		boolean encontrado = false;
		
		for(int pos=0;pos<lista.length && !encontrado;pos++) {
			if (lista[pos] == valor) {
				encontrado = true;
				posicion = pos;
			}
		}
		
		return posicion;
	}
	
	/**
	 * Metodo para buscar la posicion de un valor en un array por busqueda binaria
	 */
	public static int buscarBinRecArrays( int lista[], int valor, int izq, int der) {
        int cen = 0;
        int pos = -1;

        if(izq > der) {
            return pos;
        }

        cen = (int)((izq+der)/2);
        if(lista[cen]== valor) {
            pos = cen;
        }
        else {
            if (lista[cen]<valor) {
                pos = buscarBinRecArrays(lista, valor, cen+1, der);
            }
            else {
                pos = buscarBinRecArrays(lista,valor, izq, cen-1);
            }
        }

        return pos;

   }
		
	
}
