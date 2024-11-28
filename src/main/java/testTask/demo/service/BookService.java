package testTask.demo.service;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testTask.demo.entity.Book;
import testTask.demo.repository.BookRepository;
import org.jsoup.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class BookService {

    private final BookRepository bookRepository;
    private static final String BASE_URL = "https://books.toscrape.com/catalogue/page-";
    private static final int TOTAL_PAGES = 50;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> scrapeAllPages() {
        List<Book> allBooks = new ArrayList<>();
        for (int page = 1; page <= TOTAL_PAGES; page++) {
            String pageUrl = BASE_URL + page + ".html";
            allBooks.addAll(scrapeBooksData(pageUrl));
        }
        return allBooks;
    }

    public void storeBookData(List<Book> books) {
        if (!books.isEmpty()) {
            bookRepository.saveAll(books);
        }
    }

    private List<Book> scrapeBooksData(String url) {
        List<Book> books = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url).get();
            Elements bookElements = document.select("article.product_pod");

            for (Element element : bookElements) {

                String title = element.select("h3 > a").attr("title");
                String priceText = element.select("p.availability").text();
                String availability = element.select("p.price_color").first().text();
                String rating = element.select("p.star-rating").attr("class").split(" ")[1];

                Book book = new Book(title, priceText, availability, rating);
                books.add(book);
            }

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return books;
    }


}
