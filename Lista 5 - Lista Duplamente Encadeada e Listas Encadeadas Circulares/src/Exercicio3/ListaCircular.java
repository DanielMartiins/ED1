package Exercicio3;

public class ListaCircular extends Lista
{
	/*
	Complexidade alcan�ada: O(N).
	Insiro no inicio da lista encadeada em O(1) N vezes.
	Chamo a fun��o insere() apenas uma vez fora do loop, e nesse caso vai executar em O(1) por estar vazia
	A lista resultante j� estar� invertida porque eu inseri no inicio da lista de forma manual, sem
	usar o m�todo insere() dentro do loop que por sua vez insere no final
	 */
	public ListaCircular inverteLista() {

		if (this.vazia()) return this;
		ListaCircular listaInvertida = new ListaCircular();
		Elo p = prim;
		listaInvertida.insere(p.dado);
		for (p = p.prox; p != prim; p = p.prox) {
			Elo q = new Elo(p.dado);
			q.prox = listaInvertida.prim;
			listaInvertida.prim = q;
		}
		//Nesse momento, o ultimo elemento da lista invertida est� c�clico em s� pr�prio.
		//Por isso, o loop abaixo vai iterar at� que p.prox seja s� pr�prio, para consertar isso
		for (p = listaInvertida.prim; p.prox != p; p = p.prox);
		p.prox = listaInvertida.prim;

		return listaInvertida;
	}

	/* Imprime todos os elementos da lista */
	public void imprime()
	{
		Elo p;
		System.out.println("Elementos da lista");
		
		p = prim;
		
		if (p != null)
		{
			do
			{
				System.out.print(p.dado + " ");
				p = p.prox;

			} while (p != prim);
		}
		
		System.out.println();
	}
	
	public void imprimeRecursivo()
	{
		System.out.println("Elementos da lista:");
		
		if(this.vazia())
			return;
		
		imprimeRecursivo(prim);
		
		System.out.println();
	}
	
	private void imprimeRecursivo(Elo p)
	{
		System.out.print(p.dado + " ");
		
		if(p.prox == prim)
			return;
		
		imprimeRecursivo(p.prox);
	}

	/* Insere elemento no fim da lista. */
	public void insere(int novo)
	{
		Elo p, q;
		q = new Elo(novo);
		p = prim;

		if (p != null)
		{
			/* Percorre at� alcancar o in�cio. */
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
	
	/* Remove da lista o primeiro elemento com valor igual a �elem". Ret. true se removeu. */
	public boolean remove(int elem)
	{
		Elo p = null;
		Elo ant = null;

		if (prim == null) return false;

		for( p = prim; ( (p.prox != prim ) && (p.dado != elem) ); p = p.prox)
			ant = p;

		/* Achou */
		if ( p.dado == elem )
		{
			/* � o primeiro */     
			if ( p == prim )
			{
				/* � o �nico */
				if ( prim == prim.prox )
				{
					prim = null;  
				}
				else
				{
					/* Guarda o anterior ao primeiro */
					for( ant = prim; ( ant.prox != prim ); ant = ant.prox);
					
					ant.prox = prim.prox; 
					prim = prim.prox; 
				}     
			}   
			else
			{
				/* No meio */
				ant.prox = p.prox;     
			} 

			/* Remove a �ltima refer�ncia para o elo a ser removido. Dessa forma,
			 * o Garbage Collector ir� liberar essa mem�ria. */
			p = null;

			return true;    
		}
		else  
			return false;
	}
	
	/* Resolu��o da quest�o 3 da lista auxiliar de Lista Encadeada. */
	public Lista separa(int n)
	{
		Lista l2 = new Lista();
		
		Elo p = prim;
		
		/* Loop para encontrar o elo cujo atributo dado tenha valor "n". */
		do
		{
			/* Encontrou o elemento desejado. */
			if(p.dado == n)
				break;
			
			p = p.prox;
			
		} while (p != prim);
				
		/* Caso tenha percorrido a lista sem encontrar o elemento. */
		if(p.dado != n)
			return null;
		
		/* O "prim" da nova lista � o pr�ximo do elo apontado por p. */
		l2.prim = p.prox;
		
		/* O pr�ximo do elo apontado por p tem que apontar para o prim da
		 * lista original. */
		p.prox = prim;
		
		Elo q;
		
		/* Anda at� o �ltimo elemento da lista 2. */
		for(q = l2.prim; q.prox != prim; q = q.prox);
		
		/* O pr�ximo do �ltimo elemento da lista 2 aponta para o primeiro. */
		q.prox = l2.prim;

		/* Retorna a nova lista constru�da. */
		return l2;
	}
}