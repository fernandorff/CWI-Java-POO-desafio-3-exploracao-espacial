import exploracaoespacial.Nave;
import exploracaoespacial.Planeta;
import exploracaoespacial.Recurso;
import org.junit.Assert;
import org.junit.Test;

public class TestesBonus {

    Recurso agua = new Recurso(40, 5);

    Recurso oxigenio = new Recurso(30, 2);

    Recurso silicio = new Recurso(90, 30);

    Recurso ouro = new Recurso(200, 40);

    Recurso ferro = new Recurso(50, 50);

    Planeta terra = new Planeta("Terra", 10, agua, oxigenio);

    Planeta jupiter = new Planeta("Jupiter", 2, silicio, ouro);

    Planeta lixo = new Planeta("Lixo", 5, ferro, ferro, ferro, ferro, ferro, ferro);

    Nave nave = new Nave(200);

    @Test
    public void calculandoCombustivelRestanteSeViajarComPrioridadeNaPosicaoDosPlanetas() {

        // prioridades:
        // 0 -> explora baseado na posicao dos planetas
        // 1 -> explora baseado no valor total dos planetas
        // 2 -> explora baseado no valor por peso dos planetas
        System.out.println(nave);
        nave.explorar(0, terra, jupiter, lixo);
        System.out.println(nave);

    }

    @Test
    public void deveTerCombustivelRestanteDiferenteSeExplorarComPrioridadeValorTotal() {

        // prioridades:
        // 0 -> explora baseado na posicao dos planetas
        // 1 -> explora baseado no valor total dos planetas
        // 2 -> explora baseado no valor por peso dos planetas
        System.out.println(nave);
        nave.explorar(1, terra, jupiter, lixo);
        System.out.println(nave);

        int valorEsperadoDoCombustivelRestanteSeViajarLinearmentePelasPosicoes = 140;

        Assert.assertNotEquals(valorEsperadoDoCombustivelRestanteSeViajarLinearmentePelasPosicoes, nave.getCombustivel());
    }

    @Test
    public void deveTerCombustivelRestanteDiferenteSeExplorarComPrioridadeValorPorPeso() {

        // prioridades:
        // 0 -> explora baseado na posicao dos planetas
        // 1 -> explora baseado no valor total dos planetas
        // 2 -> explora baseado no valor por peso dos planetas
        System.out.println(nave);
        nave.explorar(2, terra, jupiter, lixo);
        System.out.println(nave);

        int valorEsperadoDoCombustivelRestanteSeViajarLinearmentePelasPosicoes = 140;

        Assert.assertNotEquals(valorEsperadoDoCombustivelRestanteSeViajarLinearmentePelasPosicoes, nave.getCombustivel());
    }

}
