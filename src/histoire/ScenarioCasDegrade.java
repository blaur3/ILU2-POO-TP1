package histoire;
import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;
import villagegaulois.Etal;

public class ScenarioCasDegrade {
	public static void main(String[] args) { 
		Village village = new Village("le village des irréductibles", 10, 5);
		Gaulois bonemine = new Gaulois("Bonemine", 7);
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		
		Etal etal = new Etal();
		village.ajouterHabitant(bonemine);
		village.ajouterHabitant(abraracourcix);
		village.installerVendeur(bonemine, "fleurs", 20);
		Etal etalFleur = village.rechercherEtal(bonemine);
		
		//test liberer etal non occupe
		System.out.println("***Test : liberer etal non occupe***");
		try {
		etal.libererEtal(); }
		catch(NullPointerException e) {
			e.printStackTrace();
		}
		System.out.println("[FIN] Test : liberer etal non occupe\n");
		
		
		//test acheteur null
		System.out.println("***Test : acheteur null***");
		System.out.println(etalFleur.acheterProduit(10, null));
		System.out.println("[FIN] Test : acheteur null\n");
		
		
		//test acheter sur un etal non occupe
		System.out.println("***Test : achat sur étal non occupé***");
		try {
		System.out.println(etal.acheterProduit(10, abraracourcix));
		}
		catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		System.out.println("[FIN] Test : achat sur étal non occupé\n");
		
		
		//test quantite positive
		System.out.println("***Test : quantite d'achat <1***");
		try {
			System.out.println(etalFleur.acheterProduit(0, abraracourcix));
		}
		catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
		System.out.println("[FIN] Test : quantite d'achat <1\n");
		System.out.println("Fin du test"); 
		
		}
	

	
	
}
