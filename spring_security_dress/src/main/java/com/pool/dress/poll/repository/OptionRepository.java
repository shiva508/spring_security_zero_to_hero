package com.pool.dress.poll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.security.dress.poll.domine.Option;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long>{

}
