package practica;
public class Ordenacion {
	
	
	
		public static void main(String[] args) {
			
			int numeros [] = {1,112,3,4,223,5,13,234,542,324,141,5,43,1,32,654,1132,5654,2134,7689,46767,3453,8,5,0};
			int aux;
			
			for (int i = 0; i < numeros.length; i++) {
				for (int j = 0; j < numeros.length; j++) {
					if (numeros[j] > numeros[i]) {
						aux = numeros[i];
						numeros[i] = numeros[j];
						numeros[j] = aux;
					}
				}
				
			}
			
			for (int i = 0; i < numeros.length; i++) {
				System.out.println(numeros[i]);
			}
		}

}
