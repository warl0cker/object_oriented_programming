/**
 *
 * ModelNumereTelefon class
 *
 */

public class ModelNumereTelefon {
    private String codTara;
    private String codJudet;
    private String nrTelefon;
    public ModelNumereTelefon() {
        this.codTara = "";
        this.codJudet = "";
        this.nrTelefon = "";
    }
    public ModelNumereTelefon(String codTara, String codJudet, String nrTelefon) {
        this.codTara = codTara;
        this.codJudet = codJudet;
        this.nrTelefon = nrTelefon;
    }
    public String getCodTara() {
        return codTara;
    }
    public String getCodJudet() {
        return codJudet;
    }
    public String getNrTelefon() {
        return nrTelefon;
    }
    public void setCodTara(String codTara) {
        this.codTara = codTara;
    }
    public void setCodJudet(String codJudet) {
        this.codJudet = codJudet;
    }
    public void setNrTelefon(String nrTelefon) {
        this.nrTelefon = nrTelefon;
    }
    public String convertesteNumarTelefon() {
        return "+" + this.codTara + "-" + this.codJudet + "-" + this.nrTelefon;
    }
}



/**
 *
 * Abonat class
 *
 */

public class Abonat {
    private int codAbonat;
    private ModelNumereTelefon nrTelefon;
    private Persoana persoana;
    public Abonat(int codAbonat, ModelNumereTelefon nrTelefon, Persoana persoana) throws Exception {
        if (validareNumarTelefon(nrTelefon)) {
            this.codAbonat = codAbonat;
            this.nrTelefon = nrTelefon;
            this.persoana = persoana;
        } else {
            throw new Exception("Numarul de telefon nu este valid!");
        }
    }
    public int getCodAbonat() {
        return codAbonat;
    }
    public void setCodAbonat(int codAbonat) {
        this.codAbonat = codAbonat;
    }
    public ModelNumereTelefon getNrTelefon() {
        return nrTelefon;
    }
    public void setNrTelefon(ModelNumereTelefon nrTelefon) throws Exception {
        if (validareNumarTelefon(nrTelefon)) {
            this.nrTelefon = nrTelefon;
        } else {
            throw new Exception("Numarul de telefon nu este valid!");
        }
    }
    public Persoana getPersoana() {
        return persoana;
    }
    public void setPersoana(Persoana persoana) {
        this.persoana = persoana;
    }
    public boolean validareNumarTelefon(ModelNumereTelefon nrTelefon) {
        return nrTelefon.getCodJudet().length() == 3 && nrTelefon.getCodTara().length() == 4 && nrTelefon.getNrTelefon().length() == 6;
    }
    public String getInformatii() {
        return "Abonatul " + this.persoana.getNume() + " " + this.persoana.getPrenume() + " cu codul " + this.codAbonat + " are numarul de telefon " + this.nrTelefon.convertesteNumarTelefon();
    }
}



/**
 *
 * Persoana class
 *
 */

public class Persoana {
    private String nume;
    private String prenume;
    public Persoana(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
    }
    public String getNume() {
        return nume;
    }
    public String getPrenume() {
        return prenume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }
}



/**
 *
 * AgendaTelefonica class
 *
 */

public class AgendaTelefonica {
    private final Abonat[] abonati;
    private int numarAbonati;
    public AgendaTelefonica(int dimensiuneMaxima) {
        this.abonati = new Abonat[dimensiuneMaxima];
        this.numarAbonati = 0;
    }
    public String adaugaAbonat(Abonat abonat) {
        if (numarAbonati < abonati.length) {
            abonati[numarAbonati] = abonat;
            numarAbonati++;
            return "Abonatul a fost adaugat in agenda!";
        } else {
            return "Agenda este plina!";
        }
    }
    public boolean stergeAbonat(int codAbonat) {
        for (int i = 0; i < numarAbonati; i++) {
            if (abonati[i].getCodAbonat() == codAbonat) {
                for (int j = i; j < numarAbonati - 1; j++) {
                    abonati[j] = abonati[j + 1];
                }
                numarAbonati--;
                abonati[numarAbonati] = null;
                return true;
            }
        }
        return false;
    }
    public Abonat cautaNrTelefon(int codAbonat) {
        for (int i = 0; i < numarAbonati; i++) {
            if (abonati[i].getCodAbonat() == codAbonat) return abonati[i];
        }
        return null;
    }
    public Abonat[] getAbonati() {
        return this.abonati;
    }
}



