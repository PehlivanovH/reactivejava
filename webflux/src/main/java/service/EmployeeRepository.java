package service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

public class EmployeeRepository {
    public Mono<Employee> findEmployeeById(String id) {
        System.out.println("EmployeeRepository findEmployeeById " + id);

        return Mono.just(new Employee(id));
    }

    public Flux<Employee> findeEmpoyeesByDepartment(String departmentId) {
        System.out.println("findeEmpoyeesByDepartment");
        var employees = List.of(new Employee("Anna"),
                new Employee("Banana"),
                new Employee("Puhana"));

       // return Flux.fromIterable(employees).delayElements(Duration.ofSeconds(3));
        return Flux.fromIterable(employees);
    }
}
