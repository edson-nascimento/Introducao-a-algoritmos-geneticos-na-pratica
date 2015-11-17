# Introdução a Algoritmos Genéticos na pratica
Aqui você vai encontrar uma introdução de como começar a trabalhar com algoritmos genéticos com um exemplo prático e funcional.

## Introdução

  Algoritmos Genéticos, AGs, são métodos de busca inspirados na evolução dos seres vivos, introduzidos por John Holland (1975) e popularizados por um de seus alunos, David Goldberg (1989), seguem o princípio da seleção natural e sobrevivência dos mais aptos, segundo Charles Darwin (1859). Ele propôs que quanto mais apto um indivíduo for de sobreviver em um meio ambiente, mais chances ele terá de se reproduzir e passar sua carga genética para seus descendentes.

É nisto que se baseiam os Algoritmos Genéticos, buscar boas soluções em um espaço de busca grande, em que uma busca pontual seria muito cara.

### Detalhes da Aplicação

Neste exemplo uso como função objetivo, encontrar um gene pré-definido por uma frase em uma string, por exemplo:  `hello algoritmo genético`

A população inicial será criada com 50 indivíduos aleatórios, com genes de mesmo comprimento que a solução, a aptidão será calculada pelo número de letras iguais a solução, por exemplo, se a solução fosse ‘ola’, o gene ‘olq’ teria aptidão 2 e o gene ‘qlw’ teria aptidão 1.

O critério de parada será a solução encontrada, ou até chegar um número máximo de gerações definida na aplicação.

Programei a seleção por torneio, onde são sorteados 3 indivíduos, destes os 2 com maior aptidão são selecionados para o crossover. A taxa de crossover é de 60%, que pode ser alterada, e um crossover de 1 ponto, exemplo:
Defini uma taxa de mutação de 3%, também podendo ser alterada, que substitui um gene por outro aleatório, por exemplo:

### Código

Há cinco classes neste exemplo:

Execute.java (Classe que recebe os parâmetros e chama execução do algorítimo);

Algoritimo.java (Métodos e variáveis estáticas para controle do AG, crossover, seleção…);

Populacao.java (Classe de domínio que define uma população, contém uma lista de indivíduos);

Individuo.java (Classe de domínio que representa um indivíduo, contém seus genes e valor de aptidão).

Tela.java (Classe responsável pela interface do programa).
