/**
 * @author Vanessa Lutz
 *
 */

package kniffel;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.*;     						// Laden damit frequency table und array sort funktioniert 

 
public class Controller implements Initializable {
 
	// Definition der Variablen für Würfeln
	
   int anzahlrunden = 0;
   int spieler = 1;
   int keinspielerwechsel = 1;			  
   Integer[] wuerfel = {0,0,0,0,0};       
   int summe;							  
   int anzahlwuerfe=0;
   int keepwuerfel1 = 0;
   int keepwuerfel2 = 0;  
   int keepwuerfel3 = 0;
   int keepwuerfel4 = 0;
   int keepwuerfel5 = 0;
   
   // Definition der Variablen für die Auswertung der Würfelergebnisse , die Variablen werden auf 1 gesetzt wenn jeweils zutreffend
   
   int auswertungeinser = 0;
   int auswertung3erpasch = 0;
   int auswertungchance = 0;
   int auswertungkleinestrasse = 0;
   int auswertunggrossestrasse = 0;
   int auswertungfullhouse = 0;
   int auswertungkniffel = 0;
   String nameSpieler1 = "";
   String nameSpieler2 = "";
   
   // Definition der Variablen für die Anzeige der Punktzahl nach Auswertung der Würfelergebnisse
   
   int anz_auswertungeinser = 0;
   int anz_auswertung3erpasch = 0;
   int anz_auswertungchance = 0;
   int anz_auswertungkleinestrasse = 0;
   int anz_auswertunggrossestrasse = 0;
   int anz_auswertungfullhouse = 0;
   int anz_auswertungkniffel = 0;
   
   // Definition der Variablen für die Auswahl des Spielers ( 3erpasch, kleine strasse etc ) 

   int ausw_einser_sp1 = 0;
   int ausw_einser_sp2 = 0;
   int ausw_3erpasch_sp1 = 0;
   int ausw_3erpasch_sp2 = 0;
   int ausw_chance_sp1 = 0;
   int ausw_chance_sp2 = 0;
   int ausw_kleinestrasse_sp1 = 0;
   int ausw_kleinestrasse_sp2 = 0;
   int ausw_grossestrasse_sp1 = 0;
   int ausw_grossestrasse_sp2 = 0;
   int ausw_fullhouse_sp1 = 0;
   int ausw_fullhouse_sp2 = 0;
   int ausw_kniffel_sp1 = 0;
   int ausw_kniffel_sp2 = 0;
   
   // Definition der Variablen für Ergebnisse 
      
   int erg_einser_sp1 = 0;
   int erg_einser_sp2 = 0;
   int erg_3erpasch_sp1 = 0;
   int erg_3erpasch_sp2 = 0;
   int erg_chance_sp1 = 0;
   int erg_chance_sp2 = 0;
   int erg_fullhouse_sp1 = 0;
   int erg_fullhouse_sp2 = 0;
   int erg_kleinestrasse_sp1 = 0;	   
   int erg_kleinestrasse_sp2 = 0;
   int erg_grossestrasse_sp1 = 0;
   int erg_grossestrasse_sp2 = 0;
   int erg_kniffel_sp1 = 0;
   int erg_kniffel_sp2 = 0;
   int summeergebnissp1 = 0;								
   int summeergebnissp2 = 0;								
      
   // Definiton der allgemeinen Felder für Würfeleln  
                             
   @FXML private Button urheber;
   @FXML private Button neuesspiel;
   @FXML private Button wuerfeln;                          
   @FXML private Button spielerwechsel;								  
   @FXML private TextField anz_namespieler1;
   @FXML private TextField anz_namespieler2;
   @FXML private TextField anzeigewuerfel1;
   @FXML private TextField anzeigewuerfel2;
   @FXML private TextField anzeigewuerfel3;
   @FXML private TextField anzeigewuerfel4;
   @FXML private TextField anzeigewuerfel5;
   @FXML private TextField anzeigesumme;
   @FXML private TextField anzeigeanzahlwuerfe;
   @FXML private TextField meldung;
   @FXML private TextField anzeigespieler;
   @FXML private Button keepw1;
   @FXML private Button keepw2;
   @FXML private Button keepw3;
   @FXML private Button keepw4;
   @FXML private Button keepw5;
   
