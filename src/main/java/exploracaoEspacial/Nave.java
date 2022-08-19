package exploracaoEspacial;

import java.util.*;
import java.util.stream.Stream;

public class Nave {

    public int valorAcumulado;

    public int valorAcumuladoPorPeso;

    private int combustivel;

    private int posicao = 0;

    private boolean aDeriva = false;

    public Nave(int combustivel) {setCombustivel(combustivel);}

    public void explorar(int i,Planeta... args) {

        Math.min()

        for (Planeta arg : args) {



        }


        if (!this.aDeriva) {

            for (Planeta arg : args) {

                while (this.getPosicao() != arg.getPOSICAO() && !this.aDeriva) {

                    if (this.getPosicao() < arg.getPOSICAO()) {
                        this.posicao += 1;
                        this.combustivel -= 3;
                    } else {
                        this.posicao -= 1;
                        this.combustivel -= 3;
                    }
                    this.setADerivaSeSemCombustivel();

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
            }
        }
    }

    public boolean isaDeriva() {return aDeriva;}

    public void setADerivaSeSemCombustivel() {

        if (this.combustivel < 3) {
            this.aDeriva = true;
        } else {
            this.aDeriva = false;
        }

    }

    public int getCombustivel() {return this.combustivel;}

    public void setCombustivel(int combustivel) {this.combustivel = combustivel;}

    public int getPosicao() {return this.posicao;}

    public void setPosicao(int posicao) {this.posicao = posicao;}

}
