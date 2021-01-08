package mk.ukim.finki.bp.web;

import mk.ukim.finki.bp.model.*;
import mk.ukim.finki.bp.repository.*;
import mk.ukim.finki.bp.service.hotel_service;
import mk.ukim.finki.bp.views.R11Dto;
import mk.ukim.finki.bp.views.R12Dto;
import mk.ukim.finki.bp.views.R13Dto;
import mk.ukim.finki.bp.views.R14Dto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/hotels")
public class HoteliController {
    private final hotel_service hotel_service;
    private final hotel_repository hotel_repository;
    private final rezervacija_repository rezervacija_repository;
    private final ocenuva_repository ocenuva_repository;
    private final soba_repository soba_repository;
    private final gostin_repository gostin_repository;

    public HoteliController(mk.ukim.finki.bp.service.hotel_service hotel_service,
                            mk.ukim.finki.bp.repository.hotel_repository hotel_repository,
                            mk.ukim.finki.bp.repository.rezervacija_repository rezervacija_repository,
                            mk.ukim.finki.bp.repository.ocenuva_repository ocenuva_repository,
                            mk.ukim.finki.bp.repository.soba_repository soba_repository, mk.ukim.finki.bp.repository.gostin_repository gostin_repository) {
        this.hotel_service = hotel_service;
        this.hotel_repository = hotel_repository;
        this.rezervacija_repository = rezervacija_repository;
        this.ocenuva_repository = ocenuva_repository;
        this.soba_repository = soba_repository;
        this.gostin_repository = gostin_repository;
    }

    @GetMapping
    public String getHotelsPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<hotel> hotelList = this.hotel_service.hoteli();
        model.addAttribute("hoteli",hotelList);
        List<R12Dto> hoteli = this.hotel_service.hotels();
        model.addAttribute("hotels", hoteli);
        return "hotels";
    }
    @GetMapping("/grades-and-comments")
    public String getGradesAndCommentsPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<R11Dto> ocenki_i_komentari = this.hotel_service.oceni_i_komentari();
        model.addAttribute("ocenki_i_komentari", ocenki_i_komentari);
        return "grades_and_comments";
    }
    @GetMapping("/reservations")
    public String getReservationsForHotelX(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("hoteli", this.hotel_service.hoteli());
        return "reservationsx";
    }
    @PostMapping("/reservations")
    public String reservationView(@RequestParam int hotelce,Model model) {
            hotel h = this.hotel_repository.findById(hotelce).get();
            model.addAttribute("hoteli", this.hotel_service.hoteli());
            model.addAttribute("hotel", h);
            List<R13Dto> rezervaciizahotelx = this.hotel_service.rezervacii_za_daden_hotel(h.getHotelIme());
            model.addAttribute("rezervacii", rezervaciizahotelx);
        return "reservationsx";
    }
    @GetMapping("/grading")
    public String getGradingForm( Model model) {
        List<hotel> hotelList = this.hotel_service.hoteli();
        model.addAttribute("hotels", hotelList);
        return "grading-form";
    }
    @PostMapping("/grading")
    public String gradingForm(@RequestParam int hotel_id,
                              @RequestParam int rezervacija_id,
                              @RequestParam String gostin_embg,
                              @RequestParam String komentar,
                              @RequestParam int ocena,
                              Model model) {
        if(this.hotel_repository.findById(hotel_id).isPresent()
                && this.rezervacija_repository.findById(rezervacija_id).isPresent()) {
            hotel h = this.hotel_repository.findById(hotel_id).get();
            rezervacija r = this.rezervacija_repository.findById(rezervacija_id).get();
            if(r.getGostin().getGostin_embg().equals(gostin_embg)
                    && r.getSoba().getH().getHotelIme().equals(h.getHotelIme())) {
                    ocenuva ocenka= new ocenuva(new ocenuvaId(r.getGostin(),h,r),ocena,komentar);
                    this.ocenuva_repository.save(ocenka);
                return "redirect:/hotels/grades-and-comments";
            }
            else
                return "redirect:/hotels/grades-and-comments?error=YouMustHaveMadeReservationInTheHotelThatYouWantToGrade";
        }
        return "redirect:/hotels/grades-and-comments?error=YouEnteredWrongData";
    }

    @GetMapping("/rooms/{id}")
    public String getRoomsForHotelX(@PathVariable int id, Model model) {
       // hotel h = this.hotel_repository.findById(id).get();
        R12Dto hotel = this.hotel_repository.getR12().get(id);
        String ime=hotel.getHOTEL_IME();
        List<R14Dto> sobizahotelx = this.hotel_service.sobi_na_daden_hotel(ime);
        model.addAttribute("rooms", sobizahotelx);
        return "roomsx";
    }
    @GetMapping("/makeReservation/{id}")
    public String getMakeReservation(@PathVariable int id, Model model) {

        R14Dto soba = this.hotel_repository.getR14().get(id);
        int soba_broj = soba.getSOBA_BROJ();
        String hotel_ime = soba.getHOTEL_IME();
        hotel h = this.hotel_repository.findByHotelIme(hotel_ime).get();
        soba s = this.soba_repository.findByHHotelIdAndSobaBroj(h.getHotelId(),soba_broj).get();
        String ai = "all inclusive";
        String bi = "breakfast included";
        String na = "no addition";
        model.addAttribute("ai",ai);
        model.addAttribute("bi",bi);
        model.addAttribute("na",na);
        model.addAttribute("soba", s);
        model.addAttribute("hotel",h);
        return "rezerviraj";
    }

    @PostMapping("/makereservation")
    public String madeReservation(@RequestParam int soba_id,
                                  @RequestParam String gostin_embg,
                                  @RequestParam String gostin_ime,
                                  @RequestParam String gostin_prezime,
                                  @RequestParam String gostin_email,
                                  @RequestParam String check_in,
                                  @RequestParam String check_out,
                                  @RequestParam String usluga_ime) throws ParseException {
        gostin g = new gostin(gostin_embg,gostin_ime,gostin_prezime,gostin_email);
        this.gostin_repository.save(g);
        soba s = this.soba_repository.findById(soba_id).get();
        Date d=new SimpleDateFormat("yyyy-MM-dd").parse(check_in);
        Date d1=new SimpleDateFormat("yyyy-MM-dd").parse(check_out);
        rezervacija r = new rezervacija(d,d1,usluga_ime,s,g);
        this.rezervacija_repository.save(r);
      return "redirect:/hotels/reservations";
    }
}
