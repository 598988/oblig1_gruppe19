package no.hvl.dat109.loginUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import no.hvl.dat109.funksjon.Spillere;
import no.hvl.dat109.funksjon.Startspill;


public class LoginUtil {
	
	private final static int MAX_INTERACTIVE_INTERVAL = 60;

	public static void loggUtBruker(HttpSession session) {
        session.invalidate();
	}

	/*
	public static void loggInnBruker(HttpServletRequest request, String username) {
    	
        loggUtBruker(request.getSession());

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(MAX_INTERACTIVE_INTERVAL);
        session.setAttribute("username", username);
        session.setAttribute("cart", new Cart());
	}
	*/
	public static void loggInnBruker(HttpServletRequest request, int antall) {
    	
        loggUtBruker(request.getSession());

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(MAX_INTERACTIVE_INTERVAL);
        session.setAttribute("antallSpillere", antall);
        session.setAttribute("spillere", new Spillere());
        
        //session.setAttribute("startspill", new Startspill(null));
	}
	
	public static boolean erBrukerInnlogget(HttpSession session) {
		return session != null 
				&& session.getAttribute("antallSpillere") != null
				&& session.getAttribute("spillere") != null;
	}

}
