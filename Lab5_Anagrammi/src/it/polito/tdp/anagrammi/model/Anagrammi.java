package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.db.AnagrammaDAO;

public class Anagrammi {
	
	AnagrammaDAO dao = new AnagrammaDAO();
	
	public boolean corretto(String anagramma) {
		return dao.isCorrect(anagramma);
	}
	
	public List<String> calcolaPermutazioni(String input) {
		List<String> soluzione = new ArrayList<String>();
	    String parziale = "";
		calcola(input, parziale, 0, soluzione);
		return soluzione;
	}

	private void calcola(String input, String parziale, int livello, List<String> soluzione) {

		if (livello == input.length()) {   // Condizione di uscita
			soluzione.add(parziale);
			return ;
		}
		
		for (int i=0; i<input.length(); i++)
			if (conta(parziale, input.charAt(i)) < conta(input, input.charAt(i))) {    // Filtro
				parziale += input.charAt(i);                                           // Aggiungo carattere
				calcola(input, parziale, livello+1, soluzione);                        // Ricorsione
				parziale = parziale.substring(0, parziale.length()-1);                 // Backtracking
			}
		
	}
	
	// Conta quanti caratteri c sono contenuti nella parola s
	private static int conta(String s, char c) {
		int contatore = 0;
		
		for (int i=0; i<s.length(); i++)
			if (s.charAt(i) == c)
				contatore++;
			
		return contatore;
	}

}
