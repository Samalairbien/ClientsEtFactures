package metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client
{
	private String nom;
	private List<Facture> factures = new ArrayList<Facture>();
	private static List<Client> clients = new ArrayList<Client>();
	/** 
	 * Crée un client.
	 * @param nom le nom du client. 
	 */

	public Client(String nom)
	{
		this.nom = nom;
		clients.add(this);
	}

	/**
	 * Retourne le nom du client.
	 * @return le nom du client.
	 */

	public String getNom()
	{
		return nom;
	}

	/**
	 * Modifie le nom du client.
	 * @param nom le nom du client.
	 */

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	/**
	 * Créé une facture.
	 * @param montant Le montant de la facture.
	 * @return la facture créée.
	 */

	public Facture createFacture(int montant)
	{
		if (montant < 0) {
			return null;
		}
		else {
			Facture facture = new Facture(this, montant, false, LocalDate.now());
			factures.add(facture);
			return facture;
		}
	}

	/**
	 * Retourne une copie de la liste des factures du client. 
	 * @return une copie de la liste des factures du client.
	 */

	public List<Facture> getFactures()
	{
		List<Facture> Facture = new ArrayList<Facture>(factures);
		return Facture;
	}

	/**
	 * Retourne la somme des montants des factures.
	 * @return la somme des montants des factures.
	 */

	public int sommeMontants()
	{
		int montant=0;
		for(Facture facture : factures)
		{
			montant += montant+facture.getMontant();
		}
		return montant;
	}

	/**
	 * Créé une facture en précisant si elle est reglée.
	 * param montant Le montant de la facture.
	 * param estreglee() Vrai si la facture est reglée.
	 * @return la facture créée.
	 */

	public Facture createFacture(int montant, boolean reglementFacture)
	{
		if (montant < 0) {
			System.out.println("Le montant d'une facture ne peut pas être négatif.");
			return null;
		}
		else {
			Facture facture = new Facture(this, montant, reglementFacture, LocalDate.now());
			factures.add(facture);
			return facture;
		}
	}    

	/**
	 * Retourne la liste des factures reglées. 
	 * @return la liste des factures reglées.
	 */

	public List<Facture> facturesReglees()
	{

		List<Facture> factureReglees = new ArrayList<Facture>();
		for(Facture facture : factures)
		{
			if(facture.estReglee())
			{
				factureReglees.add(facture);
			}
		}
		return factureReglees;
	}

	/**
	 * Retourne tous les clients créés.
	 * @return une copie de la liste de tous les clients.
	 */
	public static List<Client> tous()
	{
		return new ArrayList<Client>(clients);
	}

	/**
	 * Supprime le client.
	 */

	public void delete()
	{
		clients.remove(this);
	}

	public void deleteFacture(Facture facture) {
		factures.remove(facture);
	}
}
