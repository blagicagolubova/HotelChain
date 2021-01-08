package mk.ukim.finki.bp.service.impl;

import mk.ukim.finki.bp.model.hotel;
import mk.ukim.finki.bp.repository.hotel_repository;
import mk.ukim.finki.bp.service.hotel_service;
import mk.ukim.finki.bp.views.R11Dto;
import mk.ukim.finki.bp.views.R12Dto;
import mk.ukim.finki.bp.views.R13Dto;
import mk.ukim.finki.bp.views.R14Dto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class hotel_service_impl implements hotel_service {

    private final hotel_repository hotel_repository;

    public hotel_service_impl(mk.ukim.finki.bp.repository.hotel_repository hotel_repository) {
        this.hotel_repository = hotel_repository;
    }

    @Override
    public List<R11Dto> oceni_i_komentari() {
        return this.hotel_repository.getR11();
    }

    @Override
    public List<hotel> hoteli() {
        return this.hotel_repository.findAll();
    }

    @Override
    public List<R12Dto> hotels() {
        return this.hotel_repository.getR12();
    }

    @Override
    public List<R13Dto> rezervacii_za_daden_hotel(String name) {
        return this.hotel_repository.getR13().stream().filter(i->i.getHOTEL_IME().equals(name)).collect(Collectors.toList());
    }

    @Override
    public List<R14Dto> sobi_na_daden_hotel(String name) {
        return this.hotel_repository.getR14().stream().filter(i->i.getHOTEL_IME().equals(name)).collect(Collectors.toList());
    }
}
