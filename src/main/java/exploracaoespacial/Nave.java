package exploracaoespacial;

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

    public void organizarPrioridade(int prioridadeDefinida, Planeta... argsPlanetas) {

        Collections.addAll(roteiroDeExploracao, argsPlanetas);

        switch (prioridadeDefinida) {

            case 1:
                roteiroDeExploracaoComPrioridade = roteiroDeExploracao.stream()
                        .sorted(Comparator.comparing(Planeta::getValorTotal).reversed())
                        .collect(Collectors.toList());
                break;
            case 2:
                roteiroDeExploracaoComPrioridade = roteiroDeExploracao.stream()
                        .sorted(Comparator.comparing(Planeta::getValorPorPeso).reversed())
                        .collect(Collectors.toList());
                break;
            default:
                roteiroDeExploracaoComPrioridade = roteiroDeExploracao.stream()
                        .sorted(Comparator.comparing(Planeta::getPosicao))
                        .collect(Collectors.toList());
                break;

        }

    }

    public void explorar(int escolherPrioridade, Planeta... argsPlanetas) {

        escolherPrioridade = Math.min(escolherPrioridade, 2);

        organizarPrioridade(escolherPrioridade, argsPlanetas);

        for (Planeta argPlaneta : roteiroDeExploracaoComPrioridade) {

            // indo para o planeta destino
            while (this.getPosicao() != argPlaneta.getPosicao() && !this.aDeriva) {

                moverUmaPosicao(argPlaneta.getPosicao());

            }

            // chegou ao planeta destino e coletou os recursos
            if (((this.getPosicao() - argPlaneta.getPosicao()) == 0)) {
                this.valorAcumulado += argPlaneta.getValorTotal();
                this.valorAcumuladoPorPeso += argPlaneta.getValorPorPeso();
            }

        }

        // voltando para posicao inicial
        while (this.getPosicao() != 0 && !this.aDeriva) {

            moverUmaPosicao(0);

        }
    }

    public void moverUmaPosicao(int posicaoDestino) {

        if (this.getPosicao() < posicaoDestino) {
            this.posicao += 1;
            this.combustivel -= 3;
        } else {
            this.posicao -= 1;
            this.combustivel -= 3;
        }
        this.setADerivaSeSemCombustivel();

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

    public int getCombustivel() {

        return combustivel;
    }

    public void setCombustivel(int combustivel) {this.combustivel = combustivel;}

    public int getPosicao() {return this.posicao;}

    public String toString() {

        return "Nave --- Posicao: " + posicao + " - Combustivel: " + combustivel + " - Esta a deriva? " + aDeriva + " - Valor acumulado: " + valorAcumulado + " - Valor acumulado por peso: " + valorAcumuladoPorPeso;
    }

}
