package Exercicio1;

import filaCircularDupla.TesteFilaDupla;

public class SistemaOperacional {

    private final TesteFilaDupla processos;

    public SistemaOperacional(int qtdProcessosSimultaneos) {
        this.processos = new TesteFilaDupla(qtdProcessosSimultaneos);
    }

    public boolean incluirProcesso(Processo processo) {
        if (processos.cheia()) return false;

        processos.insere(processo.getNumeroIdentificador());
        return true;
    }

    public boolean retirarProcessoComMaiorTempoDeEspera() {
        if (processos.vazia()) return false;

        processos.removeFim();
        return true;
    }

    public boolean imprimirProcessos() {
        if (processos.vazia()) return false;

        processos.imprime();
        return true;
    }
}
