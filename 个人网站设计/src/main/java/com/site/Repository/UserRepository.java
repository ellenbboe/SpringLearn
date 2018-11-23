package com.site.Repository;

import com.site.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
    Boolean existsByuserNameAndPassword(String userName,String Password);
    User findByuserNameAndPassword(String userName,String Password);
}
