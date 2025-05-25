package Exercicio2;

public class ListaCircular extends Lista
{

	public ListaCircular merge(ListaCircular lista2) {
	/*
		Complexidade alcançada: O(N^2). Chamo N vezes a função
		insere() em cada loop, que também são O(N). Logo, O(N^2).
	 */

		ListaCircular listaResultante = new ListaCircular();
		Elo p1 = prim, p2 = lista2.prim;

		//Inserir alternadamente
		do {
			listaResultante.insere(p1.dado);
			listaResultante.insere(p2.dado);
			p1 = p1.prox;
			p2 = p2.prox;
		} while (p1 != prim && p2 != lista2.prim);

		//Se uma lista for maior que a outra, uma essas duas condições será verdadeira
		if (p1 != prim) {
			do {
				listaResultante.insere(p1.dado);
				p1 = p1.prox;
			} while (p1 != prim);
		} else if (p2 != lista2.prim) {
			do {
				listaResultante.insere(p2.dado);
				p2 = p2.prox;
			} while (p2 != p2.prox);
		}

		for (Elo p = prim; p.prox != null; p = p.prox) listaResultante.insere(p.dado);

		return listaResultante;
	}

	/* Insere elemento no fim da lista. */
	public void insere(int novo)
	{
		Elo p, q;
		q = new Elo(novo);
		p = prim;

		if (p != null)
		{
			/* Percorre até alcancar o início. */
			while (p.prox != prim)
			{
				p = p.prox;
			}

			p.prox = q;
			q.prox = prim;
		}
		else
		{
			prim = q;
			prim.prox = q;     
		}
	}
}