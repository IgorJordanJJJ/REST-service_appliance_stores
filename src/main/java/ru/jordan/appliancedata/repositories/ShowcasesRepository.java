package ru.jordan.appliancedata.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.jordan.appliancedata.models.Showcases;

@Repository
public interface ShowcasesRepository extends JpaRepository<Showcases, Integer> {
}
