import exploracaoEspacial.Nave;
import exploracaoEspacial.Planeta;
import exploracaoEspacial.Recurso;
import org.junit.Assert;
import org.junit.Test;

public class TestesObrigatorios {

    Recurso agua = new Recurso("Agua", 80, 10);

    Recurso oxigenio = new Recurso("Oxigenio", 50, 2);

    Recurso silicio = new Recurso("Silicio", 60, 15);

    Recurso ouro = new Recurso("Ouro", 120, 20);

    Recurso ferro = new Recurso("Ferro", 30, 30);

    Planeta terra = new Planeta("Terra", 2, agua, oxigenio);

    Planeta marte = new Planeta("Marte", 4, silicio, ferro, ouro);

    Planeta jupiter = new Planeta("Jupiter", 8, oxigenio, ferro);

    Planeta lixo = new Planeta("Lixo", 5);

    @Test
    public void deveFicarADerivaQuandoFaltarCombustivelParaIrAteUmPlaneta() {

        System.out.println("\nTeste - Deve ficar a deriva quando faltar combustivel para ir ate um planeta.");

        Nave nave = new Nave(30);

        System.out.println(nave);

        // prioridade -> 0 = posicao || 1 = valor total || 2 = valor por peso
        nave.explorar(0, jupiter);

        System.out.println(nave);

        Assert.assertTrue(nave.isaDeriva());

    }

    @Test
    public void deveTerValorTotalZeradoQuandoNaoExistirNenhumRecurso() {

        System.out.println("\nTeste - Deve ter valor total zerado quando nao existir nenhum recurso");

        Nave nave = new Nave(60);

        System.out.println(nave);

        // prioridade -> 0 = posicao || 1 = valor total || 2 = valor por peso
        nave.explorar(0, lixo);

        System.out.println(nave);
        System.out.println();

        int valorEsperado = 0;

        Assert.assertEquals(valorEsperado,nave.getValorAcumulado());

    }

    @Test
    public void deveTerValorTotalQuandoExistirRecursosNoPlaneta() {

        System.out.println("\nTeste - Deve ter valor total quando existir recursos no planeta");

        Nave nave = new Nave(60);

        System.out.println(nave);

        // prioridade -> 0 = posicao || 1 = valor total || 2 = valor por peso
        nave.explorar(0, terra);

        System.out.println(nave);

        int valorEsperado = terra.getValorTotal();

        Assert.assertEquals(valorEsperado,nave.getValorAcumulado());

    }

    @Test
    public void deveTerValorPorPesoZeradoQuandoNaoExistirNenhumRecurso() {

        System.out.println("\nDeve ter valor por peso zerado quando nao existir nenhum recurso");

        Nave nave = new Nave(60);

        System.out.println(nave);

        // prioridade -> 0 = posicao || 1 = valor total || 2 = valor por peso
        nave.explorar(0, lixo);

        System.out.println(nave);

        int valorEsperado = 0;

        Assert.assertEquals(valorEsperado,nave.getValorAcumuladoPorPeso());

    }

    @Test
    public void deveTerValorPorPesoQuandoExistirRecursosNoPlaneta(){

        System.out.println("\nTeste - Deve ter valor por peso quando existir recursos no planeta");

        Nave nave = new Nave(60);

        System.out.println(nave);

        // prioridade -> 0 = posicao || 1 = valor total || 2 = valor por peso
        nave.explorar(0, terra);

        System.out.println(nave);

        int valorEsperado = terra.getValorPorPeso();

        Assert.assertEquals(valorEsperado,nave.getValorAcumuladoPorPeso());

    }

}
