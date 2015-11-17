import java.util.Random;

public class Algoritimo {

    private static String solucao;
    private static double taxaDeCrossover;
    private static double taxaDeMutacao;
    private static String caracteres;

    public static Populacao novaGeracao(Populacao populacao, boolean elitismo) {
        Random r = new Random();
        
        /**
         * Cria uma nova população do mesmo tamanho da antiga 
         */
        Populacao novaPopulacao = new Populacao(populacao.getTamPopulacao());

        /**
         * Se for com o método eletista sempre vai pegar o melhor individuo da população anterior
         */
        if (elitismo) {
            novaPopulacao.setIndividuo(populacao.getIndivduo(0));
        }

        /**
         * Insere novos individúos até a população atingir o seu tamanho completo
         */
        while (novaPopulacao.getNumIndividuos() < novaPopulacao.getTamPopulacao()) {
        	/**
        	 * Seleciona dois indivios aleátorios para fazer o cruzamento
        	 */
            Individuo[] pais = selecaoTorneio(populacao);

            Individuo[] filhos = new Individuo[2];

            /**
             * Verifica a taxa de crossover, se ainda for menor realiza o crossover, se não, mantem©m os pais selecionados para a próxima geração
             */
            if (r.nextDouble() <= taxaDeCrossover) {
                filhos = crossover(pais[1], pais[0]);
            } else {
                filhos[0] = new Individuo(pais[0].getGenes());
                filhos[1] = new Individuo(pais[1].getGenes());
            }

            /**
             * Adiciona os filhos gerados a nova geração
             */
            novaPopulacao.setIndividuo(filhos[0]);
            novaPopulacao.setIndividuo(filhos[1]);
        }

        /**
         * Faz a avaliação dos individúos (Fitness)
         */
        novaPopulacao.ordenaPopulacao();
        return novaPopulacao;
    }

    public static Individuo[] crossover(Individuo individuo1, Individuo individuo2) {
        Random r = new Random();

        /**
         * Faz o sorteio de 2 pontos de corte Aleátorios
         */
        int pontoCorte1 = r.nextInt((individuo1.getGenes().length()/2) -2) + 1;
        int pontoCorte2 = r.nextInt((individuo1.getGenes().length()/2) -2) + individuo1.getGenes().length()/2;

        Individuo[] filhos = new Individuo[2];

        /**
         * Pega os genes dos pais selecionados
         */
        String genePai1 = individuo1.getGenes();
        String genePai2 = individuo2.getGenes();

        String geneFilho1;
        String geneFilho2;

        /**
         * Aplica os pontos de corte
         */
        geneFilho1 = genePai1.substring(0, pontoCorte1);
        geneFilho1 += genePai2.substring(pontoCorte1, pontoCorte2);
        geneFilho1 += genePai1.substring(pontoCorte2, genePai1.length());
        
        geneFilho2 = genePai2.substring(0, pontoCorte1);
        geneFilho2 += genePai1.substring(pontoCorte1, pontoCorte2);
        geneFilho2 += genePai2.substring(pontoCorte2, genePai2.length());

        /**
         * Cria o novo individúo com os genes dos pais
         */
        filhos[0] = new Individuo(geneFilho1);
        filhos[1] = new Individuo(geneFilho2);

        return filhos;
    }

    public static Individuo[] selecaoTorneio(Populacao populacao) {
        Random r = new Random();
        Populacao populacaoIntermediaria = new Populacao(3);

        /**
         * Seleciona 3 individúos aleatóriamente na população
         */
        populacaoIntermediaria.setIndividuo(populacao.getIndivduo(r.nextInt(populacao.getTamPopulacao())));
        populacaoIntermediaria.setIndividuo(populacao.getIndivduo(r.nextInt(populacao.getTamPopulacao())));
        populacaoIntermediaria.setIndividuo(populacao.getIndivduo(r.nextInt(populacao.getTamPopulacao())));
        
        /**
         * Faz a avaliação dos individúos (Fitness)
         */
        populacaoIntermediaria.ordenaPopulacao();

        Individuo[] pais = new Individuo[2];

        /**
         * Seleciona os dois individuos mais aptos da população
         */
        pais[0] = populacaoIntermediaria.getIndivduo(0);
        pais[1] = populacaoIntermediaria.getIndivduo(1);

        return pais;
    }

    public static String getSolucao() {
        return solucao;
    }

    public static void setSolucao(String solucao) {
        Algoritimo.solucao = solucao;
    }

    public static double getTaxaDeCrossover() {
        return taxaDeCrossover;
    }

    public static void setTaxaDeCrossover(double taxaDeCrossover) {
        Algoritimo.taxaDeCrossover = taxaDeCrossover;
    }

    public static double getTaxaDeMutacao() {
        return taxaDeMutacao;
    }

    public static void setTaxaDeMutacao(double taxaDeMutacao) {
        Algoritimo.taxaDeMutacao = taxaDeMutacao;
    }

    public static String getCaracteres() {
        return caracteres;
    }

    public static void setCaracteres(String caracteres) {
        Algoritimo.caracteres = caracteres;
    }
    
    
}