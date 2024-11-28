package testTask.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import testTask.demo.entity.Book;
import testTask.demo.service.BookService;

import java.util.List;

@SpringBootApplication
public class BookScrapeApplication  {

    public static void main(String[] args) {
        SpringApplication.run(BookScrapeApplication.class, args);
    }


}
