package nave;


public class Nave {

    public int combustivel;
    public int posicao = 0;

    public Nave(int combustivel) {

        setCombustivel(combustivel);

    }

    public void explorar() {

    }

    public int getCombustivel() {
        return this.combustivel;
    }

    public void setCombustivel(int combustivel) {
        this.combustivel = combustivel;
    }

    public int getPosicao() {
        return this.posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }


}
