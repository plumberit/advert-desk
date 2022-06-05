package com.shapovalov.course.controllers;

import com.shapovalov.course.model.Admin;
import com.shapovalov.course.model.Advertisement;
import com.shapovalov.course.model.Client;
import com.shapovalov.course.repositories.AdminRepository;
import com.shapovalov.course.repositories.ClientRepository;
import com.shapovalov.course.repositories.AdvertisementRepository;
import com.shapovalov.course.service.AdvertisementSearcher;
import com.shapovalov.course.service.ExtendedAdvertisement;
import com.shapovalov.course.service.ExtendedAdvertisementCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
public class SiteController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @GetMapping("/")
    public String getMainPage(Model model) {
        Iterable<Client> guests = clientRepository.findAll();
        model.addAttribute("guests", guests);
        return "system templates/white at start";
    }


    @PostMapping("/")
    public String postMainPage(@RequestParam String email, @RequestParam String password) {
        if (password.equals("none") && email.equals("none")) {
            return "main page/main page";
        } else {
            Iterable<Admin> admins = adminRepository.findAll();
            for (Admin adm : admins) {
                if (adm.getEmail().equals(email)) {
                    if (adm.getPassword().equals(password)) {
                        return "main page/admin";
                    } else {
                        return "error";
                    }
                }
            }
        }
        return "error";
    }

    @PostMapping("/login")
    public String loginPage(@RequestParam String email, @RequestParam String password) {
        if (password.equals("none") && email.equals("none")) {
            return "login panel";
        } else {
            return "error";
        }
    }

    @PostMapping("/order")
    public String orderPage(Model model, @RequestParam String email, @RequestParam String password) {

        if (password.equals("none") && email.equals("none")) {
            return "order";
        } else {
            Iterable<Admin> admins = adminRepository.findAll();
            for (Admin adm : admins) {
                if (adm.getEmail().equals(email)) {
                    if (adm.getPassword().equals(password)) {
                        model.addAttribute("message", "Ви не можете створювати замовлень, бо ви є адміністратором.");
                        return "notification";
                    } else {
                        return "error";
                    }
                }
            }
        }
        return "error";
    }

    @PostMapping("/handlePassword")
    public String handlePasswordPage(Model model, @RequestParam String email, @RequestParam String password) {
        boolean guide = false;

        Iterable<Admin> admins = adminRepository.findAll();
        for (Admin adm : admins) {
            if (adm.getEmail().equals(email)) {
                if (adm.getPassword().equals(password)) {
                    guide = true;
                }
            }
        }
        model.addAttribute("guide", guide);
        return "system templates/handle password";
    }

    @PostMapping("/handleOrder")
    public String handleOrderPage(@RequestParam String name, @RequestParam String surname,
                                  @RequestParam String how_to_speak, @RequestParam String description) {

        Client client = new Client();
        client.setName(name);
        client.setSurname(surname);
        clientRepository.save(client);

        Long findID = 0L;
        Iterable<Client> clients = clientRepository.findAll();
        for (Client cl : clients) {
            if (cl.getName().equals(name)) {
                findID = cl.getId();
            }
        }

        Advertisement advert = new Advertisement();
        advert.setClientID(findID);
        advert.setName(name);
        advert.setSurname(surname);
        advert.setCommunication(how_to_speak);
        advert.setDescription(description);
        advertisementRepository.save(advert);

        return "system templates/handle order";

    }

    @PostMapping("/list")
    public String listPage(Model model, @RequestParam String email, @RequestParam String password) {
        boolean showAdverts=false;
        Iterable<Admin> admins = adminRepository.findAll();
        for (Admin adm : admins) {
            if (adm.getEmail().equals(email)) {
                if (adm.getPassword().equals(password)) {
                    showAdverts = true;
                } else {
                    return "error";
                }
            }
        }
        if (showAdverts) {
            Iterable<Advertisement> advertisements = advertisementRepository.findAll();
            ExtendedAdvertisement [] extAdvertisements =
                    ExtendedAdvertisementCreator.improveAdvertisements(advertisements);
            model.addAttribute("advertisements", extAdvertisements);
            return "list";
        }

        return "error";
    }

    @PostMapping("/search")
    public String searchPage(Model model, @RequestParam String email, @RequestParam String password,
                             @RequestParam String searchInput) {
        boolean showAdverts=false;
        Iterable<Admin> admins = adminRepository.findAll();
        for (Admin adm : admins) {
            if (adm.getEmail().equals(email)) {
                if (adm.getPassword().equals(password)) {
                    showAdverts = true;
                } else {
                    return "error";
                }
            }
        }
        if (showAdverts) {
            Iterable<Advertisement> advertisements = advertisementRepository.findAll();
            Long [] advertisementsSearchID =
                    AdvertisementSearcher.searchAdvertsID(advertisements, searchInput);

            System.out.println(advertisementsSearchID.length);

            ArrayList<Advertisement> searchedAdvertisements = new ArrayList<>();
            for (int i = 0; i < advertisementsSearchID.length; i++) {
                searchedAdvertisements.add(
                        advertisementRepository.findById(advertisementsSearchID[i]).orElse(new Advertisement()));
            }

            System.out.println(searchedAdvertisements.size());

            ExtendedAdvertisement [] advertisementsList =
                    ExtendedAdvertisementCreator.improveAdvertisements(searchedAdvertisements);
            model.addAttribute("advertisements", advertisementsList);
            return "search";
        }

        return "error";
    }


    @PostMapping("/advert")
    public String advertPage(Model model, @RequestParam String email,
                             @RequestParam String password, @RequestParam String advertNumber) {
        boolean showAdvert=false;
        Long buttonNum = Long.parseLong(advertNumber);
        Iterable<Admin> admins = adminRepository.findAll();
        for (Admin adm : admins) {
            if (adm.getEmail().equals(email)) {
                if (adm.getPassword().equals(password)) {
                    showAdvert=true;
                }
            }
        }

        if(showAdvert) {
            Advertisement advertisement = advertisementRepository.
                    findById(buttonNum).orElse(new Advertisement());
            model.addAttribute("advert", advertisement);
            return "advert";
        }

        return "error";
    }

}
