package pe.gob.fisi.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.fisi.persona.Persona;

@RestController
@RequestMapping(path = "/api")
public class PersonaController {

	private PersonaService personaService;
	
	@Autowired
	public PersonaController(PersonaService personaService){
		this.personaService = personaService;
	}
	
	@GetMapping("/find/{code}")
	public ResponseEntity<Persona> getPersona(@PathVariable("code") Integer code) {
	    return Optional.ofNullable(personaService.findById(code))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Persona>> getList() {
	    return Optional.ofNullable(personaService.getList())
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