   // Definiton der Felder für die Auswertung der aktuellen Würfel
   
   @FXML private Button einser;
   @FXML private Button dreierpasch;
   @FXML private Button chance;
   @FXML private Button fullhouse;
   @FXML private Button kleinestrasse;
   @FXML private Button grossestrasse;
   @FXML private Button kniffel;
   @FXML private TextField anzeigeeinser;
   @FXML private TextField anzeigedreierpasch;
   @FXML private TextField anzeigechance;
   @FXML private TextField anzeigefullhouse;
   @FXML private TextField anzeigekleinestrasse;
   @FXML private TextField anzeigegrossestrasse;
   @FXML private TextField anzeigekniffel;
      
   // Definiton der Textfelder für die Ergebnisse Speieler 1 und Spieler 2
   
   @FXML private TextField anz_einsersp1;
   @FXML private TextField anz_einsersp2;
   @FXML private TextField anz_3erpaschsp1;
   @FXML private TextField anz_3erpaschsp2;
   @FXML private TextField anz_chancesp1;
   @FXML private TextField anz_chancesp2;
   @FXML private TextField anz_fullhousesp1;
   @FXML private TextField anz_fullhousesp2;
   @FXML private TextField anz_kleinestrassesp1;
   @FXML private TextField anz_kleinestrassesp2;
   @FXML private TextField anz_grossestrassesp1;
   @FXML private TextField anz_grossestrassesp2;
   @FXML private TextField anz_kniffelsp1;
   @FXML private TextField anz_kniffelsp2;
   @FXML private TextField anz_summesp1;
   @FXML private TextField anz_summesp2;
      
   private void funktionen_nach_entscheidung() {
	   
        summeergebnissp1 = erg_einser_sp1 + erg_3erpasch_sp1 + erg_chance_sp1 + erg_fullhouse_sp1 + erg_kleinestrasse_sp1 + erg_grossestrasse_sp1 + erg_kniffel_sp1;
        summeergebnissp2 = erg_einser_sp2 + erg_3erpasch_sp2 + erg_chance_sp2 + erg_fullhouse_sp2 + erg_kleinestrasse_sp2 + erg_grossestrasse_sp2 + erg_kniffel_sp2;
        anz_summesp1.setText(""+ summeergebnissp1);
        anz_summesp2.setText(""+ summeergebnissp2);
        
        meldung.setText("");						
		anzeigewuerfel1.setText("");
		anzeigewuerfel2.setText("");
		anzeigewuerfel3.setText("");
		anzeigewuerfel4.setText("");
		anzeigewuerfel5.setText("");
		anzeigesumme.setText(" ");
        
		wuerfeln.setDisable(false);									
        keepw1.setDisable(true);								
		keepw2.setDisable(true);
		keepw3.setDisable(true);
		keepw4.setDisable(true);
		keepw5.setDisable(true);
		einser.setDisable(true);
        
        einser.setDisable(true);								
		dreierpasch.setDisable(true);
		chance.setDisable(true);
		fullhouse.setDisable(true);
		kleinestrasse.setDisable(true);
		grossestrasse.setDisable(true);
		kniffel.setDisable(true);
   
		anzahlwuerfe=0;											 
		anzeigeanzahlwuerfe.setText("" + anzahlwuerfe);   
		meldung.setText(" ");
		keepwuerfel1 = 0;
		keepwuerfel2 = 0;
		keepwuerfel3 = 0;
		keepwuerfel4 = 0;
		keepwuerfel5 = 0;
		
		anzeigeeinser.setText("");								
		anzeigedreierpasch.setText("");
		anzeigechance.setText("");
		anzeigefullhouse.setText("");
		anzeigekleinestrasse.setText("");
		anzeigegrossestrasse.setText("");
		anzeigekniffel.setText("");
		anzeigeeinser.setText("");
		
		anzahlrunden=anzahlrunden+1;
		
		if (( anzahlrunden == 7 && keinspielerwechsel == 1 )  || ( anzahlrunden == 14 && keinspielerwechsel == 0 ))
		{
		wuerfeln.setDisable(true);
		nameSpieler1 = anz_namespieler1.getText();
		nameSpieler2 = anz_namespieler2.getText();
		
			if ( summeergebnissp1 > summeergebnissp2  )
			{
				meldung.setText("Spieler 1: " + nameSpieler1  + " hat mit " + summeergebnissp1 + " Punkten gewonnen !!!!"); 
			}
			if ( summeergebnissp2 > summeergebnissp1  )
			{
				meldung.setText("Spieler 2 :"  +  nameSpieler2 +" hat mit " + summeergebnissp2 + " Punkten gewonnen !!!!"); 
			}
			if ( summeergebnissp2 == summeergebnissp1  )
			{
				meldung.setText("Unentschieden !!!!"); 
			}
		}   
   }
   
 
   @Override
   public void initialize(URL location, ResourceBundle resources) {}
         
