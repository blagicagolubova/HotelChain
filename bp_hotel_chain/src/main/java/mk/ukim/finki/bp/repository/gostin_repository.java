package mk.ukim.finki.bp.repository;

import mk.ukim.finki.bp.model.gostin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface gostin_repository extends JpaRepository<gostin, String> {
}
