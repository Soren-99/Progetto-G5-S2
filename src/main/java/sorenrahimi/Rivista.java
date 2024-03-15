package sorenrahimi;

public class Rivista extends Elemento {
    private final Periodicita periodicita;

    public enum Periodicita {
        SETTIMANALE, MENSILE, SEMESTRALE
    }
    public Rivista(String isbn, String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

  @Override
  public String toString(){
        return super.toString() + ", Periodicita: " + periodicita;
  }

    public Periodicita getPeriodicita(){
        return periodicita;
    }

}
