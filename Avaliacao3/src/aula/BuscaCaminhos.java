package aula;

import java.util.concurrent.RecursiveTask;

public class BuscaCaminhos extends RecursiveTask<Integer> {

    int n;
    int m;
    int quantidade = 0;

    public BuscaCaminhos(int n, int m) {
        this.n = n;
        this.m = m;
    }

    public int contarCaminhos(int m, int n) {
        if (n == 0 && m == 0) {
            return 0;
        }
        if (n == 0 || m == 0) {
            return 1;
        }
        return (contarCaminhos(m-1, n) + contarCaminhos(m, n - 1));
    }

    @Override
    protected Integer compute() {

        if (m == 0 && n == 0) {
            contarCaminhos(m, n);
        } else if (this.m > 0 || this.n > 0) {
            quantidade += contarCaminhos(m, n);
        }else{
            BuscaCaminhos by = new BuscaCaminhos(1,2);
            BuscaCaminhos bx = new BuscaCaminhos(2,1);
            by.fork();
            bx.fork();
            by.join();
            bx.join();
        }
            return quantidade;
        }

    }
