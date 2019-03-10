package service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

public class Repository {
    public Mono<Person> findPerson() {
        return Mono.just(new Person("John Doe"));
    }

    public Flux<Person> findPeopleWitheGeneX() {
        var people = MutantDB.mapping.keySet().stream().map(name -> new Person(name)).collect(Collectors.toList());

        return Flux.fromIterable(people);
    }
}
