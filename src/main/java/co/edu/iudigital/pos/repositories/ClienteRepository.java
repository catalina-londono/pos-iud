package co.edu.iudigital.pos.repositories;

import co.edu.iudigital.pos.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
