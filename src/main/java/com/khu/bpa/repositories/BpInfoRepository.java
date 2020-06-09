package com.khu.bpa.repositories;

import com.khu.bpa.entities.BpInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BpInfoRepository extends JpaRepository<BpInfo, Long> {

    @Query("SELECT COUNT(u)>0 FROM User u WHERE u.username=:username")
    Boolean isUsernameExist(@Param("username") String username);

    @Query("SELECT b FROM BpInfo b JOIN User u ON b.user.id=u.id WHERE u.username=:username")
    BpInfo getBpInfoByUsername(@Param("username") String username);

}