   public void neuesspiel (ActionEvent event) {
	   
	    anzahlwuerfe=0;                             
	    anzahlrunden=0;
		keepwuerfel1 = 0;
		keepwuerfel2 = 0;
		keepwuerfel3 = 0;
		keepwuerfel4 = 0;
		keepwuerfel5 = 0;
		summe = 0;
		spieler = 1;
		
		anzeigeanzahlwuerfe.setText("" + anzahlwuerfe);   
		meldung.setText("");
		anzeigewuerfel1.setText("");
		anzeigewuerfel2.setText("");
		anzeigewuerfel3.setText("");
		anzeigewuerfel4.setText("");
		anzeigewuerfel5.setText("");
		anzeigesumme.setText(" ");
		anzeigespieler.setText("" + spieler);
		anzeigeeinser.setText("");
		anzeigedreierpasch.setText("");
		anzeigechance.setText("");
		anzeigefullhouse.setText("");
		anzeigekleinestrasse.setText("");
		anzeigegrossestrasse.setText("");
		anzeigekniffel.setText("");
		anzeigeeinser.setText("");
	   
		anz_einsersp1.setText("");							
		anz_einsersp2.setText("");
		anz_3erpaschsp1.setText("");
		anz_3erpaschsp2.setText("");
		anz_chancesp1.setText("");
		anz_chancesp2.setText("");
		anz_fullhousesp1.setText("");
		anz_fullhousesp2.setText("");
		anz_kleinestrassesp1.setText("");
		anz_kleinestrassesp2.setText("");
		anz_grossestrassesp1.setText("");
		anz_grossestrassesp2.setText("");
		anz_kniffelsp1.setText("");
		anz_kniffelsp2.setText("");
		anz_summesp1.setText("");
		anz_summesp2.setText("");
				
		nameSpieler1 = anz_namespieler1.getText();
		nameSpieler2 = anz_namespieler2.getText();
						
		keepw1.setDisable(true);								
		keepw2.setDisable(true);
		keepw3.setDisable(true);
		keepw4.setDisable(true);
		keepw5.setDisable(true);
		einser.setDisable(true);
		
		ausw_einser_sp1 = 0;									 
		ausw_einser_sp2 = 0;
		ausw_3erpasch_sp1 = 0;
		ausw_3erpasch_sp2 = 0;
		ausw_chance_sp1 = 0;
		ausw_chance_sp2 = 0;
		ausw_kleinestrasse_sp1 = 0;
		ausw_kleinestrasse_sp2 = 0;
		ausw_grossestrasse_sp1 = 0;
		ausw_grossestrasse_sp2 = 0;
		ausw_fullhouse_sp1 = 0;
		ausw_fullhouse_sp2 = 0;
		ausw_kniffel_sp1 = 0;
		ausw_kniffel_sp2 = 0;
		
		wuerfeln.setDisable(false);									
		einser.setDisable(true);								
		dreierpasch.setDisable(true);
		chance.setDisable(true);
		fullhouse.setDisable(true);
		kleinestrasse.setDisable(true);
		grossestrasse.setDisable(true);
		kniffel.setDisable(true);
		
		// Reset der Variablen für die Anzeige der Punktzahl nach Auswertung der Würfelergebnisse
		   anz_auswertungeinser = 0;
		   anz_auswertung3erpasch = 0;
		   anz_auswertungchance = 0;
		   anz_auswertungkleinestrasse = 0;
		   anz_auswertunggrossestrasse = 0;
		   anz_auswertungfullhouse = 0;
		   anz_auswertungkniffel = 0;
		   
		   ausw_einser_sp1 = 0;
		   ausw_einser_sp2 = 0;
		   ausw_3erpasch_sp1 = 0;
		   ausw_3erpasch_sp2 = 0;
		   ausw_chance_sp1 = 0;
		   ausw_chance_sp2 = 0;
		   ausw_kleinestrasse_sp1 = 0;
		   ausw_kleinestrasse_sp2 = 0;
		   ausw_grossestrasse_sp1 = 0;
		   ausw_grossestrasse_sp2 = 0;
		   ausw_fullhouse_sp1 = 0;
		   ausw_fullhouse_sp2 = 0;
		   ausw_kniffel_sp1 = 0;
		   ausw_kniffel_sp2 = 0;
		
		   erg_einser_sp1 = 0;
		   erg_einser_sp2 = 0;
		   erg_3erpasch_sp1 = 0;
		   erg_3erpasch_sp2 = 0;
		   erg_chance_sp1 = 0;
		   erg_chance_sp2 = 0;
		   erg_fullhouse_sp1 = 0;
		   erg_fullhouse_sp2 = 0;
		   erg_kleinestrasse_sp1 = 0;	   
		   erg_kleinestrasse_sp2 = 0;
		   erg_grossestrasse_sp1 = 0;
		   erg_grossestrasse_sp2 = 0;
		   erg_kniffel_sp1 = 0;
		   erg_kniffel_sp2 = 0;
		   summeergebnissp1 = 0;								
		   summeergebnissp2 = 0;		
		} 
   
