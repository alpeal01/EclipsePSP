package es.floridauniversiraria.T1Actividades;
import java.util.Scanner;

public class Ej11 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		char abc[] = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
		int num = sc.nextInt();
		int resto = num % 23;
		
		char let = abc[resto];
		
		System.out.print(num);
		System.out.println(let);
		
		sc.close();
	}
		

}
