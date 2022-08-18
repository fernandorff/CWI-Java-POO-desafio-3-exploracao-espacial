package recurso;

public class Recurso {

    private String nome;
    private int valor;
    private int peso;

    public Recurso(String nome, int valor, int peso) {

        setNome(nome);
        setPeso(peso);
        setValor(valor);


    }

    public int getPeso() {
        return peso;
    }

    public int getValor() {
        return valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
