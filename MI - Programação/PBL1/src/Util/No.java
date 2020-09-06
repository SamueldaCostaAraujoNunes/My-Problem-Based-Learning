package Util;
/**
 * * A classe <b>No</b>, tem como função guardar um dado e a referencia de um  proximo nó.
 *
 * @author Samuel da Costa Araujo Nunes
 * @since out 2019.
 * @version 1.0
 */
public class No {
    private Object obj;
    private No prox;
    
    /**O construtor inicializa os atributos do nó.
     * 
     * @param obj 
     */
    public No(Object obj){
        this.obj = obj;
        this.prox= null;
    }
    /**
     * Ferramenta de auxilio no print ao usuario
     */
    public void displayNo(){
        System.out.print(obj+" -> ");}
    
    /**
     * Indica o nó que virá logo após este nó.
     * @param prox 
     */
    public void setProx(No prox) {
        this.prox = prox;
    }
    /**
     * Retorna a referencia do proximo nó.
     * @return 
     */
    public No getProx() {
        return this.prox;
    }
    /**Indica o objeto que esse nó guardará.
     * @param obj 
     */
    public void setObj(Object obj) {
        this.obj = obj;
    }
    //Retorna ao programa principal, o objeto guardado.
    public Object getObj() {
        return this.obj;
    }
    
    
    
}
