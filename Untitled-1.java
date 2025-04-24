// Para ler e escrever dados em Java, aqui na DIO padronizamos da seguinte forma: 
// - new Scanner(System.in): cria um leitor de Entradas, com métodos úteis com prefixo "next";
// - System.out.println:.imprime um texto de Saída (Output) e pulando uma linha.

import java.util.Scanner;

abstract class Conta {
    protected double saldo; 

    
    public Conta(double saldo) {
        this.saldo = saldo;
    }

    
    public abstract void sacar(double valor);

    
    public void exibirSaldo() {
        System.out.printf("Saldo Atual: %.2f%n", saldo);
    }
}


class ContaCorrente extends Conta {
    private double limite; 
        
    public ContaCorrente(double saldo, double limite) {
        super(saldo);
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) {
        // TODO: Implemente a lógica para verificar se o saque é permitido considerando o saldo e o limite:
        // Dica: Se saldo - valor >= -limite, o saque é permitido.
       


        exibirSaldo(); // Exibe o saldo atualizado
    }
}


class ContaPoupanca extends Conta {

    public ContaPoupanca(double saldo) {
        super(saldo);
    }

    // Implementação do método sacar para Conta Poupança
    @Override
    public void sacar(double valor) {
        // TODO: Implemente a lógica para verificar se o saque é permitido considerando apenas o saldo:
        // Dica: Se saldo >= valor, o saque é permitido.
        

        exibirSaldo(); // Exibe o saldo atualizado
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String tipoConta = scanner.next(); // Corrente ou Poupanca
        String nome = scanner.next(); // Nome do titular
        String numero = scanner.next(); // Número da conta (não utilizado)
        double saldoInicial = scanner.nextDouble(); // Saldo inicial

        Conta conta;

        if (tipoConta.equalsIgnoreCase("Corrente")) {
            double limite = scanner.nextDouble(); // Limite para conta corrente
            conta = new ContaCorrente(saldoInicial, limite);
        } else {
            conta = new ContaPoupanca(saldoInicial);
        }

        while (scanner.hasNextDouble()) {
            double valorSaque = scanner.nextDouble();
            conta.sacar(valorSaque);
        }

        scanner.close();
    }
}
