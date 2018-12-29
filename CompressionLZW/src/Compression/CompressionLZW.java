package Compression;

import java.util.HashMap;
import java.util.Map;

public class CompressionLZW {
	Map<String, Integer> Dictionnaire = new HashMap<String, Integer>();
	String fichiersource;
	String fichierCompresse = new String();
	private int tailleDictionnaire = 256;

	public CompressionLZW(String source) {
		this.loadDictionnaire();// 0 ... 255 Code Ascii
		this.fichiersource=source;
		// this.Compresser();
	}

	public void getDictionnaire() {
		Map<String, Integer> dico = new HashMap<String, Integer>();

		for (String s : Dictionnaire.keySet()) {
			if (Dictionnaire.get(s) > 255) {
				dico.put(s, Dictionnaire.get(s));
			}
		}

		System.out.println("0..255 ASCII");

		for (String s : dico.keySet()) {
			System.out.println(s + "      " + dico.get(s));
		}
	}

	public void addDictionnaire(String s, Integer k) {
		Dictionnaire.put(s, k);
	}

	public void loadDictionnaire() {
		for (int i = 0; i <= 255; i++) {
			Dictionnaire.put(Character.toString((char) i), i);
		}
	}

	public String getFichiersource() {
		return fichiersource;
	}

	public void setFichiersource(String fichiersource) {
		this.fichiersource = fichiersource;
	}

	public String getFichierCompresse() {
		return fichierCompresse;
	}

	public void setFichierCompresse(String fichierCompresse) {
		this.fichierCompresse = fichierCompresse;
	}

	public void Compresser() {
		
		char t;
		String s = new String();
		String u = new String();

		char source[] = new char[this.fichiersource.length()];
		source = this.fichiersource.toCharArray();

		// initilalisation
		s = Character.toString(source[0]);

		for (int i = 1; i < source.length; i++) {
			t = source[i];
			u = s;
			u = u + t; //concatener s et t dans u

			//Le test
			//si u a ete deja ajouté au dico
			if (this.Dictionnaire.containsKey(u)) {
				s = u;
			}
			//si u n'existe pas dans le dico
			else {
				//ajouter u au dico
				this.Dictionnaire.put(u, tailleDictionnaire);
				tailleDictionnaire++;
				
				//ajouter la sequence s au fichier compressé
				this.fichierCompresse = this.fichierCompresse + "  "; 
				this.fichierCompresse = this.fichierCompresse + this.Dictionnaire.get(s);
				
				s = Character.toString(t);
			}
		}
		// ajouter la derniere sequence  s au fichier compréssé
		this.fichierCompresse = this.fichierCompresse + "  "; 
		this.fichierCompresse = this.fichierCompresse + this.Dictionnaire.get(s);
	}
}
