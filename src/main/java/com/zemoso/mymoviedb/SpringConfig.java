package com.zemoso.mymoviedb;

import com.zemoso.mymoviedb.favourite.FavouriteService;
import com.zemoso.mymoviedb.favourite.FavouriteServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public FavouriteService favouriteService() {
        return new FavouriteServiceImpl();
    }

}