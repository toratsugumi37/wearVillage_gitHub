package com.example.wearVillage.DAO.myPageDeleteDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Slf4j
@Repository(value = "deleteAccount")
@RequiredArgsConstructor

public class DeleteAccountDAOImpl implements DeleteAccountDAO {
    private final NamedParameterJdbcTemplate template;

    @Override
    public Boolean DeleteAccount(String id) {
        StringBuffer sql = new StringBuffer();
        sql.append("delete from USER_INFO ");
        sql.append( "where id = :id ");

        Map<String,String> param = Map.of("id",id);

        try{
            int updatedRow = template.update(sql.toString(),param);
            if(updatedRow>=1){
                return true;
            } else {
                return false;
            }
        } catch (EmptyResultDataAccessException e){
            return false;
        }
    }
}