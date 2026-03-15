package tech.arcane.nexus.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.arcane.nexus.entity.City;
import tech.arcane.nexus.repository.CityRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    public List<City> getAllCities() { return cityRepository.findAll(); }
}