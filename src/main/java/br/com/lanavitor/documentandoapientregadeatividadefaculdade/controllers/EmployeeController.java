package br.com.lanavitor.documentandoapientregadeatividadefaculdade.controllers;

import br.com.lanavitor.documentandoapientregadeatividadefaculdade.entity.Employee;
import br.com.lanavitor.documentandoapientregadeatividadefaculdade.services.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping()
    @Operation(summary = "Lista todos os Funcionarios", description = "Listagem de funcionarios")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A requisição foi executada com secusso."),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado")})
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> list = service.findAllEmployee();
        if (!list.isEmpty()) {
            return ResponseEntity.ok().body(list);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca o funcionario por ID", description = "Busca o funcionario por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A requisição foi executada com secusso."),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado")})
    public ResponseEntity<Employee> findById(@PathVariable Long id) {
        Employee entity = service.findById(id);
        if (entity != null) {
            return ResponseEntity.ok().body(entity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
