import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
}
