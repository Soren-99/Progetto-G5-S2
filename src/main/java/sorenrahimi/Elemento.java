package sorenrahimi;

import java.io.Serializable;

public abstract class Elemento implements Serializable {
    private String isbn;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;


    public Elemento(String isbn, String titolo, int annoPubblicazione, int numeroPagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public String toString(){
        return "ISBN: " + isbn + ", Titolo: " + titolo + ", Anno di Pubblicazione: " + annoPubblicazione +
                ", Numero di Pagine: " + numeroPagine;
    }

    public String getIsbn() {
        return isbn;
    }
    public String getTitolo() {
        return titolo;
    }
    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }
    public int getNumeroPagine() {
        return numeroPagine;
    }
}
