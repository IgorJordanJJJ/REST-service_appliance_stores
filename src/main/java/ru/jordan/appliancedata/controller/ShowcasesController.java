package ru.jordan.appliancedata.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.jordan.appliancedata.models.Showcases;
import ru.jordan.appliancedata.services.ShowcaseService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/showcases")
public class ShowcasesController {

    private final ShowcaseService showcaseService;

    @Autowired
    public ShowcasesController(ShowcaseService showcaseService) {
        this.showcaseService = showcaseService;
    }


    @GetMapping()
    public List<Showcases> getAllStores() {
        return showcaseService.findall();
    }

    @GetMapping("/type/{Type}")
    public List<Showcases> getStoresByType(@PathVariable String Type) {
        return showcaseService.getShowcasesByType(Type);
    }

    @GetMapping("/address/{address}")
    public List<Showcases> getStoresByAddress(@PathVariable String address) {
        return showcaseService.getShowcasesByAddress(address);
    }

    @GetMapping("/createdDateRange")
    public List<Showcases> getStoresByCreatedDateRange(
            @RequestParam Date startDate,
            @RequestParam Date endDate
    ) {
        return showcaseService.getStoresByDatecreateRange(startDate, endDate);
    }

    @GetMapping("/lastUpdatedRange")
    public List<Showcases> getStoresByLastUpdatedRange(
            @RequestParam Timestamp startDate,
            @RequestParam Timestamp endDate
    ) {
        return showcaseService.getStoresByLastUpdatedRange(startDate, endDate);
    }

    @PostMapping
    public void addStore(@RequestBody Showcases showcases) {
        showcaseService.save(showcases);
    }

    @PutMapping("/{id}")
    public void updateStore(@PathVariable int id, @RequestBody Showcases updatedShowcases) {
        showcaseService.update(id, updatedShowcases);
    }

    @DeleteMapping("/{id}")
    public void deleteStore(@PathVariable int id) {
        showcaseService.delete(id);
    }

}
