/*
 * 1. Să se scrie o clasă Cerc, care are un constructor in care indicati raza cercului, împreună cu metodele
 * getArie() pentru a obţine aria şi getCircumferinta(), care returnează circumferinţa cercului. Sa se testeze
 * functionalitatea acestei clase.
 */
public class Cerc {
    private final double raza;
    public Cerc(double r) {
        raza = r;
    }
    public double getArie() {
        return Math.PI * raza * raza;
    }
    public double getCircumferinta() {
        return 2 * Math.PI * raza;
    }
    public static void main(String[] args) {
        Cerc cerc1 = new Cerc(5);
        System.out.println("Aria cercului este: " + cerc1.getArie());
        System.out.println("Circumferinta cercului este: " + cerc1.getCircumferinta());
    }
}


/*
 * 2. Să se implementeze o clasă Produs. Fiecare produs are o denumire şi un preţ unitar. Scrieţi constructorul şi
 * următoarele metode: afiseazaProdus(), getPret(), setPret(int np), aplicaReducere(int procent). Să se scrie un
 * program care creează două produse şi le afişează, apoi să li se reducă preţul cu 10% şi apoi să se afişeze
 * din nou.
 */
public class Produs {
    private final String denumire;
    private double pretUnitar;
    public Produs(String a, double b) {
        denumire = a;
        pretUnitar = b;
    }
    public void afiseazaProdus() {
        System.out.println("Produsul este: " + denumire + " cu pretul: " + pretUnitar);
    }
    public double getPret() {
        return pretUnitar;
    }
    public void setPret(int np) {
        if (np > 0) pretUnitar = np;
    }
    public void aplicaReducere(int procent) {
        if (procent > 0 && procent <= 100) pretUnitar -= pretUnitar * (procent / 100.0);
    }
    public static void main(String[] args) {
        Produs p1 = new Produs("Margarina", 87.0);
        Produs p2 = new Produs("Unt", 103.5);
        p1.afiseazaProdus();
        p2.afiseazaProdus();
        p1.aplicaReducere(10);
        p2.aplicaReducere(10);
        p1.afiseazaProdus();
        p2.afiseazaProdus();
    }
}


/*
 * 3. Creaţi o clasǎ ContBancar care are douǎ variabile instanţǎ private numite numarCont şi sumaCont. Aceste
 * variabile sunt iniţializate prin intermediul parametrilor unui constructor definit de cǎtre programator. Sǎ se
 * implementeze metode publice pentru adǎugarea, respectiv extragerea, unei sume în/din cont. Apoi sǎ se
 * scrie o altǎ clasǎ Test care, în metoda main, creeazǎ un obiect de tip ContBancar cu numǎrul 40 şi valoarea
 * minimă 10 RON şi apoi adaugǎ, respectiv scoate o sumǎ din cont. Dupǎ fiecare apelare a unei metode sǎ se
 * afişeze numǎrul contului şi soldul curent.
 */
public class ContBancar {
    private final long numarCont;
    private double sumaCont;
    public ContBancar(long a, double b) {
        numarCont = a;
        sumaCont = b;
    }
    public void adaugaSuma(double suma) {
        if (suma > 0) sumaCont += suma;
		else System.out.println("Suma introdusa este invalida!");
    }
    public void extragereSuma(double suma) {
        if (sumaCont > suma) sumaCont -= suma;
        else System.out.println("Fonduri insuficiente!");
    }
    public void afiseazaCont() {
        System.out.println("Numar cont: " + numarCont + " cu suma: " + sumaCont);
    }
}
public class ContBancarTest {
    public static void main(String[] args) {
        ContBancar c1 = new ContBancar(40, 10);
        c1.adaugaSuma(10);
        c1.afiseazaCont();
        c1.extragereSuma(20);
        c1.afiseazaCont();
        c1.extragereSuma(30);
        c1.afiseazaCont();
    }
}


/*
 * 4. Să se creeze o clasă denumită Dreptunghi. Clasa are atributele lungime şi latime, fiecare iniţializate
 * implicit cu 1, şi metode care calculează perimetrul şi aria dreptunghiului. În plus, clasa conţine metode set
 * şi get pentru ambele atribute. Metodele set ar trebui sa verifice faptul că lungimea şi lăţimea au valori reale
 * între 0.0 şi 20.0. Să se scrie o altă clasă care verifică funcţionalitatea clasei Dreptunghi.
 */