   // Beim Betätigen von "Start Würfeln " ( on Action = run ) werden folgende Funktionen ausgeführt:
   // 1.) Würfeln in Abhängigkeit ob "Halten" ausgewählt
   // 2.) Auswertung der Ergebnisse (3er-Pasch, Full House Kniffel etc )
   // 3.) Anzeige der Ergebnisse in Abhängigkeit Spieler 1 / Spieler 2 und abspeichern in Ergebnis Variablen
   
   public void run (ActionEvent event) {
	   
	   anzeigespieler.setText("" + spieler);    
	  	   		   	   
	  if (anzahlwuerfe <3)  {                 
	   
		  if (keepwuerfel1 == 0)  { 
			  wuerfel[0] = (int)(Math.random()*6+1);
		  }
		  
		  if (keepwuerfel2 == 0)  {  
			  wuerfel[1] = (int)(Math.random()*6+1);
			  }
		   
		  if (keepwuerfel3 == 0)  { 
			  wuerfel[2] = (int)(Math.random()*6+1);
			  }
		 
		  if (keepwuerfel4 == 0)  {  
			  wuerfel[3] = (int)(Math.random()*6+1);
			  }
		  
		  if (keepwuerfel5 == 0)  {   
			  wuerfel[4] = (int)(Math.random()*6+1);
			  } 
		  	    
		  summe = wuerfel[0] + wuerfel[1] + wuerfel[2] + wuerfel[3] + wuerfel[4];
		  anzahlwuerfe=anzahlwuerfe+1;
		     	   	
		  anzeigewuerfel1.setText("" + (wuerfel[0]));  
		  anzeigewuerfel2.setText("" + (wuerfel[1]));
		  anzeigewuerfel3.setText("" + (wuerfel[2]));
		  anzeigewuerfel4.setText("" + (wuerfel[3]));
		  anzeigewuerfel5.setText("" + (wuerfel[4]));
		  anzeigesumme.setText(""+summe);
		  anzeigeanzahlwuerfe.setText("" +anzahlwuerfe);
		  
		  if (anzahlwuerfe ==1)  { 
		  
		    keepw1.setDisable(false);								
			keepw2.setDisable(false);
			keepw3.setDisable(false);
			keepw4.setDisable(false);
			keepw5.setDisable(false);
		  }
		  
		  if (anzahlwuerfe ==3)  {
			  
			  meldung.setText("Die maximale Anzahl Würfe ist erreicht !"); 
			  wuerfeln.setDisable(true);									
		  }
		
		  // Wenn Auswahl noch nicht getroffen, Vorbelegung der Anzeigen für Bewertung auf Null und Freigabe Auswahl Button
		  	  		  
		  if ((spieler == 1 && ausw_einser_sp1 == 0 ) || (spieler == 2 && ausw_einser_sp2 == 0 ))
			{
				einser.setDisable(false);	
				anz_auswertungeinser = 0;
				anzeigeeinser.setText("" + (anz_auswertungeinser));
			}
			if ((spieler == 1 && ausw_3erpasch_sp1 == 0 ) || (spieler == 2 && ausw_3erpasch_sp2 == 0 ))
			{
				dreierpasch.setDisable(false);	
				anz_auswertung3erpasch = 0;
				anzeigedreierpasch.setText("" + (anz_auswertung3erpasch));
			}
			if ((spieler == 1 && ausw_chance_sp1 == 0 ) || (spieler == 2 && ausw_chance_sp2 == 0 ))
			{
				chance.setDisable(false);	
				anz_auswertungchance = 0;
				anzeigechance.setText("" + (anz_auswertungchance));
			}
			if ((spieler == 1 && ausw_fullhouse_sp1 == 0 ) || (spieler == 2 && ausw_fullhouse_sp2 == 0 ))
			{
				fullhouse.setDisable(false);	
				anz_auswertungfullhouse = 0;
				anzeigefullhouse.setText("" + (anz_auswertungfullhouse));
			}
			if ((spieler == 1 && ausw_kleinestrasse_sp1 == 0 ) || (spieler == 2 && ausw_kleinestrasse_sp2 == 0 ))
			{
				kleinestrasse.setDisable(false);	
				anz_auswertungkleinestrasse = 0;
				anzeigekleinestrasse.setText("" + (anz_auswertungkleinestrasse));
			}
			if ((spieler == 1 && ausw_grossestrasse_sp1 == 0 ) || (spieler == 2 && ausw_grossestrasse_sp2 == 0 ))
			{
				grossestrasse.setDisable(false);	
				anz_auswertunggrossestrasse = 0;
				anzeigegrossestrasse.setText("" + (anz_auswertunggrossestrasse));
			}
			if ((spieler == 1 && ausw_kniffel_sp1 == 0 ) || (spieler == 2 && ausw_kniffel_sp2 == 0 ))
			{
				kniffel.setDisable(false);	
				anz_auswertungkniffel = 0;
				anzeigekniffel.setText("" + (anz_auswertungkniffel));
			}
		  
		   auswertungeinser = 0;                     
		   auswertung3erpasch = 0;
		   auswertungchance = 0;
		   auswertungkleinestrasse = 0;
		   auswertunggrossestrasse = 0;
		   auswertungfullhouse = 0;
		   auswertungkniffel = 0;
		  
		   anz_auswertungeinser = 0;				
	       anz_auswertung3erpasch = 0;
	       anz_auswertungchance = 0;
	       anz_auswertungkleinestrasse = 0;
	       anz_auswertunggrossestrasse = 0;
	       anz_auswertungfullhouse = 0;
	       anz_auswertungkniffel = 0;
		  
		   Integer[] a_wuerfel = new Integer[5];						 
	       a_wuerfel = wuerfel.clone();									 	
	       Arrays.sort(a_wuerfel); 										
	        
	        // Auswertung wie oft die Zahlen 1-6 vorkommen ( Frequency table )
			
			int auswertung1 = Collections.frequency(Arrays.asList(a_wuerfel), 1);  
			int auswertung2 = Collections.frequency(Arrays.asList(a_wuerfel), 2);  
			int auswertung3 = Collections.frequency(Arrays.asList(a_wuerfel), 3);  
			int auswertung4 = Collections.frequency(Arrays.asList(a_wuerfel), 4);  
			int auswertung5 = Collections.frequency(Arrays.asList(a_wuerfel), 5);  
			int auswertung6 = Collections.frequency(Arrays.asList(a_wuerfel), 6);  
			
			// Auswertung alle Einser
			
						if (auswertung1 >= 1 ) 
						{
							auswertungeinser = 1;
							anz_auswertungeinser = auswertung1;											
						 }	
						
			// Auswertung 3-er Pasc
						
						if (auswertung1 >= 3 || auswertung2 >= 3 || auswertung3 >= 3 || auswertung4 >= 3 || auswertung5 >= 3 || auswertung6 >= 3)
						{												
							auswertung3erpasch = 1;
							anz_auswertung3erpasch = summe;					
						 }	
				  
			// Auswertung Chance
						
						auswertungchance = 1;
						anz_auswertungchance = summe;
							 								
			// Auswertung Full house
							
							if (auswertung3erpasch == 1 &&(auswertung1 == 2 || auswertung2 == 2 || auswertung3 == 2 || auswertung4 == 2 || auswertung5 == 2 || auswertung6 == 2))
							{												
								auswertungfullhouse = 1;
								anz_auswertungfullhouse = 25;
							 }	
									
			// Auswertung Straße ( muss neu sortiert werden )
							
							int merke1=0;
							int merke2=0;
							int sort=0;

							for (int z=0; z<3; z++)
							{
								if ((a_wuerfel[z]+1) == a_wuerfel[z+1])
								{
									sort++;
								}else if ((a_wuerfel[z]+1) != a_wuerfel[z+1] && sort >= 1)
								{				
									merke2 = a_wuerfel[z+2];
									merke1 = a_wuerfel[z+1];
									a_wuerfel[z+2] = merke1;
									a_wuerfel[z+1] = merke2;					
								}
							}
							
			// Auswertung Kleine Straße oder große Straße
					
							int reihe=0;

							for (int i=0; i<4; i++)
							{
								if ((a_wuerfel[i]+1) == a_wuerfel[i+1])
								{
									reihe++;
								}else if ((a_wuerfel[i]+1) != a_wuerfel[i+1] && reihe >= 1)
								{
									break;
								}
							}
							if (reihe == 3)
							{
								auswertungkleinestrasse = 1;
								anz_auswertungkleinestrasse = 30;
							} else if (reihe == 4)
							{
								auswertunggrossestrasse = 1;
								anz_auswertunggrossestrasse = 40;
								auswertungkleinestrasse = 1;
								anz_auswertungkleinestrasse = 30;
							}
					
				// Auswertung Kniffel
					
							if (auswertung1 == 5 || auswertung2 == 5 || auswertung3 == 5 || auswertung4 == 5 ||auswertung5 == 5 || auswertung6 == 5)
							{										
								auswertungkniffel = 1;
								anz_auswertungkniffel = 50;
							}
				
				
				if ( (auswertungeinser == 1 && spieler == 1 && erg_einser_sp1 == 0 && ausw_einser_sp1 == 0) || ( auswertungeinser == 1 && spieler == 2 && erg_einser_sp2 == 0 && ausw_einser_sp2 == 0 ) )
				{
					anzeigeeinser.setText("" + (anz_auswertungeinser));
					einser.setDisable(false);
				}
							
				// Auswertung Anzeige 3erpasch ja/nein
				
				if ( (auswertung3erpasch == 1 && spieler == 1 && erg_3erpasch_sp1 == 0 && ausw_3erpasch_sp1 == 0) || ( auswertung3erpasch == 1 && spieler == 2 && erg_3erpasch_sp2 == 0 && ausw_3erpasch_sp2 == 0 ) )
				{
					anzeigedreierpasch.setText("" + (anz_auswertung3erpasch));
					dreierpasch.setDisable(false);
				}
		
				// Auswertung Chance ja/nein
				
				if ( (auswertungchance == 1 && spieler == 1 && erg_chance_sp1 == 0 && ausw_chance_sp1 == 0) || ( auswertungchance == 1 && spieler == 2 && erg_chance_sp2 == 0 && ausw_chance_sp2 == 0 ) )
				{
					anzeigechance.setText("" + (anz_auswertungchance));
					chance.setDisable(false);
				}
				
				// Auswertung Full House ja/nein
				
				if ( (auswertungfullhouse == 1 && spieler == 1 && erg_fullhouse_sp1 == 0 && ausw_fullhouse_sp1 == 0) || ( auswertungfullhouse == 1 && spieler == 2 && erg_fullhouse_sp2 == 0 && ausw_fullhouse_sp2 == 0 ) )
				{
					anzeigefullhouse.setText("" + (anz_auswertungfullhouse));
					fullhouse.setDisable(false);
				}
				
				// Auswertung kleine Straße ja/nein
				
				if ( (auswertungkleinestrasse == 1 && spieler == 1 && erg_kleinestrasse_sp1 == 0 && ausw_kleinestrasse_sp1 == 0) || ( auswertungkleinestrasse == 1 && spieler == 2 && erg_kleinestrasse_sp2 == 0 && ausw_kleinestrasse_sp2 == 0 ) )
				{
					anzeigekleinestrasse.setText("" + (anz_auswertungkleinestrasse));
					kleinestrasse.setDisable(false);
				}
		
				// Auswertung grosse Straße ja/nein
				
				if ( (auswertunggrossestrasse == 1 && spieler == 1 && erg_grossestrasse_sp1 == 0 && ausw_grossestrasse_sp1 == 0) || ( auswertunggrossestrasse == 1 && spieler == 2 && erg_grossestrasse_sp2 == 0 && ausw_grossestrasse_sp2 == 0 ) )
				{
					anzeigegrossestrasse.setText("" + (anz_auswertunggrossestrasse));
					grossestrasse.setDisable(false);
				}
				
				// Auswertung Kniffel ja/nein
				
				if ( (auswertungkniffel == 1 && spieler == 1 && erg_kniffel_sp1 == 0 && ausw_kniffel_sp1 == 0) || ( auswertungkniffel == 1 && spieler == 2 && erg_kniffel_sp2 == 0 && ausw_kniffel_sp2 == 0 ) )
				{
					anzeigekniffel.setText("" + (anz_auswertungkniffel));
					kniffel.setDisable(false);
				}	
	  		}
	  	}
  
