import exploracaoEspacial.Nave;
import exploracaoEspacial.Planeta;
import exploracaoEspacial.Recurso;
import org.junit.Assert;
import org.junit.Test;

public class TestesObrigatórios {

    Recurso agua = new Recurso("Agua", 80, 10);

    Recurso oxigenio = new Recurso("Oxigenio", 50, 2);

    Recurso silicio = new Recurso("Silicio", 60, 15);

    Recurso ouro = new Recurso("Ouro", 120, 20);

    Recurso ferro = new Recurso("Ferro", 30, 30);

    Nave nave = new Nave(15);

    @Test
    public void Teste() {

        Assert.assertEquals("Agua", agua.getNome());

    }

    @Test
    public void TestePlaneta() {

        Planeta terra = new Planeta("Terra", 2, agua, oxigenio);

        Planeta marte = new Planeta("Marte", 4, silicio, ferro, ouro);

        Planeta jupiter = new Planeta("Jupiter", 8, oxigenio, ferro);

        Nave nave = new Nave(200);

        nave.explorar(1, jupiter,marte,terra);

        System.out.println(nave.getPosicao());
        System.out.println(nave.getCombustivel());
        System.out.println(nave.isaDeriva());
        System.out.println(nave.valorAcumulado);
        System.out.println(nave.valorAcumuladoPorPeso);

    }

}
