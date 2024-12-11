public class Fila {
    
    private ListaLigada lista;
    
    public Fila(){
        this.lista =  new ListaLigada(); // this é opcional / sabemos que é um construtor porque tem o mesmo nome da classe.
    }
    
    public void adicionar(String novoValor){
        this.lista.adicionar(novoValor);
    } 
    
    public void remover(){ // remove o valor procurado, o método get precisa trazer o valor
        this.lista.remover(this.get());
    }
    
    public String get(){
        return this.lista.getPrimeiro().getValor(); // trazendo o valor
    }
    
    public int getTamanho(){
        return this.lista.getTamanho();
    }
}