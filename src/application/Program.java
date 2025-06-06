package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.BusinessException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Informe dados da Conta:");
		System.out.print("Numero: ");
		int numeroConta = sc.nextInt();
		System.out.print("Titular: ");
		sc.nextLine();
		String titular = sc.nextLine();
		System.out.print("Saldo Inicial: ");
		double saldoInicial = sc.nextDouble();
		System.out.print("Limite de Saque: ");
		double limite = sc.nextDouble();
		
		Account acc = new Account(numeroConta, titular, saldoInicial, limite);
		
		System.out.println();
		System.out.print("Informe uma quantia para sacar: ");
		double amount = sc.nextDouble();
		
		try {
			acc.withdraw(amount);
			System.out.printf("Novo saldo:  " + String.format("%.2f%n", acc.getBalance()));
		}
		catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	}
}
