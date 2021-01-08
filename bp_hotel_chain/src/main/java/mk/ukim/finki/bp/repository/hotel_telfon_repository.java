package mk.ukim.finki.bp.repository;

import mk.ukim.finki.bp.model.hotel_telefon;
import mk.ukim.finki.bp.model.hotel_telefon_id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface hotel_telfon_repository extends JpaRepository<hotel_telefon, hotel_telefon_id> {
}
