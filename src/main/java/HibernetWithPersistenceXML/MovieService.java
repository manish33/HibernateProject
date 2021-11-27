package HibernetWithPersistenceXML;

import org.springframework.orm.hibernate5.HibernateOperations;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Service
public class MovieService {
    static EntityManager em;
    EntityManager getEntityManager(){
        if(em==null){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernetWithPersistenceXML");
             em = emf.createEntityManager();
        }
        return em;
    }

    public Movie getMovie(Long movieId) {
        EntityManager em = getEntityManager();
        Movie movie = em.find(Movie.class, new Long(movieId));
        System.out.println("all movie removed");
        em.detach(movie);
        return movie;
    }

    public void saveMovie() {
        EntityManager em= getEntityManager();

        em.getTransaction().begin();
        Movie movie = new Movie();
        movie.setId(1L);
        movie.setMovieName("The Godfather");
        movie.setReleaseYear(1972);
        movie.setLanguage("English");

        em.persist(movie);
        em.getTransaction().commit();
    }

    public List<?> queryForMovies() {
        EntityManager em = getEntityManager();
        List<?> movies = em.createQuery("SELECT movie from Movie movie where movie.language = ?1")
                .setParameter(1, "English")
                .getResultList();
        return movies;
    }

    public void mergeMovie() {
        EntityManager em = getEntityManager();
        Movie movie = getMovie(1L);
        em.detach(movie);
        movie.setLanguage("Italian");
        em.getTransaction().begin();
        em.merge(movie);
        em.getTransaction().commit();
    }
    public void removeMovie() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Movie movie = em.find(Movie.class, new Long(1L));
        em.remove(movie);
        em.getTransaction().commit();
    }

    public static void main(String[] args) {
        MovieService movieService = new MovieService();
        movieService.saveMovie();
        List<?> objects = movieService.queryForMovies();
        System.out.println(objects.size()+" size");
        objects.stream().forEach(o -> ((Movie)o).getLanguage());
        movieService.mergeMovie();
        movieService.getMovie((long) 1);
        movieService.removeMovie();
        movieService.getMovie((long) 1);

    }
}
