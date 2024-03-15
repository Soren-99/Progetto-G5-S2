package sorenrahimi;


import ch.qos.logback.core.util.FileUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        Archivio archivio = new Archivio();

        archivio.aggiungiElemento(new Libro("2932910293", "La casa bianca", 1976, 297, "Mario Rossi", "Thriller" ));
        archivio.aggiungiElemento(new Rivista("4738338398", "Vanilla Magazine", 2020, 82, Rivista.Periodicita.SETTIMANALE));
        archivio.aggiungiElemento(new Libro("4337282921", "Il drago Rosso", 1926, 189, "John Smith", "Avventura"));
        archivio.aggiungiElemento(new Libro("8473632902", "La bellezza", 2004, 357, "Rita Bianchi", "Biografico" ));
        archivio.aggiungiElemento(new Rivista("748390228", "Focus", 2008, 16, Rivista.Periodicita.MENSILE));

        Elemento elemento1 = archivio.ricercaPerISBN("2932910293");
        System.out.println("Elemento trovato per ISBN: " + elemento1.getTitolo());

        List<Elemento> elementiAnno = archivio.ricercaPerAnnoPubblicazione(1976);
        System.out.println("Elementi trovati per anno di pubblicazione: ");
        for (Elemento elemento : elementiAnno) {
            System.out.println("- " + elemento.getTitolo());
        }

        File file = new File("src/archivio.txt");

        try {
            FileUtils.writeStringToFile(file, "Salvataggio su disco avvenuto con successo", StandardCharsets.UTF_8);
            //archivio.salvataggioSuDisco("archivio.txt");
        }catch (IOException e) {
            System.err.println("Errore durante il salvataggio su disco: " + e.getMessage());
        }

        try {

            Archivio archivioCaricato = Archivio.caricamentoDalDisco("archivio.txt");
            System.out.println("Archivio caricato dal disco con " + archivioCaricato.elementi.size() + " elementi.");
        }catch (IOException | ClassNotFoundException e){
            System.err.println();
        }

    }
}
