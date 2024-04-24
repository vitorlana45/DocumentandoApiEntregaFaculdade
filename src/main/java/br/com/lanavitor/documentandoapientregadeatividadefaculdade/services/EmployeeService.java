package br.com.lanavitor.documentandoapientregadeatividadefaculdade.services;

import br.com.lanavitor.documentandoapientregadeatividadefaculdade.entity.Employee;
import br.com.lanavitor.documentandoapientregadeatividadefaculdade.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;


    public List<Employee> findAllEmployee() {
        return repository.findAll();
    }

    public Employee findById(Long id) {
        Employee entity = repository.findById(id).orElse(null);

        if (entity != null) return entity;
        else return null;
    }
}
