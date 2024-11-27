package testTask.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import testTask.demo.entity.Book;
import testTask.demo.service.BookService;

import java.util.List;

@SpringBootApplication
public class BookScrapeApplication implements CommandLineRunner {
    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(BookScrapeApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        List<Book> books = bookService.scrapeAllPages();
        bookService.storeBookData(books);
        System.out.println("Book data stored in the database");
    }
}