   // Funktionen halten Würfel 1 bis Würfel 5
   
   		public void keep1 (ActionEvent event) {
   				if (anzahlwuerfe > 0)  {    
   				keepwuerfel1 = 1;
   				keepw1.setDisable(true);
   				} 
   		}
   
	   public void keep2 (ActionEvent event) {
	       keepwuerfel2 = 1;
	       keepw2.setDisable(true);
		 	} 
	   
	   public void keep3 (ActionEvent event) {
	       keepwuerfel3 = 1;
	       keepw3.setDisable(true);
		 	} 
	   
	   public void keep4 (ActionEvent event) {
	       keepwuerfel4 = 1;
	       keepw4.setDisable(true);
		 	} 
	   
	   public void keep5 (ActionEvent event) {
	       keepwuerfel5 = 1;
	       keepw5.setDisable(true);
		 	} 
	   
   
   // Entscheidung des Spielers welche Auswahl (  3-er_pasch, full House Kniffel etc ) 
   // Kopieren des aktuellen Würfelergebnisses in den Ergebnisspeicher
   
   public void einser (ActionEvent event) {								    
	   	   
	   if (spieler == 1 )													
	   {
		  erg_einser_sp1  =  anz_auswertungeinser;
	      ausw_einser_sp1 = 1;
	      anz_einsersp1.setText(""+ erg_einser_sp1);
	   }
	   else      															
	   {
		   erg_einser_sp2  =  anz_auswertungeinser;
		   ausw_einser_sp2 = 1;
		   anz_einsersp2.setText(""+ erg_einser_sp2);
	   }
	   funktionen_nach_entscheidung();
		}
      
