import java.util.Scanner;

public class PilhaFila {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha: [1] para Pilha, [2] para Fila");
        int escolha = scanner.nextInt();
        scanner.nextLine(); 

        if (escolha == 1) {
            Pilha pilha = new Pilha();
            executarPilha(pilha, scanner);
        } else if (escolha == 2) {
            Fila fila = new Fila();
            executarFila(fila, scanner);
        } else {
            System.out.println("Opção inválida!");
        }

        scanner.close();
    }

    private static void executarPilha(Pilha pilha, Scanner scanner) {
        while (true) {
            System.out.println("Escolha uma operação: [1] Adicionar [2] Remover [3] Ver Primeiro [4] Ver Tamanho [5] Sair");
            int operacao = scanner.nextInt();
            scanner.nextLine(); 

            switch (operacao) {
                case 1:
                    System.out.println("Digite o valor para adicionar:");
                    String valor = scanner.nextLine();
                    pilha.adicionar(valor);
                    break;
                case 2:
                    pilha.remover();
                    break;
                case 3:
                    System.out.println("Primeiro da pilha: " + pilha.get());
                    break;
                case 4:
                    System.out.println("Tamanho da pilha: " + pilha.getTamanho());
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Operação inválida!");
            }
        }
    }

    private static void executarFila(Fila fila, Scanner scanner) {
        while (true) {
            System.out.println("Escolha uma operação: [1] Adicionar [2] Remover [3] Ver Primeiro [4] Ver Tamanho [5] Sair");
            int operacao = scanner.nextInt();
            scanner.nextLine(); 

            switch (operacao) {
                case 1:
                    System.out.println("Digite o valor para adicionar:");
                    String valor = scanner.nextLine();
                    fila.adicionar(valor);
                    break;
                case 2:
                    fila.remover();
                    break;
                case 3:
                    System.out.println("Primeiro da fila: " + fila.get());
                    break;
                case 4:
                    System.out.println("Tamanho da fila: " + fila.getTamanho());
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Operação inválida!");
            }
        }
    }
}

class Fila {

    private ListaLigada lista;

    public Fila() {
        this.lista = new ListaLigada();
    }

    public void adicionar(String novoValor) {
        this.lista.adicionar(novoValor);
    }

    public void remover() {
        this.lista.remover(this.get());
    }

    public String get() {
        return this.lista.getPrimeiro().getValor();
    }

    public int getTamanho() {
        return this.lista.getTamanho();
    }
}

class Pilha {

    private ListaLigada lista;

    public Pilha() {
        this.lista = new ListaLigada();
    }

    public void adicionar(String novoValor) {
        this.lista.adicionarComeco(novoValor);
    }

    public void remover() {
        this.lista.remover(this.get());
    }

    public String get() {
        return this.lista.getPrimeiro().getValor();
    }

    public int getTamanho() {
        return this.lista.getTamanho();
    }
}

class ListaLigada {

    private Elemento primeiro;
    private Elemento ultimo;
    private int tamanho;

    public ListaLigada() {
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

    public void adicionar(String novoValor) {
        Elemento novoElemento = new Elemento(novoValor);
        if (this.primeiro == null && this.ultimo == null) {
            this.primeiro = novoElemento;
            this.ultimo = novoElemento;
        } else {
            this.ultimo.setProximo(novoElemento);
            this.ultimo = novoElemento;
        }
        this.tamanho++;
    }

    public void remover(String valor) {
        if (this.primeiro == null) {
            return;
        }

        if (this.primeiro.getValor().equals(valor)) {
            this.primeiro = this.primeiro.getProximo();
            this.tamanho--;
            if (this.tamanho == 0) {
                this.ultimo = null;
            }
            return;
        }

        Elemento atual = this.primeiro;
        while (atual.getProximo() != null) {
            if (atual.getProximo().getValor().equals(valor)) {
                atual.setProximo(atual.getProximo().getProximo());
                this.tamanho--;
                if (atual.getProximo() == null) {
                    this.ultimo = atual;
                }
                return;
            }
            atual = atual.getProximo();
        }
    }

    public void adicionarComeco(String novoValor) {
        Elemento novoElemento = new Elemento(novoValor);
        if (this.primeiro == null && this.ultimo == null) {
            this.primeiro = novoElemento;
            this.ultimo = novoElemento;
        } else {
            novoElemento.setProximo(this.primeiro);
            this.primeiro = novoElemento;
        }
        this.tamanho++;
    }
}

class Elemento {

    private String valor;
    private Elemento proximo;

    public Elemento(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Elemento getProximo() {
        return proximo;
    }

    public void setProximo(Elemento proximo) {
        this.proximo = proximo;
    }
}
