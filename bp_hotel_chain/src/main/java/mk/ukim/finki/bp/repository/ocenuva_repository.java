package mk.ukim.finki.bp.repository;

import mk.ukim.finki.bp.model.ocenuva;
import mk.ukim.finki.bp.model.ocenuvaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ocenuva_repository extends JpaRepository<ocenuva, ocenuvaId> {
}