   public void dreierpasch (ActionEvent event) {	
	   		    
		if (spieler == 1 )													   
		   {
			  erg_3erpasch_sp1  =  anz_auswertung3erpasch;
		      ausw_3erpasch_sp1 = 1;
		      anz_3erpaschsp1.setText(""+ erg_3erpasch_sp1);
		   }
		   else      															
		   {
			   erg_3erpasch_sp2  =  anz_auswertung3erpasch;
			   ausw_3erpasch_sp2 = 1;
			   anz_3erpaschsp2.setText(""+ erg_3erpasch_sp2);
		   }
		   funktionen_nach_entscheidung();
   		}    
   
   public void chance (ActionEvent event) {
	   
	   if (spieler == 1 )													   
	   	{
		   erg_chance_sp1  =  anz_auswertungchance;
		   ausw_chance_sp1 = 1;
		   anz_chancesp1.setText(""+ erg_chance_sp1);
	   	}
	   	else      															
	   	{
		   erg_chance_sp2  =  anz_auswertungchance;
		   ausw_chance_sp2 = 1;
		   anz_chancesp2.setText(""+ erg_chance_sp2);
	   	}
	   	funktionen_nach_entscheidung();    
	}     
   
   public void fullhouse (ActionEvent event) {
	   
	   if (spieler == 1 )													   
	   	{
		   erg_fullhouse_sp1  =  anz_auswertungfullhouse;
		   ausw_fullhouse_sp1 = 1;
		   anz_fullhousesp1.setText(""+ erg_fullhouse_sp1);
	   	}
	   else      															
	   	{
		   erg_fullhouse_sp2  =  anz_auswertungfullhouse;
		   ausw_fullhouse_sp2 = 1;
		   anz_fullhousesp2.setText(""+ erg_fullhouse_sp2);
	   	}
	   	funktionen_nach_entscheidung();    
	}     

