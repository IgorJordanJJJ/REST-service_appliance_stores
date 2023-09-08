package ru.jordan.appliancedata.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.jordan.appliancedata.models.Showcases;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public interface ShowcasesRepository extends JpaRepository<Showcases, Integer> {
    List<Showcases> findByType(String storeType);
    List<Showcases> findByAddress(String address);
    List<Showcases> findByDatecreateBetween(Date startDate, Date endDate);
    List<Showcases> findBydatechangeBetween(Timestamp startDate, Timestamp endDate);
}
