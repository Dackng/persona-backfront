package pe.gob.fisi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.fisi.persona.Persona;
import pe.gob.fisi.persona.PersonaRepository;

@Service
public class PersonaService {

	PersonaRepository personaRepository;
	
	@Autowired
	public PersonaService(PersonaRepository personaRepository){
		this.personaRepository = personaRepository;
	}
	
	public Persona findById(Integer code){
		return personaRepository.findById(code);
	}
	
	public List<Persona> getList(){
		return (List<Persona>) personaRepository.findAll();
	}
}
