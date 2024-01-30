public class ContainerCheioException extends Exception {
    
    public ContainerCheioException() {
        super("Container Cheio");
    }

    public ContainerCheioException(String mensagem) {
        super(mensagem);
    }
}