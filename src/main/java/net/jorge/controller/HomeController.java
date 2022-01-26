package net.jorge.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.jorge.model.Vacante;



@Controller

public class HomeController {

	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Vacante> lista = getVacantes();
		model.addAttribute("vacantes", lista);
		return "tabla";
	}
	
	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		Vacante vacante = new Vacante();
		vacante.setNombre("Ingeniero Informatico");
		vacante.setDescripcion("Se necesita ingeniero para dar soporte a web");
		vacante.setFecha(new Date());
		vacante.setSalario(4500000.0);
		
		model.addAttribute("vacante", vacante);
		
		return "detalle";
	}
	
	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<String>();
		lista.add("Ingeniero en Informatica");
		lista.add("Contador");
		lista.add("Vendedor");
		lista.add("Arquitecto");
		
		model.addAttribute("empleos", lista);
		
		return "listado";
	}
	
	@GetMapping("/")
	public String mostrarHome(Model model) {
		/*
		 * model.addAttribute("mensaje", "Bienvenidos a Empleos App");
		 * model.addAttribute("fecha", new Date());
		 */
		String nombre = "Auxiliar Contable";
		Date fechaPub = new Date();
		double salario = 9000.0;
		boolean vigente = true;

		model.addAttribute("nombre", nombre);
		model.addAttribute("fecha", fechaPub);
		model.addAttribute("salario", salario);
		model.addAttribute("vigente", vigente);
		
		return "home";
	}
	
	private List<Vacante> getVacantes() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		List<Vacante> lista = new LinkedList<Vacante>();
		try {
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero Espacial");
			vacante1.setDescripcion("Solicitamos Ing Espacial para diseñar vuelo tripulado.");
			vacante1.setFecha(sdf.parse("01-12-2021"));
			vacante1.setSalario(9500000.0);
			vacante1.setDestacado(1);
			vacante1.setImagen("empresa1.png");

			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Astronauta");
			vacante2.setDescripcion("Solicitamos Astronauta para vuelo tripulado.");
			vacante2.setFecha(sdf.parse("24-11-2021"));
			vacante2.setSalario(1400000.0);
			vacante2.setDestacado(0);
			vacante2.setImagen("empresa2.png");

			Vacante vacante3 = new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Bombero");
			vacante3.setDescripcion("Solicitamos Bombero para trabajar en Stgo.");
			vacante3.setFecha(sdf.parse("12-12-2021"));
			vacante3.setSalario(500000.0);
			vacante3.setDestacado(0);

			Vacante vacante4 = new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Bailarin");
			vacante4.setDescripcion("Solicitamos Bailarin para programa de TV.");
			vacante4.setFecha(sdf.parse("22-11-2021"));
			vacante4.setSalario(900000.0);
			vacante4.setDestacado(1);
			vacante4.setImagen("empresa3.png");

			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);
			
		} catch (ParseException e) {
			// TODO: handle exception
			System.out.println("Error: " + e.getMessage());
		}
		return lista;
		
	}
}
