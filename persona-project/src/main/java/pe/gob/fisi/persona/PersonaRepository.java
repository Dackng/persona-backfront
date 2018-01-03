package pe.gob.fisi.persona;

import org.springframework.data.repository.CrudRepository;


public interface PersonaRepository extends CrudRepository<Persona, Integer> {

	Persona findById(Integer id);
}
