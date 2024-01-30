public class AVL<T> extends Node<T> {
  /*
   * A classe AVL herda de Node e adiciona a funcionalidade de balanceamento.
   */
  private int fatorbalanceamento = 0;
  // private AVL<T> pai;

  public AVL(T v) {
    super(v);
    fatorbalanceamento = 0;
  }

  // Sobrescreve o método getFilho_dir para retornar um nó AVL
  public AVL<T> getFilho_dir() {
    return (AVL<T>) super.getFilho_dir();
  }

  // Sobrescreve o método getFilho_esq para retornar um nó AVL
  public AVL<T> getFilho_esq() {
    return (AVL<T>) super.getFilho_esq();
  }

  // Retorna o fator de balanceamento de cada nó AVL
  public int getFB() {
    return this.fatorbalanceamento;
  }

  // Sobrescreve o método InserirOrdenado para atualizar o fator de balanceamento
  // após a inserção
  protected boolean InsereOrdenado(T v, AVL<T> nodepai) {
    boolean resultado;

    if (v.toString().compareTo(this.getValor().toString()) < 0) {
      // O valor deve ser inserido à esquerda do nó atual
      if (this.getFilho_esq() != null) {
        resultado = this.getFilho_esq().InsereOrdenado(v, this);
        this.verificarbalanceamento(nodepai); // Verifica o balanceamento e rotaciona, se necessário
        return resultado;
      } else {
        AVL<T> n = new AVL<T>(v);
        this.setEsq(n); // Se for nulo, cria um novo nó e adiciona como filho à esquerda
        return true;
      }
    } else {
      // O valor deve ser inserido à direita do nó atual
      if (this.getFilho_dir() != null) {
        resultado = this.getFilho_dir().InsereOrdenado(v, this);
        this.verificarbalanceamento(nodepai); // Verifica o balanceamento e rotaciona, se necessário
        return resultado;
      } else {
        AVL<T> n = new AVL<T>(v);
        this.setDir(n); // Se for nulo, cria um novo nó e adiciona como filho à direita
        return true;
      }
    }
  }

  protected boolean removerNode(T v, AVL<T> nodepai) {
    int comparacao = v.toString().compareTo(this.getValor().toString());
    boolean resultado = false;

    if (comparacao < 0) {
      if (this.getFilho_esq() != null) {
        resultado = this.getFilho_esq().removerNode(v, this); // O nó a ser removido está na subárvore esquerda
        this.verificarbalanceamento(nodepai); // Verifica o balanceamento e rotaciona, se necessário
        return resultado;
      } else
        resultado = false; // O valor não está na subárvore esquerda
    } else if (comparacao > 0) {
      if (this.getFilho_dir() != null) {
        resultado = this.getFilho_dir().removerNode(v, this); // O valor pode estar na subárvore direita
        this.verificarbalanceamento(nodepai); // Verifica o balanceamento e rotaciona, se necessário
        return resultado;
      } else
        resultado = false; // O valor não foi encontrado
    } else {
      // O nó a ser removido é o nó atual
      if ((this.getFilho_esq() == null) && (this.getFilho_dir() == null)) {
        // Este nó é uma folha, pois ambos os filhos são nulos
        this.setFilhoNode(nodepai, null); // Define o filho do pai como nulo
        resultado = true;
      } else if ((this.getFilho_esq() != null) && (this.getFilho_dir() == null)) {
        // O nó tem um filho à esquerda, mas o filho à direita é nulo
        this.setFilhoNode(nodepai, this.getFilho_esq()); // Define o pai do nó atual como o filho à esquerda do nó atual
        resultado = true;
      } else if ((this.getFilho_esq() == null) && (this.getFilho_dir() != null)) {
        // O nó tem um filho à direita, mas o filho à esquerda é nulo
        this.setFilhoNode(nodepai, this.getFilho_dir()); // Define o pai do nó atual como o filho à direita do nó atual
        resultado = true;
      } else if ((this.getFilho_esq() != null) && (this.getFilho_dir() != null)) {
        // Podemos usar um dos dois nós a seguir, tanto faz.
        // Node<String> nEsq = NodeComMaiorValor(nodeatual.getFilho_esq()); //pega o
        // node com maior valor da subárvore esquerda

        Node<T> menorNodeDir = this.getFilho_dir().NodeComMenorValor(); // Pega o nó com menor valor da subárvore à
                                                                        // direita
        Node<T> paiMenorNodeDir;
        if (menorNodeDir != this.getFilho_dir()) {
          paiMenorNodeDir = this.getFilho_dir().acharPai(menorNodeDir);
        } else
          paiMenorNodeDir = this;

        this.setValor(menorNodeDir.getValor()); // Coloca o novo valor no nó atual
        /*
         * Se menorNodeDir é o menor valor da subárvore à direita, então menorNodeDir
         * não
         * tem filhos à esquerda, porque
         * o menor valor de uma árvore é o nó mais à esquerda dessa árvore.
         * Sendo assim, já sabemos que menorNodeDir tem no máximo um filho à direita
         * ou é uma folha.
         * Podemos definir diretamente o filho (à direita) de paiMenorNodeDir como o
         * filho à direita de menorNodeDir
         */
        menorNodeDir.setFilhoNode(paiMenorNodeDir, menorNodeDir.getFilho_dir()); // Define o pai de menorNode como o
                                                                                 // filho à direita
        resultado = true;
      }
    }

    return resultado;
  }

  public AVL<T> acharPai(Node<T> noraiz) {
    return (AVL<T>) super.acharPai(noraiz);
  }

  // Calcula o fator de balanceamento do nó
  private int calculaFatorBalanceamento() {
    int alturaesq = 0;
    int alturadir = 0;
    if (this.getFilho_esq() != null)
      alturaesq = this.getFilho_esq().calculaAltura();
    if (this.getFilho_dir() != null)
      alturadir = this.getFilho_dir().calculaAltura();
    this.fatorbalanceamento = alturadir - alturaesq;
    return this.fatorbalanceamento;
  }

  private void verificarbalanceamento(AVL<T> nopai) {
    int fb = this.calculaFatorBalanceamento();
    int fb1 = 0;
    if ((fb < -1) || (fb > 1)) { // Verifica se há desbalanceamento
      if (fb > 1) { // O lado direito é bem maior
        if (this.getFilho_dir() != null) {
          fb1 = this.getFilho_dir().calculaFatorBalanceamento();
          if (fb1 < 0)
            this.rotacaoDuplaAEsquerda(nopai);
          else
            this.rotacaoAEsquerda(nopai);
        }
      } else { // fb < -1
        fb1 = 0;
        if (this.getFilho_esq() != null)
          fb1 = this.getFilho_esq().calculaFatorBalanceamento();
        if (fb1 > 0)
          this.rotacaoDuplaADireita(nopai);
        else
          this.rotacaoADireita(nopai);
      }
    }
  }

  // Implementação do algoritmo de rotação à esquerda
  private void rotacaoAEsquerda(AVL<T> nopaideA) {
    AVL<T> novaraizB = this.getFilho_dir(); // O filho da direita se torna a nova raiz
    AVL<T> tempA = this; // Raiz da rotação
    if (novaraizB != null) {
      nopaideA.setFilhoNode(this, novaraizB); // O filho da direita se torna a raiz
      tempA.setDir(novaraizB.getFilho_esq()); // O filho da esquerda da nova raiz se torna o filho da direita da antiga
                                              // raiz
      novaraizB.setDir(tempA); // O nó A se torna o filho da direita da nova raiz B
    }
  }

  // Implementação do algoritmo de rotação à direita
  private void rotacaoADireita(AVL<T> nopaideC) {
    AVL<T> novaraizB = this.getFilho_esq(); // O filho da esquerda se torna a nova raiz
    AVL<T> tempC = this; // Raiz da rotação
    if (novaraizB != null) {
      nopaideC.setFilhoNode(this, novaraizB); // O filho da esquerda se torna a raiz
      tempC.setEsq(novaraizB.getFilho_dir()); // O filho da direita da nova raiz se torna o filho da esquerda da antiga
                                              // raiz
      novaraizB.setDir(tempC); //
    }
  }

  // Rotação dupla é a chamada consecutiva de duas rotações simples
  private void rotacaoDuplaAEsquerda(AVL<T> nopaideA) {
    // Rotação simples à direita no filho da direita
    this.getFilho_dir().rotacaoADireita(this);
    // Rotação à esquerda na árvore original
    this.rotacaoAEsquerda(nopaideA);
  }

  // Rotação dupla é a chamada consecutiva de duas rotações simples
  private void rotacaoDuplaADireita(AVL<T> nopaideC) {
    // Rotação simples à esquerda no filho da esquerda
    this.getFilho_esq().rotacaoAEsquerda(this);
    // Rotação à direita na árvore original
    this.rotacaoADireita(nopaideC);
  }

  public void setFilhoNode(AVL<T> pai, AVL<T> filho) {
    if (pai.getFilho_esq() == this) {
      pai.setEsq(filho);
    } else if (pai.getFilho_dir() == this) {
      pai.setDir(filho);
    }
  }

  private Node<T> NodeComMenorValor() {
    if (this.getFilho_esq() == null) {
      return this;
    } else {
      return this.getFilho_esq().NodeComMenorValor();
    }
  }
}