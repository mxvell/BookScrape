package testTask.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import testTask.demo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
