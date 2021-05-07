
Feature: Rejestracja uzytkownika

  Testy funkcjonalnosci dodawania nowego uzytkownika
  w aplikacji seleniumdemo. Linijki opisu sa pomijane i nie maja
  wplywu na wykonanie testu

  Scenario: Tworzenie uzytkownika z unikalnym adresem email
    Given Uzytkownik z unikalnym adresem email
    When Uzytkownik rejestruje sie w aplikacji
    Then Uzytkownik powinien zostac przeniesiony na strone zalogowanego uzytkownika

  Scenario: Tworzenie uzytkownika z adresem email ktory istnieje w bazie danych
    Given Uzytkownik z adresem email istniejacym w aplikacji
    When Uzytkownik rejestruje sie w aplikacji
    Then Uzytkownik powinien zobaczyc blad zawierajacy An account is already registered with your email address