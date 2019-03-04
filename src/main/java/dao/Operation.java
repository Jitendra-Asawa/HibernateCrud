package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import data.Book;

public class Operation {
	private static SessionFactory factory;

	private Session session = null;

	public Operation() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void add(Book book) {
		session = factory.openSession();
		session.beginTransaction();
		session.save(book);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Book> read(int id) {
		session = factory.openSession();
		session.beginTransaction();
		String sql = "from Book where id =:id";
		Query<Book> query = (Query<Book>) session.createQuery(sql);
		query.setParameter("id", id);
		List<Book> results = (List<Book>) query.list();
		session.close();
		return results;
	}

	public List<Book> readAll() {
		session = factory.openSession();
		session.beginTransaction();
		String sql = "from Book";
		@SuppressWarnings("unchecked")
		List<Book> list = (List<Book>) session.createQuery(sql).list();
		session.close();
		return list;
	}

	public void update(Book book) {
		session = factory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(book);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(Book book) {
		session = factory.openSession();
		session.beginTransaction();
		session.delete(book);
		session.getTransaction().commit();
		session.close();
	}

	public void shutdown() {
		// Close caches and connection pools
		factory.close();
	}
}
