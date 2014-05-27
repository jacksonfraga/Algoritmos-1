/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication24;

/**
 *
 * @author aluno
 */
public class JavaApplication24 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] valores = {6, 5, 3, 1, 8, 7, 2, 4, 12};

        String buf = Join(valores);
        System.out.println("Original: " + buf);
        
        System.out.println("Bubble Sort: " + Join(BubbleSort(valores)));
        //System.out.println("ESQ Sort: " + Join(Esqueda(valores)));
        //System.out.println("DIR Sort: " + Join(Direita(valores)));
        System.out.println("Merge Sort: " + Join(MergeSort(valores)));
        
       
    }

    public static String Join(int[] lista) {
        String buffer = "";

        for (int i = 0; i < lista.length; i++) {
            buffer = buffer + (i == 0 ? "" : ",") + lista[i];
        }
        return buffer;
    }

    public static int[] BubbleSort(int[] lista) {
        //int[] v = { 1, 3, 10, 9, 6, 3903, 323, 13, 333, 2323, 444, 0 };

        int[] A = lista.clone();

        boolean trocou;

        int n = Tamanho(A);

        do {
            trocou = false;
            for (int i = 1; i < n; i++) {

                if (A[i - 1] > A[i]) {
                    int aux = A[i - 1];
                    A[i - 1] = A[i];
                    A[i] = aux;
                    trocou = true;
                }
            }
            n--;
        } while (trocou);


        return A;
    }

    public static int Tamanho(int[] lista) {
        return lista.length;
    }

    public static int[] Esqueda(int[] a) {
        int[] esquerda = new int[a.length/2];
        for (int i = 0; i < esquerda.length; i++) {
            esquerda[i] = a[i];
        }
        return esquerda;
    }

    public static int[] Direita(int[] a) {
        int[] direita = new int[a.length-(a.length/2)];
        int inicioDireita = (int)a.length/2;
        
        for (int i = 0; i < direita.length; i++) {
            direita[i] = a[inicioDireita];
            inicioDireita++;
        }
        
        return direita;
    }

    public static int[] MergeSort(int[] lista) {
        if (lista.length <= 1) {
            return lista;
        }

        int[] metadeEsq = Esqueda(lista);
        int[] metadeDir = Direita(lista);

        metadeEsq = MergeSort(metadeEsq);
        metadeDir = MergeSort(metadeDir);

        return merge(metadeEsq, metadeDir);
    }

    private static int[] merge(int[] metadeEsq, int[] metadeDir) {

        int i1 = 0;
		int i2 = 0;
		int i = 0;
		int[] novo = new int[metadeEsq.length + metadeDir.length];

		while (i < (metadeEsq.length + metadeDir.length))
		{
			if (i2 >= metadeDir.length
					|| (i1 < metadeEsq.length 
							&& metadeEsq[i1] <= metadeDir[i2]))
			{
				novo[i] = metadeEsq[i1];
				i1++;
			}
			else
			{
				novo[i] = metadeDir[i2];
				i2++;
			}
			i++;
		}
		return novo;

    }
}