public class Dreptunghi {
    private double lungime;
    private double latime;
    public Dreptunghi() {
        lungime = 1.0;
        latime = 1.0;
    }
    public double getLungime() {
        return lungime;
    }
    public void setLungime(double lungime) {
        if (lungime > 0.0 && lungime <= 20.0) {
            this.lungime = lungime;
        } else {
            System.out.println("Lungimea trebuie sa fie intre 0.0 si 20.0");
        }
    }
    public double getLatime() {
        return latime;
    }
    public void setLatime(double latime) {
        if (latime > 0.0 && latime <= 20.0) {
            this.latime = latime;
        } else {
            System.out.println("Latimea trebuie sa fie intre 0.0 si 20.0");
        }
    }
    public double perimetruDreptunghi() {
        return 2 * (lungime + latime);
    }
    public double arieDreptunghi() {
        return lungime * latime;
    }
}
public class DreptunghiTest {
    public static void main(String[] args) {
        Dreptunghi dreptunghi = new Dreptunghi();
        System.out.println("Lungime: " + dreptunghi.getLungime());
        System.out.println("Latime: " + dreptunghi.getLatime());
        System.out.println("Perimetru: " + dreptunghi.perimetruDreptunghi());
        System.out.println("Arie: " + dreptunghi.arieDreptunghi());
        dreptunghi.setLungime(5.0);
        dreptunghi.setLatime(10.0);
        System.out.println("Lungime: " + dreptunghi.getLungime());
        System.out.println("Latime: " + dreptunghi.getLatime());
        System.out.println("Perimetru: " + dreptunghi.perimetruDreptunghi());
        System.out.println("Arie: " + dreptunghi.arieDreptunghi());
        dreptunghi.setLungime(30.0);
        dreptunghi.setLatime(-5.0);
    }
}


/*
 * 5. Să se creeze o clasă denumită Dreptunghi care este putin mai complicată decât cea din problema
 * anterioară. Această clasă stochează numai coordonatele colţurilor dreptunghiului. Constructorul apelează o
 * metodă set() care acceptă patru seturi de coordonate şi verifică dacă acestea nu au coordonatele x şi y mai
 * mari de 20.0. De asemenea, verifică faptul că cele 4 seturi de coordonate specifică un dreptunghi.
 * Metodele acestei clase calculează lungimea, lăţimea, perimetrul şi aria fiecărui dreptunghi. Includeţi o
 * metodă booleană estePatrat() care determină dacă dreptunghiul este pătrat. Sǎ se scrie o altă clasă care
 * verifică funcţionalitatea acestei clase.
 */
public class Dreptunghi {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x4;
    private double y4;
    public Dreptunghi(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        set(x1, y1, x2, y2, x3, y3, x4, y4);
    }
    public void set(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        if (x1 > 20.0 || y1 > 20.0 || x2 > 20.0 || y2 > 20.0 || x3 > 20.0 || y3 > 20.0 || x4 > 20.0 || y4 > 20.0) {
            throw new IllegalArgumentException("Coordinatele trebuie sa fie intre 0.0 si 20.0");
        }
        double lungime1 = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
        double lungime2 = Math.sqrt(Math.pow(x3-x2, 2) + Math.pow(y3-y2, 2));
        double lungime3 = Math.sqrt(Math.pow(x4-x3, 2) + Math.pow(y4-y3, 2));
        double lungime4 = Math.sqrt(Math.pow(x1-x4, 2) + Math.pow(y1-y4, 2));
        if (lungime1 != lungime3 || lungime2 != lungime4) {
            throw new IllegalArgumentException("Coordinatele nu reprezinta un dreptunghi");
        }
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x4 = x4;
        this.y4 = y4;
    }
    public double getLungime() {
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }
    public double getLatime() {
        return Math.sqrt(Math.pow(x4-x1, 2) + Math.pow(y4-y1, 2));
    }
    public double getPerimetru() {
        return 2 * (getLungime() + getLatime());
    }
    public double getArie() {
        return getLungime() * getLatime();
    }
    public boolean estePatrat() {
        return getLungime() == getLatime();
    }
}
public class DreptunghiTest {
    public static void main(String[] args) {
        Dreptunghi r = new Dreptunghi(0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0);
        System.out.println("Lungime: " + r.getLungime());
        System.out.println("Latime: " + r.getLatime());
        System.out.println("Perimetru: " + r.getPerimetru());
        System.out.println("Arie: " + r.getArie());
        System.out.println("Este Patrat: " + r.estePatrat());
        r.set(0.0, 0.0, 0.0, 2.0, 2.0, 2.0, 2.0, 0.0);
        System.out.println("Lungime: " + r.getLungime());
        System.out.println("Latime: " + r.getLatime());
    }
}


/*
 * 6. Sa se scrie o clasa Complex care realizeaza operatii aritmetice cu numere complexe. Numerele complexe
 * au forma: parteaReala+i*parteaImaginara, unde i=sqrt(-1). Folositi variabile double pentru a memora
 * datele private ale clasei. Furnizati 2 constructori, unul care initializeaza variabilele clasei si un constructor
 * care le initializeaza cu valori implicite. Scrieti metode publice pentru fiecare din urmatoarele operatii:
 * a) Adunarea a doua numere complexe.
 * b) Scaderea a doua numere complexe. Rezultatul este un numar complex nou.
 * c) Afisarea unui numar complex sub forma (a,b) unde a este partea reala, iar b partea imaginara a numarului
 * complex.
 * Sa se scrie o alta clasa care testeaza functionalitatea clasei Complex.
 */
