package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entity.Client;
import tn.esprit.entity.Stock;
@Repository
public interface StockRepository extends CrudRepository<Stock,Long> {

}
