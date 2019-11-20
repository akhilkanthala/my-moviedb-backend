package com.zemoso.mymoviedb.favourite;

import com.zemoso.mymoviedb.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

public class FavouriteServiceImpl implements FavouriteService {
    @Autowired
    private FavouriteRepository favouriteRepository;

    public List<Favourite> getFavourites(Integer id) {
        return favouriteRepository.findAllByUserIdAndDeleted(id, false);
    }

    public Favourite addFavourite(Favourite favourite) {
        return favouriteRepository.save(favourite);
    }

    public Boolean isPresent(Integer id, Integer mid) {
        return favouriteRepository.existsByUserIdAndMovieIdAndDeleted(id, mid, false);
    }
@Transactional
    public void deleteFavourite(Integer id, Integer mid) {
        favouriteRepository.deleteByUserIdAndMovieId(id,mid);
//        Favourite favourite = favouriteRepository.getOneByUserIdAndMovieIdAndDeleted(id, mid, false);
//        if (Objects.isNull(favourite)) {
//            throw new BadRequestException("User id is invalid");
//        }
//        favourite.setDeleted(true);
//        favouriteRepository.save(favourite);
//        return user;

//        return null;
    }
}
