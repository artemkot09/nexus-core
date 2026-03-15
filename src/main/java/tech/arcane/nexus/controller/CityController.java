package tech.arcane.nexus.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.arcane.nexus.entity.City;
import tech.arcane.nexus.service.CityService;
import java.util.List;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;
    @GetMapping
    public List<City> allCities() { return cityService.getAllCities(); }
}