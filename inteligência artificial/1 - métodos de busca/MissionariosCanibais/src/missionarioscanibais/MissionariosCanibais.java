/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package missionarioscanibais;

import busca.BuscaLargura;
import busca.Estado;
import busca.MostraStatusConsole;
import busca.Nodo;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MissionariosCanibais implements Estado {

    
    @Override
    public String getDescricao() {
        return " Problema dos Canibais e Missionários ";
    }
    
    //Random gerador = new Random();
    final int cE, cD, mE, mD;
    final char ladoBarco;
    
    final String op; // operacao que gerou o estado (ir esquerda ou direita)
    
    /** construtor para o estado, recebe cada valor de atributo */
    public MissionariosCanibais(String op, int cE, int mE, int cD, int mD, char ladoBarco) {    
        this.cE = cE;
        this.cD = cD;
        this.mE = mE;
        this.mD = mD;
        this.ladoBarco = ladoBarco;
        this.op = op;
    }

    /**
     * verifica se o estado é válido
     */
    public boolean ehValido() {
        if (mE > 0 && mE < cE)
            return false;
        if (mD > 0 && mD < cD) 
            return false;
        return true;
    }
    
    /**
     * verifica se o estado final foi atingido
     */
    @Override
    public boolean ehMeta() {
        return this.cE == 0 && this.mE == 0 && this.cD == 3 && this.mD == 3;
    }
    
    /**
     * Custo para geracao do estado
     */
    @Override
    public int custo() {
        return 1;
    }
    
    /**
     * gera uma lista de sucessores do nodo.
     * @return visitados
     */
    @Override
    public List<Estado> sucessores() {
        List<Estado> visitados = new LinkedList<Estado>(); // a lista de sucessores
        
        doisCanibais(visitados);
        doisMissionarios(visitados);
        umCanibal(visitados);
        umMissionario(visitados);
        canibalMissionario(visitados);
        
        return visitados;
    }
    
    private void doisCanibais(List<Estado> visitados){
        if(ladoBarco == 'e' && cE >= 2){
            MissionariosCanibais novo = new MissionariosCanibais("Levar 2 Canibais", cE - 2, mE, cD + 2, mD, 'd');
            if (!visitados.contains(novo) && novo.ehValido()) visitados.add(novo);
        } else if (ladoBarco == 'd' && cD >=2) {
            MissionariosCanibais novo = new MissionariosCanibais("Trazer 2 Canibais", cE + 2, mE, cD - 2, mD, 'e');
            if (!visitados.contains(novo) && novo.ehValido()) visitados.add(novo);
        }
    };
    
    private void doisMissionarios(List<Estado> visitados){
        if(ladoBarco == 'e' && mE >= 2){
            MissionariosCanibais novo = new MissionariosCanibais("Levar 2 Missionarios", cE, mE - 2, cD, mD + 2, 'd');
            if (!visitados.contains(novo) && novo.ehValido()) visitados.add(novo);
        } else if (ladoBarco == 'd' && mD >= 2) {
            MissionariosCanibais novo = new MissionariosCanibais("Trazer 2 Missionarios", cE, mE + 2, cD, mD - 2, 'e');
            if (!visitados.contains(novo) && novo.ehValido()) visitados.add(novo);
        }
    };
    
    private void umCanibal(List<Estado> visitados){
        if(ladoBarco == 'e' && cE >= 1){
            MissionariosCanibais novo = new MissionariosCanibais("Levar 1 Canibal", cE - 1, mE, cD + 1, mD, 'd');
            if (!visitados.contains(novo) && novo.ehValido()) visitados.add(novo);
        } else if (ladoBarco == 'd' && cD >= 1) {
            MissionariosCanibais novo = new MissionariosCanibais("Trazer 1 Canibal", cE + 1, mE, cD - 1, mD, 'e');
            if (!visitados.contains(novo) && novo.ehValido()) visitados.add(novo);
        }
    };
    
    private void umMissionario(List<Estado> visitados){
        if(ladoBarco == 'e' && mE >= 1){
            MissionariosCanibais novo = new MissionariosCanibais("Levar 1 Missionario", cE, mE - 1, cD, mD + 1, 'd');
            if (!visitados.contains(novo) && novo.ehValido()) visitados.add(novo);
        } else if (ladoBarco == 'd' && mD >= 1) {
            MissionariosCanibais novo = new MissionariosCanibais("Trazer 1 Missionario", cE, mE + 1, cD, mD - 1, 'e');
            if (!visitados.contains(novo) && novo.ehValido()) visitados.add(novo);
        }
    };
    
    private void canibalMissionario(List<Estado> visitados){
        if(ladoBarco == 'e' && cE >= 1 && mE >= 1){
            MissionariosCanibais novo = new MissionariosCanibais("Levar 1 Canibal e 1 Missionario", cE - 1, mE - 1, cD + 1, mD + 1, 'd');
            if (!visitados.contains(novo) && novo.ehValido()) visitados.add(novo);
        } else if (ladoBarco == 'd' && cD >= 1 && mD >= 1) {
            MissionariosCanibais novo = new MissionariosCanibais("Trazer 2 Canibais", cE + 1, mE + 1, cD - 1, mD - 1, 'e');
            if (!visitados.contains(novo) && novo.ehValido()) visitados.add(novo);
        }
    };
 
    /**
     * verifica se um estado e igual a outro
     * (usado para poda)
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof MissionariosCanibais) {
            MissionariosCanibais e = (MissionariosCanibais)o;
            return this.cE == e.cE && this.mE == e.mE && this.cD == e.cD && this.mD == e.mD;
        }
        return false;
    }
    
    /** 
     * retorna o hashCode do estado
     * (usado para poda, conjunto de fechados)
     */
    @Override
    public int hashCode() { 
        return (cE + "," + mE + "," + ladoBarco).hashCode();
    }
    
    @Override
    public String toString() {
        return String.format("(%dM, %dC) | (%dM, %dC) | %s \n", mE, cE, mD, cD, op);
    }
    
    public static void main(String[] a) {
        MissionariosCanibais estadoInicial = new MissionariosCanibais("estado inicial", 3, 3, 0, 0, 'e');
        // chama busca em largura
        System.out.println("busca em ....");
        Nodo n = new BuscaLargura(new MostraStatusConsole()).busca(estadoInicial);
        if (n == null) {
            System.out.println("sem solucao!");
        } else {
            System.out.println("Solucao:\n" + n.montaCaminho() + "\n\n");
        }
    }
    
}
