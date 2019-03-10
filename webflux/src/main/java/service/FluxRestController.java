package service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/superhero")
public class FluxRestController {

    private final Repository repository = new Repository();
    private final MutationReactor mutationReactor = new MutationReactor();

    @GetMapping("/{id}")
    private Flux<Mutant> getPeople(@PathVariable String id) {
        return repository.findPeopleWitheGeneX()
                .map(person -> person.name)
                .flatMap(mutationReactor::createSuperhero);
    }
}