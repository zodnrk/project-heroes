package ch.bfh.zodnrk.camp.controller;

import ch.bfh.zodnrk.camp.model.Hero;
import ch.bfh.zodnrk.camp.repository.HeroRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
        Iterable<Hero> heroes = heroRepository.findAll();
        heroes.forEach(this::addHateoasLinks);

        return heroes;
    }

    @GetMapping("/{id}")
    public @ResponseBody Hero getById(@PathVariable String id) {
        Hero hero = heroRepository.findById(id).get();

        return addHateoasLinks(hero);
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

    private Hero addHateoasLinks(Hero hero) {
        return hero.add(linkTo(methodOn(HeroController.class).getById(hero.getId())).withSelfRel());
    }
}
