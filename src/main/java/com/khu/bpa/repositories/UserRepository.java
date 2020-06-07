package com.khu.bpa.repositories;

import com.khu.bpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT COUNT(u)>0 FROM User u WHERE u.username=:username")
    Boolean isUsernameExist(@Param("username") String username);

    @Query("SELECT COUNT(u)>0 FROM User u WHERE u.email=:email")
    Boolean isEmailExist(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.username=:username")
    User getUserByUsername(@Param("username") String username);

    @Query("SELECT u FROM User u WHERE u.role='PATIENT'")
    List<User> getAllPatients();
}
