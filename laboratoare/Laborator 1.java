1. Sa scrie folosind editorul Notepad urmatorul program:
a) Sa se salveze programul in fisierul Test.java
b) Sa se compileze programul din linia de comanda
c) Sa se execute programul
->  public class Test {
		public static void main(String[] args) {
			System.out.println("Buna ziua tuturor");
		}
	}

2. Sa se compileze urmatorul program. Daca sunt erori, sa se corecteze.
->  public class Erori {
		public static void main(String[] args) {
			int a;
			a = 5;
			int b;
			b = 5;
			int c;
			c = a / b;
			System.out.println(c);
		}
	}

3. Sa se completeze urmatorul program pentru a calcula si afisa media aritmetica a 3 numere reale.
->  public class Medie {
		public static void main(String[] args) {
			double a, b, c, medie;
			a = 2.2;
			b = 3.3;
			c = 10;
			medie = (a+b+c)/3;
			System.out.println(medie);
		}
	}

4. Se da urmatoarea clasa. Ce valori afiseaza programul?
->  public class NumereIntregi {
		public static void main(String[] args) {
			int numarBaza10 = 267; // 267
			int valoareOpt = 0413; // 267
			int valoare16 = 0x10B; // 267
			int valoareBinara = 0b100001011; // 267
			System.out.println(numarBaza10 + valoareOpt); // 534
			System.out.println(valoare16 + valoareBinara); // 534
		}
	}

5. Se dau urmatoarele secvente de program. Ce afiseaza fiecare secventa?
-> a) Going Fishing!
   b) I'm doing anything but fishing!
   c) TRUE, FALSE, TRUE
   d) A pyramid sinker that weighs 3ounces is used for a moderate moving tide.

6. Se dă următoarea secvenţă de pseudocod:
ESTEINREGISTRATA := FALSE
FLOAT NOUAGREUTATE := 78.8
IF GREUTATE > NOUAGREUTATE
THEN ESTEINREGISTRATA:= TRUE
ELSE ESTEINREGISTRATA:= FALSE
ENDIF
a) Să se traduca pseudocodul în Java
b) Să se insereze codul Java obţinut la punctul anterior intr-o clasa care să fie compilată şi executată
->  public class Main {
		public static void main(String[] args) {
			boolean esteInregistrata = false;
			float nouaGreutate = 78.8f;
			float greutate = 80.0f;
			if(greutate > nouaGreutate){
				esteInregistrata = true;
				System.out.println(esteInregistrata);
			} else {
				System.out.println(esteInregistrata);
			}
		}
	}

7. Se dă următoarea secvenţă de pseudocod:
IF temperaturaApei este mai mare sau egala cu 30 THEN
suntPestiMulti := false //Pestii sunt putini
ELSEIF temperaturaApei este mai mica decat 30 dar mai mare decat 18 THEN
suntPestiMulti:= true //Pestii sunt multi
ELSEIF temperaturaApei este mai mica sau egala cu 18 THEN
suntPestiMulti:= false //Pestii sunt putini
ENDIF
a) Să se traduca pseudocodul în Java
b) Să se insereze codul Java obţinut la punctul anterior intr-o clasa care să fie compilată şi executată.
->  public class Main {
		public static void main(String[] args) {
			int temperaturaApei = 19;
			boolean suntPestiMulti = false;
			if(temperaturaApei >= 30){
				System.out.println("Pestii sunt putini");
			}else if(temperaturaApei < 30 && temperaturaApei > 18){
				suntPestiMulti = true;
				System.out.println("Pestii sunt multi");
			}else if(temperaturaApei <= 18){
				System.out.println("Pestii sunt putini");
			}
		}
	}

8. Se dă următoarea secvenţă de pseudocod:
locatie := Lacul Sinoe
IF locatie != NULL THEN
print "Loc de pescuit: " + locatie
ENDIF
a) Să se traduca pseudocodul în Java
b) Să se insereze codul Java obţinut la punctul anterior intr-o clasa care să fie compilată şi executată.
->  public class Main {
		public static void main(String[] args) {
			String locatie = "Lacul Sinoe";
			if(locatie != null){
				System.out.println("Loc de pescuit: " + locatie);
			}
		}
	}
