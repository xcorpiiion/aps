package br.com.unip.aps.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.unip.aps.domain.Cliente;

@Controller
@RequestMapping("home")
public class HomeController {

	@GetMapping("/home")
	public ModelAndView home(ModelMap modelMap) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("teste");

		Cliente cliente = new Cliente();
		cliente.setIdade(12);
		cliente.setNome("teste");
		
		EntityManager em = entityManagerFactory.createEntityManager();
		
		try {
			em.getTransaction();
			em.persist(cliente);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro: " + e.getMessage());
		} finally {
			em.close();
		}
		return new ModelAndView("/home");
	}

}
