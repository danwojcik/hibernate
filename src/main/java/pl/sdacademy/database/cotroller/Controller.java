package pl.sdacademy.database.cotroller;

import pl.sdacademy.database.model.Model;
import pl.sdacademy.database.model.entity.Run;
import pl.sdacademy.database.model.entity.RunMember;
import pl.sdacademy.database.view.View;

import java.util.List;

public class Controller {

    private Model model;
    private View view;

    public Controller() {

        model = new Model();
        view = new View();
    }

    public void start() {
        int wybierzOpcje = 0;
        do {
            wybierzOpcje = view.pokazMenuIwybierzOpcje();

            switch (wybierzOpcje) {
                case 1:
                    dodajBieg();
                    break;
                case 2:
                    dodajZawodnika();
                    break;
                case 3:
                    pokazWszystkieBiegi();
                    break;
                case 4:
                    pokazWsztstkichZawodnikow();
                    break;
                case 5:
                    usunZawodnika();
                    break;
                case 6:
                    znajdzZawodnikaPoId();
                    break;
                case 7:
                    usunBieg();
                    break;
            }
        } while (wybierzOpcje != 0);
        view.aplikacjaZakonczonaTxt();
    }
    private void dodajBieg() {
        Run nowyBieg = view.dodajBieg();
        model.save(nowyBieg);
    }


    private void dodajZawodnika() {
       RunMember nowyZawodnik =  view.dodajZawodnika();
       model.save(nowyZawodnik);
    }

    private void pokazWszystkieBiegi() {
       List<Run> listRun =  model.getAllRuns();
       view.pokazWszystkieBiegi(listRun);
    }
    private void pokazWsztstkichZawodnikow() {
        List<RunMember> listRunners = model.getAllRunner();
        view.pokazWszystkichZwodnikow(listRunners);
    }

    private void usunZawodnika() {
        Integer usunZawodnika = view.usunZawodnika();
        RunMember znajdzZawodnika = model.findById(usunZawodnika);
        view.wyswietlDaneZawodnika(znajdzZawodnika);
        model.deleteRunnersById(usunZawodnika);
    }

    private void znajdzZawodnikaPoId() {
        Integer znajdzZawodnikaPoId = view.znajdzZawodnikaPoId();
        RunMember znajdzZawodnika = model.findById(znajdzZawodnikaPoId);
        view.wyswietlDaneZawodnika(znajdzZawodnika);
    }

    private void usunBieg() {
        Integer usunBieg = view.usunBieg();
        model.deleteRunsById(usunBieg);
    }
}
