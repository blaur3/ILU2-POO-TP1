package villagegaulois;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private Marche marche;

	public Village(String nom, int nbVillageoisMaximum, int nbEtals) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
		marche = new Marche(nbEtals);
		
	}
	
	public static class Marche{
		private Etal[] etals;
		
		private Marche(int nbEtals) {
			etals = new Etal[nbEtals];
			for(int i = 0; i< nbEtals; i++) {
				etals[i] = new Etal();
			}
			
		}
		
		private void utiliserEtal(int indiceEtal, Gaulois vendeur, String produit, int nbProduit) {
			this.etals[indiceEtal].occuperEtal(vendeur,produit, nbProduit);
		}
		
		private int trouverEtalLibre() {
			for(int i =0; i<etals.length; i++) {
				if (!etals[i].isEtalOccupe())
					return i;	
			}
			return -1;
		}
		
		private Etal[] trouverEtal(String produit) {
			//compte du nombre d'etals contenant le produit
			int nbEtals = 0;
			for(Etal etal : etals) {
				if(etal.contientProduit(produit))
					nbEtals++;
			}
			
			Etal[] etalsProduit = new Etal[nbEtals];
			
			// ajouter des etals contenant le produit au tablea etalsProduit
			int indiceEtalProduit = 0;
			for(Etal etal : etals) {
				if(etal.contientProduit(produit)) {
					etalsProduit[indiceEtalProduit] = etal;
					indiceEtalProduit++;
				}
			}
			return etalsProduit;
		}
		
		private Etal trouverVendeur(Gaulois gaulois) {
			for(Etal etal : etals) {
				if(etal.getVendeur() == gaulois)
					return etal;
			}
			return null;
		}
		
		private String  AfficherMarche() {
			int nbEtalsVides = 0;
			StringBuilder chaine = new StringBuilder();
			for(Etal etal : etals) {
				if(etal.isEtalOccupe())
					etal.afficherEtal();
				else
					nbEtalsVides  ++;
			}
			if(nbEtalsVides !=0 ) {
				chaine.append("Il reste " + nbEtalsVides + " étals non utilisés dans le marché. \n");
				return chaine.toString();
			}
			return null;
		}
		
	
	//fin classe interne Marche
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;
		}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;
			}
		}
		return null;
	}

	public String afficherVillageois() {
		StringBuilder chaine = new StringBuilder();
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef "
					+ chef.getNom() + ".\n");
		} else {
			chaine.append("Au village du chef " + chef.getNom()
					+ " vivent les légendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");
			}
		}
		return chaine.toString();
	}
	
	public String installerVendeur(Gaulois vendeur, String produit,int nbProduit) {
		StringBuilder chaine = new StringBuilder();
		chaine.append(vendeur.getNom() + " cherche un endroit pour vendre " + nbProduit + " " + produit + "\n");
		for(int i = 0; i<marche.etals.length; i++) {
			if(!marche.etals[i].isEtalOccupe()) {
				marche.etals[i].occuperEtal(vendeur, produit, nbProduit);
				chaine.append("Le vendeur "+ vendeur.getNom()+" vend des " + produit + " à l'étal n°" + i + " .\n");
				return chaine.toString();
			}
		}
		chaine.append("Aucun étal n'est libre.\n");
		return chaine.toString();
	}
	
}