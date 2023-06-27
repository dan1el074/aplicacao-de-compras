package br.com.aplicacaodecompras.modelos;

import java.util.ArrayList;
import java.util.List;

public class Conta {
    private String titular;
    private double limite;
    private double saldo;
    private List<Compra> compras;

    public Conta(String titular, double limite) {
        this.titular = titular;
        this.limite = limite;
        this.saldo = limite;
        compras = new ArrayList<Compra>();
    }

    public void mostraInfo() {
        String info = "\n*******************************\nTitular: %s \nSaldo: R$%.2f \n******************************* \n".formatted(titular,saldo);
        System.out.println(info);
    }

    public boolean validaCompra (Compra compra) {
        if (this.saldo > compra.getValor()) {
            this.saldo -= compra.getValor();
            this.compras.add(compra);
            return true;
        }

        return false;
    }


    public double getSaldo() {
        return saldo;
    }

    public List<Compra> getCompras() {
        return compras;
    }
}
