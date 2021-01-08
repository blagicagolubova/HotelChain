package mk.ukim.finki.bp.repository;

import mk.ukim.finki.bp.model.soba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface soba_repository extends JpaRepository<soba, Integer> {
    Optional<soba> findByHHotelIdAndSobaBroj(int id,int sb);
}
