package listaSingular;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		ListaOrdenada lista = new ListaOrdenada();
		TesteListaSingular teste = new TesteListaSingular();
		
		teste.valida(lista);
	}
}