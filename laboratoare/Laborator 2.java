1. Care sunt valorile variabilelor dupa executarea fiecarei linii?
->       1) int j=1; int k=0;	    ->  1, 0
	 2) boolean b=true;         ->  true
	 3) double d=3.141;         ->  3.141
	 4) k=j++;                  ->  1
	 5) k=j--;                  ->  2
	 6) k=++j;                  ->  2
	 7) k=--j;                  ->  1
	 8) k=+(-1);                ->  -1
	 9) b=!true;                ->  false
	10) k=(int) d;              ->  3
	11) j=10;                   ->  10
	12) k=k+j*j-k/j%k;          ->  103
	13) k=j<<3;                 ->  80
	14) k=j>>4;                 ->  0
	15) k=j>>>5;                ->  0
	16) b=j<k;                  ->  false
	17) b=j>k;                  ->  true
	18) b=j<=k;                 ->  false
	19) b=j!=k;                 ->  true
	20) b=j==k;                 ->  false
	21) k=j|k;                  ->  10
	22) k=j&k;                  ->  10
	23) k=j^k;                  ->  0
	24) b=(j<0)&&((j%10)==3);   ->  false
	25) k=(j<0)?-j:j;           ->  10
	26) k+=j;                   ->  20
	27) k-=j;                   ->  10
	28) j^=j;                   ->  0

2. Care din urmatoarele fragmente de cod vor compila cu succes si vor afisa Egal la executie?
-> a, c

3. Care sunt valorile lui n si x dupa executarea fiecarei instructiuni?
-> n=1, x=4

4. Care sunt valorile lui n si x dupa executarea fiecarei instructiuni?
-> n=2, x=2

5. Sa se modifice urmatoarea secventa de cod astfel incat sa fie mai uşor de citit:
-> 	switch (x){
		case 100:
		case 101:
			System.out.println("x este mare ");
			break;
		case 10:
			System.out.println("x este mediu");
			break;
		case -1000:
			System.out.println("x este negativ");
			break;
	}

6. Ce valori au variabilele contor i si j pe linia 6?
-> a, c, f

7.Care sunt valorile variabilelor i si j pe linia 4?
-> b, c, d, f

8. Ce valoare are variabila c dupǎ executarea secvenţei de cod?
-> c

9. Să se scrie un program Java care calculeaza şi afişeaza suma numerelor intregi din intervalul [1,15].
->  public class Main {
		public static void main(String[] args) {
			int sum = 0;
			for (int i = 1; i <= 15; i++) {
				sum += i;
			}
			System.out.println(sum);
		}
	}

10. Să se scrie un program Java care calculeaza şi afişeaza produsul numerelor intregi pare din intervalul [1,20]. Dati mai multe solutii.
->  public class Main {
		public static void main(String[] args) {
			long produs = 1;
			for (int i = 1; i <= 20; i++) {
				if (i % 2 == 0) produs *= i;
			}
			System.out.println(produs);
		}
	}
->  public class Main {
		public static void main(String[] args) {
			long produs = 1;
			for (int i = 2; i <= 20; i = i + 2) {
				produs *= i;
			}
			System.out.println(produs);
		}
	}

11. Să se scrie un program Java care traduce numerele de la 1 la 12 în numele lunilor corespunzătoare: Ianuarie, Februarie, ..., Decembrie
->  import java.util.Random;
	public class Main {
		public static void main(String[] args) {
			int min = 1, max = 12;
			Random rand = new Random();
			int randomNum = rand.nextInt((max - min) + 1) + min;
			switch (randomNum) {
				case 1 -> System.out.println("Ianuarie");
				case 2 -> System.out.println("Februarie");
				case 3 -> System.out.println("Martie");
				case 4 -> System.out.println("Aprilie");
				case 5 -> System.out.println("Mai");
				case 6 -> System.out.println("Iunie");
				case 7 -> System.out.println("Iulie");
				case 8 -> System.out.println("August");
				case 9 -> System.out.println("Septembrie");
				case 10 -> System.out.println("Octombrie");
				case 11 -> System.out.println("Noiembrie");
				case 12 -> System.out.println("Decembrie");
			}
		}
	}
