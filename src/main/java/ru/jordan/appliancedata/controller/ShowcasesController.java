package ru.jordan.appliancedata.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.jordan.appliancedata.models.Showcases;
import ru.jordan.appliancedata.services.ShowcaseService;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
            @RequestParam String startDate,
            @RequestParam String endDate
    ) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate1 = dateFormat.parse(startDate);
        Date endDate1 = dateFormat.parse(endDate);

        return showcaseService.getStoresByDatecreateRange(startDate1, endDate1);
    }

    @GetMapping("/lastUpdatedRange")
    public List<Showcases> getStoresByLastUpdatedRange(
            @RequestParam String startDate,
            @RequestParam String endDate
    ) {
        Timestamp startDate1 = Timestamp.valueOf(startDate);
        Timestamp endDate1 = Timestamp.valueOf(endDate);
        return showcaseService.getStoresByLastUpdatedRange(startDate1, endDate1);
    }

    @PostMapping()
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
