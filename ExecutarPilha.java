public class ExecutarPilha {
    public static void main(String[] args) {
      Pilha pilha = new Pilha();
       
       pilha.adicionar("Stellita");
       pilha.adicionar("Jesus");
       pilha.adicionar("Debona");
       pilha.adicionar("Igao");
       
       System.out.println("Tamanho da pilha: " +pilha.getTamanho());
       System.out.println("Primeiro da pilha " +pilha.get());
       
       pilha.remover();
       
       System.out.println("Tamanho da pilha: " +pilha.getTamanho());
       System.out.println("Primeiro da pilha " +pilha.get());
   }
}