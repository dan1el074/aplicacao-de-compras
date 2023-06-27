package br.com.aplicacaodecompras.principal;

import br.com.aplicacaodecompras.modelos.Compra;
import br.com.aplicacaodecompras.modelos.Conta;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do titular: ");
        String titular = scanner.nextLine();

        System.out.println("Digite seu saldo: ");
        double saldo = Double.parseDouble(scanner.nextLine());

        Conta conta1 = new Conta(titular,saldo);
        conta1.mostraInfo();

        int sair = 0;
        while (sair != 2) {
            System.out.println("Nome do produto: ");
            String produto = scanner.nextLine();

            System.out.println("Valor do produto: ");
            double valor = Double.parseDouble(scanner.nextLine());

            Compra compra1 = new Compra(produto,valor);
            boolean compraRealizada = conta1.validaCompra(compra1);
            String menu = "-- Menu de ações -- \n1- Nova compra \n2- Sair";

            if (compraRealizada) {
                System.out.println("Compra realizada! \n");
                System.out.println(menu);
                sair = Integer.parseInt(scanner.nextLine());
            } else {
                System.out.println("Saldo insuficiente!");
                System.out.println("Saldo atual: R$" + conta1.getSaldo() + "\n");
                System.out.println(menu);
                sair = scanner.nextInt();
            }
        }

        System.out.println("******************************* \nCOMPRA FINALIZADA! \n");

        Collections.sort(conta1.getCompras());
        for (Compra c: conta1.getCompras()) {
            System.out.println(c);
        }
        System.out.println("******************************* \n");
    }
}
