package com.zemoso.mymoviedb.favourite;

import com.zemoso.mymoviedb.baseEntity.BaseEntity;
import com.zemoso.mymoviedb.user.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Entity
@Table(name = "favourites")
@Getter
@Setter
@TypeDef(name = "MovieJsonType", typeClass = MovieJsonType.class)
public class Favourite  extends BaseEntity{
    @Column(nullable = false)
    private Integer movieId;
    @Type(type = "MovieJsonType")
    private MovieJson movieObject;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="user_id")
    private User user;

    public Favourite(Integer id,MovieJson movieObject,User user){
        this.id=id;
        this.movieObject=movieObject;
        this.user=user;
    }
    public Favourite(){
        super();
    }
}
