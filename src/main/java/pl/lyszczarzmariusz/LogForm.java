package pl.lyszczarzmariusz;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Map;

public class LogForm {
    public static void main(String[] args) throws IOException {
        String url = "https://www.swiatksiazki.pl/Ksiazki/ksiazki-3799.html?is_new=1&p=1&product_list_limit=30&product_list_mode=grid&product_list_order=release_date&product_list_dir=desc";
        Connection.Response loginForm = Jsoup.connect(url)
                .timeout(2000)
                .method(Connection.Method.GET)
                .userAgent("JSoup scraper")
                .execute();
        Map<String, String> loginCookies = loginForm.cookies();
        Connection.Response login = Jsoup.connect(url)
                .userAgent("JSoup scraper")
                .data("user", "user")
                .data("pass","pass")
                .cookies(loginCookies)
                .method(Connection.Method.POST)
                .execute();
        loginCookies = login.cookies();
    }
}
