/**
 * 
 * Copyright © 2019 L-Programming. All Rights Reserved.
 * @author Vanessa Lutz  
 * @version 2.0
 *
 */


package kniffel;

import java.util.Arrays;
import java.util.Collections;


public class Würfeln {							

	static int[] auswertung_f = {0,0,0,0,0,0,0}; 								 

	public void würfel_run(Integer[] wuerfel, int[]anzahlwuerfe,int[] halten ) {		          
		
			if (anzahlwuerfe[0] <3)  {                 
			   
					anzahlwuerfe[0]++;
					
					for (int z=0; z < 5; z++) {	
					
							if (halten[z] == 0)  { 
								wuerfel[z] = (int)(Math.random()*6+1);
							}
					}
					wuerfel[5] = wuerfel[0] + wuerfel[1] + wuerfel[2] + wuerfel[3] + wuerfel[4];   				      	
			}
	}


	public void würfel_auswertung(int[] auswertung,int[] anz_auswertung,Integer[] wuerfel ) {												
	       			
			for (int z=0; z<6; z++) {
	        
				auswertung_f[z] = Collections.frequency(Arrays.asList(wuerfel), (z+1));  
            		}  
			
			// Auswertung alle Einser
			
			if (auswertung_f[0] >= 1 ) 
			{
				auswertung[0] = 1;
				anz_auswertung[0] = auswertung_f[0];											
			 }	
			
			// Auswertung 3-er Pasch
			
			if (auswertung_f[0] >= 3 || auswertung_f[1] >= 3 || auswertung_f[2] >= 3 || auswertung_f[3] >= 3 || auswertung_f[4] >= 3 || auswertung_f[5] >= 3)
			{												
				auswertung[1] = 1;
				anz_auswertung[1] = wuerfel[5];
			 }	
	  
			// Auswertung Chance
			
			auswertung[2] = 1;
			anz_auswertung[2] = wuerfel[5];
				 								
			// Auswertung Full house
			
			if (auswertung[1] == 1 &&(auswertung_f[0] == 2 || auswertung_f[1] == 2 || auswertung_f[2] == 2 || auswertung_f[3] == 2 || auswertung_f[4] == 2 || auswertung_f[5] == 2))
			{												
				auswertung[3] = 1;
				anz_auswertung[3] = 25;
			 }	
					
			// Auswertung kleine + große Straße
			
			if (auswertung_f[2] >= 1 && auswertung_f[3] >= 1 )
			{
			
			// Auswertung kleine Strasse
			
			if ((auswertung_f[0] >= 1 && auswertung_f[1] >= 1 )  || ( auswertung_f[1] >= 1 && auswertung_f[4] >= 1 ) || (auswertung_f[4] >= 1 && auswertung_f[5] >= 1 ))
			{
				auswertung[4] = 1;
				anz_auswertung[4] = 30;
			
			// Auswertung grosse Strasse
			
			if ((auswertung_f[1] == 1 && auswertung_f[4] == 1 ) && (auswertung_f[0] == 1 || auswertung_f[5] == 1 ) )
			{
				auswertung[5] = 1;
				anz_auswertung[5] = 40;	
			}
			}
		}
	
			// Auswertung Kniffel
	
			if (auswertung_f[0] == 5 || auswertung_f[1] == 5 || auswertung_f[2] == 5 || auswertung_f[3] == 5 ||auswertung_f[4] == 5 || auswertung_f[5] == 5)
			{										
				auswertung[6] = 1;
				anz_auswertung[6] = 50;
			}
		}
}





















	



