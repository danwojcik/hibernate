# hibernate

Program wykorzystujący framework hibernate do łączenia się z bazą danych. Program umożliwia dodanie biegu, zapisanie zawodnika do odpowiedniego biegu, 
usunięcie go z listy, a także wyświetlenie listy wszystkich biegów lub zawodników. 

Program zbudowany jest w oparciu o warstwę DAO, która odpowiada za pobierania, dodawanie, usuwanie i modyfikowanie danych. Aplikacja została napisana wg wzorca MVC:
* Model - Model danych - opis struktur danych i powiązań pomiędzy nimi
* View - Interfejs, czyli to co widzi użytkownik
* Controller - Logika działania - powiązania między zdarzeniami zachodzącymi w systemie
