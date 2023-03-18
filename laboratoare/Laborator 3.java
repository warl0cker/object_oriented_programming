/*
 * 1. Sa se scrie un program care memoreaza doua numere întregi citite din ferestre JOptionPane si contine metode care
 * calculeaza si returneaza suma, diferenta, produsul, maximul si minimul dintre numere. Sa se testeze executia metodelor
 * apelându-le din metoda main a clasei si afisând valorile furnizate de metode.
 */
import javax.swing.JOptionPane;
public class Main {
    private int n1, n2;
    public void citesteNumere() {
        String input1 = JOptionPane.showInputDialog("Introduceti primul numar:");
        String input2 = JOptionPane.showInputDialog("Introduceti al doilea numar:");
        n1 = Integer.parseInt(input1);
        n2 = Integer.parseInt(input2);
    }
    public int getSuma() {
        return n1 + n2;
    }
    public int getDiferenta() {
        return n1 - n2;
    }
    public int getProdus() {
        return n1 * n2;
    }
    public int getMaxim() {
        return Math.max(n1, n2);
    }
    public int getMinim() {
        return Math.min(n1, n2);
    }
    public static void main(String[] args) {
        Main rez = new Main();
        rez.citesteNumere();
        int suma = rez.getSuma();
        int diferenta = rez.getDiferenta();
        int produs = rez.getProdus();
        int maxim = rez.getMaxim();
        int minim = rez.getMinim();
        JOptionPane.showMessageDialog(null, "Suma: "+suma+"\n"+"Diferenta: "+diferenta+"\n"+"Produsul: "+produs+"\n"+"Maximul: "+maxim+"\n"+"Minimul: "+minim);
    }
}


/*
 * 2. Sa se implementeze urmatoarele metode:
 * - metoda “transformaInGradeCelsius” returneaza temperatura in grade Celsius echivalenta cu temperatura Fahrenheit
 * folosind formula: C=5/9 * (F-32) ;
 * - metoda “transformaInGradeFahrenheit“ returneaza temperatura in grade Fahrenheit echivalenta cu temperatura Celsius
 * folosind formula: F=9/5 *C+32 ;
 * Folositi aceste metode pentru a scrie un program care primeste din linia de comanda sau dintr-o fereastra de tip JOptionPane
 * doua valori reale ce reprezinta temperaturi Celsius, respectiv Fahrenheit si afiseaza temperatura echivalenta in celalalt
 * sistem de temperaturi.
 */
import javax.swing.JOptionPane;
public class Main {
    public static double transformaInGradeCelsius(double F) {
        return (5.0/9.0) * (F - 32);
    }
    public static double transformaInGradeFahrenheit(double C) {
        return (9.0/5.0) * C + 32;
    }
    public static void main(String[] args) {
        String valoareC = JOptionPane.showInputDialog("Introduceti o temperatura in Celsius:");
        double C = Double.parseDouble(valoareC);
        String valoareF = JOptionPane.showInputDialog("Introduceti o temperatura in Fahrenheit:");
        double F = Double.parseDouble(valoareF);
        double c1 = transformaInGradeFahrenheit(C);
        double f2 = transformaInGradeCelsius(F);
        JOptionPane.showMessageDialog(null, C+" grade Celsius este egal cu "+c1+" grade Fahrenheit.\n"+F+" grade Fahrenheit este egal cu "+f2+" grade Celsius.");
    }
}


/*
 * 3. Scrieti o metoda numita afiseazaPatratStea care afiseaza un patrat umplut cu simbolul “*” a carui latura este specificata ca
 * parametru al metodei. Incorporati aceasta metoda intr-un program care preia din linia de comanda o valoare intreaga pentru
 * latura si realizeaza afisarea patratului prin apelarea metodei patratStea.
 */
