package aula;

import java.util.concurrent.RecursiveTask;

public class BuscaCaminhos extends RecursiveTask<Integer> {

    int n;
    int m;
    int quantidade = 0;
    boolean div;

    public BuscaCaminhos(int n, int m, boolean estado) {
        this.n = n;
        this.m = m;
        this.div = estado;
    }

    public int contarCaminhos(int m, int n) {
        if (n == 0 && m == 0) {
            return 0;
        }
        if (n == 0 || m == 0) {
            return 1;
        }
        return (contarCaminhos(m - 1, n) + contarCaminhos(m, n - 1));
    }

    @Override
    protected Integer compute() {
        if (div == false) {
            BuscaCaminhos by = new BuscaCaminhos(m-1,n,true);
            BuscaCaminhos bx = new BuscaCaminhos(m,n-1,true);
            by.fork();
            bx.fork();
            quantidade += by.join();
            quantidade += bx.join();
        } else {
            quantidade = contarCaminhos(m, n);
        }
        return quantidade;
    }

}