public class Complex {
    private final double real;
    private final double imaginar;
    public Complex(double real, double imaginar) {
        this.real = real;
        this.imaginar = imaginar;
    }
    public Complex adunare(Complex altNr) {
        double realNou = this.real + altNr.real;
        double imaginarNou = this.imaginar + altNr.imaginar;
        return new Complex(realNou, imaginarNou);
    }
    public Complex scadere(Complex altNr) {
        double realNou = this.real - altNr.real;
        double imaginarNou = this.imaginar - altNr.imaginar;
        return new Complex(realNou, imaginarNou);
    }
    public void afseaza() {
        System.out.println("(" + this.real + ", " + this.imaginar + ")");
    }
}
public class ComplexTest {
    public static void main(String[] args) {
        Complex c1 = new Complex(1.0, 2.0);
        Complex c2 = new Complex(3.0, 4.0);
        Complex sum = c1.adunare(c2);
        Complex dif = c1.scadere(c2);
        sum.afiseaza();
        dif.afiseaza();
    }
}

/*
 * 7. Creati o clasa numita Rational pentru realizarea operatiilor aritmetice cu numere rationale. Folositi
 * variabile intregi pentru a reprezenta variabilele instanta private ale clasei – numitor si numitor. Scrieti
 * un constructor care permite initializarea obiectului cand este creat, cu valorile primite ca parametri.
 * Constructorul stocheaza fractia in forma redusa (de exemplu, fractia 2/4 ar trebui stocata in obiect ca ½).
 * Scrieti un alt constructor care nu are parametri si care initializeaza obiectul cu valori implicite.
 * Clasa Rational are urmatoarele metode publice:
 * - adunarea a doua numere rationale. Rezultatul adunarii ar trebui stocat in forma redusa.
 * - scaderea a doua numere rationale.
 * - inmultirea a doua numere rationale.
 * - impartirea a doua numere rationale.
 * - afisarea numerelor rationale in forma a/b
 * - afisarea numarelor rationale in format virgula flotanta.
 * Rezultatul efectuarii unei operatii va fi un numar rational nou, deci va trebui stocat in forma redusa intr-un alt
 * obiect de tip Rational.
 */
public class Rational {
    private final int numarator;
    private final int numitor;
    public Rational(int numarator, int numitor) {
        int cmmdc = cmmdc(numarator, numitor);
        this.numarator = numarator / cmmdc;
        this.numitor = numitor / cmmdc;
    }
    public Rational adunare(Rational altNr) {
        int newnumarator = this.numarator * altNr.numitor + altNr.numarator * this.numitor;
        int newnumitor = this.numitor * altNr.numitor;
        return new Rational(newnumarator, newnumitor);
    }
    public Rational scadere(Rational altNr) {
        int newnumarator = this.numarator * altNr.numitor - altNr.numarator * this.numitor;
        int newnumitor = this.numitor * altNr.numitor;
        return new Rational(newnumarator, newnumitor);
    }
    public Rational inmultire(Rational altNr) {
        int newnumarator = this.numarator * altNr.numarator;
        int newnumitor = this.numitor * altNr.numitor;
        return new Rational(newnumarator, newnumitor);
    }
    public Rational impartire(Rational altNr) {
        int newnumarator = this.numarator * altNr.numitor;
        int newnumitor = this.numitor * altNr.numarator;
        return new Rational(newnumarator, newnumitor);
    }
    public String afiseazaFractie() {
        return numarator + "/" + numitor;
    }
    public double afiseazaFloat() {
        return (double) numarator / numitor;
    }
    private int cmmdc(int a, int b) {
        return b == 0 ? a : cmmdc(b, a % b);
    }
    public static void main(String[] args) {
        Rational r1 = new Rational(2, 4);
        Rational r2 = new Rational(3, 5);
        Rational sum = r1.adunare(r2);
        Rational dif = r1.scadere(r2);
        Rational prd = r1.inmultire(r2);
        Rational cfc = r1.impartire(r2);
        System.out.println("realNr1 = " + r1.afiseazaFractie() + " = " + r1.afiseazaFloat());
        System.out.println("realNr2 = " + r2.afiseazaFractie() + " = " + r2.afiseazaFloat());
        System.out.println("Suma = " + sum.afiseazaFractie() + " = " + sum.afiseazaFloat());
        System.out.println("Diferenta = " + dif.afiseazaFractie() + " = " + dif.afiseazaFloat());
        System.out.println("Produsul = " + prd.afiseazaFractie() + " = " + prd.afiseazaFloat());
        System.out.println("Coeficientul = " + cfc.afiseazaFractie() + " = " + cfc.afiseazaFloat());
    }
}
