# hibernate

Program wykorzystujący framework hibernate do łączenia się z bazą danych. Program umożliwia dodanie biegu podając jego nazwę, zapisanie zawodnika do odpowiedniego biegu podając jego imię i numer startowy. Nr ID biegacza jest generowany automatycznie. Zawodnika można usunąć z listy podając jego nr ID. Mamy również możliwość wyświetlenie listy wszystkich biegów lub zawodników.

Program zbudowany jest w oparciu o warstwę DAO, która odpowiada za pobierania, dodawanie, usuwanie i modyfikowanie danych. Aplikacja została napisana wg wzorca MVC:
* Model - przechowujęstrukturę danych i łączy się z bazą danych za pomocą frameworka hibernate.
* View - Interfejs wyświelany użutkownikowi. Poprzez klasę scanner, możliwość wyboru odpowiedniej opcji.
* Controller - pobiera dane z modelu i przekazuje do widoku. Przechowuję logikę wyświatlengo menu, zwartego w instruykcji switch-case. 
