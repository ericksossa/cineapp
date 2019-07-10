package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppCreate {

	public static void main(String[] args) {
		Noticia noticia = new Noticia();
		noticia.setTitulo("Proximo Estreno: Cars recargado");
		noticia.setDetalle("El mes de enero");
		
		
		
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo =  context.getBean("noticiasRepository", NoticiasRepository.class);
		
		repo.save(noticia);
		context.close();

	}

}
