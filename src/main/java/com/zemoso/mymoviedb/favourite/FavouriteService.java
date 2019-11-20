package com.zemoso.mymoviedb.favourite;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FavouriteService {

    public Favourite addFavourite(Favourite favourite);

 public    List<Favourite> getFavourites(Integer id);

    Boolean isPresent(Integer id, Integer mid);

   public void deleteFavourite(Integer id, Integer mid);
//    public Favourite deleteFavourite(MovieJson movieObject);
}
