package com.zemoso.mymoviedb.favourite;


import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface FavouriteRepository extends JpaRepository<Favourite, Integer> {
    public List<Favourite> findAllByDeleted(Boolean deleted);
public List<Favourite> findAllByUserIdAndDeleted(Integer id,Boolean deleted);
    public Favourite getOneByUserIdAndMovieIdAndDeleted(Integer id,Integer mid,Boolean deleted);
public Boolean existsByUserIdAndMovieIdAndDeleted(Integer id,Integer mid,Boolean deleted);

    void deleteByUserIdAndMovieId(Integer id, Integer mid);
}
