package pruebasjparepo;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppSorting {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");

		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		// obtiene valores de las entidades por orden de un campo.
//		List<Noticia>lista = repo.findAll(Sort.by("titulo").descending());
		
		// obtiene valores de las entidades por orden de varios campos.
		List<Noticia>lista = repo.findAll(Sort.by("fecha").descending().and(Sort.by("titulo")));
		
		for (Noticia n : lista) {
			System.out.println(n);
		}
		
		context.close();

	}

}
