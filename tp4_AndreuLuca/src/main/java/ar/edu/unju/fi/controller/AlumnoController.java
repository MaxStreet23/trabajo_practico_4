package ar.edu.unju.fi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.collections.ListadoAlumno;
import ar.edu.unju.fi.model.Alumno;
@Controller
public class AlumnoController {
	
	@Autowired
	Alumno nuevoAlumno = new Alumno();
	
	@GetMapping("/formularioAlumnos")
    public ModelAndView getFormularioAlumnos() {
		//vista de formDocente
		ModelAndView modelView = new ModelAndView("formularioAlumnos");
		modelView.addObject("nuevoAlumno", nuevoAlumno);
        return modelView;
    }
	
	@PostMapping("/guardarAlumno")
	public ModelAndView saveAlumno(@ModelAttribute("nuevoAlumno") Alumno alumnoAGuardar) {
		//guardar
		ListadoAlumno.agregarAlumno(alumnoAGuardar);
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoAlumno", ListadoAlumno.listarAlumnos());	
		return modelView;	
	}
	
	@GetMapping("/borrarAlumno/{dni}")
	public ModelAndView deleteAlumnoDelListado(@PathVariable(name="dni") String dni) {
		//borrar
		ListadoAlumno.eliminarAlumno(dni);
		//mostrar el nuevo listado
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoAlumno", ListadoAlumno.listarAlumnos());	
		return modelView;		
	}
	
	@GetMapping("/alumnos")
	public ModelAndView showAlumnos() {
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoAlumno", ListadoAlumno.listarAlumnos());	
		return modelView;		
	}
}
