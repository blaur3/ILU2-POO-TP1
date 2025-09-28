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
		try {
		etal.libererEtal(); }
		catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		village.ajouterHabitant(bonemine);
		village.ajouterHabitant(abraracourcix);
		System.out.println(etal.acheterProduit(10, abraracourcix));
		System.out.println("Fin du test"); 
		
		}
	

	
	
}
