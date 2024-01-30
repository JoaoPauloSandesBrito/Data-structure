/* ***************************************************************
* Autor............: JOAO PAULO SANDES BRITO
* Matricula........: 202110811
* Inicio...........: 14/03/2023
* Ultima alteracao.: 14/03/2023
* Nome.............: Pilha
* Funcao...........: INTERFACE PILHA
*************************************************************** */

public interface Pilha{

    void fazVazia();
    
    boolean estaVazia();
    
    Object getTop() throws Exception ;
    
    void push(Object o);
    
    Object pop() throws Exception ;
    
    }
