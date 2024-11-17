package unoeste.fipp.mymovies.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import unoeste.fipp.mymovies.entity.Filme;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Filme, String> {
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Filme> searchByTitle(String title);
}
