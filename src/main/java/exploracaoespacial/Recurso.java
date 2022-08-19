package exploracaoespacial;

public class Recurso {

    private int valor;

    private int peso;

    public Recurso(int valor, int peso) {

        setPeso(peso);
        setValor(valor);

    }

    public int getPeso() {return peso;}

    public void setPeso(int peso) {this.peso = peso;}

    public int getValor() {return valor;}

    public void setValor(int valor) {this.valor = valor;}


}
