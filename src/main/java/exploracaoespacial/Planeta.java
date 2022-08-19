package exploracaoespacial;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Planeta {

    public final List<Recurso> recursos;

    public final int posicao;

    private String nome;

    private int valorTotal = 0;

    private int pesoPlaneta = 0;

    private int valorPorPeso = 0;

    public Planeta(String nome, int posicao, Recurso... args) {

        setNome(nome);
        this.posicao = posicao;
        this.recursos = Collections.unmodifiableList(Arrays.asList(args));

        for (Recurso recurso : this.recursos) {
            this.valorTotal += recurso.getValor();
            this.pesoPlaneta += recurso.getPeso();

            this.valorPorPeso += (recurso.getValor() / this.getPesoPlaneta());
        }

    }

    public String toString() {

        return "Planeta --- Nome: " + nome + " - Posicao: " + posicao + " - Valor total: " + valorTotal + " - Valor por peso: " + valorPorPeso;
    }

    public int getPesoPlaneta() {

        return pesoPlaneta;
    }

    public void setNome(String nome) {this.nome = nome;}

    public int getPosicao() {return posicao;}

    public int getValorPorPeso() {return valorPorPeso;}

    public int getValorTotal() {return valorTotal;}

}
