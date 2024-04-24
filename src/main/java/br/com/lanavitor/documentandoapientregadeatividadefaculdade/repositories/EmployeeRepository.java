package br.com.lanavitor.documentandoapientregadeatividadefaculdade.repositories;

import br.com.lanavitor.documentandoapientregadeatividadefaculdade.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
