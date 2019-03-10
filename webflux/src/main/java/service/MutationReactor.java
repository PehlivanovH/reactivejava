package service;

import reactor.core.publisher.Mono;

public class MutationReactor {

    public Mono<Mutant> createSuperhero(String name) {
        return Mono.just(new Mutant(MutantDB.get(name)));
    }
}
