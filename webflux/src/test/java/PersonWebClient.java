import org.junit.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import service.Mutant;
import service.Person;

import java.util.List;

public class PersonWebClient {


    @Test
    public void testMono() {
        WebClient client = WebClient.create("http://localhost:8080");

        Mono<Person> personMono = client.get()
                .uri("/person/{id}", "id")
                .retrieve()
                .bodyToMono(Person.class);

        Person person = personMono.block();
        System.out.println(person);
    }


    @Test
    public void testFlux() {
        WebClient client = WebClient.create("http://localhost:8080");

        Flux<Mutant> mutantFlux = client.get()
                .uri("/superhero/{id}", "id")
                .retrieve()
                .bodyToFlux(Mutant.class);

        mutantFlux.subscribe(System.out::println);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
