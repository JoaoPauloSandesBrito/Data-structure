/* ***************************************************************
* Autor............: JOAO PAULO SANDES BRITO
* Matricula........: 202110811
* Inicio...........: 14/03/2023
* Ultima alteracao.: 14/03/2023
* Nome.............: Pilha
* Funcao...........: IMPLEMENTAR PILHA ENCADEADA
*************************************************************** */

public class PilhaEncadeada implements Pilha {

    private ListaDuplamenteEncadeada<Object> lista;

    private int count;

    public PilhaEncadeada() {
        lista = new ListaDuplamenteEncadeada<Object>();
        count = 0;
    }

    public void fazVazia() {
        lista.fazVazia();
        count = 0;
    }

    public boolean estaVazia() {
        return count == 0;
    }

    public void push(Object objeto) {
        lista.inserirInicio(objeto);
        count++;
    }

    public Object pop() throws Exception  {
        if (count == 0)
            throw new ContainerVazioException();

        Object result = lista.getPrimeiro();
        lista.remover(result);
        count--;
        return result;
    }

    public Object getTop() throws Exception {
        if (count == 0)
            throw new ContainerVazioException();

        return lista.getPrimeiro();
    }
}
