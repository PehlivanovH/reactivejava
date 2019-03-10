package service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/person")
public class MonoRestController {

    private final Repository repository = new Repository();

    @GetMapping("/{id}")
    private Mono<Person> getPerson(@PathVariable String id) {
        return repository.findPerson();
    }
}