package pl.sdacademy.database.view;


import pl.sdacademy.database.model.entity.Run;
import pl.sdacademy.database.model.entity.RunMember;

import java.util.List;
import java.util.Scanner;

public class View {

    Scanner scanner = new Scanner(System.in);

    private void menu(String text) {
        System.out.println(text);
    }

    public int pokazMenuIwybierzOpcje() {

        menu("Wybierz opcje: ");
        menu("[1] Dodaj bieg");
        menu("[2] Dodaj zawodnika");
        menu("[3] Pokaż wszystkie biegi");
        menu("[4] Pokaż wszystkich zadowdników");
        menu("[5] Usun zawodnika po ID");
        menu("[6] Znajdz zawodnika po ID");
        menu("[0] Wyjście");

        int wybor = scanner.nextInt();
        return wybor;
    }

    public Run dodajBieg() {

        Run run = new Run();

        System.out.println("Dodaj nazwe nowego biegu: ");
        String nowyBieg = scanner.next();
        run.setName(nowyBieg);

        return run;
    }

    public RunMember dodajZawodnika() {

        RunMember runMember = new RunMember();

        System.out.println("Dodaj nowego zawodnika: ");
        String nowyZawodnik = scanner.next();
        System.out.println("Wpisz numer startowy: ");
        int nowyNumerStartowy = scanner.nextInt();

        runMember.setName(nowyZawodnik);
        runMember.setStartNumber(nowyNumerStartowy);

        return runMember;
    }

    public void pokazWszystkieBiegi(List<Run> list) {

        System.out.println("Lista wszystkich biegow: ");

        for (Run run : list) {
            System.out.println(run.getName());
        }
    }
    public void pokazWszystkichZwodnikow(List<RunMember> list) {

        System.out.println("Lista wszystkich zawodnikow: ");

        for (RunMember runMember : list) {
            System.out.println(runMember.getName());
        }
    }

    public Integer usunZawodnika() {

        System.out.println("Podaj ID zawodnika do usuniecia: ");

        int usunZawodnika = scanner.nextInt();
        return usunZawodnika;
    }

    public Integer znajdzZawodnikaPoId() {

        System.out.println("Podaj numer ID zawodnika: ");

        int znajdzZawodnikaPoId = scanner.nextInt();
        return znajdzZawodnikaPoId;
    }

    public void wyswietlDaneZawodnika(RunMember zawodnik) {

        System.out.println("Nr id: " + zawodnik.getId() + " imie: " + zawodnik.getName() +
                " numer startowy: " + zawodnik.getStartNumber());
    }

    public Integer usunBieg() {

        System.out.println("Podaj ID biegu do usuniecia: ");

        int usunBieg = scanner.nextInt();
        return usunBieg;
    }

    public void aplikacjaZakonczonaTxt() {

        System.out.println("Aplikacja zakonczona");
        return;
    }
}
