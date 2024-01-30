/* ***************************************************************
* Autor............: JOAO PAULO SANDES BRITO
* Matricula........: 202110811
* Inicio...........: DESCONHECIDO
* Ultima alteracao.: 14/03/2023
* Nome.............: ListaDuplamenteEncadeada
* Funcao...........: IMPLEMENTAR LISTA DUPLAMENTE ENCADEADA
*************************************************************** */

public class ListaDuplamenteEncadeada<Tipo> {

    private Element head;
    private Element tail;

    public final class Element {
        Tipo data;
        Element next, prev;

        Element(Tipo d, Element p, Element n) {
            data = d;
            next = n;
            prev = p;
        }

        public void inserirDepois(Tipo item) {
            Element temp = new Element(item, this, next);
            next = temp;
            if (tail == this) {
                tail = next;
            } else {
                temp.next.prev = temp;
            }
        }

        public void inserirAntes(Tipo item) {
            Element temp = new Element(item, prev, this);
            prev = temp;
            if (this == head) {
                head = prev;
            } else {
                temp.prev.next = temp;
            }
        }

    }
    
    public Tipo getPrimeiro(){
        return head.data;
    }
    
    public void fazVazia(){
        head = null;
        tail = null;
    }

    public void inserirInicio(Tipo item) {
        Element temp = new Element(item, null, head);
        if (head == null) {
            tail = temp;
        } else {
            head.prev = temp;
        }
        head = temp;
    }

    public void inserirFim(Tipo item) {
        Element temp = new Element(item, tail, null);
        if (head == null) {
            head = temp;
        } else {
            tail.next = temp;
        }
        tail = temp;
    }

    public void remover(Tipo item) throws ObjetoNaoEncontradoException {
        Element ptr = head;
        while (ptr != null && ptr.data != item) {
            ptr = ptr.next;
        }

        if (ptr == null) {
            throw new ObjetoNaoEncontradoException();
        }

        if ((ptr == head) && (ptr == tail)) {
            head = null;
            tail = null;
        } else if (ptr == head) {
            head = ptr.next;
            head.prev = null;
        } else if (ptr == tail) {
            tail = ptr.prev;
            tail.next = null;
        } else {
            (ptr.prev).next = ptr.next;
            (ptr.next).prev = ptr.prev;
        }
    }

}