public class ARVOREBINARIABUSCA<T> {

    private Node<T> raiz;

    public ARVOREBINARIABUSCA(Node<T> r) {
        raiz = r;
    }

    public ARVOREBINARIABUSCA(T valor) {
        raiz = new Node<T>(valor);
    }

    public Node<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(Node<T> novaraiz) {
        this.raiz = novaraiz;
    }

    public void imprimirPreOrdem() {
        raiz.imprimePreOrdem();
    }

    public void imprimirInOrdem() {
        raiz.imprimeInOrdem();
    }

    public void imprimirPosOrdem() {
        raiz.imprimePosOrdem();
    }

    public void imprimirEmLargura() throws Exception {
        raiz.imprimeEmLargura();
    }

    public void imprimirEmLarguraRecursivo() throws Exception {
        raiz.imprimeEmLarguraRecursivo(new FilaEncadeada());
    }

    public void imprimirEmLarguraInvertido() throws Exception {
        raiz.imprimeEmLarguraInvertido();
    }

    public int calculaAltura() {
        return raiz.calculaAltura();
    }

    public int calculaAlturaEmLargura() throws Exception {
        return raiz.calculaAlturaEmLargura();
    }

    public boolean InsereOrdenado(T v) {
        return raiz.InsereOrdenado(v);
    }

    public Node<T> pesquisarValor(T v) {
        return raiz.pesquisarValor(v);
    }

    // public boolean removerNode(T v) {
    // return raiz.removerNode(v, raiz);
    // }

    public int calculaTotalNodes() {
        return raiz.calculaTotalNodes();
    }

    public int calculaTotalNodesFolhas() {
        return raiz.calculaTotalNodesFolhas();
    }

    public static int buscaBinaria(int[] vetorbusca, int x_aprocurar, int minvetor, int maxvetor) {
        if (minvetor > maxvetor)
            return -1;

        int meiovetor = (minvetor + maxvetor) / 2;

        if (vetorbusca[meiovetor] < x_aprocurar)
            return buscaBinaria(vetorbusca, x_aprocurar, meiovetor + 1, maxvetor);
        else if (vetorbusca[meiovetor] > x_aprocurar)
            return buscaBinaria(vetorbusca, x_aprocurar, minvetor, meiovetor - 1);
        else
            return meiovetor;
    }

}
