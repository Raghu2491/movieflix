package io.egen.repository;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.egen.entity.Movies;

@Repository
public class MoviesRepositoryImp implements MoviesRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Movies> findAll() {
		TypedQuery<Movies> query = em.createNamedQuery("Movie.findAll", Movies.class);
		return query.getResultList();
	}

	@Override
	public Movies findById(String id) {
		return em.find(Movies.class, id);
	}

	@Override
	public List<Movies> findByArguments(Map<String, String> params) {
		TypedQuery<Movies> query=null;
		
		if(params.get("type")!=null)
		{	
			if(params.get("sort")=="year")
				query = em.createNamedQuery("Movie.findMovieByTypeSortByYear", Movies.class);
			else if(params.get("sort")=="rating") 
				query = em.createNamedQuery("Movie.findMovieByTypeSortByRating", Movies.class);
			else if(params.get("sort")=="votes") 
				query = em.createNamedQuery("Movie.findMovieByTypeSortByVotes", Movies.class);
			else
				query = em.createNamedQuery("Movie.findMovieByType", Movies.class);
			query.setParameter("pType", params.get("type")); 
		}	
		else if(params.get("year")!=null)
		{
			if(params.get("sort")=="year")
				query = em.createNamedQuery("Movie.findAllMovieSortByYear", Movies.class);
			else if(params.get("sort")=="rating") 
				query = em.createNamedQuery("Movie.findMovieByYearSortByRating", Movies.class);
			else if(params.get("sort")=="votes") 
				query = em.createNamedQuery("Movie.findMovieByYearSortByVotes", Movies.class);
			else
				query = em.createNamedQuery("Movie.findMovieByYear", Movies.class);
			query.setParameter("pYear", Integer.parseInt(params.get("year")));
		}
		else if(params.get("genre")!=null)
		{
			if(params.get("sort")=="year")
				query = em.createNamedQuery("Movie.findMovieByGenreSortByYear", Movies.class);
			else if(params.get("sort")=="rating") 
				query = em.createNamedQuery("Movie.findMovieByGenreSortByRating", Movies.class);
			else if(params.get("sort")=="votes") 
				query = em.createNamedQuery("Movie.findMovieByGenreSortByVotes", Movies.class);
			else
				query = em.createNamedQuery("Movie.findMovieByGenre", Movies.class);
			query.setParameter("pGenre", params.get("genre"));
		}
		else
		{

			if(params.get("sort")=="year")
				query = em.createNamedQuery("Movie.findAllMovieSortByYear", Movies.class);
			else if(params.get("sort")=="rating") 
				query = em.createNamedQuery("Movie.findAllMovieSortByRating", Movies.class);
			else if(params.get("sort")=="votes") 
				query = em.createNamedQuery("Movie.findAllMovieSortByVotes", Movies.class);
			else
				query = em.createNamedQuery("Movie.findAll", Movies.class);
		}
		
		List<Movies> movies = query.getResultList();
		return movies;
	}
	
	@Override
	public Movies findByTitle(String title) {
		TypedQuery<Movies> query = em.createNamedQuery("Movie.findMovieByTitle", Movies.class);
		query.setParameter("pTitle", title);
		List<Movies> Movies = query.getResultList();
		if (Movies != null && Movies.size() == 1) {
			return Movies.get(0);
		}
		return null;
	}

	@Override
	public Movies create(Movies movie) {
		em.persist(movie);
		return movie;
	}

	@Override
	public Movies update(Movies emp) {
		return em.merge(emp);
	}

	@Override
	public void delete(Movies emp) {
		em.remove(emp);
	}
}
