package com.sap.acme.imdb2.repository.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sap.acme.imdb2.entity.Genre;
import com.sap.acme.imdb2.repository.interfaces.GenreDao;

@Repository
public class HibernateGenreDao implements GenreDao{

	private SessionFactory sessionFactory;
	
	@Autowired
	public HibernateGenreDao(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Genre> findGenres() {
		try(Session session = sessionFactory.openSession()){
			return session.createQuery("from Genre").getResultList();
		}
	}
}
