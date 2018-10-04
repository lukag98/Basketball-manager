/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Luka
 */
@Controller
@RequestMapping("/")

public class MainController {

@RequestMapping(value={"/","/login"})
 public String homepage() {
   
     
 return "index";
 } 
 
 @Autowired     
 DriverManagerDataSource dataSource;
 @RequestMapping(value={"/secondpage"})
 public String secodnpage(ModelMap map, @RequestParam String username, @RequestParam String password) throws SQLException  {
     
     map.addAttribute("username",username);
     map.addAttribute("password",password);
    
  

              
       ResultSet rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM dresovi");
             List<Dresovi> lista2 = new ArrayList<>();
             while(rs.next()){
                Dresovi d = new Dresovi(rs.getString("dre_brend"),
                                        rs.getString("dre_boja")
               );
                lista2.add(d);
               
             }
             map.addAttribute("listadresova",lista2);
             rs.close();
             
             rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM klub");
             List<Klub> lista3 = new ArrayList<>();
             while(rs.next()){
                Klub k = new Klub(rs.getString("klu_naziv"),
                                  rs.getString("klu_osnivanje"),
                                  rs.getString("klu_trofeji"),
                                  rs.getString("klu_ukplata"),
                                  rs.getString("klu_rank")
               );
                lista3.add(k);
               
             }
             map.addAttribute("listakluba",lista3);
             rs.close();
             
             rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM predsednik");
             List<Predsednik> pred = new ArrayList<>();
             while(rs.next()){
                Predsednik p = new Predsednik (rs.getString("pre_ime"),
                                              rs.getString("pre_prezime")
                
               );
                pred.add(p);
               
             }
             map.addAttribute("predsednik",pred);
             rs.close();
             
             
     
      rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM logovanje where log_username='" +username +"'" );
      if(rs.next() ){     
         if(!rs.getString("log_password").equals(password)){       
             rs.close();
           
             return "index";
         }
         rs=dataSource.getConnection().createStatement().executeQuery("SELECT * FROM predsednik where log_username='" +username +"'" );
         if(rs.next()){
             rs.close();
             
          
               return "Direktor";
           
         
         }
         
         rs=dataSource.getConnection().createStatement().executeQuery("SELECT * FROM trener where log_username='" +username +"'" );
         if(rs.next()){
             rs.close();
             return "home";
         }
          rs=dataSource.getConnection().createStatement().executeQuery("SELECT * FROM igrac where log_username='" +username +"'" );
         if(rs.next()){
             rs.close();
             return "Igrac";
         }
         
     }
       
     rs.close();
  
     return "index";

 }
 @RequestMapping(value={"/index"})
 public String index() throws SQLException {
   
      
    return "index";
 
 } 
 @RequestMapping(value={"/Roster"})
 public String Roster(ModelMap map) throws SQLException {
   ResultSet rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM igrac");
   List<Igrac> lista = new ArrayList<>();
   List<Menadzer> lista1 = new ArrayList<>();
   List<Transfer> transfer = new ArrayList<>();
   List<Trener> trener = new ArrayList<>();
   List<Pomocni> lista6 = new ArrayList<>();
   
   while( rs.next() ){
     Igrac i = new Igrac( rs.getString("igr_ime"),
                          rs.getString("igr_prezime"),
                          rs.getString("igr_pozicija"),
                          rs.getString("igr_datRodj"),
                          rs.getString("igr_plata")
             
             
             
     );
     lista.add(i);
     }
   
 
   rs.close();
     map.addAttribute("listaigraca",lista);

     rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM menazder");
     
     while(rs.next()){
         Menadzer m = new Menadzer( rs.getString("men_ime"),
                                    rs.getString("men_prezime")
                                    
         );
         lista1.add(m);
     }
     rs.close();
     map.addAttribute("listamenadzera",lista1);
     
     rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM transferi");
     
     while(rs.next()){
         Transfer t = new Transfer( rs.getString("tra_ime"),
                                    rs.getString("tra_prezime"),
                                    rs.getString("tra_cenaTrans")
                                    
         );
         transfer.add(t);
     }
     rs.close();
     map.addAttribute("listatransfera",transfer);
     
     rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM pomocnitrener");
     
     while(rs.next()){
          Pomocni r = new Pomocni( rs.getString("pom_ime"),
                                    rs.getString("pom_prezime"),
                                    rs.getString("pom_datumRodjenja")
                                    
         );
         lista6.add(r);
     }
     rs.close();
     map.addAttribute("pomocni",lista6);
     
      rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM trener");
     
     while(rs.next()){
         Trener a = new Trener( rs.getString("tre_ime"),
                                    rs.getString("tre_prezime"),
                                    rs.getString("tre_god")
                                    
         );
         trener.add(a);
     }
     rs.close();
     map.addAttribute("listatrenera",trener);
  
 
  return "Roster";
    
 }
  @RequestMapping(value={"/Stadium"})
 public String Stadium(ModelMap map) throws SQLException {
    ResultSet rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM hala");
             List<Hala> lista4 = new ArrayList<>();
             while(rs.next()){
                Hala h = new Hala(rs.getString("hal_naziv"),
                                  rs.getString("hal_kapacitet"),
                                  rs.getString("hal_adresa")
               );
               lista4.add(h);
               
             }
             map.addAttribute("hala",lista4);
             rs.close();
   
     
 return "Stadium";
 }
 
