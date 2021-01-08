package mk.ukim.finki.bp.repository;

import mk.ukim.finki.bp.model.rezervacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface rezervacija_repository extends JpaRepository<rezervacija, Integer> {
}
