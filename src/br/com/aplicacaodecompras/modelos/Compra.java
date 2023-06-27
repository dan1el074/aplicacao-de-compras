package br.com.aplicacaodecompras.modelos;

public class Compra implements Comparable<Compra>{
    private String descricao;
    private double valor;

    public Compra(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        String texto = "Produto: %s - R$%.2f".formatted(descricao,valor);
        return texto;
    }

    @Override
    public int compareTo(Compra outraCompra) {
        if (this.valor > outraCompra.valor) {
            return -1;
        } else if (this.valor < outraCompra.valor) {
            return 1;
        } else {
            return 0;
        }
    }
}