/**
 *
 * PanouMultiplu class
 *
 */

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.FlowLayout;
import java.util.Arrays;
public class PanouMultiplu {
    JPanel panouParinte = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JTextField[] variabile;
    JPanel[] panels;
    boolean okApasat;
    public PanouMultiplu(String titlu, String[] optiuni) {
        this.variabile = new JTextField[optiuni.length];
        this.panels = new JPanel[optiuni.length];
        panouParinte.setLayout(new BoxLayout(panouParinte, BoxLayout.Y_AXIS));
        for (int i = 0; i < optiuni.length; i++) {
            variabile[i] = new JTextField(20);
            panels[i] = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panels[i].add(new JLabel(optiuni[i]));
            panels[i].add(variabile[i]);
            panouParinte.add(panels[i]);
        }
        int result = JOptionPane.showConfirmDialog(null, panouParinte, titlu, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        this.okApasat = result == JOptionPane.OK_OPTION;
    }
    public String[] getVariabile() {
        return Arrays.stream(this.variabile).map(JTextComponent::getText).toArray(String[]::new);
    }
    public boolean getOkApasat() {
        return this.okApasat;
    }
}



/**
 *
 * TestUnit for application
 *
 */

import javax.swing.JOptionPane;
public class TestAgenda {
    static String mesajOptiuni = """
        
        Alege o optiune:
        1 - Adaugare Abonat
        2 - Stergere Abonat
        3 - Modificare Abonat
        4 - Afisare Agenda
        0 - Iesire
        
        """;
    private final AgendaTelefonica agenda;
    public TestAgenda(int numarMaximAbonati) {
        this.agenda = new AgendaTelefonica(numarMaximAbonati);
    }
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Usage: TestAgenda <numar-maxim-abonati>");
            return;
        }
        int numarMaximAbonati = Integer.parseInt(args[0]);
        TestAgenda testAgenda = new TestAgenda(numarMaximAbonati);
        int optiune = -1;
        while (optiune != 0) {
            optiune = testAgenda.citesteOptiunePrincipala();
            switch (optiune) {
                case 0 -> System.out.println("Ati ales sa iesiti.");
                case 1 -> testAgenda.adaugareAbonat();
                case 2 -> testAgenda.stergereAbonat();
                case 3 -> testAgenda.modificareAbonat();
                case 4 -> testAgenda.listareAbonati();
                default -> testAgenda.afisareEroare("Eroare", "Optiunea selectata nu este valida!");
            }
        }
    }
    private int citesteOptiunePrincipala() {
        String raspuns = JOptionPane.showInputDialog(null, mesajOptiuni, "Gestiune Agenda", JOptionPane.INFORMATION_MESSAGE);
        return (raspuns == null) ? 0 : Integer.parseInt(raspuns);
    }
    private void adaugareAbonat() {
        try {
            Abonat abonatNou = obtineAbonat();
            String mesaj = agenda.adaugaAbonat(abonatNou);
            this.afisareMesaj("Adaugare Abonat", mesaj);
        } catch (Exception e) {
            this.afisareEroare("Adaugare Abonat", "Datele introduse sunt invalide!");
        }
    }
    private Abonat obtineAbonat() throws Exception {
        String titlu = "Adaugare abonat";
        String[] optiuni = new String[] { "Cod abonat", "Nume", "Prenume", "Cod tara", "Cod judet", "Numar telefon" };
        PanouMultiplu panouMultiplu = new PanouMultiplu(titlu, optiuni);
        if (panouMultiplu.getOkApasat()) {
            String[] variabile = panouMultiplu.getVariabile();
            int codAbonat = Integer.parseInt(variabile[0]);
            Persoana persoana = new Persoana(variabile[1], variabile[2]);
            ModelNumereTelefon modelNumereTelefon = new ModelNumereTelefon(variabile[3], variabile[4], variabile[5]);
            return new Abonat(codAbonat, modelNumereTelefon, persoana);
        } else {
            throw new Exception("Operatiune anulata.");
        }
    }
    private void stergereAbonat() {
        String codAbonatSters = JOptionPane.showInputDialog(null, "Introduceti codul abonatului de sters:", "Stergere abonat", JOptionPane.INFORMATION_MESSAGE);
        int codAbonatStersInt = Integer.parseInt(codAbonatSters);
        if (agenda.stergeAbonat(codAbonatStersInt)) {
            String mesaj = "Abonatul cu codul " + codAbonatStersInt + " a fost sters cu succes.";
            this.afisareMesaj("Stergere abonat", mesaj);
        } else {
            String mesaj = "Abonatul cu codul " + codAbonatStersInt + " nu exista in agenda.";
            this.afisareEroare("Stergere abonat", mesaj);
        }
    }
    private void modificareAbonat() throws Exception {
        String codAbonatModificat = JOptionPane.showInputDialog(null, "Introduceti codul abonatului de modificat:", "Modificare abonat", JOptionPane.INFORMATION_MESSAGE);
        int codAbonatModificatInt = Integer.parseInt(codAbonatModificat);
        Abonat abonatModificat = agenda.cautaNrTelefon(codAbonatModificatInt);
        if (abonatModificat != null) {
            String titlu = "Adaugare abonat";
            String[] optiuni = new String[] { "Cod abonat", "Nume", "Prenume", "Cod tara", "Cod judet", "Numar telefon" };
            PanouMultiplu panouMultiplu = new PanouMultiplu(titlu, optiuni);
            if (panouMultiplu.getOkApasat()) {
                String[] variabile = panouMultiplu.getVariabile();
                int codAbonat = Integer.parseInt(variabile[0]);
                abonatModificat.setCodAbonat(codAbonat);
                Persoana persoana = new Persoana(variabile[1], variabile[2]);
                abonatModificat.setPersoana(persoana);
                ModelNumereTelefon modelNumereTelefon = new ModelNumereTelefon(variabile[3], variabile[4],
                        variabile[5]);
                abonatModificat.setNrTelefon(modelNumereTelefon);
            } else {
                throw new Exception("Operatiune anulata.");
            }
            String mesaj = "Abonatul a fost modificat cu succes.";
            this.afisareMesaj("Modificare abonat", mesaj);
        } else {
            String mesaj = "Abonatul cu codul " + codAbonatModificatInt + " nu exista in agenda.";
            this.afisareEroare("Modificare abonat", mesaj);
        }
    }
    private void listareAbonati() {
        StringBuilder agendaText = new StringBuilder("Agenda telefonica:\n\n");
        Abonat[] abonati = this.agenda.getAbonati();
        if (abonati.length == 0) {
            agendaText.append("Nu exista abonati in agenda.");
        } else {
            for (Abonat abonat : abonati) {
                if (abonat != null) agendaText.append(abonat.getInformatii()).append("\n");
            }
        }
        this.afisareMesaj("Afisare agenda", agendaText.toString());
    }
    private void afisareMesaj(String titlu, String mesaj) {
        JOptionPane.showMessageDialog(null, mesaj, titlu, JOptionPane.INFORMATION_MESSAGE);
    }
    private void afisareEroare(String titlu, String mesaj) {
        JOptionPane.showMessageDialog(null, mesaj, titlu, JOptionPane.ERROR_MESSAGE);
    }
}
