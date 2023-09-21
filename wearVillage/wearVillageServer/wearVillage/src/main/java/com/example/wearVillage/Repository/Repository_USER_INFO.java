package com.example.wearVillage.Repository;


import com.example.wearVillage.Entity.USER_INFO;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository_USER_INFO extends JpaRepository <USER_INFO, String> {

    List<USER_INFO> findByID(String ID);
    USER_INFO findByEMAIL(String EMAIL);
    Boolean existsByEMAIL(String EMAIL);
    List<USER_INFO> findByIDAndPW(String ID, String PW);
    Boolean existsByID(String ID);


}





