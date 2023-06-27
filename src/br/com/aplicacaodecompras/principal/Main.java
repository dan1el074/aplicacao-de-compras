package br.com.aplicacaodecompras.principal;

import br.com.aplicacaodecompras.modelos.Compra;
import br.com.aplicacaodecompras.modelos.Conta;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = leitura.nextLine();
        System.out.println("Digite seu saldo: ");
        double novoLimite = leitura.nextDouble();

        Conta conta1 = new Conta(nome,novoLimite);
        conta1.mostraInfo();

        String menu = "-- Menu de interação -- \n1- Nova compra \n2- Sair";
        int sair = 0;

        while (sair != 2) {
            System.out.println("Novo produto: ");
            String novoProduto = leitura.next();

            System.out.println("Valor: ");
            double novoValor = leitura.nextDouble();

            Compra compra1 = new Compra(novoProduto,novoValor);
            boolean compraRealizada = conta1.lancaCompra(compra1);

            if (compraRealizada) {
                System.out.println("Compra realizada!\n");
                System.out.println(menu);
                sair = leitura.nextInt();
            } else {
                System.out.println("Saldo insuficiente!\n");
                sair = 2;
                leitura.close();
            }
        }

        System.out.println("*******************************");
        if(conta1.getCompras().size() > 0) {
            System.out.println("COMPRA FINALIZADA: \n");
            Collections.sort(conta1.getCompras());
            for (Compra compra : conta1.getCompras()) {
                System.out.println(compra);
            }
        } else {
            System.out.println("NENHUMA COMPRA REALIZADA!");
        }
        System.out.println("*******************************\n");
        System.out.printf("Saldo atual: R$%.2f \n",conta1.getSaldo());

    }
}
