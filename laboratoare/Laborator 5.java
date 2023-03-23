/**
 * 
 * 1. Sa se creeze un tablou uni-dimensional care memoreaza 20 de numere generate aleator, fiecare intre
 * 10 si 100, inclusiv. Pe masura ce un numar este generat si memorat, este afisat numai daca nu este un
 * duplicat al unui numar deja memorat.
 * 
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
public class TablouUniDimensional {
    public static void main(String[] args) {
        int[] randomArray = new int[20];
        Random random = new Random();
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int i = 0; i < randomArray.length; i++) {
            int randomNumber;
            do {
                randomNumber = random.nextInt(91) + 10;
            } while (uniqueNumbers.contains(randomNumber));
            uniqueNumbers.add(randomNumber);
            randomArray[i] = randomNumber;
        }
        System.out.println("Numere generate aleator: " + Arrays.toString(randomArray));
    }
}



/**
 * 
 * 2. Creati clasa MultimeIntregi. Fiecare obiect al clasei poate pastra 10 numere intregi intre 0 si 9. O
 * multime este reprezentata intern ca un tablou de 1 si 0-uri. De exp, elementul a[i]=1 daca numarul i
 * apartine multimii, altfel a[i]=0. Un constructor al clasei nu are parametri si initializeaza multimea
 * vida, adica o multime a carui tablou are numai elemente nule. Al doilea constructor al clasei
 * initializeaza tabloul ce memoreaza elementele multimii, cu ajutorul tabloului transmis ca parametru
 * formal. Al treilea constructor are un parametru int si creaza si initializeaza multimea cu elemente
 * generate aleator.
 * Furnizati urmatoarele metode :
 * - reuneste MultimiIntregi creaza o alta multime care este teoretic reuniunea celor doua multimi date (a
 * doua multime este data ca parametru al metodei) (ie, un element din tabloul celei de-a treia multimi
 * este setat cu 1, daca acel element este 1 in una sau ambele multimi),
 * - intersecteaza MultimiIntregi creaza o alta multime care este teoretic intersectia celor doua multimi
 * (ie, un element din tabloul celei de-a treia multimi este setat cu 1, daca acel element este 1 in ambele
 * multimi),
 * - insereazaElement insereaza un nou numar intreg k in multime (ie a[k]=1),
 * - stergeElement sterge numarul j (a[j]=0) dat ca parametru al metodei,
 * - suntEgale determina daca doua multimi sunt egale.
 * - afiseaza multimea ca o lista de numere separate prin spatii.
 * Afisati '---' pentru multimea vida. Scrieti un program care testeaza aceasta clasa.
 *
 */
import java.util.Arrays;
import java.util.Random;
public class MultimeIntregi {
    private final int[] set;
    public MultimeIntregi() {
        set = new int[10];
    }
    public MultimeIntregi(int[] elements) {
        set = new int[10];
        for (int element : elements) {
            if (element >= 0 && element <= 9) set[element] = 1;
        }
    }
    public MultimeIntregi(int size) {
        set = new int[10];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int element = random.nextInt(10);
            set[element] = 1;
        }
    }
    public MultimeIntregi merge(MultimeIntregi other) {
        int[] mergedSet = new int[10];
        for (int i = 0; i < 10; i++) {
            if (set[i] == 1 || other.set[i] == 1) mergedSet[i] = 1;
        }
        return new MultimeIntregi(mergedSet);
    }
    public MultimeIntregi intersects(MultimeIntregi other) {
        int[] intersectedSet = new int[10];
        for (int i = 0; i < 10; i++) {
            if (set[i] == 1 && other.set[i] == 1) intersectedSet[i] = 1;
        }
        return new MultimeIntregi(intersectedSet);
    }
    public void insereazaElement(int k) {
        if (k >= 0 && k <= 9) set[k] = 1;
    }
    public void stergeElement(int j) {
        if (j >= 0 && j <= 9) set[j] = 0;
    }
    public boolean suntEgale(MultimeIntregi other) {
        return Arrays.equals(set, other.set);
    }
    public void display() {
        boolean isEmpty = true;
        for (int i = 0; i < 10; i++) {
            if (set[i] == 1) {
                System.out.print(i + " ");
                isEmpty = false;
            }
        }
        if (isEmpty) System.out.print("---");
        System.out.println();
    }
}
public class MultimeIntregiTest {
    public static void main(String[] args) {
        MultimeIntregi set1 = new MultimeIntregi();
        set1.insereazaElement(3);
        set1.insereazaElement(5);
        set1.insereazaElement(7);
        set1.display();
        MultimeIntregi set2 = new MultimeIntregi(new int[] {2, 4, 6, 8});
        set2.display();
        MultimeIntregi set3 = new MultimeIntregi(5);
        set3.display();
        MultimeIntregi set4 = set1.merge(set2);
        set4.display();
        MultimeIntregi set5 = set1.intersects(set2);
        set5.display();
        set1.stergeElement(5);
        set1.display();
        System.out.println(set1.suntEgale(set2));
        System.out.println(set1.suntEgale(new MultimeIntregi(new int[] {3, 7})));
    }
}



