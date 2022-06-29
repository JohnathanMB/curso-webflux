package co.com.sofka.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface EstudianteDataRepository extends CrudRepository<EstudianteData, String>, QueryByExampleExecutor<EstudianteData> {
}