   public void kleinestrasse (ActionEvent event) {
	   
	   if (spieler == 1 )													   
	   	{
		   erg_kleinestrasse_sp1  =  anz_auswertungkleinestrasse;
		   ausw_kleinestrasse_sp1 = 1;
		   anz_kleinestrassesp1.setText(""+ erg_kleinestrasse_sp1);
	   	}
	   else      															
	   	{
		   erg_kleinestrasse_sp2  =  anz_auswertungkleinestrasse;
		   ausw_kleinestrasse_sp2 = 1;
		   anz_kleinestrassesp2.setText(""+ erg_kleinestrasse_sp2);
	   }
	   funktionen_nach_entscheidung();    
	}     

   public void grossestrasse (ActionEvent event) {
	   
	   if (spieler == 1 )													   
	   	{
		  erg_grossestrasse_sp1  =  anz_auswertunggrossestrasse;
	      ausw_grossestrasse_sp1 = 1;
	      anz_grossestrassesp1.setText(""+ erg_grossestrasse_sp1);
	   	}
	   	else      															
	   	{
		   erg_grossestrasse_sp2  =  anz_auswertunggrossestrasse;
		   ausw_grossestrasse_sp2 = 1;
		   anz_grossestrassesp2.setText(""+ erg_grossestrasse_sp2);
	   	}
	   	funktionen_nach_entscheidung();    
	}     

