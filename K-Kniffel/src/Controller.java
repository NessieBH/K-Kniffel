/**
 * 
 * Copyright � 2019 L-Programming. All Rights Reserved.
 * @author Vanessa Lutz  
 * @version 2.0
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.*;     


public class Controller implements Initializable {
 
	// Definition der Variablen f�r W�rfeln / Auswertung der W�rfel / Entscheidung der Spieler
	
   int anzahlrunden = 0;
   int spieler = 1;
   int keinspielerwechsel = 1;			  
   Integer[] wuerfel = {0,0,0,0,0,0};									  
   int[] anzahlwuerfe= {0};
   int[] halten = new int[]{0,0,0,0,0};									  
   int[] auswertung = new int[]{0,0,0,0,0,0,0}; 					     
   public int[] enable_auswahl = new int[]{0,0,0,0,0,0,0}; 				 
   int[] anz_auswertung = new int[]{0,0,0,0,0,0,0}; 				
     
   int[] summe_ergebnis = new int[]{0,0};
   String nameSpieler1, nameSpieler2;
   
               
   // Definiton der allgemeinen Felder f�r W�rfeln GUI
                             
   @FXML private Button spielanleitung, neuesspiel, wuerfeln, spielerwechsel;
   @FXML private TextField anz_namespieler1,anz_namespieler2 ;
   @FXML private TextField anzeigesumme, anzeigeanzahlwuerfe, meldung, anzeigespieler;
   @FXML public Button keepw1, keepw2, keepw3, keepw4, keepw5; 
   @FXML public ImageView w�rfel1, w�rfel2, w�rfel3, w�rfel4, w�rfel5; 
   
   // Definiton der Felder f�r die Auswertung der aktuellen W�rfel GUI
   
   @FXML private Button einser, dreierpasch, chance, fullhouse;
   @FXML private Button kleinestrasse, grossestrasse, kniffel ;
   @FXML private TextField anzeigeeinser, anzeigedreierpasch, anzeigechance, anzeigefullhouse;
   @FXML private TextField anzeigekleinestrasse, anzeigegrossestrasse, anzeigekniffel;
         
   // Definiton der Textfelder f�r die Ergebnisse Speieler 1 und Spieler 2 GUI
   
   @FXML private TextField anz_einsersp1, anz_3erpaschsp1, anz_chancesp1, anz_fullhousesp1;
   @FXML private TextField anz_kleinestrassesp1, anz_grossestrassesp1,anz_kniffelsp1, anz_summesp1; 
   @FXML private TextField anz_einsersp2, anz_3erpaschsp2, anz_chancesp2, anz_fullhousesp2;
   @FXML private TextField anz_kleinestrassesp2, anz_grossestrassesp2,anz_kniffelsp2, anz_summesp2; 
   
    
   private Image Bild1 = new Image("W�rfel1.png");
   private Image Bild2 = new Image("W�rfel2.png");
   private Image Bild3 = new Image("W�rfel3.png");
   private Image Bild4 = new Image("W�rfel4.png");
   private Image Bild5 = new Image("W�rfel5.png");
   private Image Bild6 = new Image("W�rfel6.png");
   private Image Bild7 = new Image("W�rfel_leer.png");
                
   Spieler01 sp1 = new Spieler01();   				
   Spieler02 sp2 = new Spieler02();   				
   W�rfeln run = new W�rfeln();   					
   
     
    @Override
      
     public void initialize(URL location, ResourceBundle resources) {
     	
     disable_buttons();	
     reset_GUI(); 
     }
   	
    public void neuesspiel (ActionEvent event) {
	    anzahlwuerfe = new int []{0};
	    anzahlrunden=0;
	    halten = new int[]{0,0,0,0,0};									
		wuerfel[5] = 0;													
		spieler = 1;
		keinspielerwechsel = 1;
		
		reset_GUI();													
		disable_buttons();												
		
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
		
		wuerfeln.setDisable(false);				
				
		anz_auswertung = new int []{0,0,0,0,0,0,0} ;    		
		auswertung = new int []{0,0,0,0,0,0,0} ;    			
		enable_auswahl = new int []{0,0,0,0,0,0,0} ;    	
		sp1.reset_entscheidung();
		sp2.reset_entscheidung();
	}

   // Beim Bet�tigen von "Start W�rfeln" ( on Action = run ) werden folgende Funktionen ausgef�hrt:
   // 1.) W�rfeln in Abh�ngigkeit ob "Halten" ausgew�hlt
   // 2.) Auswertung der Ergebnisse (3er-Pasch, Full House Kniffel etc )
   // 3.) Anzeige der Ergebnisse in Abh�ngigkeit Spieler 1 / Spieler 2 und abspeichern im Ergebnis Array
   
   public void run (ActionEvent event) {
	     
	   run.w�rfel_run(wuerfel, anzahlwuerfe,halten);					    
	      
	   if (wuerfel[0] ==1 ) { w�rfel1.setImage(Bild1); } 
	   if (wuerfel[0] ==2 ) { w�rfel1.setImage(Bild2); } 
	   if (wuerfel[0] ==3 ) { w�rfel1.setImage(Bild3); } 
	   if (wuerfel[0] ==4 ) { w�rfel1.setImage(Bild4); } 
	   if (wuerfel[0] ==5 ) { w�rfel1.setImage(Bild5); } 
	   if (wuerfel[0] ==6 ) { w�rfel1.setImage(Bild6); } 
	   
	   if (wuerfel[1] ==1 ) { w�rfel2.setImage(Bild1); } 
	   if (wuerfel[1] ==2 ) { w�rfel2.setImage(Bild2); } 
	   if (wuerfel[1] ==3 ) { w�rfel2.setImage(Bild3); } 
	   if (wuerfel[1] ==4 ) { w�rfel2.setImage(Bild4); } 
	   if (wuerfel[1] ==5 ) { w�rfel2.setImage(Bild5); } 
	   if (wuerfel[1] ==6 ) { w�rfel2.setImage(Bild6); } 
	   
	   if (wuerfel[2] ==1 ) { w�rfel3.setImage(Bild1); } 
	   if (wuerfel[2] ==2 ) { w�rfel3.setImage(Bild2); } 
	   if (wuerfel[2] ==3 ) { w�rfel3.setImage(Bild3); } 
	   if (wuerfel[2] ==4 ) { w�rfel3.setImage(Bild4); } 
	   if (wuerfel[2] ==5 ) { w�rfel3.setImage(Bild5); } 
	   if (wuerfel[2] ==6 ) { w�rfel3.setImage(Bild6); } 
	   
	   if (wuerfel[3] ==1 ) { w�rfel4.setImage(Bild1); } 
	   if (wuerfel[3] ==2 ) { w�rfel4.setImage(Bild2); } 
	   if (wuerfel[3] ==3 ) { w�rfel4.setImage(Bild3); } 
	   if (wuerfel[3] ==4 ) { w�rfel4.setImage(Bild4); } 
	   if (wuerfel[3] ==5 ) { w�rfel4.setImage(Bild5); } 
	   if (wuerfel[3] ==6 ) { w�rfel4.setImage(Bild6); } 
	   
	   if (wuerfel[4] ==1 ) { w�rfel5.setImage(Bild1); } 
	   if (wuerfel[4] ==2 ) { w�rfel5.setImage(Bild2); } 
	   if (wuerfel[4] ==3 ) { w�rfel5.setImage(Bild3); } 
	   if (wuerfel[4] ==4 ) { w�rfel5.setImage(Bild4); } 
	   if (wuerfel[4] ==5 ) { w�rfel5.setImage(Bild5); } 
	   if (wuerfel[4] ==6 ) { w�rfel5.setImage(Bild6); } 
	   
	    anzeigespieler.setText("" + spieler);    
	  	anzeigeanzahlwuerfe.setText("" +anzahlwuerfe[0]);   		
		anzeigesumme.setText(""+ wuerfel[5]);
		  		  
		  if (anzahlwuerfe[0] ==1)  { 
		  
		    keepw1.setDisable(false);								
			keepw2.setDisable(false);
			keepw3.setDisable(false);
			keepw4.setDisable(false);
			keepw5.setDisable(false);
		  }
		  
		  if (anzahlwuerfe[0] ==3)  {
			  
			  meldung.setText("Die maximale Anzahl W�rfe ist erreicht !"); 
			  wuerfeln.setDisable(true);
			  keepw1.setDisable(true);								
			  keepw2.setDisable(true);
			  keepw3.setDisable(true);
			  keepw4.setDisable(true);
			  keepw5.setDisable(true);  		  
		  }
		
		  
		  // Vorbelegung der Anzeigen f�r Bewertung auf Null und Freigabe Auswahl Button
		  	  		  
		  if (spieler ==1) {
			  sp1.anzeige_null(anz_auswertung, auswertung);				
		  }
		  else {
		     sp2.anzeige_null(anz_auswertung, auswertung);				
		  }
		    		   
		   	run.w�rfel_auswertung(auswertung,anz_auswertung, wuerfel);
			
		   	enable_auswahl = new int[]{0,0,0,0,0,0,0};
		   	
		   	 		if (spieler ==1) {
					  sp1.anzeige_ergebnis(auswertung,enable_auswahl);	
					 }
					else {
					  sp2.anzeige_ergebnis(auswertung,enable_auswahl);	
					 }			
					
					if ( enable_auswahl[0] == 1 ) {
						  einser.setDisable(false);
						  anzeigeeinser.setText("" + (anz_auswertung[0]));
					  }
					  if ( enable_auswahl[1] == 1 ) {
						  dreierpasch.setDisable(false);
						  anzeigedreierpasch.setText("" + (anz_auswertung[1]));
					  } 
					  if ( enable_auswahl[2] == 1 ) {
						  chance.setDisable(false);
						  anzeigechance.setText("" + (anz_auswertung[2]));
					  } 
					  if ( enable_auswahl[3] == 1 ) {
						  fullhouse.setDisable(false);
						  anzeigefullhouse.setText("" + (anz_auswertung[3]));
					  } 
					  if ( enable_auswahl[4] == 1 ) {
						  kleinestrasse.setDisable(false);
						  anzeigekleinestrasse.setText("" + (anz_auswertung[4]));
					  } 
					  if ( enable_auswahl[5] == 1 ) {
						  grossestrasse.setDisable(false);
						  anzeigegrossestrasse.setText("" + (anz_auswertung[5]));
					  } 
					  if ( enable_auswahl[6] == 1 ) {
						  kniffel.setDisable(false);
						anzeigekniffel.setText("" + (anz_auswertung[6]));
					  }  			  
	  		}
 
     // Funktionen halten W�rfel 1 bis W�rfel 5
   
   		public void keep1 (ActionEvent event) {
   			halten[0] = 1;
   			keepw1.setDisable(true);
   			}
   
	   public void keep2 (ActionEvent event) {
		   halten[1] = 1;
	       keepw2.setDisable(true);
		 	} 
	   
	   public void keep3 (ActionEvent event) {
		   halten[2] = 1;
	       keepw3.setDisable(true);
		 	} 
	   
	   public void keep4 (ActionEvent event) {
		   halten[3] = 1;
	       keepw4.setDisable(true);
		 	} 
	   
	   public void keep5 (ActionEvent event) {
		   halten[4] = 1;
	       keepw5.setDisable(true);
		 	} 
	   
  
	   // Entscheidung der Spieler (  3-er_pasch, Full House, Kniffel etc. ) 
	   	
	   public void einser (ActionEvent event) {								    
		   	   
		   if (spieler ==1) {
				  sp1.ent_einser(anz_auswertung, anz_einsersp1);	
			  }
			  else {
				  sp2.ent_einser(anz_auswertung, anz_einsersp2);	
			  }
		   	funktionen_nach_entscheidung();
			}
	      
	      public void dreierpasch (ActionEvent event) {	
		   		    
	   	   if (spieler ==1) {
	   			  sp1.ent_3erpasch(anz_auswertung, anz_3erpaschsp1);	
	   		  }
	   		  else {
	   			  sp2.ent_3erpasch(anz_auswertung, anz_3erpaschsp2);	
	   		  }	   
	   	   funktionen_nach_entscheidung();		   
	   		}    
	   
	   public void chance (ActionEvent event) {
		   
		   if (spieler ==1) {
				  sp1.ent_chance(anz_auswertung, anz_chancesp1);	 
			  }
			  else {
				  sp2.ent_chance(anz_auswertung, anz_chancesp2);	
			  }   
		   	funktionen_nach_entscheidung();    
		}     
	   
	   public void fullhouse (ActionEvent event) {
		   
		   if (spieler ==1) {
				  sp1.ent_fullhouse(anz_auswertung, anz_fullhousesp1);	 
			  }
			  else {
				  sp2.ent_fullhouse(anz_auswertung, anz_fullhousesp2);	
			  }
		   	funktionen_nach_entscheidung();    
		}     
	
	   public void kleinestrasse (ActionEvent event) {
		   
		   if (spieler ==1) {
				  sp1.ent_kleinestrasse(anz_auswertung, anz_kleinestrassesp1);	
			  }
			  else {
				  sp2.ent_kleinestrasse(anz_auswertung, anz_kleinestrassesp2);	
			  }
		   funktionen_nach_entscheidung();    
		}     
	
	   public void grossestrasse (ActionEvent event) {
		   
		   if (spieler ==1) {
				  sp1.ent_grossestrasse(anz_auswertung, anz_grossestrassesp1); 
			  }
			  else {
				  sp2.ent_grossestrasse(anz_auswertung, anz_grossestrassesp2);	
			  }
		   	funktionen_nach_entscheidung();    
		}     
	
	   public void kniffel (ActionEvent event) {
		   
		   if (spieler ==1) {
				  sp1.ent_kniffel(anz_auswertung, anz_kniffelsp1);			
			  }
			  else {
				  sp2.ent_kniffel(anz_auswertung, anz_kniffelsp2);			
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
		   	anzahlwuerfe = new int []{0};                             
			halten = new int[]{0,0,0,0,0};									
			wuerfel[5] = 0;												    
			reset_GUI();
		}     
	
	   public void spielanleitung (ActionEvent event) {
		   
		        JFrame spielanleitung = new JFrame();
		        spielanleitung.setBounds(000, 000, 000, 000);
		        spielanleitung.setVisible(true);
		        spielanleitung.setTitle("K-Kniffel");
		        spielanleitung.add(new JLabel(new ImageIcon("Spielanleitung.jpg")));
		        spielanleitung.pack();
		}
	
	   private void reset_GUI() {	
		
			anzeigeanzahlwuerfe.setText("" + anzahlwuerfe[0]);  
			meldung.setText("");
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
			w�rfel1.setImage(Bild7);
			w�rfel2.setImage(Bild7);
			w�rfel3.setImage(Bild7);
			w�rfel4.setImage(Bild7);
			w�rfel5.setImage(Bild7);
		}
	
	   public void disable_buttons() {
		
			keepw1.setDisable(true);
			keepw2.setDisable(true);
			keepw3.setDisable(true);
			keepw4.setDisable(true);
			keepw5.setDisable(true);
			einser.setDisable(true);
			dreierpasch.setDisable(true);
			chance.setDisable(true);
			fullhouse.setDisable(true);
			kleinestrasse.setDisable(true);
			grossestrasse.setDisable(true);
			kniffel.setDisable(true);
		} 
		
	   private void funktionen_nach_entscheidung() {
	  
		   if (spieler ==1) {
				  sp1.summe(anz_summesp1, summe_ergebnis);				                            // Aufruf Class Spieler01 Methode Summe
		   }
			  else {
				 sp2.summe(anz_summesp2, summe_ergebnis);											// Aufruf Class Spieler02 Methode Summe
			  }
		  
		   reset_GUI();													       
		   auswertung = new int []{0,0,0,0,0,0,0} ;    			   
		   enable_auswahl = new int[]{0,0,0,0,0,0,0}; 			   
		   
		   spielerwechsel.setDisable(false);
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
	 
			anzahlwuerfe = new int []{0};											 
			anzeigeanzahlwuerfe.setText("" + anzahlwuerfe[0]);   
			meldung.setText(" ");
			halten = new int[]{0,0,0,0,0};								
			anzahlrunden++;
			
			if (( anzahlrunden == 7 && keinspielerwechsel == 1 )  || ( anzahlrunden == 14 && keinspielerwechsel == 0 ))
			{
			wuerfeln.setDisable(true);
			spielerwechsel.setDisable(true);
			
			nameSpieler1 = anz_namespieler1.getText();
			nameSpieler2 = anz_namespieler2.getText();
			
			
			if ( keinspielerwechsel == 1 )					
			{	
				summe_ergebnis[1] = 0;
			}	
			
			if ( summe_ergebnis[0] > summe_ergebnis[1] )
				{
					meldung.setText("Spieler 1 " +  nameSpieler1  + " hat mit " + summe_ergebnis[0] + " Punkten gewonnen !!!");
				}
				if ( summe_ergebnis[0] < summe_ergebnis[1]  )
				{
					meldung.setText("Spieler 2 "  +  nameSpieler2  +" hat mit " + summe_ergebnis[1] + " Punkten gewonnen !!!");
				}
				if ( summe_ergebnis[0] == summe_ergebnis[1]  )
				{
					meldung.setText("Unentschieden !!!");
				}
			}   
	 }
}

