public class Node<T> {
    private T valor; // Valor armazenado no nó raiz.
    private Node<T> filho_esq, filho_dir; // Referências para subárvores.

    // Construtor da árvore sem subárvore.
    public Node(T v) {
        valor = v;
        filho_esq = null;
        filho_dir = null;
    }

    // Construtor que recebe subárvores.
    public Node(T v, Node<T> NoEsq, Node<T> NoDir) {
        valor = v;
        filho_esq = NoEsq;
        filho_dir = NoDir;
    }

    // Retorna o valor do nó raiz.
    public T getValor() {
        return valor;
    }

    public Node<T> getFilho_esq() {
        return filho_esq;
    }

    // Retorna a subárvore direita.
    public Node<T> getFilho_dir() {
        return filho_dir;
    }

    // Define o valor do nó raiz da árvore.
    public void setValor(T v) {
        valor = v;
    }

    // Define o nó da subárvore esquerda.
    public void setEsq(Node<T> f_esq) {
        filho_esq = f_esq;
    }

    // Define o nó da subárvore direita.
    public void setDir(Node<T> f_dir) {
        filho_dir = f_dir;
    }

    // Imprime a árvore em pré-ordem.
    public void imprimePreOrdem() {
        System.out.print(this.valor + " "); // Visita o nó raiz.
        if (this.getFilho_esq() != null) {
            this.getFilho_esq().imprimePreOrdem();
        }
        if (this.getFilho_dir() != null) {
            this.getFilho_dir().imprimePreOrdem();
        }
    }

    // Imprime a árvore em ordem.
    public void imprimeInOrdem() {
        if (this.getFilho_esq() != null) {
            this.getFilho_esq().imprimeInOrdem();
        }
        System.out.print(this.valor + " "); // Visita o nó raiz.
        if (this.getFilho_dir() != null) {
            this.getFilho_dir().imprimeInOrdem();
        }
    }

    // Imprime a árvore em pós-ordem.
    public void imprimePosOrdem() {
        if (this.getFilho_esq() != null) {
            this.getFilho_esq().imprimePosOrdem();
        }
        if (this.getFilho_dir() != null) {
            this.getFilho_dir().imprimePosOrdem();
        }
        System.out.print(this.valor + " "); // Visita o nó raiz.
    }

    // Imprime a árvore em largura.
    public void imprimeEmLargura() throws Exception {
        FilaEncadeada f = new FilaEncadeada();
        f.enfileirar(this);
        while (!f.estaVazia()) {
            @SuppressWarnings("unchecked")
            Node<T> no = (Node<T>) f.desenfileirar();

            if (no.getFilho_esq() != null) {
                f.enfileirar(no.getFilho_esq());
            }
            if (no.getFilho_dir() != null) {
                f.enfileirar(no.getFilho_dir());
            }

            System.out.print(no.getValor() + " ");
        }
    }

    // Método recursivo para imprimir a árvore em largura.
    public void imprimeEmLarguraRecursivo(FilaEncadeada f) throws Exception {
        @SuppressWarnings("unchecked")
        Node<T> no = (Node<T>) f.desenfileirar();
        if (no.getFilho_esq() != null) {
            f.enfileirar(no.getFilho_esq());
        }
        if (no.getFilho_dir() != null) {
            f.enfileirar(no.getFilho_dir());
        }
        System.out.print(no.getValor() + " ");
        if (!f.estaVazia()) {
            imprimeEmLarguraRecursivo(f);
        }
    }

    // Imprime a árvore em largura invertida.
    public void imprimeEmLarguraInvertido() throws Exception {
        FilaEncadeada f = new FilaEncadeada();
        PilhaEncadeada p = new PilhaEncadeada();

        f.enfileirar(this);
        while (!f.estaVazia()) {
            @SuppressWarnings("unchecked")
            Node<T> no = (Node<T>) f.desenfileirar();

            if (no.getFilho_esq() != null) {
                f.enfileirar(no.getFilho_esq());
            }
            if (no.getFilho_dir() != null) {
                f.enfileirar(no.getFilho_dir());
            }
            p.push(no.getValor());
        }
        System.out.println();
        imprimePilha(p);
    }

    // Imprime uma pilha.
    private void imprimePilha(PilhaEncadeada p) throws Exception {
        while (!p.estaVazia()) {
            System.out.print(p.pop() + " ");
        }
    }

