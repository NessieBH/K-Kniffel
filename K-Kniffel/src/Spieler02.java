/**
 * 
 * Copyright © 2019 L-Programming. All Rights Reserved.
 * @author Vanessa Lutz  
 * @version 2.0
 *
 */


package kniffel;


public class Spieler02 {

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
	
	
		public void ent_einser(int[] anz_auswertung, javafx.scene.control.TextField anz_einsersp2) {		  
	
			ergebnis[0]  =  anz_auswertung[0];
			entscheidung[0] = 1;
		    anz_einsersp2.setText(""+  anz_auswertung[0]);
		}
	
		public void ent_3erpasch(int[] anz_auswertung, javafx.scene.control.TextField anz_anz_3erpaschsp2) {
			
			ergebnis[1]  =  anz_auswertung[1];
			entscheidung[1] = 1;
			anz_anz_3erpaschsp2.setText(""+ anz_auswertung[1]);	
		}
		
		public void ent_chance(int[] anz_auswertung, javafx.scene.control.TextField anz_chancesp2) {
			
			ergebnis[2]  =  anz_auswertung[2];
			entscheidung[2] = 1;
			anz_chancesp2.setText(""+ anz_auswertung[2]);	
		}
		
		public void ent_fullhouse(int[] anz_auswertung, javafx.scene.control.TextField anz_fullhousesp2) {
			
			ergebnis[3]  =  anz_auswertung[3];
			entscheidung[3] = 1;
			anz_fullhousesp2.setText(""+ anz_auswertung[3]);	
		}
		
		public void ent_kleinestrasse(int[] anz_auswertung, javafx.scene.control.TextField anz_kleinestrassesp2) {
	
			ergebnis[4]  =  anz_auswertung[4];
			entscheidung[4] = 1;
			anz_kleinestrassesp2.setText(""+ anz_auswertung[4]);	
		}
		
		public void ent_grossestrasse(int[] anz_auswertung, javafx.scene.control.TextField anz_grossestrassesp2) {
	
			ergebnis[5]  =  anz_auswertung[5];
			entscheidung[5] = 1;
			anz_grossestrassesp2.setText(""+ anz_auswertung[5]);
		}
	
		public void ent_kniffel(int[] anz_auswertung, javafx.scene.control.TextField anz_kniffelsp2) {
	
			ergebnis[6]  =  anz_auswertung[6];
			entscheidung[6] = 1;
			anz_kniffelsp2.setText(""+ anz_auswertung[6]);	
		}
		
		public void summe(javafx.scene.control.TextField anz_summesp2, int[] summe_ergebnis) {
	
			 ergebnis[7] =0;
			 
			 for( int i = 0; i<7; i++ ){									 		
				   ergebnis[7] = ergebnis[i] + ergebnis[7];
					} 
			   anz_summesp2.setText(""+ ergebnis[7]);  
			   summe_ergebnis[1] = ergebnis[7];
		}
	
		public void reset_entscheidung() {
	
			entscheidung = new int[]{0,0,0,0,0,0,0};
			ergebnis = new int[]{0,0,0,0,0,0,0,0};
		}
}
