package fr.philippe.main;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		public void gerer()
		{
			int choix;
			do 
			{
				System.out.println("_________Gestion du compte courant");
				System.out.println("1 - Consulter");
				System.out.println("2 - Deposer");
				System.out.println("3 - Retirer");
				System.out.println("4 - Interet");
				System.out.println("0 - Quitter");
				System.out.println("_________");
				System.out.println("Votre choix : ");
				choix = Console.saisirInt();
				switch (choix)
				{
				case 1 : this.consulter(); break; 
				case 2 : this.deposer(); break;
				case 3 : this.retirer(); break;
				case 4 : this.calculerInterets(); break;
				}
			}
			while (choix !=0);
		}
	}

}