   public void kniffel (ActionEvent event) {
	   
	   if (spieler == 1 )													   
	   	{
		  erg_kniffel_sp1  =  anz_auswertungkniffel;
	      ausw_kniffel_sp1 = 1;
	      anz_kniffelsp1.setText(""+ erg_kniffel_sp1);
	   	}
	   	else      															
	   	{
		   erg_kniffel_sp2  =  anz_auswertungkniffel;
		   ausw_kniffel_sp2 = 1;
		   anz_kniffelsp2.setText(""+ erg_kniffel_sp2);
	   	}
	   	funktionen_nach_entscheidung();    
	}     

   public void spielerwechsel (ActionEvent event) {
	   
	   keinspielerwechsel = 0;		 
	
	   if (spieler == 1)  { 
	    
		   spieler =2;
		  } 
	   else {
		   spieler =1;	
	   }
	   anzeigespieler.setText("" + spieler);
	
	   	wuerfeln.setDisable(false);								
		anzahlwuerfe=0;                             
	    keepwuerfel1 = 0;
		keepwuerfel2 = 0;
		keepwuerfel3 = 0;
		keepwuerfel4 = 0;
		keepwuerfel5 = 0;
		summe = 0;
	
		anzeigeanzahlwuerfe.setText("" + anzahlwuerfe);  
		meldung.setText("");
		anzeigewuerfel1.setText("");
		anzeigewuerfel2.setText("");
		anzeigewuerfel3.setText("");
		anzeigewuerfel4.setText("");
		anzeigewuerfel5.setText("");
		anzeigesumme.setText(" ");
		anzeigespieler.setText("" + spieler);
		anzeigeeinser.setText("");
		anzeigedreierpasch.setText("");
		anzeigechance.setText("");
		anzeigefullhouse.setText("");
		anzeigekleinestrasse.setText("");
		anzeigegrossestrasse.setText("");
		anzeigekniffel.setText("");
		anzeigeeinser.setText(""); 
	}     

   public void urheber (ActionEvent event) {
	   
	        JFrame urheber = new JFrame();
	        urheber.setBounds(000, 000, 000, 000);
	        urheber.setVisible(true);
	        urheber.add(new JLabel(new ImageIcon("Spielanleitung.jpg")));
	        urheber.pack();
	}

}
	
	
	
	
	
   		    
	    