public class Main {
    public static void afiseazaPatratStea(int latura) {
        for (int i = 0; i < latura; i++) {
            for (int j = 0; j < latura; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Introduceti o lungime a laturii patratului");
            return;
        }
        int latura = Integer.parseInt(args[0]);
        afiseazaPatratStea(latura);
    }
}


/*
 * 4. Modificati metoda “afiseazaPatratStea” din problema anterioara pentru a desena patrate formate cu orice caracter specificat
 * in semnatura metodei.
 */
public class Main {
    public static void afiseazaPatratStea(int latura, char ch) {
        for (int i = 0; i < latura; i++) {
            for (int j = 0; j < latura; j++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Introduceti o lungime a laturii patratului si un caracter");
            return;
        }
        int latura = Integer.parseInt(args[0]);
        char ch = args[1].charAt(0);
        afiseazaPatratStea(latura, ch);
    }
}


/*
 * 5. Un numar intreg se numeste numar perfect daca divizorii sai (inclusiv 1), mai mici strict decat numarul respectiv, adunati
 * dau numarul. De exemplu 6=1+2+3 este un numar perfect. Scrieti o metoda “perfect” care determina daca parametrul numar
 * este perfect. Folositi aceasta metoda intr-un program care determina si afiseaza toate numerele perfecte intre 1 si 1000. Care
 * sunt numerele perfecte intre 1 si 10 000 ?
 */
public class Main {
    public static boolean perfect(int n) {
        int sum = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i * i != n) sum += n / i;
            }
        }
        return sum == n && n != 1;
    }
    public static void main(String[] args) {
        System.out.println("Numerele perfecte intre 1 si 1000 sunt:");
        for (int i = 1; i <= 1000; i++) {
            if (perfect(i)) System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Numerele perfecte intre 1 si 10000 sunt:");
        for (int i = 1; i <= 10000; i++) {
            if (perfect(i)) System.out.print(i + " ");
        }
        System.out.println();
    }
}


/*
 * 6. Valoarea lui e^x poate fi calculata cu urmatoarea formula:
 * e^x = x^n/n! = 1+x+x^2/2!+x^3/3!+..., n=0, infinit
 */
public class Main {
    public static long factorial(long a) {
        long p = 1;
        for (int i = 1; i <= a; i++) p *= i;
        return p;
    }

    public static double calcul(int nr, double epsilon) {
        double suma = 0;
        int i = 0;
        while (true) {
            long produs;
            suma += Math.pow(nr, i);
            produs = factorial(i);
            suma /= produs;
            i++;
            if (suma < epsilon) break;
        }
        return suma;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Introduceti doua numere: ");
            return;
        }
        int nr = Integer.parseInt(args[0]);
        double epsilon = Integer.parseInt(args[1]);
        System.out.println("Suma este: " + calcul(nr, epsilon));
    }
}


/*
 * 7. Se considera urmatorul program:
 *    1. public class Test1{
 *    2.     public float oMetoda (float a, float b){return 0.0; }
 *    3.
 *    4. }
 * Care din urmatoarele metode sunt corecte daca se adauga (câte una) pe linia 3?
 * a) public int oMetoda (int a, int b){}
 * b) public float oMetoda (float a, float b){}
 * c) public float oMetoda (float a, float b, int c) throws Exception{}
 * d) public float oMetoda (float c, float d){}
 * e) public float oMetoda (int a, int b, int c){}
 */
 - a) este corecta. Acesta este un exemplu de supraincarcare a metodei, in care o noua metoda cu acelasi nume ca o
      metoda existenta este adaugata in clasa, dar cu parametri diferiti. in acest caz, parametrii sunt modificati de
      la float la int, deci este o supraincarcare valida.
 - b) nu este corecta deoarece exista deja in clasa. Este aceeasi metoda cu cea definita in clasa, deci nu este o
      metoda noua.
 - c) este corecta. Acesta este un alt exemplu de supraincarcare a metodei, dar cu un parametru suplimentar si o
      noua declaratie de exceptie. Acest lucru este valabil deoarece modifica semnatura metodei, facand-o distincta
      de metoda existenta in clasa.
 - d) este corecta. Acesta este un alt exemplu de supraincarcare a metodei, in care parametrii sunt modificati de
      la a si b la c si, respectiv, d. Aceasta creeaza o noua metoda care este diferita de metoda existenta in clasa.
 - e) nu este corecta. Desi modifica numarul si tipurile de parametri, are aceeasi semnatura de metoda ca metoda
      existenta in clasa. Prin urmare, nu este o metoda noua si va duce la o eroare de compilare.


