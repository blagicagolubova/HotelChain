package mk.ukim.finki.bp.service;

import mk.ukim.finki.bp.model.hotel;
import mk.ukim.finki.bp.views.R11Dto;
import mk.ukim.finki.bp.views.R12Dto;
import mk.ukim.finki.bp.views.R13Dto;
import mk.ukim.finki.bp.views.R14Dto;

import java.util.List;

public interface hotel_service {
    List<R11Dto> oceni_i_komentari();
    List<hotel> hoteli();
    List<R12Dto> hotels();
    List<R13Dto> rezervacii_za_daden_hotel(String name);
    List<R14Dto> sobi_na_daden_hotel(String name);
}
