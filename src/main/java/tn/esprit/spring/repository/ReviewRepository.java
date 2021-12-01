package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}
