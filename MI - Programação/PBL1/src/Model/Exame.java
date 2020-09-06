package Model;

/**
 * A classe <b>Exame</b> define um tipo de dado, referente ao registro,
 * indicação e realizamento de exames.
 *
 * @author Samuel da Costa Araujo Nunes
 * @since out 2019.
 * @version 1.0
 */
public class Exame {

    /**
     * O atributo statusDoExame é utilizado para informar se o exame, já foi
     * realizado ou não.
     */
    private Boolean statusDoExame;
    /**
     * O atributo nomeDoExame é utilizado para informar, o nome do exame.
     */
    private String nomeDoExame;

    /**
     * Construtor da classe <b>Exame</b>.<br><br>
     * <b>uso:</b><br>
     * Exame exame = new Exame("Exame de Exemplo");<br><br>
     * <b>onde:</b><br>
     *
     * @param nomeDoExame String que identifica o nome do exame.
     */
    public Exame(String nomeDoExame) {
        this.statusDoExame = false;
        this.nomeDoExame = nomeDoExame;
    }

    /**
     * Recupera o status atual do Exame, ou seja, se ele já foi realizado ou não
     *
     * @return Retorna um Boolean, que se refere ao status atual.
     */
    public Boolean getStatusDoExame() {
        return statusDoExame;
    }

    /**
     * Atualiza o status atual do Exame, ou seja, se ele já foi realizado ou não
     *
     * @param statusDoExame Indica o novo valor, a ser mudado.
     */
    public void setStatusDoExame(Boolean statusDoExame) {
        this.statusDoExame = statusDoExame;
    }

    /**
     *Recupera o nome do Exame.
     * @return
     */
    public String getNomeDoExame() {
        return nomeDoExame;
    }
    /**
     * Indica o novo nome do exame.
     * @param nomeDoExame Indica o nome a ser ultilizado.
     */
    public void setNomeDoExame(String nomeDoExame) {
        this.nomeDoExame = nomeDoExame;
    }
}