/**
 *
 * 3. Sa se scrie un program care contine o clasa numita Parola ce contine o metoda ce genereaza parola
 * unui utilizator, folosind numele şi prenumele său, precum si data de nastere a acestuia. Programul va
 * realiza urmatoarele operatii:
 * a. cere utilizatorului sa introduca numele si prenumele său,
 * b. cere utilizatorului sa introduca data de naştere în format dd/mm/yyyy,
 * c. afiseaza parola.
 * Parola va fi generatǎ dupa urmatorul algoritm: primele doua litere din nume vor fi concatenate cu
 * ultimele 2 cifre ale datei de naştere şi cu ultimele 2 litere din prenumele utilizatorului.
 * Indicatie: Informatiile cerute utilizatorului vor fi preluate prin intermediul ferestrei ce apare cand este
 * apelata metoda statica JOptionPane.showInputDialog(String) din pachetul javax.swing.
 *
 */
import javax.swing.JOptionPane;
public class Password {
    public static void generatePassword() {
        String firstName = JOptionPane.showInputDialog("Introduceti Prenumele:");
        String lastName = JOptionPane.showInputDialog("Introduceti Numele:");
        String dateOfBirth = JOptionPane.showInputDialog("Introduceti data nasterii in format (dd/mm/yyyy):");
        String[] dateParts = dateOfBirth.split("/");
        String password = firstName.substring(0, 2) + dateParts[2].substring(2) + lastName.substring(lastName.length() - 2);
        JOptionPane.showMessageDialog(null, "Parola dumneavoastra este: " + password);
    }
    public static void main(String[] args) {
        Password.generatePassword();
    }
}



/**
 *
 * 4. Fie un sir preluat din linia de comanda sau dintr-o fereastra de tip InputDialog. Verificati ca acest sir
 * este o adresa de e-mail valida de forma User_name@provider_name.extension (e.g.,
 * vasile@yahoo.com sau mailto:vasile@univ-galati.ro). In caz afirmativ, afisati numele utilizatorului si
 * numele provider-ului. Altfel, afisati un mesaj de eroare.
 *
 */
import javax.swing.JOptionPane;
public class EmailValidator {
    public static void main(String[] args) {
        String email = JOptionPane.showInputDialog("Introduceti adresa de email:");
        String[] parts = email.split("@");
        if (parts.length != 2) {
            JOptionPane.showMessageDialog(null, "Adresa de email este invalida");
            return;
        }
        String[] providerParts = parts[1].split("\\.");
        if (providerParts.length < 2 || providerParts.length > 4) {
            JOptionPane.showMessageDialog(null, "Adresa de email este invalida");
            return;
        }
        JOptionPane.showMessageDialog(null, "Numele utilizatorului: " + parts[0] + "\nNumele furnizorului: " + parts[1]);
    }
}



/**
 *
 * 5. Să se scrie două metode ale clasei Poligon:
 * public double calculeazaPerimetru() {. . .} şi
 * public double calculeazaArie() {. . .}
 * care calculează perimetrul şi aria unui poligon. Pentru a calcula perimetrul, calculaţi distanţa dintre
 * punctele adiacente şi adunaţi aceste distanţe. Aria unui poligon cu punctele (x0, y0), ..., (xn-1, yn-1) este:
 * |x0y1+x1y2+x2y3+...+xn-1y0-y0x1-y1x2-...-yn-1x0|/2
 *
 */
