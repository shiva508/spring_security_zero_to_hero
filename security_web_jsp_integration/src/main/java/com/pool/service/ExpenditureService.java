package com.pool.service;

import java.util.List;

import com.pool.model.Expenditure;

public interface ExpenditureService {
	public Expenditure saveExpenditure(Expenditure expenditure) ;
	public List<Expenditure> getAllExpenditure();
	public List<Expenditure> findByUserId(Integer userId);
	public void deleteByExpenditureId(Integer expenditureId);
}
