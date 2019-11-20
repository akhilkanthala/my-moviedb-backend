package com.zemoso.mymoviedb.favourite;

import com.zemoso.mymoviedb.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FavouriteController {
    private Logger logger = Logger.getLogger(FavouriteController.class.getName());
    @Autowired
    private FavouriteService favouriteService;


    @PostMapping(value = "/users/{id}/favourites")
    public ResponseEntity<Favourite> addUser(@PathVariable("id") Integer id, @RequestBody final Favourite favourite) {
        favourite.setUser(new User(id));
//        System.out.println(favourite.getUser().getUserName());
        return new ResponseEntity<>(favouriteService.addFavourite(favourite), HttpStatus.CREATED);
    }

    @GetMapping(value = "/users/{id}/favourite")
    public ResponseEntity<?> getFavourites(@PathVariable("id") Integer id, @RequestParam("mid") Integer mid) {
        return new ResponseEntity<>(favouriteService.isPresent(id, mid), HttpStatus.OK);
    }

    @GetMapping(value = "/users/{id}/favourites")
    public ResponseEntity<?> getFavourites(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(favouriteService.getFavourites(id), HttpStatus.OK);
    }
    @DeleteMapping(value = "/users/{id}/favourites/{mid}")
    public ResponseEntity<?> deleteFavourites(@PathVariable("id") Integer id, @PathVariable("mid") Integer mid) {
        favouriteService.deleteFavourite(id, mid);
        return new ResponseEntity<>("favourite marked as deleted", HttpStatus.OK);
    }
//    @DeleteMapping(value = "/users/{id}")
//    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
//        userService.deleteUser(id);
//        return new ResponseEntity<>("User marked as deleted", HttpStatus.ACCEPTED);
//    }
}
