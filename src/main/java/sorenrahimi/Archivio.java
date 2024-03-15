package sorenrahimi;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Archivio implements Serializable {
    private List<Elemento> elementi;

    public Archivio(){
        this.elementi = new ArrayList<>();
    }
    public void aggiungiElemento(Elemento elemento) {
        elementi.add(elemento);
    }

    public void rimuoviElemento(String isbn){
        elementi.removeIf(e -> e.getIsbn().equals(isbn));
    }
    public Elemento ricercaPerISBN(String isbn){
        return elementi.stream()
                .filter(e -> e.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }
    public  List<Elemento> ricercaPerAnnoPubblicazione(int anno){
        return elementi.stream()
                .filter(e -> e.getAnnoPubblicazione() == anno)
                .collect(Collectors.toList());
    }
    public  List<Elemento> ricercaPerAutore(String autore){
        return elementi.stream()
                .filter(e -> e instanceof Libro && ((Libro) e).getAutore().equals(autore))
                .collect(Collectors.toList());
    }

    public void salvataggioSuDisco(String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
        oos.writeObject(this);
        }
    }

    public static Archivio caricamentoDalDisco(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Archivio) ois.readObject();
    }

    }
}