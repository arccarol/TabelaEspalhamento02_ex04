package controller;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class TabelaEspalhamento {
    private List<List<Departamento>> tabela;
    private int tamanho;
    
 
    public TabelaEspalhamento(int tamanho) {
        this.tamanho = tamanho;
        tabela = new ArrayList<>(tamanho);
        for (int i = 0; i < tamanho; i++) {
            tabela.add(new LinkedList<>());
        }
    }
    
    private int hash(int andar) {
        return andar % tamanho;
    }
    
    public void inserir(Departamento departamento) {
        int indice = hash(departamento.getAndar());
        tabela.get(indice).add(departamento);
    }
    

    public Departamento consultar(int andar) {
        int indice = hash(andar);
        List<Departamento> listaDepartamentos = tabela.get(indice);
        for (Departamento departamento : listaDepartamentos) {
            if (departamento.getAndar() == andar) {
                return departamento;
            }
        }
        return null; 
    }
    
    
    public boolean remover(int andar) {
        int indice = hash(andar);
        List<Departamento> listaDepartamentos = tabela.get(indice);
        for (Departamento departamento : listaDepartamentos) {
            if (departamento.getAndar() == andar) {
                listaDepartamentos.remove(departamento);
                return true; 
            }
        }
        return false; 
    }
}
