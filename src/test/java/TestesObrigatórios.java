import org.junit.Assert;
import org.junit.Test;
import recurso.Recurso;

public class TestesObrigatórios {

    Recurso agua = new Recurso("Agua",180,10);
    Recurso oxigenio = new Recurso("Oxigenio", 300, 2);
    Recurso silicio = new Recurso("Silicio", 60,15);
    Recurso ouro = new Recurso("Ouro", 120,20);
    Recurso ferro = new Recurso("Ferro", 30,30);

    @Test
    public void Teste(){
        Assert.assertEquals("Agua", agua.getNome());
    }

}
