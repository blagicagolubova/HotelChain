package mk.ukim.finki.bp.repository;

import mk.ukim.finki.bp.model.grad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface grad_repository extends JpaRepository<grad, Integer> {
}
