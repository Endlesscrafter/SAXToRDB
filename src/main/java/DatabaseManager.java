import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;

public class DatabaseManager {

    public Connection connect() throws SQLException {

        String treiber;
        OracleDataSource ods = new OracleDataSource();
        treiber = "oracle.jdbc.driver.OracleDriver";
        Connection dbConnection = null;

        /* Treiber laden */
        try
        {
            Class.forName(treiber).newInstance();       /****   FEHLER   ******/
            System.out.println("Treiber erfolgreich geladen");
        }
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException e){

            System.out.println("Fehler beim laden des Treibers: "+ e.getMessage());
        }

        /* Datenbank-Verbindung erstellen  */
        try {

            ods.setURL("jdbc:oracle:thin:DBPRAK13/dbprak13@schelling.nt.fh-koeln.de:1521:XE");
            dbConnection = ods.getConnection();
            System.out.println("Verbindung erstellt");
        }
        catch (SQLException e){

            System.out.println("Fehler beim Verbindungsaufbau zur Datenbank!");
            System.out.println(e.getMessage());
        }

        return dbConnection;

    } // end connect()

    public int insertArtikel(Connection con, String insert){


        Statement stmt;
        int iz = -1;
        System.out.println("Kommando : " + insert);

        /* Kommando ausführen */
        try{
            stmt = con.createStatement();
            iz   = stmt.executeUpdate(insert);
            stmt.close();
        }
        catch(SQLException e){

            System.out.println(e.getMessage());
            System.out.println("SQL Exception wurde geworfen!");
        }

        return iz;
    }

    public int updateKunde(Connection con, String insert){


        Statement stmt;
        int iz = -1;
        System.out.println("Kommando : " + insert);

        /* Kommando ausführen */
        try{
            stmt = con.createStatement();
            iz   = stmt.executeUpdate(insert);
            stmt.close();
        }
        catch(SQLException e){

            System.out.println(e.getMessage());
            System.out.println("SQL Exception wurde geworfen!");
        }

        return iz;
    }

    public void selectKunde(Connection con, String select){

        Statement stmt;
        ResultSet rs;
        try{

            stmt = con.createStatement();
            rs = stmt.executeQuery(select);

            while(rs.next()){
                System.out.print(String.valueOf(rs.getInt("KNR")) + " ");
                System.out.print(rs.getString("KNAME") +" ");
                System.out.print(String.valueOf(rs.getInt("PLZ"))+ " ");
                System.out.println(rs.getString("STRASSE") );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void readLager(Connection con, String select){

        Statement stmt;
        ResultSet rs;

        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(select);

            boolean first = true;
            int artiekl_counter = 1;

            while(rs.next()){
                if(first){
                    System.out.println("Lagernummer       : " + String.valueOf(rs.getInt("LAGERNUMMER")));
                    System.out.println("Lagerort          : " + rs.getString("LAGERORT"));
                    System.out.println("Lagerpostleitzahl : " + String.valueOf(rs.getInt("LAGERPOSTLEITZAHL")));
                    first = false;
                }

                System.out.println();
                System.out.println("\tArtikel " + artiekl_counter + " :");
                System.out.println();
                System.out.println("\tArtikelnummer      : " + String.valueOf(rs.getInt("ARTNR")));
                System.out.println("\tArtikelbezeichnung : " + rs.getString("ARTBEZ"));
                System.out.println("\tMengeneinheit      : " + rs.getString("MGE"));
                System.out.println("\tSteuersatz         : " + String.valueOf(rs.getInt("STEU")));
                Date date = rs.getDate("EDAT");
                if(date == null)
                    System.out.println("\tEinlieferungsdatum : Keine Angabe");
                else
                    System.out.println("\tEinlieferungsdatum : " + date.toString());
                artiekl_counter++;
            }
            System.out.println();
            System.out.println();

        } catch (SQLException e){
            e.printStackTrace();
        }


    }
}
