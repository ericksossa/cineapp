package net.itinajero.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.itinajero.app.model.Pelicula;

@Service
public class PeliculasServiceImpl implements IPeliculasService {

	private List<Pelicula> lista = null;

	public PeliculasServiceImpl() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		try {
			lista = new LinkedList<Pelicula>();
			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Toy Story");
			pelicula1.setDuracion(180);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Aventura");
			pelicula1.setFechaEstreno(formatter.parse("02-05-2019"));
			pelicula1.setImagen("toy.jpg");
			pelicula1.setEstatus("Inactiva");

			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("Annabel");
			pelicula2.setDuracion(120);
			pelicula2.setClasificacion("C");
			pelicula2.setGenero("Terror");
			pelicula2.setFechaEstreno(formatter.parse("02-06-2019"));

			lista.add(pelicula1);
			lista.add(pelicula2);

		} catch (ParseException e) {
			System.out.println("Error:" + e.getMessage());

		}

	}

	@Override
	public List<Pelicula> buscarTodas() {
		return lista;
	}

	@Override
	public Pelicula buscarPorId(int idPelicula) {
		for (Pelicula p : lista) {
			if (p.getId() == idPelicula) {
				return p;
			}
		}
		return null;
	}

	@Override
	public void insertar(Pelicula pelicula) {
		lista.add(pelicula);
		
	}

	@Override
	public List<String> buscarGeneros() {
		
		List<String> generos = new LinkedList<>();
		
		generos.add("Accion");
		generos.add("Aventura");
		generos.add("Clasicas");
		generos.add("Comedia Romantica");
		generos.add("Drama");
		generos.add("Terror");
		generos.add("Infantil");
		generos.add("Accion y aventura");
		generos.add("Romantica");
		generos.add("Ciencia ficcion");
		
		return generos;
	}

}
