package exploracaoEspacial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Nave {

    List<Planeta> roteiroDeExploracao = new ArrayList<>();

    List<Planeta> roteiroDeExploracaoComPrioridade;

    private int valorAcumulado;

    private int valorAcumuladoPorPeso;

    private int combustivel;

    private int posicao = 0;

    private boolean aDeriva = false;

    public Nave(int combustivel) {setCombustivel(combustivel);}

    public void organizarPrioridade(int prioridadeDefinida, Planeta... args) {

        Collections.addAll(roteiroDeExploracao, args);

        // prioridade -> 0 = posicao || 1 = valor total || 2 = valor por peso
        switch (prioridadeDefinida) {
            case 0:
                roteiroDeExploracaoComPrioridade = roteiroDeExploracao.stream()
                        .sorted(Comparator.comparing(Planeta::getPOSICAO))
                        .collect(Collectors.toList());
                break;

            case 1:
                roteiroDeExploracaoComPrioridade = roteiroDeExploracao.stream()
                        .sorted(Comparator.comparing(Planeta::getValorTotal))
                        .collect(Collectors.toList());
                break;
            case 2:
                roteiroDeExploracaoComPrioridade = roteiroDeExploracao.stream()
                        .sorted(Comparator.comparing(Planeta::getValorPorPeso))
                        .collect(Collectors.toList());
                break;
        }

    }

    public void explorar(int escolherPrioridade, Planeta... args) {

        organizarPrioridade(escolherPrioridade, args);

        if (!this.aDeriva) {

            for (Planeta arg : roteiroDeExploracaoComPrioridade) {

                while (this.getPosicao() != arg.getPOSICAO() && !this.aDeriva) {

                    if (this.getPosicao() < arg.getPOSICAO()) {
                        this.posicao += 1;
                        this.combustivel -= 3;
                    } else {
                        this.posicao -= 1;
                        this.combustivel -= 3;
                    }
                    this.setADerivaSeSemCombustivel();
                    // System.out.println(this.toString());

                }

                if (((this.getPosicao() - arg.getPOSICAO()) == 0)) {
                    this.valorAcumulado += arg.getValorTotal();
                    this.valorAcumuladoPorPeso += arg.getValorPorPeso();
                }

            }
            while (this.getPosicao() != 0 && !this.aDeriva) {

                if (this.getPosicao() > 0) {
                    this.posicao -= 1;
                    this.combustivel -= 3;
                }
                this.setADerivaSeSemCombustivel();
                // System.out.println(this.toString());

            }
        }
    }

    public void setADerivaSeSemCombustivel() {

        this.aDeriva = this.combustivel < 3;

    }

    public boolean isaDeriva() {

        return aDeriva;
    }

    public int getValorAcumulado() {

        return valorAcumulado;
    }

    public int getValorAcumuladoPorPeso() {

        return valorAcumuladoPorPeso;
    }

    public void setCombustivel(int combustivel) {this.combustivel = combustivel;}

    public int getPosicao() {return this.posicao;}

    public String toString() {

        return "Nave --- Posicao: " + posicao + " - Combustivel: " + combustivel + " - Esta a deriva? " + aDeriva + " - Valor acumulado: " + valorAcumulado + " - Valor acumulado por peso: " + valorAcumuladoPorPeso;
    }

}
