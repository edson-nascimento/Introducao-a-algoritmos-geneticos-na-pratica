public class Populacao {

    private Individuo[] individuos;
    private int tamPopulacao;

    /**
     * Cria uma população com individuos aleatórios
     * @param numGenes
     * @param tamPop
     */
    public Populacao(int numGenes, int tamPop) {
        tamPopulacao = tamPop;
        individuos = new Individuo[tamPop];
        for (int i = 0; i < individuos.length; i++) {
            individuos[i] = new Individuo(numGenes);
        }
    }

    /**
     * Cria uma população com individuos sem valor, que vão ser preenchidos posteriormente
     * @param tamPop
     */
    public Populacao(int tamPop) {
        tamPopulacao = tamPop;
        individuos = new Individuo[tamPop];
        for (int i = 0; i < individuos.length; i++) {
            individuos[i] = null;
        }
    }

    /**
     * Coloca un individuo em uma certa posição da população
     * @param individuo
     * @param posicao
     */
    public void setIndividuo(Individuo individuo, int posicao) {
        individuos[posicao] = individuo;
    }

    /**
     * Coloca un individuo na próxima posição disponível na população
     * @param individuo
     */
    public void setIndividuo(Individuo individuo) {
        for (int i = 0; i < individuos.length; i++) {
            if (individuos[i] == null) {
                individuos[i] = individuo;
                return;
            }
        }
    }

    /**
     * Verifica se algum individuo da população tem a solução
     * @param solucao
     * @return
     */
    public boolean temSolocao(String solucao) {
        Individuo i = null;
        for (int j = 0; j < individuos.length; j++) {
            if (individuos[j].getGenes().equals(solucao)) {
                i = individuos[j];
                break;
            }
        }
        if (i == null) {
            return false;
        }
        return true;
    }

    /**
     * Ordena a população pelo valor da fitness assim quando querer pegar os melhores  individuo eles já estarão em sequencia
     */
    public void ordenaPopulacao() {
        boolean trocou = true;
        while (trocou) {
            trocou = false;
            for (int i = 0; i < individuos.length - 1; i++) {
                if (individuos[i].getAptidao() < individuos[i + 1].getAptidao()) {
                    Individuo temp = individuos[i];
                    individuos[i] = individuos[i + 1];
                    individuos[i + 1] = temp;
                    trocou = true;
                }
            }
        }
    }

    /**
     * Numero de indviduos existentes na população
     * @return
     */
    public int getNumIndividuos() {
        int num = 0;
        for (int i = 0; i < individuos.length; i++) {
            if (individuos[i] != null) {
                num++;
            }
        }
        return num;
    }

    public int getTamPopulacao() {
        return tamPopulacao;
    }

    public Individuo getIndivduo(int pos) {
        return individuos[pos];
    }
}