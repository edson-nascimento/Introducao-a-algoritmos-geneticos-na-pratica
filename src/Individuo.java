import java.util.Random;

public class Individuo {

    private String genes = "";
    private int aptidao = 0;

    /**
     * Gera um individúo Aleatório
     * @param numGenes
     */
    public Individuo(int numGenes) {
        genes = "";
        Random r = new Random();
        
        String caracteres = Algoritimo.getCaracteres();
        
        for (int i = 0; i < numGenes; i++) {
            genes += caracteres.charAt(r.nextInt(caracteres.length()));
        }
        
        geraAptidao();        
    }

    /**
     * Cria um individuo com os genes que foram gerados
     * @param genes
     */
    public Individuo(String genes) {    
        this.genes = genes;
        
        Random r = new Random();
        /**
         * Se a mutação estiver ativada ele vai gerar genes aleatórios e substituir pelos por alguns originais
         */
        if (r.nextDouble() <= Algoritimo.getTaxaDeMutacao()) {
            String caracteres = Algoritimo.getCaracteres();
            String geneNovo="";
            int posAleatoria = r.nextInt(genes.length());
            for (int i = 0; i < genes.length(); i++) {
                if (i==posAleatoria){
                    geneNovo += caracteres.charAt(r.nextInt(caracteres.length()));
                }else{
                    geneNovo += genes.charAt(i);
                }
                
            }
            this.genes = geneNovo;   
        }
        geraAptidao();
    }

    /**
     * Gera a aptidão
     */
    private void geraAptidao() {
        String solucao = Algoritimo.getSolucao();
        for (int i = 0; i < solucao.length(); i++) {
            if (solucao.charAt(i) == genes.charAt(i)) {
                aptidao++;
            }
        }
    }

    public int getAptidao() {
        return aptidao;
    }

    public String getGenes() {
        return genes;
    }
}