package net.jorge.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.jorge.model.Vacante;

@Service
public class VacantesServiceImpl implements IVacantesService {
	
	private List<Vacante> lista = null;

	public VacantesServiceImpl() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		lista = new LinkedList<Vacante>();
		try {
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero Espacial");
			vacante1.setDescripcion("Solicitamos Ing Espacial para diseñar vuelo tripulado.");
			vacante1.setFecha(sdf.parse("01-12-2021"));
			vacante1.setSalario(6500000.0);
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
	}
	
	@Override
	public List<Vacante> buscarTodas() {
		
		return lista;
	}

	@Override
	public Vacante buscarPorId(Integer id) {
		for(Vacante v : lista) {
			if(v.getId() == id) {
				return v;
			}
		}
		return null;
	}

}
