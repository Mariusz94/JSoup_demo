package pl.lyszczarzmariusz;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://www.google.pl/").get();
            System.out.println(doc.title());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
