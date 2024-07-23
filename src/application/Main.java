package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of tax payers: ");
		int n = sc.nextInt();
		List<TaxPayer> list = new ArrayList<>();
		for (int i = 1; i<=n; i++) {
			System.out.println("Tax payer #"+i+" data");
			System.out.println("Individual or company(i/c)?");
			char chose = sc.next().charAt(0);
			System.out.println("Name: ");
			String name = sc.next();
			System.out.println("Anual Income: ");
			double anualIncome = sc.nextDouble();
			if (chose == 'i') {
				System.out.println("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, anualIncome, healthExpenditures));
				
		}
			else {
				
				System.out.println("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				list.add(new Company(name, anualIncome,numberOfEmployees));
			}
		}
		
		System.out.println("TAXES PAID: ");
		double sum = 0;
		for (TaxPayer taxpayer : list) {
			System.out.println("Name: "+ taxpayer.getName()+" $"+String.format(" %.2f",taxpayer.tax()));
			sum = sum + taxpayer.tax();
		}
		System.out.println(sum);
		sc.close();
	}

}
