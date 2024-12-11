public class ListaLigada {
    private Elemento primeiro; // quem é o primeiro da lista, onde começa
    private Elemento ultimo; // ponteiro null para o último da lista
    private int tamanho;// numero de elementos na listra, utilizar ++

    public ListaLigada(){
        this.tamanho = 0;
    }
    
    public Elemento getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(Elemento primeiro) {
        this.primeiro = primeiro;
    }

    public Elemento getUltimo() {
        return ultimo;
    }

    public void setUltimo(Elemento ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    
    public void adicionar (String novoValor){
        Elemento novoElemento = new Elemento (novoValor);
        if (this.primeiro == null && this.ultimo == null  ){
            this.primeiro = novoElemento;
            this.ultimo = novoElemento;
        }else{
            this.ultimo.setProximo(novoElemento);
            this.ultimo = novoElemento;
        }
        
        this.tamanho++;
    }
    
    public void remover (String novoValor){
    }
    
    public Elemento getTamanho (int posicao){
        Elemento atual = this.primeiro;
        for (int i = 0; i <= posicao; i++){
            if(atual.getProximo() != null){
               atual = atual.getProximo();
            }
        }
        return atual;
    }
    public void adicionarComeco (String novoValor){
        Elemento novoElemento = new Elemento(novoValor);
        if (this.primeiro == null && this.ultimo == null  ){
            this.primeiro = novoElemento;
            this.ultimo = novoElemento;
        }
        else{
            novoElemento.setProximo(this.primeiro);
            this.primeiro=novoElemento;
        }
        this.tamanho++;
    }
}