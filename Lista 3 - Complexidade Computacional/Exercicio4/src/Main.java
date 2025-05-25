import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Pilha pilha = new Pilha(10);
		pilha.push(2);
		pilha.push(2);
		System.out.println(pilha.getQtdNumerosPares());
		pilha.pop();
		System.out.println(pilha.getQtdNumerosPares());
		pilha.pop();
		System.out.println(pilha.getQtdNumerosPares());
		pilha.pop();
		System.out.println(pilha.getQtdNumerosPares());
		pilha.push(4);
		pilha.push(1);
		pilha.push(5);
		pilha.push(4);
		pilha.push(4);
		pilha.push(1);
		pilha.push(4);
		pilha.push(3);
		pilha.push(4);
		System.out.println(pilha.getQtdNumerosPares());
	}
}