   @RequestMapping(value={"/TrenerStadium"})
 public String TrenerStadium(ModelMap map) throws SQLException {
    ResultSet rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM hala");
             List<Hala> lista4 = new ArrayList<>();
             while(rs.next()){
                Hala h = new Hala(rs.getString("hal_naziv"),
                                  rs.getString("hal_kapacitet"),
                                  rs.getString("hal_adresa")
               );
               lista4.add(h);
               
             }
             map.addAttribute("hala",lista4);
             rs.close();
   
     
 return "TrenerStadium";
 }
   @RequestMapping(value={"/home"})
 public String Home(ModelMap map) throws SQLException{
      ResultSet rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM dresovi");
             List<Dresovi> lista2 = new ArrayList<>();
           
             while(rs.next()){
                Dresovi d = new Dresovi(rs.getString("dre_brend"),
                                        rs.getString("dre_boja")
               );
                lista2.add(d);
               
             }
             map.addAttribute("listadresova",lista2);
             rs.close();
             
             rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM klub");
             List<Klub> lista3 = new ArrayList<>();
             while(rs.next()){
                Klub k = new Klub(rs.getString("klu_naziv"),
                                  rs.getString("klu_osnivanje"),
                                  rs.getString("klu_trofeji"),
                                  rs.getString("klu_ukplata"),
                                  rs.getString("klu_rank")
               );
                lista3.add(k);
               
             }
             map.addAttribute("listakluba",lista3);
             rs.close();
             
              rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM predsednik");
             List<Predsednik> pred = new ArrayList<>();
             while(rs.next()){
                Predsednik p = new Predsednik (rs.getString("pre_ime"),
                                              rs.getString("pre_prezime")
                
               );
                pred.add(p);
               
             }
             map.addAttribute("predsednik",pred);
             rs.close();
            

 return "home";
 }
    @RequestMapping(value={"/TrenerTeam"})
 public String TrenerTeam(ModelMap map) throws SQLException{
     ResultSet rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM igrac");
   List<Igrac> lista = new ArrayList<>();
   List<Pomocni> lista6 = new ArrayList<>();
   List<Menadzer> lista1 = new ArrayList<>();
 
   while( rs.next() ){
     Igrac i = new Igrac( rs.getString("igr_ime"),
                          rs.getString("igr_prezime"),
                          rs.getString("igr_pozicija"),
                          rs.getString("igr_datRodj"),
                          rs.getString("igr_plata")
     );
     lista.add(i);
     }
   rs.close();
     map.addAttribute("listaigraca",lista);
     
     
     rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM pomocnitrener");
     
     while(rs.next()){
          Pomocni r = new Pomocni( rs.getString("pom_ime"),
                                    rs.getString("pom_prezime"),
                                    rs.getString("pom_datumRodjenja")
                                    
         );
         lista6.add(r);
     }
     rs.close();
     map.addAttribute("pomocni",lista6);

     
     rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM menazder");
     
     while(rs.next()){
         Menadzer m = new Menadzer( rs.getString("men_ime"),
                                    rs.getString("men_prezime")
                                    
         );
         lista1.add(m);
     }
     rs.close();
     map.addAttribute("listamenadzera",lista1);
     

 return "TrenerTeam";
 
 }
 
