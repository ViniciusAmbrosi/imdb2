package com.sap.acme.imdb2.repository.dao;

import java.util.List;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sap.acme.imdb2.entity.Movie;
import com.sap.acme.imdb2.repository.interfaces.MovieDao;

@Repository
public class HibernateMovieDao implements MovieDao{

	private SessionFactory sessionFactory;
	
	@Autowired
	public HibernateMovieDao(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> findMovies() {
		try(Session session = sessionFactory.openSession()){
			return session.createQuery("from Movie").getResultList();
		}
	}
	
	@Override
	public Movie findMovieById(Long id) {
		try(Session session = sessionFactory.openSession()){
			DetachedCriteria criteria = DetachedCriteria.forClass(Movie.class);
			criteria.add(Restrictions.idEq(id));
			return (Movie) criteria.getExecutableCriteria(session).uniqueResult();
		}
	}

	@Override
	public void save(Movie movie) {
		Transaction transaction = null;
		try(Session session = sessionFactory.openSession()){
			transaction = session.beginTransaction();
			session.save(movie);
			transaction.commit();
		}catch(Exception e){
			transaction.rollback();
		}
	}

	@Override
	public void update(Movie movie) {
		Transaction transaction = null;
		try(Session session = sessionFactory.openSession()){
			transaction = session.beginTransaction();
			session.update(movie);
			transaction.commit();
		}catch(Exception e){
			transaction.rollback();
		}
	}

	@Override
	public void remove(Movie movie) {
		Transaction transaction = null;
		try(Session session = sessionFactory.openSession()){
			transaction = session.beginTransaction();
			session.remove(movie);
			transaction.commit();
		}catch(Exception e){
			transaction.rollback();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> findMoviesByName(String filter) {
		try(Session session = sessionFactory.openSession()){
			DetachedCriteria criteria = DetachedCriteria.forClass(Movie.class);
			criteria.add(Restrictions.like("title", filter, MatchMode.ANYWHERE));
			criteria.setFetchMode("genres", FetchMode.SELECT);
			return (List<Movie>) criteria.getExecutableCriteria(session).list();
		}
	}
}
