package pl.lyszczarzmariusz;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UseForm {
    public static void main(String[] args) throws IOException {
        String url = "https://www.swiatksiazki.pl/Ksiazki/ksiazki-3799.html?is_new=1&p=1&product_list_limit=30&product_list_mode=grid&product_list_order=release_date&product_list_dir=desc";
        Document doc = (Document) Jsoup.connect(url)
                .data("action", "https://www.swiatksiazki.pl/catalogsearch/result/")
                .data("search", "wiosna")
                .method(Connection.Method.GET)
                .userAgent("JSoup scraper")
                .post();

        String bookSelectors = "a.product-item-link";
        Elements bookElement = doc.select(bookSelectors);
        List<String> bookTitle = new ArrayList<>();

        for (Element element : bookElement) {
            bookTitle.add(element.text());
        }

        for (String s : bookTitle) {
            System.out.println(s);
        }
    }
}
