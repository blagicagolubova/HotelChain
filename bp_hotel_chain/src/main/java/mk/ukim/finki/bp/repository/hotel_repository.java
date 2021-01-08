package mk.ukim.finki.bp.repository;

import mk.ukim.finki.bp.model.hotel;
import mk.ukim.finki.bp.views.R11Dto;
import mk.ukim.finki.bp.views.R12Dto;
import mk.ukim.finki.bp.views.R13Dto;
import mk.ukim.finki.bp.views.R14Dto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface hotel_repository extends JpaRepository<hotel, Integer> {
    @Query(nativeQuery = true, value = "select * from oceni_i_komentari")
    List<R11Dto> getR11();
    @Query(nativeQuery = true, value = "select * from pogled_na_hotelite_od_lanecot")
    List<R12Dto> getR12();
    @Query(nativeQuery = true, value = "select * from rezervacii_za_daden_hotel")
    List<R13Dto> getR13();
    @Query(nativeQuery = true, value = "select * from sobi_na_daden_hotel")
    List<R14Dto> getR14();
    Optional<hotel> findByHotelIme(String name);
}
