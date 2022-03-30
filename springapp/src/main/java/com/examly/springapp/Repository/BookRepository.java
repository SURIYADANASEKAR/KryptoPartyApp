package ccom.examly.springapp.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ccom.examly.springapp.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	@Query("Select book  FROM bookConfirm book WHERE book.user_id=:user_id")
	List<Book> getCartByuserId(@Param("user_id")Long user_id);
	


}