package mk.ukim.finki.bp.repository;

import mk.ukim.finki.bp.model.gostin_telefon;
import mk.ukim.finki.bp.model.gostin_telefon_id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface gostin_telefon_repository extends JpaRepository<gostin_telefon, gostin_telefon_id> {
}
