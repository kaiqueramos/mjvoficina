package br.com.mjvoficina.home.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador para rota /
 * @author kaique
 *
 */
@Controller
@RequestMapping("/")
public class HomeController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Retorna a tela home
	 * @return
	 */
	@GetMapping
	public String home() {
		LOGGER.info("Inicio home");
		LOGGER.info("Fim home");
		return "home";
	}
}
