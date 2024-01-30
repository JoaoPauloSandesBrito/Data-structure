public class ContainerVazioException extends Exception {
    
    public ContainerVazioException() {
        super("Container Vazio");
    }

    public ContainerVazioException(String mensagem) {
        super(mensagem);
    }
}