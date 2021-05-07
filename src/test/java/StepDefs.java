import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {

    @Given("Uzytkownik z unikalnym adresem email")
    public void uzytkownikZUnikalnymAdresemEmail() {
        System.out.println("Tworze uzytkownika z unikalnym adreserm");
    }

    @When("Uzytkownik rejestruje sie w aplikacji")
    public void uzytkownikRejestrujeSieWAplikacji() {
        System.out.println("Rejestracja uzytkownika");
    }

    @Then("Uzytkownik powinien zostac przeniesiony na strone zalogowanego uzytkownika")
    public void uzytkownikPowinienZostacPrzeniesionyNaStroneZalogowanegoUzytkownika() {
        System.out.println("Sprawdzenie czy jesteśmy na odpowiedniej stronie");
    }

    @Given("Uzytkownik z adresem email istniejacym w aplikacji")
    public void uzytkownikZAdresemEmailIstniejacymWAplikacji() {
        System.out.println("Tworze uzytkownika z adresem email istniejacym w aplikacji");

    }

    @Then("Uzytkownik powinien zobaczyc blad zawierajacy An account is already registered with your email address")
    public void uzytkownikPowinienZobaczycBladZawierajacyAnAccountIsAlreadyRegisteredWithYourEmailAddress() {
        System.out.println("Sprawdzam czy został wyswietlony blad");
    }
}
