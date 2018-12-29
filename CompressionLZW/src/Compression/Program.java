package Compression;

import java.util.Scanner;

public class Program {
	
	public static void main(String[] args) {
		CompressionLZW test ;
		Scanner sc = new Scanner(System.in);
		String fSource ;
		//= "sisi-et-isis";
		
		System.out.println("Entrer le texte à compresser");
		fSource = sc.nextLine();
		
		test =  new CompressionLZW(fSource);
		
		System.out.println("Fichier source:----");
		System.out.println(test.getFichiersource());
		
		System.out.println("Fichier compressé:----");
		test.Compresser();
		System.out.println("res: "+test.fichierCompresse);
		
		System.out.println("Dictionnaire :----");
		test.getDictionnaire();
		
	}	
}
