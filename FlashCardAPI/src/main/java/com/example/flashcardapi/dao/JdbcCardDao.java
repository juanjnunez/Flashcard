package com.example.flashcardapi.dao;

import com.example.flashcardapi.model.Card;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcCardDao implements CardDao {
    private final JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public JdbcCardDao() {
    }

    @Override
    public Card addCard(Card card){
        Card createdCard = new Card();
        String sql = "INSERT INTO card (question, answer, tag_id)" +
                "VALUES (?, ?, ?) RETURNING id;";
        try{
            int newCardId = jdbcTemplate.queryForObject(sql, int.class, card.getQuestion(),
                    card.getAnswer(), card.getTagId());
            createdCard = getCardById(newCardId);
        } catch (CannotGetJdbcConnectionException e) {
            System.out.println("Sorry, could not connect");
        } catch (DataIntegrityViolationException e){
            System.out.println("Sorry, could not add new card");
        }
        return createdCard;
    }

    @Override
    public Card getCardById(int id){
        Card returningCard = null;
        String sql = "SELECT * FROM card WHERE id = ?;";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql,id);
            if (results.next()){
                returningCard = mapToResults(results);
            }
        } catch (CannotGetJdbcConnectionException e){
            System.out.println("Sorry, could not connect");
        }
        return returningCard;
    }

    private Card mapToResults(SqlRowSet rowSet){
        Card newCard = new Card();
        newCard.setId(rowSet.getInt("id"));
        newCard.setQuestion(rowSet.getString("question"));
        newCard.setAnswer(rowSet.getString("answer"));
        newCard.setTagId(rowSet.getInt("tag_id"));
        return newCard;
    }
}
