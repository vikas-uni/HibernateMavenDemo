package main;


import java.util.HashSet;
import java.util.Set;

import model.Author;
import model.Book;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class MainApp {

	private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
	public static void main(String[] args) {
		insert();

	}
	
	private static void insert(){
		
		Session sess = factory.openSession();
		sess.beginTransaction();
		
		Set<Author> howToProgramWithJavaAuthor = new HashSet<Author>();  
        Set<Author> howToProgramWithJava2ndAuthors = new HashSet<Author>();  
        Set<Author> howToPlayGuitarAuthor = new HashSet<Author>();  
          
        Set<Book> trevorsBooks = new HashSet<Book>();  
        Set<Book> johnsBooks = new HashSet<Book>();  
          
        Author author = new Author();  
        author.setAuthorName("Trevor Page");  
        howToProgramWithJavaAuthor.add(author);  
          
        Author author2 = new Author();  
        author2.setAuthorName("John Doe");  
          
        howToProgramWithJava2ndAuthors.add(author);  
        howToProgramWithJava2ndAuthors.add(author2);  
        howToPlayGuitarAuthor.add(author2);  
          
        Book book = new Book();  
        book.setBookName("How to Program with Java");  
          
        Book book2 = new Book();  
        book2.setBookName("How to Program with Java 2nd Edition");  
          
        Book book3 = new Book();  
        book3.setBookName("How to Play Guitar");  
          
        trevorsBooks.add(book);  
        trevorsBooks.add(book2);  
        johnsBooks.add(book2);  
        johnsBooks.add(book3);  
        author.setBooks(trevorsBooks);  
        author2.setBooks(johnsBooks);  
        book.setAuthors(howToProgramWithJavaAuthor);  
        book2.setAuthors(howToProgramWithJava2ndAuthors);  
        book3.setAuthors(howToPlayGuitarAuthor);  
          
        sess.save(author);  
        sess.save(author2);  
        
        sess.getTransaction().commit();
        sess.flush();
        sess.close();
        
        factory.close();
	}
	
	private static void list(){
		Session session = factory.openSession();
		Author auth = (Author) session.load(Author.class, 2);
		System.out.println(auth.getAuthorName());
	}

}
