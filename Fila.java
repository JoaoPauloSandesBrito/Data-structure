public interface Fila{

    void fazVazia();
    
    boolean estaVazia();
    
    Object getPrimeiro() throws ContainerVazioException, ListaVaziaException ;
    
    void enfileirar(Object objeto) throws ContainerCheioException;

    Object desenfileirar() throws ContainerVazioException, ListaVaziaException, ObjetoNaoEncontradoException;
    
    }
