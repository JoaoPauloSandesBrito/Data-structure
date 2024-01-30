public class ARVOREAVL<T> extends ARVOREBINARIABUSCA<T> {

       public ARVOREAVL(AVL<T> r) {
              super(r);
       }

       public ARVOREAVL(T valor) {
              super(new AVL<T>(valor));
       }

       public AVL<T> getRaiz() {
              return (AVL<T>) super.getRaiz();
       }

       public void setRaiz(AVL<T> novaraiz) {
              super.setRaiz(novaraiz);
       }

       public AVL<T> pesquisarValor(T v) {
              return (AVL<T>) super.pesquisarValor(v);
       }

       public boolean InsereOrdenado(T v) {
              AVL<T> raiz = this.getRaiz();
              return raiz.InsereOrdenado(v, raiz);
       }

}