import java.awt.Point;
public class Poligon {
    private final Point[] puncte;
    public Poligon(Point[] puncte) {
        this.puncte = puncte;
    }
    public double calculeazaPerimetru() {
        double perimetru = 0.0;
        for (int i = 0; i < puncte.length; i++) {
            Point p1 = puncte[i];
            Point p2 = puncte[(i + 1) % puncte.length];
            double distanta = p1.distance(p2);
            perimetru += distanta;
        }
        return perimetru;
    }
    public double calculeazaArie() {
        double arie = 0.0;
        for (int i = 0; i < puncte.length; i++) {
            Point p1 = puncte[i];
            Point p2 = puncte[(i + 1) % puncte.length];
            arie += (p1.getX() * p2.getY()) - (p2.getX() * p1.getY());
        }
        return Math.abs(arie) / 2;
    }
    public static void main(String[] args) {
        Point[] puncte = {new Point(0, 0), new Point(0, 3), new Point(4, 0)};
        Poligon poligon = new Poligon(puncte);
        System.out.println("Perimetru: " + poligon.calculeazaPerimetru());
        System.out.println("Arie: " + poligon.calculeazaArie());
    }
}



/**
 *
 * 6. Folosind structura de tablou, sǎ se implementeze o mulţime M de puncte din plan. Ştim cǎ un punct
 * din plan este caracterizat prin coordonatele sale (x, y). Fie P un alt punct din plan care nu aparţine
 * multimii M. Coordonatele punctul P se vor prelua dintr-o fereastra de tip JOptionPane. Să se
 * determine şi să afişeze coordonatele punctului din M care se află la cea mai mică distanţă de P.
 * Indicaţie: distanţa(p1, p2)=sqrt((p1.x-p2.x)2+(p1.y-p2.y)2)
 *
 */
import javax.swing.JOptionPane;
import java.awt.Point;
public class Main {
    public static double distance(Point p1, Point p2) {
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
    public static void main(String[] args) {
        Point[] M = {new Point(1, 2), new Point(3, 4), new Point(-1, 5)};
        int x = Integer.parseInt(JOptionPane.showInputDialog("Introduceti coordonata x a lui P: "));
        int y = Integer.parseInt(JOptionPane.showInputDialog("Introduceti coordonata y a lui P: "));
        Point P = new Point(x, y);
        Point closestPoint = M[0];
        double minDistance = distance(P, closestPoint);
        for (int i = 1; i < M.length; i++) {
            double d = distance(P, M[i]);
            if (d < minDistance) {
                minDistance = d;
                closestPoint = M[i];
            }
        }
        JOptionPane.showMessageDialog(null, "Cel mai apropiat punct din M la P este (" + closestPoint.x + ", " + closestPoint.y + ")\n");
    }
}


/**
 *
 * 7. O companie aeriana foloseste un sistem automat de rezervare a locurilor unui avion. Sa se scrie un
 * program care realizeaza acest lucru pentru un singur avion cu capacitatea de 10 locuri la fiecare zbor.
 * Folosind o fereastra JOptionPane, programul ar trebui sa afiseze urmatorul meniu de alternative:
 * Alegeti 1 pentru sectiunea de Fumatori
 * Alegeti 2 pentru sectiunea de Nefumatori
 * Daca persoana scrie cifra 1, atunci programul ar trebui sa rezerve un loc in sectiunea fumatori (1..5).
 * Altfel, se alege un loc la nefumatori (locurile 6-10). Apoi programul ar trebui sa afiseze un mesaj cu
 * numarul locului si sectiunea fumatori sau nefumatori a avionului. Rezervarea unui loc ar trebui marcata
 * printr-un 1.
 * Cand o sectiune este plina, programul ar trebui sa intrebe clientul daca doreste sa i se rezerve un loc la
 * cealalta sectiune. Daca da, se face rezervarea respectiva. Altfel, se afiseaza mesajul “Urmatorul zbor este
 * in 3 ore.” Acelasi mesaj va fi afisat si daca nu mai exista nici un loc liber.
 *
 */
import javax.swing.JOptionPane;
public class Main {
    private static final int CAPACITATE = 10;
    private static final int DIMENSIUNE_SECTIUNE = 5;
    private static final boolean[] seats = new boolean[CAPACITATE];
    public static void main(String[] args) {
        while (true) {
            String input = JOptionPane.showInputDialog("Alegeti 1 pentru sectiunea de Fumatori sau 2 pentru sectiunea de Nefumatori.\n");
            int section = Integer.parseInt(input);
            int seatNumber = reserveSeat(section);
            if (seatNumber == -1) {
                JOptionPane.showMessageDialog(null, "Urmatorul zbor este în 3 ore.");
                break;
            } else {
                String sectionName = (section == 1) ? "Fumatori" : "Nefumatori";
                JOptionPane.showMessageDialog(null, "Locul cu numarul " + seatNumber + " in sectiunea " + sectionName + " a fost rezervat.\n");
            }
        }
    }
    private static int reserveSeat(int section) {
        int sectionSize = (section == 1) ? DIMENSIUNE_SECTIUNE : CAPACITATE - DIMENSIUNE_SECTIUNE;
        for (int i = 0; i < sectionSize; i++) {
            int seatNumber = (section == 1) ? i + 1 : DIMENSIUNE_SECTIUNE + i + 1;
            if (!seats[seatNumber - 1]) {
                seats[seatNumber - 1] = true;
                return seatNumber;
            }
        }
        String message = "Sectiunea " + ((section == 1) ? "Fumatori" : "Nefumatori") + " este plina.\nDoriti sa rezervati un loc in cealalta sectiune?\n";
        int option = JOptionPane.showConfirmDialog(null, message);
        if (option == JOptionPane.YES_OPTION) {
            int otherSection = (section == 1) ? 2 : 1;
            return reserveSeat(otherSection);
        } else {
            return -1;
        }
    }
}



/**
 *
 * 8. Sa se scrie un program care afisează numarul de elemente nule de pe diagonala principala a unei
 * matrice patratica. In cazul in care matricea nu este patratica, aplicatia trebuie sa afiseze mesajul
 * “Atentie, matricea nu este patratica!”.
 *
 */
import javax.swing.JOptionPane;
import java.util.StringJoiner;
public class Main {
    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Introduceti lungimea matricei:"));
        int m = Integer.parseInt(JOptionPane.showInputDialog("Introduceti latimea matricei:"));
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
        StringJoiner message = new StringJoiner("");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                message.add(matrix[i][j] + " ");
            }
            message.add("\n");
        }
        int nullCount = 0;
        if (n != matrix[0].length) {
            JOptionPane.showMessageDialog(null, "Matricea este:\n" + message + "\nAtentie, matricea nu este patrata!\n");
        } else {
            for (int i = 0; i < n; i++) {
                if (matrix[i][i] == 0) nullCount++;
            }
            JOptionPane.showMessageDialog(null, "Matricea este:\n" + message + "\nNumarul de elemente nule pe diagonala principala: " + nullCount + "\n");
        }
    }
}



