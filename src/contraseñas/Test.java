package contraseñas;

import java.io.File;
import java.io.FileNotFoundException;

public class Test
{

	public static void main(String[] args) throws FileNotFoundException
	{
		String path = ".//data.in";
		
		ProcesadorDeClaves procesador = new ProcesadorDeClaves(new File(path));
		procesador.ProcesarClaves();
		procesador.RecuperarClaves();
	}

}
