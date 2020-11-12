package ch.bfh.zodnrk.camp.controller;

import ch.bfh.zodnrk.camp.model.Hero;
import ch.bfh.zodnrk.camp.repository.HeroRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/heroes")
public class HeroController {

    private final HeroRepository heroRepository;

    public HeroController(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @GetMapping
    public @ResponseBody
    Iterable<Hero> list() {
        return heroRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Hero getById(@PathVariable String id) {
        return heroRepository.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Hero hero) {
        heroRepository.save(hero);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Hero hero) {
        heroRepository.save(hero);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id) {
        heroRepository.deleteById(id);
    }
}
