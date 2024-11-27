 # Books to Scrape Web Scraper

This project is a Spring Boot application that scrapes book data from the [Books to Scrape](https://books.toscrape.com/) website and stores it in a PostgreSQL database.

Technologies Used

    Java - collections, OOP
    Backend
        Spring Boot 
        Spring Data JPA
        Spring WEB
        Spring starter tomcat
    Database - PostgreSQL
  

Key Features

   **Scrape Book Data from Multiple Pages**: The `scrapeAllPages()` method in the `BookService` class iterates through the first 50 pages of the Books to Scrape website, scraping book data from each page and aggregating the results.

   **Extract Book Details**: The `scrapeBooksData()` method in the `BookService` class uses JSoup to extract the following information for each book: title, price, availability, and rating.

   **Save Book Data to Database**: The `storeBookData()` method in the `BookService` class saves the scraped book data to a PostgreSQL database using Spring Data JPA.

    Clone the repository: https://github.com/mxvell/BookScrape.git 
    Configure your PostgreSQL database in application.properties:  
    - spring.datasource.url=jdbc:postgresql://localhost:5432/bookScraper
    - spring.datasource.username=your-username
    - spring.datasource.password=your-password
    Run the application using your IDE or with mvn spring-boot:run 

## Usage

The entry point of the application is the `BookScrapeApplication` class. The `run()` method in this class is the main entry point, which calls the `scrapeAllPages()` and `storeBookData()` methods in the `BookService` class.

The `BookService` class has the following methods:

1. `scrapeAllPages()`: This method iterates through the first 50 pages of the Books to Scrape website, scraping book data from each page and returning a list of `Book` objects.

2. `scrapeBooksData(String url)`: This method takes a page URL as input, connects to the page using JSoup, and extracts the book data (title, price, availability, and rating) from the page.

3. `storeBookData(List<Book> books)`: This method saves the list of `Book` objects to the PostgreSQL database using the `BookRepository` interface.

The `Book` class is the entity class that represents a book, and the `BookRepository` interface is the Spring Data JPA repository for interacting with the `Book` entity.

