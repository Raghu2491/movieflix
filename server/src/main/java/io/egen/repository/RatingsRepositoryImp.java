package io.egen.repository;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.entity.Ratings;

@Repository
public class RatingsRepositoryImp implements RatingsRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public double findByArguments(Map<String, String> params) {
		TypedQuery<Double> query;
		if(params.get("movieId")!=null)
		{
			query = em.createNamedQuery("Rating.findRatingAvgByMovieId", Double.class);
			query.setParameter("pMovieId", params.get("movieId"));
		}	
		else	
			query = em.createNamedQuery("Rating.findAll", Double.class);
		double avg = query.getSingleResult();
		return avg;
	}

	@Override
	public List<Ratings> findByUserIdMovieId(String userId, String movieId) {
		TypedQuery<Ratings> query = em.createNamedQuery("Rating.findRatingByUserIdMovieId", Ratings.class);
		query.setParameter("pUserId", userId); 
		query.setParameter("pMovieId", movieId);
		return query.getResultList();
	}
	
	@Override
	public Ratings findById(String id) {
		return em.find(Ratings.class, id);
	}
	
	@Override
	public Ratings create(Ratings emp) {
		em.persist(emp);
		return emp;
	}

	@Override
	public Ratings update(Ratings emp) {
		return em.merge(emp);
	}

	@Override
	public void delete(Ratings emp) {
		em.remove(emp);
	}
}
