package es.floridauniversitaria.T2Actividades;

class Act1 {

	int sumador(int num1, int num2) {
		int sum = 0;
		
		
		System.out.println("Sumando de " + num1 + " hasta " + num2);
		for (int i = num1; i <= num2; i++) {

			sum += i;

		}

		return sum;

	}

	public static void main(String[] args) {

		Act1 act1 = new Act1();

		int sum = act1.sumador(Integer.parseInt(args[0]),Integer.parseInt(args[1]));

		System.out.println(sum);

	}

}