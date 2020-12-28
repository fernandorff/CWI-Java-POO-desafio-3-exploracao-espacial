## Exploração Espacial

![Serenity do Firefly](https://vignette.wikia.nocookie.net/firefly/images/1/11/Firefly_class_ship.jpg/revision/latest?cb=20090714124528)

Devido a eventos trágicos ocorridos no planeta Terra a raça humana se deparou com uma escacez de recursos naturais em seu habitat de origem e se viu obrigada a explorar outros planetas atrás destes recursos. O objetivo do trabalho é simular este cenário caótico.

### Recursos

Todos os recursos possuem um `valor` e um `peso`, ambos não podem ser modificados depois de sua
 criação. Os recursos podem ser:

- Água (valor: 180, peso: 10)
- Oxigênio (valor: 300, peso: 2)
- Silício (valor: 60, peso: 16)
- Ouro (valor: 120, peso: 25)
- Ferro (valor: 30, peso: 32)

### Planeta

Os planetas possuem uma `posição` (int) e uma lista de `recursos`, ambos também não podem ser alterados depois de sua
criação. Deve ser possível buscar o valor total e o valor por peso dos recursos deste planeta, onde o valor total é a 
**soma de todos os valores** e o valor por peso é a **divisão dos valores por seus respectivos pesos**.

Exemplo: Se um planeta possuir os recursos de Água, Oxigênio e Ouro:

- **Valor total** = valor de agua + valor de oxigênio + valor de ouro;
- **Valor por peso** = valor de agua / peso da água + valor de oxigênio / peso do oxigênio + valor de ouro / peso do ouro;

### Nave

Ao ser criada, a nave deve receber uma quantidade de combustível, ela gasta 3L de combustível para viajar
uma posição. Deve possuir um atributo chamado `posição`, que inicia em 0. Deve também implementar
os seguintes métodos:
 
- `getQuantidadeDeCombustivel`
 
- `explorar`: Este recebe um planeta ou uma lista de planetas e retorna uma lista de recursos que 
conseguiu explorar, quando a nave vai a um planeta, deve ser reduzida a quantidade de combustível
gasta para chegar até sua posição. Quando não houverem mais planetas a serem explorados, a nave deve 
retornar a sua posição inicial, esta viagem também afeta sua quantidade de combustível.
Se não houver combustível para chegar a uma posição, deve ir até a posição que sua quantidade permitir,
tanto na ida quanto na volta. A quantidade de combustível deve estar atualizada no término de execução
deste método.

Exemplos:

- **[N _ _ P1 _ _ P2]**: Neste caso temos a nave na posição 0, um planeta P1 na posição 3 e um planeta
P2 na 6. A nave irá até P1, coleta seus recursos, depois a P2, coleta os recursos e por fim volta a
posição inicial 0. Se não houver combustível para chegar até P2, por exemplo, a nave deve ficar a deriva
na posição que conseguir chegar.

- **[N _ _ _ _ P]**: Este caso é mais simples, só precisamos explorar um planeta. A nave sai da posição
0, vai até P na posição 5, coleta os recursos e volta a 0. Faltando combustível em algum dos dois
trajetos, a nave deve ir até onde conseguir.

**OBS.: Utilizem todos os valores como int** (valor dos recursos, valor por peso, posição, quantidade de combustível)

# Exemplo de Teste

```Java
@Test
public void deveFicarADerivaQuandoFaltarCombustivelParaIrAteUmPlaneta() {
    int posicaoEsperada = 3;
    Nave milleniumFalcon = new Nave(9);
    Planeta tatooine = new Planeta(4, new ArrayList<>());

    milleniumFalcon.explorar(tatooine);
    int posicaoResultante = milleniumFalcon.getPosicao();

    Assert.assertEquals(posicaoEsperada, posicaoResultante);
}
```

### Bônus

No método `explorar`, quando for passada uma lista de planetas, deve também haver uma "prioridade"
em que a Nave irá explorar os planetas. Esta prioridade está ligada ao Planeta, pode ser a posição,
o valor total de seus recursos ou o valor por peso dos mesmos. Nos exemplos acima a prioridade era a
posição.

Exemplo: Quero explorar esta lista de planetas com o prioridade de valor total, então minha
nave deve começar pelo planeta com o maior valor total e terminar pelo menor.

Me provem, através de testes, que a prioridade altera a quantidade de combustível restante no final
da exploração. Se eu escolher a prioridade posição deve sobrar mais combustível do que se eu
escolher quantidade de recursos.

## Testes Obrigatórios

* Devem existir **obrigatóriamente** na solução entregue testes unitários com os seguintes nomes:

    - deveFicarADerivaQuandoFaltarCombustivelParaIrAteUmPlaneta
    - deveTerValorTotalZeradoQuandoNaoExistirNenhumRecurso
    - deveTerValorTotalQuandoExistirRecursosNoPlaneta
    - deveTerValorPorPesoZeradoQuandoNaoExistirNenhumRecurso
    - deveTerValorPorPesoQuandoExistirRecursosNoPlaneta
