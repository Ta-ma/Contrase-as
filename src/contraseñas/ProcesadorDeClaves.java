package contraseñas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ProcesadorDeClaves
{
	String cadena;
	String[] claves;
	
	public ProcesadorDeClaves (File archivo) throws FileNotFoundException
	{
		Scanner sc = new Scanner(archivo);
		cadena = sc.nextLine();
		sc.close();
	}
	
	public void ProcesarClaves ()
	{
		int tam = cadena.length();
		claves = new String[(tam / 6)]; // siempre va a ser divisible por 6 (a menos que sea un archivo trucho)
		
		for (int i = 0; i < claves.length; i++)
			claves[i] = "";
		
		int j = 0;
		
		for (int i = 0; i < tam; i++)
		{
			if ((i & 1) == 0) 	// par
				claves[j] += cadena.charAt(tam - 1 - (i / 2));
			else 				// impar
				claves[j] += cadena.charAt(i / 2);
			
			if ((i + 1) % 6 == 0)
				j++;
		}
		
		// Un mejor algoritmo a lo mejor me ahorraba estos pasos de mierda
		
		for (int i = 0; i < claves.length; i++)
			claves[i] = new StringBuilder(claves[i]).reverse().toString();
		
		Collections.reverse(Arrays.asList(claves));
	}
	
	public void RecuperarClaves ()
	{
		System.out.println(claves.length);
		for (int i = 0; i < claves.length; i++)
			System.out.println(claves[i]);
	}
}
