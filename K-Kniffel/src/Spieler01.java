/**
 * 
 * Copyright © 2019 L-Programming. All Rights Reserved.
 * @author Vanessa Lutz  
 * @version 2.0
 *
 */


package kniffel;


public class Spieler01 {							

	   static int[] entscheidung = new int[]{0,0,0,0,0,0,0};    
	   static int[] ergebnis = new int[]{0,0,0,0,0,0,0,0};      
	
	
	   public void anzeige_null(int[] anz_auswertung, int[] auswertung) {		
		
			 for (int z=0; z < 7; z++) {			
			   
			   if ( entscheidung[z] == 0 )
			   {
					anz_auswertung[z] = 0;
				}
		   }
	   }

	   public void anzeige_ergebnis(int[] auswertung, int[]enable_auswahl) {		  
		
			for (int z=0; z < 7; z++) {			
			   
		   		if (  entscheidung[z] == 0  && ( ergebnis[z] == 0 || auswertung[z] == 1))
		   		{
		   			enable_auswahl[z] =1;
				}
		   }
	   }
			
		public void ent_einser(int[] anz_auswertung, javafx.scene.control.TextField anz_einsersp1) {
		
			ergebnis[0]  =  anz_auswertung[0];
			entscheidung[0] = 1;
		    anz_einsersp1.setText(""+ anz_auswertung[0]);	
		}
		
		public void ent_3erpasch(int[] anz_auswertung, javafx.scene.control.TextField anz_anz_3erpaschsp1) {
		
			ergebnis[1]  =  anz_auswertung[1];
			entscheidung[1] = 1;
			anz_anz_3erpaschsp1.setText(""+ anz_auswertung[1]);	
		}
		
		public void ent_chance(int[] anz_auswertung, javafx.scene.control.TextField anz_chancesp1) {
		
			ergebnis[2]  =  anz_auswertung[2];
			entscheidung[2] = 1;
			anz_chancesp1.setText(""+ anz_auswertung[2]);		
		}
		
		public void ent_fullhouse(int[] anz_auswertung, javafx.scene.control.TextField anz_fullhousesp1) {
		
			ergebnis[3]  =  anz_auswertung[3];
			entscheidung[3] = 1;
			anz_fullhousesp1.setText(""+ anz_auswertung[3]);		
		}
		
		public void ent_kleinestrasse(int[] anz_auswertung, javafx.scene.control.TextField anz_kleinestrassesp1) {
		
			ergebnis[4]  =  anz_auswertung[4];
			entscheidung[4] = 1;
			anz_kleinestrassesp1.setText(""+ anz_auswertung[4]);	
		}
		
		public void ent_grossestrasse(int[] anz_auswertung, javafx.scene.control.TextField anz_grossestrassesp1) {
		
			ergebnis[5]  =  anz_auswertung[5];
			entscheidung[5] = 1;
			anz_grossestrassesp1.setText(""+ anz_auswertung[5]);	
		}
		
		public void ent_kniffel(int[] anz_auswertung, javafx.scene.control.TextField anz_kniffelsp1) {
		
			ergebnis[6]  =  anz_auswertung[6];
			entscheidung[6] = 1;
			anz_kniffelsp1.setText(""+ anz_auswertung[6]);	
		}
		
		public void summe(javafx.scene.control.TextField anz_summesp1, int[] summe_ergebnis) {
		
			 ergebnis[7] =0;
			 
			 for( int i = 0; i<7; i++ ){									 		
				   ergebnis[7] = ergebnis[i] + ergebnis[7];
					} 
			   anz_summesp1.setText(""+ ergebnis[7]);  
			   summe_ergebnis[0] = ergebnis[7];
		}

		public void reset_entscheidung() {
		
			entscheidung = new int[]{0,0,0,0,0,0,0};
			ergebnis = new int[]{0,0,0,0,0,0,0,0};	
		}	
}
