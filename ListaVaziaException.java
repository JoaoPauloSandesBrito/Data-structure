public class ListaVaziaException extends Exception {
    
    public ListaVaziaException() {
        super("Lista Vazio");
    }

    public ListaVaziaException(String mensagem) {
        super(mensagem);
    }
}