 @RequestMapping(value={"/Igrac"})
 public String Igrac(ModelMap map) throws SQLException{
     ResultSet rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM dresovi");
             List<Dresovi> lista2 = new ArrayList<>();
           
             while(rs.next()){
                Dresovi d = new Dresovi(rs.getString("dre_brend"),
                                        rs.getString("dre_boja")
               );
                lista2.add(d);
               
             }
             map.addAttribute("listadresova",lista2);
             rs.close();
             
             rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM klub");
             List<Klub> lista3 = new ArrayList<>();
             while(rs.next()){
                Klub k = new Klub(rs.getString("klu_naziv"),
                                  rs.getString("klu_osnivanje"),
                                  rs.getString("klu_trofeji"),
                                  rs.getString("klu_ukplata"),
                                  rs.getString("klu_rank")
               );
                lista3.add(k);
               
             }
             map.addAttribute("listakluba",lista3);
             rs.close();
             
              rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM predsednik");
             List<Predsednik> pred = new ArrayList<>();
             while(rs.next()){
                Predsednik p = new Predsednik (rs.getString("pre_ime"),
                                              rs.getString("pre_prezime")
                
               );
                pred.add(p);
               
             }
             map.addAttribute("predsednik",pred);
             rs.close();
            

 return "Igrac";
 
 }
 
 @RequestMapping(value={"/IgracTeam"})
 public String IgracTeam(ModelMap map) throws SQLException{
     ResultSet rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM igrac");
   List<Igrac> lista = new ArrayList<>();
   List<Pomocni> lista6 = new ArrayList<>();
   List<Trener> trener = new ArrayList<>();
 
 
   while( rs.next() ){
     Igrac i = new Igrac( rs.getString("igr_ime"),
                          rs.getString("igr_prezime"),
                          rs.getString("igr_pozicija"),
                          rs.getString("igr_datRodj"),
                          rs.getString("igr_plata")
     );
     lista.add(i);
     }
   rs.close();
     map.addAttribute("listaigraca",lista);
     
     
     rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM pomocnitrener");
     
     while(rs.next()){
          Pomocni r = new Pomocni( rs.getString("pom_ime"),
                                    rs.getString("pom_prezime"),
                                    rs.getString("pom_datumRodjenja")
                                    
         );
         lista6.add(r);
     }
     rs.close();
     map.addAttribute("pomocni",lista6);
     
     rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM trener");
     
     while(rs.next()){
         Trener a = new Trener( rs.getString("tre_ime"),
                                    rs.getString("tre_prezime"),
                                    rs.getString("tre_god")
                                    
         );
         trener.add(a);
     }
     rs.close();
     map.addAttribute("listatrenera",trener);

            

 return "IgracTeam";
 
 }
  @RequestMapping(value={"/Direktor"})
 public String Direktor(ModelMap map) throws SQLException{
      ResultSet rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM dresovi");
             List<Dresovi> lista2 = new ArrayList<>();
             while(rs.next()){
                Dresovi d = new Dresovi(rs.getString("dre_brend"),
                                        rs.getString("dre_boja")
               );
                lista2.add(d);
               
             }
             map.addAttribute("listadresova",lista2);
             rs.close();
             
             rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM klub");
             List<Klub> lista3 = new ArrayList<>();
             while(rs.next()){
                Klub k = new Klub(rs.getString("klu_naziv"),
                                  rs.getString("klu_osnivanje"),
                                  rs.getString("klu_trofeji"),
                                  rs.getString("klu_ukplata"),
                                  rs.getString("klu_rank")
               );
                lista3.add(k);
               
             }
             map.addAttribute("listakluba",lista3);
             rs.close();
             
             rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM predsednik");
             List<Predsednik> pred = new ArrayList<>();
             while(rs.next()){
                Predsednik p = new Predsednik (rs.getString("pre_ime"),
                                              rs.getString("pre_prezime")
                
               );
                pred.add(p);
               
             }
             map.addAttribute("predsednik",pred);
             rs.close();
            

 return "Direktor";
 
 }
 
 
 
