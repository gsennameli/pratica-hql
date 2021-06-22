package com.example.praticahql.repositories;

import com.example.praticahql.dtos.UserPasswordDTO;
import com.example.praticahql.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Transactional
    @Modifying
    @Query("update User u set u.password = :#{#user.password} where u.id = :#{#user.id}")
    void updateUserPassword(@Param("user")UserPasswordDTO userPasswordDTO);

    List<User> findByNameContains(String nameSubstring);
}
