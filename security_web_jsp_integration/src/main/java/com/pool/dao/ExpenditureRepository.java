package com.pool.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pool.model.Expenditure;
@Repository
public interface ExpenditureRepository extends JpaRepository<Expenditure, Integer> {
public List<Expenditure> findByUserId(Integer userId);
@Modifying
@Query("DELETE FROM Expenditure E where E.expenditureId=?1")
public void deleteByExpenditureId(Integer expenditureId);

}