    // Calcula a altura da árvore.
    public int calculaAltura() {
        int alturaesquerda = 0;
        int alturadireita = 0;

        if (this.getFilho_esq() != null)
            alturaesquerda = this.getFilho_esq().calculaAltura() + 1;

        if (this.getFilho_dir() != null)
            alturadireita = this.getFilho_dir().calculaAltura() + 1;

        if (alturaesquerda > alturadireita)
            return alturaesquerda;
        else
            return alturadireita;
    }

    // Calcula o número total de nós na árvore.
    public int calculaTotalNodes() {
        int totalesq = 0;
        int totaldir = 0;

        if (this.getFilho_esq() != null) {
            totalesq = this.getFilho_esq().calculaTotalNodes();
        }
        if (this.getFilho_dir() != null) {
            totaldir = this.getFilho_dir().calculaTotalNodes();
        }
        return totalesq + totaldir + 1;
    }

    // Calcula o número total de nós folhas na árvore.
    public int calculaTotalNodesFolhas() {
        int totalesq = 0;
        int totaldir = 0;
        boolean ehfolha = true;

        if (this.getFilho_esq() != null) {
            totalesq = this.getFilho_esq().calculaTotalNodesFolhas();
            ehfolha = false;
        }
        if (this.getFilho_dir() != null) {
            totaldir = this.getFilho_dir().calculaTotalNodesFolhas();
            ehfolha = false;
        }
        if (ehfolha) {
            return 1;
        } else
            return (totaldir + totalesq);
    }

    // Calcula a altura da árvore em largura.
    public int calculaAlturaEmLargura() throws Exception {
        FilaEncadeada f = new FilaEncadeada();
        FilaEncadeada dist = new FilaEncadeada();
        f.enfileirar(this);
        dist.enfileirar(0);
        int altura_maxima = 0;
        while (!f.estaVazia()) {
            @SuppressWarnings("unchecked")
            Node<T> no = (Node<T>) f.desenfileirar();
            int dist_pai = (int) dist.desenfileirar();
            if (no.getFilho_esq() != null) {
                f.enfileirar(no.getFilho_esq());
                dist.enfileirar(dist_pai + 1);
            }
            if (no.getFilho_dir() != null) {
                f.enfileirar(no.getFilho_dir());
                dist.enfileirar(dist_pai + 1);
            }
            if (dist_pai > altura_maxima)
                altura_maxima = dist_pai;
        }
        return altura_maxima;
    }

    // Insere um valor ordenadamente na árvore.
    public Boolean InsereOrdenado(T v) {
        if (v.toString().compareTo(this.getValor().toString()) < 0) {
            if (this.getFilho_esq() != null)
                return this.getFilho_esq().InsereOrdenado(v);
            else {
                Node<T> n = new Node<T>(v);
                this.setEsq(n);
                return true;
            }
        } else {
            if (this.getFilho_dir() != null)
                return this.getFilho_dir().InsereOrdenado(v);
            else {
                Node<T> n = new Node<T>(v);
                this.setDir(n);
                return true;
            }
        }
    }

    // Pesquisa um valor na árvore e retorna o nó que o contém.
    public Node<T> pesquisarValor(T v) {
        int comparacao = v.toString().compareTo(this.getValor().toString());

        if (comparacao < 0) {
            if (this.getFilho_esq() != null)
                return this.getFilho_esq().pesquisarValor(v);
            else
                return null;
        } else if (comparacao > 0) {
            if (this.getFilho_dir() != null)
                return this.getFilho_dir().pesquisarValor(v);
            else
                return null;
        } else
            return this;
    }

    // Encontra o pai de um determinado nó na árvore.
    public Node<T> acharPai(Node<T> noraiz) {
        if (this.getFilho_esq() == noraiz || this.getFilho_dir() == noraiz) {
            return this;
        } else {
            Node<T> paiEncontrado = null;
            if (this.getFilho_esq() != null) {
                paiEncontrado = this.getFilho_esq().acharPai(noraiz);
            }
            if (paiEncontrado == null && this.getFilho_dir() != null) {
                paiEncontrado = this.getFilho_dir().acharPai(noraiz);
            }
            return paiEncontrado;
        }
    }

    public void setFilhoNode(Node<T> pai, Node<T> filho) {
        if (this.getFilho_esq() == filho) {
            this.setEsq(filho);
        } else if (this.getFilho_dir() == filho) {
            this.setDir(filho);
        } else {
            throw new IllegalArgumentException("O nó especificado não é filho deste nó.");
        }
    }

}