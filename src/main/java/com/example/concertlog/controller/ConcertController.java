package com.example.concertlog.controller;

import org.springframework.ui.Model;
import com.example.concertlog.entity.Concert;
import com.example.concertlog.service.ConcertService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/concerts")
public class ConcertController {
    private final ConcertService concertService;

    public ConcertController (ConcertService concertService) {
        this.concertService = concertService;
    }

    @GetMapping
    public String list(Model model,
                       @RequestParam(required = false) String search,
                       @RequestParam(required = false) String searchType,
                       @RequestParam(required = false) Concert.Status status) {
        List<Concert> concerts;

        if(status != null) {
            concerts = concertService.filterByStatus(status);
        } else if(search != null && !search.isEmpty()) {
            concerts = switch (searchType != null ? searchType : "izvodac") {
                case "grad" -> concertService.searchByGrad(search);
                case "zanr" -> concertService.searchByZanr(search);
                default -> concertService.searchByIzvodac(search);
            };
        } else {
            concerts = concertService.getAll();
        }

        model.addAttribute("concerts", concerts);
        model.addAttribute("statusi", Concert.Status.values());
        model.addAttribute("selectedStatus", status);
        model.addAttribute("search", search);
        model.addAttribute("searchType", searchType);
        return "concerts/list";
    }
    @GetMapping("/{id}")
    public String details(@PathVariable Long id, Model model) {
        model.addAttribute("concert", concertService.getById(id));
        return "concerts/details";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("concert", new Concert());
        model.addAttribute("statusi", Concert.Status.values());
        return "concerts/add";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute Concert concert, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("statusi", Concert.Status.values());
            return "concerts/add";
        }
        concertService.save(concert);
        return "redirect:/concerts";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("concert", concertService.getById(id));
        model.addAttribute("statusi", Concert.Status.values());
        return "concerts/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @Valid @ModelAttribute Concert concert,
                       BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("statusi", Concert.Status.values());
            return "concerts/edit";
        }
        concert.setId(id);
        concertService.save(concert);
        return "redirect:/concerts";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        concertService.delete(id);
        return "redirect:/concerts";
    }

}
