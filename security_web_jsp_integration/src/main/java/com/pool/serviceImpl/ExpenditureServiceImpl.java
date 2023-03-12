package com.pool.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pool.dao.ExpenditureRepository;
import com.pool.model.Expenditure;
import com.pool.service.ExpenditureService;
@Service
@Transactional
public class ExpenditureServiceImpl implements ExpenditureService {
	@Autowired
	private ExpenditureRepository expenditureRepository;

	@Override
	public Expenditure saveExpenditure(Expenditure expenditure) {
			return expenditureRepository.save(expenditure);
	}

	@Override
	public List<Expenditure> getAllExpenditure() {
			return expenditureRepository.findAll();
	}

	@Override
	public List<Expenditure> findByUserId(Integer userId) {
		return expenditureRepository.findByUserId(userId);
	}

	@Override
	public void deleteByExpenditureId(Integer expenditureId) {
		expenditureRepository.deleteByExpenditureId(expenditureId);
		
	}
	
	
	
}