/*
 * 8. Sa se scrie trei metode supraîncarcate care calculeaza volumul unei sfere, cub, respectiv al unui tetraedru regulat. Metodele
 * contin un parametru care reprezinta raza sferei, respectiv latura cubului/tetraedrului regulat. Acest parametru va fi preluat
 * din linia de comanda sau dintr-o fereastra de tip JOptionPane.
 * Observatii. 1. Pentru constanta pi se va folosi constanta Math.PI.
 *             2. Vol(cub)=(a*a*a), Vol(sfera)=4piR3/3; vol(tetraedru)=(a*a*a) radical(2/12)
 */
import java.lang.Math;
public class Main {
    public static double volum(double a) {
        return a * a * a;
    }
    public static double volum(int raza, double pi) {
        return (4 * pi * raza * raza * raza) / 3;
    }
    public static double volum(int a) {
        return a * a * a * Math.sqrt(2) / 12;
    }
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Introduceti doua numere: ");
            return;
        }
        int x = Integer.parseInt(args[0]);
        int latura = Integer.parseInt(args[1]);
        System.out.println("Volum cub: " + volum((double) x));
        System.out.println("Volum sfera: " + volum(latura, Math.PI));
        System.out.println("Volum tetraedru: " + volum(latura));
    }
}


/*
 * 9. Se preiau din lina de comanda numerele n si k (numere naturale n>k). Calculati recursiv utilizând formula de recurenta.
 */
public class Main {
    public static int recursiv(int n, int k) {
        if (k == 0 || n == k) return 1;
        return recursiv(n - 1, k - 1) + recursiv(n - 1, k);
    }
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Introduceti doua numere: ");
            return;
        }
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        if (n <= k) {
            System.out.println("Primul nr trebuie sa fie mai mare decat al doilea nr");
        } else {
            System.out.print(recursiv(n, k));
        }
    }
}


/*
 * 10. Sa se scrie un program care calculeaza si afiseaza c.m.m.d.c dintre 2 numere intregi preluate din linia de comanda, folosind
 * urmatoarea definitie recursiva:
 * cmmdc(u,v) = { cmmdc(v, u mod v), daca v != 0
 *              { u daca v = 0
 */
public class Main {
    public static int cmmdc(int u, int v) {
        if (v == 0) return u;
        return cmmdc(v, u % v);
    }
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Introduceti doua numere intregi: ");
            return;
        }
        int nr1 = Integer.parseInt(args[0]);
        int nr2 = Integer.parseInt(args[1]);
        System.out.println("Cel mai mic divizor al lui " + nr1 + " este: " + cmmdc(nr1, nr2));
    }
}


/*
 * 11. Sa se scrie un program care calculeaza si afiseaza a la puterea b dupa formula:
 * P(a,b) = { 1, daca b = 0
 * 	        { a * P(a, b-1), altfel
 */
public class Main {
    public static int P(int a, int b) {
        if (b == 0) return 1;
        return a * P(a, b - 1);
    }
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Introduceti un numar si puterea lui");
            return;
        }
        int nr = Integer.parseInt(args[0]);
        int p1 = Integer.parseInt(args[1]);
        System.out.println("Numarul " + nr + " ridicat la puterea " + p1 + " este: " + P(nr, p1));
    }
}


/*
 * 12. Fie definitia functiei lui Ackerman, ac: N x N -> N
 * ac(m, n) = { n+1, daca m = 0
 *            { ac(m-1, 1), daca n = 0
 *            { ac(m-1, ac(m, n-1)), daca m,n > 0
 * Sa se scrie un program care calculeaza si afiseaza ac(2,2).
 */
public class Main {
    public static int ac(int m, int n) {
        if (m == 0) return n + 1;
        else if (n == 0) return ac(m - 1, 1);
        else return ac(m - 1, ac(m, n - 1));
    }
    public static void main(String[] args) {
        System.out.println("Rezultatul este: " + ac(2, 2));
    }
}