/**
 *
 * 9. Să se scrie o clasă Matrice ce memorează cu ajutorul constructorului elementele unei matrici pătrate
 * (3x3) şi conţine metode pentru implementarea următoarelor operaţii pe matrici:
 * - calcularea matricii transpuse,
 * - adunarea, respectiv scăderea a două matrici,
 * - înmulţirea a două matrici.
 * Să se scrie o altă clasă Test care testează funcţionalitatea acestei clase.
 * Indicaţie. A doua matrice folosită în metodele de adunare, scădere, respectiv înmulţire va fi dată ca
 * parametru actual al acestor metode.
 *
 */
public class Matrice {
    private int[][] matrice;
    public Matrice(int[][] matrice) {
        this.matrice = matrice;
    }
    public Matrice transpusa() {
        int[][] matriceaTranspusa = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriceaTranspusa[i][j] = matrice[j][i];
            }
        }
        return new Matrice(matriceaTranspusa);
    }
    public Matrice aduna(Matrice altaMatrice) {
        int[][] rezultatMatrice = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                rezultatMatrice[i][j] = matrice[i][j] + altaMatrice.matrice[i][j];
            }
        }
        return new Matrice(rezultatMatrice);
    }
    public Matrice scade(Matrice altaMatrice) {
        int[][] rezultatMatrice = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                rezultatMatrice[i][j] = matrice[i][j] - altaMatrice.matrice[i][j];
            }
        }
        return new Matrice(rezultatMatrice);
    }
    public Matrice inmulteste(Matrice altaMatrice) {
        int[][] rezultatMatrice = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    rezultatMatrice[i][j] += matrice[i][k] * altaMatrice.matrice[k][j];
                }
            }
        }
        return new Matrice(rezultatMatrice);
    }
    public void afiseaza() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println();
        }
    }
}
public class MatriceTest {
    public static void main(String[] args) {
        int[][] matrice1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrice2 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        Matrice m1 = new Matrice(matrice1);
        Matrice m2 = new Matrice(matrice2);
        System.out.println("Matrice 1:");
        m1.afiseaza();
        System.out.println("Matrice 2:");
        m2.afiseaza();
        System.out.println("Matrice 1 transpusa:");
        m1.transpusa().afiseaza();
        System.out.println("Matrice 1 + Matrice 2:");
        m1.aduna(m2).afiseaza();
        System.out.println("Matrice 1 - Matrice 2:");
        m1.scade(m2).afiseaza();
        System.out.println("Matrice 1 * Matrice 2:");
        m1.inmulteste(m2).afiseaza();
    }
}