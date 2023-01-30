package no.hvl.dat109.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import no.hvl.dat109.funksjon.Spiller;
import no.hvl.dat109.funksjon.Spillere;
import no.hvl.dat109.loginUtil.LoginUtil;

@Controller
@RequestMapping("/${app.url.spillernavn4}")
public class SpillerNavn4Controller {
	
	@Value("${app.message.requiresLogin}") private String REQUIRES_LOGIN_MESSAGE;
	@Value("${app.url.login}")   private String LOGIN_URL;
	@Value("${app.url.spill}") private String SPILL_URL;

	/* 
	 * GET /webshop er forespørselen for å vise webshop-siden.
	 */
	@GetMapping
    public String visNettsiden(HttpSession session, RedirectAttributes ra) {
		
		if (!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
			return "redirect:" + LOGIN_URL;
		}
		return "spillernavn4";
    }

	/* 
	 * POST /webshop er forespørselen for å handle en/flere varer.
	 */

	@PostMapping
    public String leggTilSpiller(HttpSession session, RedirectAttributes ra, @RequestParam String navn1,
    		@RequestParam String navn2, @RequestParam String navn3, @RequestParam String navn4) {
		
		if (!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
			return "redirect:" + LOGIN_URL;
		}
		
		Spillere spillere = (Spillere) session.getAttribute("spillere");
		Spiller spiller = new Spiller(navn1);
		Spiller spiller2 = new Spiller(navn2);
		Spiller spiller3 = new Spiller(navn3);
		Spiller spiller4 = new Spiller(navn4);
		
		spillere.getSpillere().add(spiller);
		spillere.getSpillere().add(spiller2);
		spillere.getSpillere().add(spiller3);
		spillere.getSpillere().add(spiller4);
		
		session.setAttribute("spiller1", spiller);
		session.setAttribute("spiller2", spiller2);
		session.setAttribute("spiller3", spiller3);
		session.setAttribute("spiller4", spiller4);
		
		return "redirect:" + SPILL_URL;
    }
}
