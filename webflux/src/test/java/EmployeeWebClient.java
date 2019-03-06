import org.junit.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import service.Employee;

import java.util.List;

public class EmployeeWebClient {


    @Test
    public void testMono() {
        WebClient client = WebClient.create("http://localhost:8080");

        Mono<Employee> employeeMono = client.get()
                .uri("/employees/{id}", "Anna")
                .retrieve()
                .bodyToMono(Employee.class);

        System.out.println("\n\n");
        employeeMono.subscribe(System.out::println);


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testFlux() {
        WebClient client = WebClient.create("http://localhost:8080");

        Flux<Employee> employeeFlux = client.get()
                .uri("/department/{id}", "Anna")
                .retrieve()
                .bodyToFlux(Employee.class);

        System.out.println("\n\n");
        List<Employee> e = employeeFlux.collectList().block();
        System.out.println(e);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