 @RequestMapping(value={"/Unesi"})
 public String Unesi(ModelMap map,@RequestParam String ime, @RequestParam String prezime,@RequestParam String pozicija, @RequestParam String datum, @RequestParam String plata) throws SQLException {
   ResultSet rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM igrac");
   List<Igrac> lista = new ArrayList<>();
   List<Menadzer> lista1 = new ArrayList<>();
   List<Transfer> transfer = new ArrayList<>();
   List<Trener> trener = new ArrayList<>();
   List<Pomocni> lista6 = new ArrayList<>();
    String s = "INSERT INTO igrac(igr_ime, igr_prezime, igr_pozicija, igr_datRodj, igr_plata) VALUES(?, ?, ?, ?, ?)";
       PreparedStatement statement = dataSource.getConnection().prepareStatement(s);
       statement.setString(1, ime);
       statement.setString(2, prezime);
       statement.setString(3, pozicija);
       statement.setString(4, datum);
       statement.setString(5, plata);
       statement.execute();

   while(rs.next()){
  
     Igrac i = new Igrac( rs.getString("igr_ime"),
                          rs.getString("igr_prezime"),
                          rs.getString("igr_pozicija"),
                          rs.getString("igr_datRodj"),
                          rs.getString("igr_plata"));
    
             lista.add(i);
   }
   rs.close();
     map.addAttribute("listaigraca",lista);

     rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM menazder");
     
     while(rs.next()){
         Menadzer m = new Menadzer( rs.getString("men_ime"),
                                    rs.getString("men_prezime")
                                    
         );
         lista1.add(m);
     }
     rs.close();
     map.addAttribute("listamenadzera",lista1);
     
     rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM transferi");
     
     while(rs.next()){
         Transfer t = new Transfer( rs.getString("tra_ime"),
                                    rs.getString("tra_prezime"),
                                    rs.getString("tra_cenaTrans")
                                    
         );
         transfer.add(t);
     }
     rs.close();
     map.addAttribute("listatransfera",transfer);
     
     rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM pomocnitrener");
     
     while(rs.next()){
          Pomocni r = new Pomocni( rs.getString("pom_ime"),
                                    rs.getString("pom_prezime"),
                                    rs.getString("pom_datumRodjenja")
                                    
         );
         lista6.add(r);
     }
     rs.close();
     map.addAttribute("pomocni",lista6);
     
      rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM trener");
     
     while(rs.next()){
         Trener a = new Trener( rs.getString("tre_ime"),
                                    rs.getString("tre_prezime"),
                                    rs.getString("tre_god")
                                    
         );
         trener.add(a);
     }
     rs.close();
     map.addAttribute("listatrenera",trener);
  
 
  return "Roster";
    
 }
  @RequestMapping(value={"/UnesiM"})
 public String UnesiM(ModelMap map,@RequestParam String mime, @RequestParam String mprezime) throws SQLException {
   ResultSet rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM igrac");
   List<Igrac> lista = new ArrayList<>();
   List<Menadzer> lista1 = new ArrayList<>();
   List<Transfer> transfer = new ArrayList<>();
   List<Trener> trener = new ArrayList<>();
   List<Pomocni> lista6 = new ArrayList<>();
    String j= "INSERT INTO menazder(men_ime, men_prezime) VALUES(?, ?)";
       PreparedStatement statement = dataSource.getConnection().prepareStatement(j);
       statement.setString(1, mime);
       statement.setString(2, mprezime);
      
       statement.execute();

   while(rs.next()){
  
     Igrac i = new Igrac( rs.getString("igr_ime"),
                          rs.getString("igr_prezime"),
                          rs.getString("igr_pozicija"),
                          rs.getString("igr_datRodj"),
                          rs.getString("igr_plata"));
    
             lista.add(i);
   }
   rs.close();
     map.addAttribute("listaigraca",lista);

     rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM menazder");
     
     while(rs.next()){
         Menadzer m = new Menadzer( rs.getString("men_ime"),
                                    rs.getString("men_prezime")
                                    
         );
         lista1.add(m);
     }
     rs.close();
     map.addAttribute("listamenadzera",lista1);
     
     rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM transferi");
     
     while(rs.next()){
         Transfer t = new Transfer( rs.getString("tra_ime"),
                                    rs.getString("tra_prezime"),
                                    rs.getString("tra_cenaTrans")
                                    
         );
         transfer.add(t);
     }
     rs.close();
     map.addAttribute("listatransfera",transfer);
     
     rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM pomocnitrener");
     
     while(rs.next()){
          Pomocni r = new Pomocni( rs.getString("pom_ime"),
                                    rs.getString("pom_prezime"),
                                    rs.getString("pom_datumRodjenja")
                                    
         );
         lista6.add(r);
     }
     rs.close();
     map.addAttribute("pomocni",lista6);
     
      rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM trener");
     
     while(rs.next()){
         Trener a = new Trener( rs.getString("tre_ime"),
                                    rs.getString("tre_prezime"),
                                    rs.getString("tre_god")
                                    
         );
         trener.add(a);
     }
     rs.close();
     map.addAttribute("listatrenera",trener);
  
 
  return "Roster";
    
 }
 
}


 





 

 
 



