package listaSingular;

public class ListaCircular extends Lista
{
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

	//Feito por mim, daniel
	public void insereInicio(int novo)
	{
		if (prim == null)
		{
			prim = new Elo(novo);
			prim.prox = prim;
		}
		else
		{
			Elo p = prim;
			Elo ult;
			for (ult = prim; ult.prox != prim; ult = ult.prox);
			prim = new Elo(novo);
			prim.prox = p;
			ult.prox = prim;
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