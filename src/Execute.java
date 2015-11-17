import java.io.ObjectInputStream.GetField;

public class Execute {
	static StringBuilder resposta;
	static String melhorIndividuo;
	
    public static void executar(String frase, double txCross, double txMutacao, int epocas, int popInicial) {
    	resposta = new StringBuilder();
    	melhorIndividuo = "";
    	System.out.println(frase+" - "+txCross+" - "+txMutacao+" - "+epocas+" - "+popInicial);

    	/**
    	 * Defina qual é a solução que deve ser alcançada
    	 */
        Algoritimo.setSolucao(frase);
        /**
         * Define os caracteres que seram usados
         */
        Algoritimo.setCaracteres("!,.:;?áÁãÃâÂõÕôÔóÓéêÉÊíQWERTYUIOPASDFGHJKLÇZXCVBNMqwertyuiopasdfghjklçzxcvbnm1234567890 ");
        /**
         * Defini a taxa de CrossOver
         */
        Algoritimo.setTaxaDeCrossover(txCross);
        /**
         * Taxa de mutação
         */
        Algoritimo.setTaxaDeMutacao(txMutacao);
        /**
         * Define se vai usar eletismo
         */
        boolean eltismo = true;
        /**
         * Defini o tamanho da população inicial
         */
        int tamPop = popInicial;
        /**
         * Numero máximo de epócas
         */
        int numMaxGeracoes = epocas;

        /**
         * Define o número de genes do indivíduo baseado na solução
         */
        int numGenes = Algoritimo.getSolucao().length();

        /**
         * Cria a primeira população aleatérioa
         */
        Populacao populacao = new Populacao(numGenes, tamPop);

        boolean temSolucao = false;
        int geracao = 0;
        
        resposta.append("Iniciando o Algoritmo \n");
        
        /**
         * O loop vai permanecer até encontrar uma solução ou atingir o numero maximo de épocas
         */
        while (!temSolucao && geracao < numMaxGeracoes) {
            geracao++;

            /**
             * Cria uma nova população
             * @var
             */
            populacao = Algoritimo.novaGeracao(populacao, eltismo);
            
            resposta.append("\n\n **Geração** " + geracao+"\n");
            
            for (int i = 1; i < populacao.getNumIndividuos(); i++) {
            	resposta.append("Ind "+i+" => Fitness: " + populacao.getIndivduo(i).getAptidao() + " => Cromossomo: " + populacao.getIndivduo(i).getGenes()+"\n");
			}
            
            resposta.append("Melhor =>>>>>>  Fitness: " + populacao.getIndivduo(0).getAptidao() + " => Cromossomo: " + populacao.getIndivduo(0).getGenes()+"\n");

            resposta.append("\n\n");
            
            /**
             * Verifica se já ancançou uma solução válida
             */
            temSolucao = populacao.temSolocao(Algoritimo.getSolucao());
        }

        if (geracao == numMaxGeracoes && !temSolucao) {
            resposta.append("Número Máximo de épocas alcançado | individuo: " + populacao.getIndivduo(0).getGenes() + " | Fitness: " + populacao.getIndivduo(0).getAptidao()+"\n");
            melhorIndividuo = "Geração: " + geracao + " | " + populacao.getIndivduo(0).getGenes() + " (Fitness: " + populacao.getIndivduo(0).getAptidao() + ")";
        }

        if (temSolucao) {
            melhorIndividuo = "Solução ótima  Geração: " + geracao + " | individuo: " + populacao.getIndivduo(0).getGenes() + " (Fitness: " + populacao.getIndivduo(0).getAptidao() + ")";
        }
    }
}
