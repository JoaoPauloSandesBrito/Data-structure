public class ObjetoNaoEncontradoException extends Exception {
    
    public ObjetoNaoEncontradoException() {
        super("Objeto não encontrado");
    }

    public ObjetoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}