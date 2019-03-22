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
			
		if ( entscheidung[0] == 0 )
		{
			anz_auswertung[0] = 0;
		}
		if (entscheidung[1] == 0 ) 
		{
			anz_auswertung[1] = 0;
		}
		if ( entscheidung[2] == 0 )
		{
			anz_auswertung[2] = 0;
		}
		if ( entscheidung[3] == 0 )
		{
			anz_auswertung[3] = 0;
		}
		if ( entscheidung[4] == 0 )
		{
		anz_auswertung[4] = 0;
		}
		if ( entscheidung[5] == 0 )
		{
		anz_auswertung[5] = 0;
		}
		if ( entscheidung[6] == 0 )
		{
		anz_auswertung[6] = 0;
		}
	}
	
	
	public void anzeige_ergebnis(int[] auswertung, int[]enable_auswahl) {		  
			
		//Auswertung Anzeige einser ja/nein
			
		if (  entscheidung[0] == 0  && ( ergebnis[0] == 0 || auswertung[0] == 1))
		{
			enable_auswahl[0] =1;
			}
			
		//Auswertung Anzeige 3erpasch ja/nein
		
		if (  entscheidung[1] == 0  && ( ergebnis[1] == 0 || auswertung[1] == 1))
		{
			enable_auswahl[1] =1;
			}
		
		//Auswertung Chance ja/nein
		
		if (  entscheidung[2] == 0  && ( ergebnis[2] == 0 || auswertung[2] == 1))
		{
			enable_auswahl[2] =1;
			}
		
		//Auswertung Full House ja/nein
		
		if (  entscheidung[3] == 0  && ( ergebnis[3] == 0 || auswertung[3] == 1))
		{
			enable_auswahl[3] =1;
			}
		
		//Auswertung kleine Straﬂe ja/nein
		
		if (  entscheidung[4] == 0  && ( ergebnis[4] == 0 || auswertung[4] == 1))
		{
			enable_auswahl[4] =1;
			}
		
		//Auswertung grosse Straﬂe ja/nein
		
		if (  entscheidung[5] == 0  && ( ergebnis[5] == 0 || auswertung[5] == 1))
		{
			enable_auswahl[5] =1;
			}
		
		//Auswertung Kniffel ja/nein
		
		if (  entscheidung[6] == 0  && ( ergebnis[6] == 0 || auswertung[6] == 1))
		{
			enable_auswahl[6] =1;
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
