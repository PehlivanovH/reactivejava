package service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/department")
public class FluxRestController {

    private final EmployeeRepository employeeRepository = new EmployeeRepository();

    @GetMapping("/{id}")
    private Flux<Employee> getEmployeeByDepartment(@PathVariable String id) {
        System.out.println("GET findeEmpoyeesByDepartment " + id);

        return employeeRepository.findeEmpoyeesByDepartment(id);
    }
}