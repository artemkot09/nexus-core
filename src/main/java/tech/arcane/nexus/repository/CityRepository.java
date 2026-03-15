package tech.arcane.nexus.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import tech.arcane.nexus.entity.City;

public interface CityRepository extends JpaRepository<City, String> { }