package no.hvl.dat109.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.dat109.funksjon.Spillere;
import no.hvl.dat109.loginUtil.InputValidator;
import no.hvl.dat109.loginUtil.LoginUtil;



@Controller
@RequestMapping("/${app.url.login}")
public class LoginController {
	
	@Value("${app.message.invalidUsername}") private String INVALID_USERNAME_MESSAGE;
	@Value("${app.url.login}")   private String LOGIN_URL;
	@Value("${app.url.spillernavn}") private String SPILLERE_URL;
	@Value("${app.url.spillernavn3}") private String SPILLERE3_URL;
	@Value("${app.url.spillernavn4}") private String SPILLERE4_URL;
	
	/* 
	 * GET /login er forespørselen for å hente login-skjema.
	 */
	@GetMapping
    public String doGet() {
		return "loginView";
    }

	/* 
	 * POST /login er forespørselen for å logge inn.
	 */
	@PostMapping
    public String doPost(
    		@RequestParam int antallSpillere,
    		HttpServletRequest request,	RedirectAttributes ra) {
		/*
		if (!InputValidator.isValidUsername(username)) {
			ra.addFlashAttribute("redirectMessage", INVALID_USERNAME_MESSAGE);
			return "redirect:" + LOGIN_URL;
		}
	*/
		LoginUtil.loggInnBruker(request, antallSpillere);
		
		if(antallSpillere==3) {
			return "redirect:" + SPILLERE3_URL;
		} 
		if(antallSpillere==4) {
			return "redirect:" + SPILLERE4_URL;
		}
		
		return "redirect:" + SPILLERE_URL;
    }
}
