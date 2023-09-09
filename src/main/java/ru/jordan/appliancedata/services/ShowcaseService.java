package ru.jordan.appliancedata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jordan.appliancedata.models.Product;
import ru.jordan.appliancedata.models.Showcases;
import ru.jordan.appliancedata.repositories.ShowcasesRepository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class ShowcaseService {

    private final ShowcasesRepository showcasesRepository;

    @Autowired
    public ShowcaseService(ShowcasesRepository showcasesRepository) {
        this.showcasesRepository = showcasesRepository;
    }


    public List<Showcases> findall(){
        return showcasesRepository.findAll();
    }
    public List<Showcases> getShowcasesByAddress(String address){
        return showcasesRepository.findByAddress(address);
    }

    public List<Showcases> getShowcasesByType(String type){
        return showcasesRepository.findByType(type);
    }

    public List<Showcases> getStoresByDatecreateRange(Date startDate, Date endDate) {
        return showcasesRepository.findByDatecreateBetween(startDate, endDate);
    }

    public List<Showcases> getStoresByLastUpdatedRange(Timestamp startDate, Timestamp endDate) {
        return showcasesRepository.findBydatechangeBetween(startDate, endDate);
    }

    @Transactional
    public void save(Showcases showcases) {
        showcases.setDatecreate(new Date());
        showcases.setDatechange(new Timestamp(System.currentTimeMillis()));
        showcasesRepository.save(showcases);
    }

    @Transactional
    public void update(int uuid, Showcases showcases) {
        Showcases showcases1 = showcasesRepository.findById(uuid).orElse(null);
        if(showcases1 != null){
            showcases.setUuid(uuid);
            showcases.setDatecreate(showcases1.getDatecreate());
            showcases.setDatechange(new Timestamp(System.currentTimeMillis()));
            showcasesRepository.save(showcases);
        }
    }


    @Transactional
    public void delete(int uuid) {
        showcasesRepository.deleteById(uuid);
    }



}
