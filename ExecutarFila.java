public class ExecutarFila {

    public static void main(String[] args) {
        Fila fila = new Fila();
        
        fila.adicionar("João");
        fila.adicionar("Jose");
        fila.adicionar("Maria");
        fila.adicionar("Ana");
        
        System.out.println("Tamanho da fila: " +fila.getTamanho());
        System.out.println("Primeiro da fila " +fila.get());
        
        fila.remover();
        
        System.out.println("Tamanho da fila: " +fila.getTamanho());
        System.out.println("Primeiro da fila " +fila.get());
    }
}