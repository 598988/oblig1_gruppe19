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
import no.hvl.dat109.funksjon.Startspill;
import no.hvl.dat109.loginUtil.LoginUtil;

@Controller
@RequestMapping("/${app.url.spill}")
public class SpillController {
	
	@Value("${app.message.requiresLogin}") private String REQUIRES_LOGIN_MESSAGE;
	@Value("${app.message.vunnet}") private String HAR_VUNNET;
	@Value("${app.url.login}")   private String LOGIN_URL;
	@Value("${app.url.spill}") private String SPILL_URL;

	/* 
	 * GET /webshop er forespørselen for å vise webshop-siden.
	 */
	@GetMapping
    public String StartSpill(HttpSession session, RedirectAttributes ra) {
		
		if (!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
			return "redirect:" + LOGIN_URL;
		}
		
		session.getAttribute("spillere");
		Spillere spillere = (Spillere) session.getAttribute("spillere");
		Startspill spillet = new Startspill(spillere);
		
		//session.getAttribute("spillere3");
		//Spillere spillere3 = (Spillere) session.getAttribute("spillere3");
		//Startspill spillet = new Startspill(spillere3);
		
		session.setAttribute("game", spillet);
		session.setAttribute("brett", spillet.getBrett());
		session.getAttribute("spiller1");
		session.getAttribute("spiller2");
		session.getAttribute("spiller3");
		session.getAttribute("spiller4");
		//spillet.start();
		
		return "spillView";
    }

	
	@PostMapping
    public String spillVidere(HttpSession session, RedirectAttributes ra) {
		
		if (!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
			return "redirect:" + LOGIN_URL;
		}
		
		Spiller spiller1 = (Spiller) session.getAttribute("spiller1");
		Spiller spiller2 = (Spiller) session.getAttribute("spiller2");
		Spiller spiller3 = (Spiller) session.getAttribute("spiller3");
		Spiller spiller4 = (Spiller) session.getAttribute("spiller4");
		
		session.getAttribute("spillere");
		Startspill spill = (Startspill) session.getAttribute("game");
		//spill.start();
		
		
		 spill.spilltrekk();
		
		//spill.start();
		
		if(spill.sjekkvunnet(spiller1.getVerdi())) {
			ra.addFlashAttribute("redirectMessage", spiller1.getNavn() + " " + HAR_VUNNET);
			return "redirect:" + LOGIN_URL;
		}
		if(spill.sjekkvunnet(spiller2.getVerdi())) {
			ra.addFlashAttribute("redirectMessage", spiller1.getNavn() + " " + HAR_VUNNET);
			return "redirect:" + LOGIN_URL;
		}
		if(spiller3 !=null && spill.sjekkvunnet(spiller3.getVerdi())) {
			ra.addFlashAttribute("redirectMessage", spiller1.getNavn() + " " + HAR_VUNNET);
			return "redirect:" + LOGIN_URL;
		}
		if(spiller4 !=null && spill.sjekkvunnet(spiller4.getVerdi())) {
			ra.addFlashAttribute("redirectMessage", spiller1.getNavn() + " " + HAR_VUNNET);
			return "redirect:" + LOGIN_URL;
		}
		
		
		return "redirect:" + SPILL_URL;
    }
    
}