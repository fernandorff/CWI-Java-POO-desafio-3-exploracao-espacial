package exploracaoEspacial;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Planeta {

    public final List<Recurso> RECURSOS;

    public final int POSICAO;

    private String nome;

    private int valorTotal = 0;

    private int valorPorPeso = 0;

    public Planeta(String nome, int POSICAO, Recurso... args) {

        setNome(nome);
        this.POSICAO = POSICAO;
        this.RECURSOS = Collections.unmodifiableList(Arrays.asList(args));

        for (int i = 0; i < this.RECURSOS.size(); i++) {
            this.valorTotal += this.RECURSOS.get(i).getValor();
            this.valorPorPeso += (this.RECURSOS.get(i).getValor() / this.RECURSOS.get(i).getPeso());
        }

    }

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public int getPOSICAO() {return POSICAO;}

    public int getValorPorPeso() {return valorPorPeso;}

    public int getValorTotal() {return valorTotal;}

}
