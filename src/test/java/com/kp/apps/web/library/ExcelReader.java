package com.kp.apps.web.library;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Takes care of Excel Reading
 * 
 * @author HariKrishna Pesala
 */
public class ExcelReader {
  public Connection c = null;
  public Statement stmnt = null;

  public String getdata(String selectColoumn, String SheetName, String where) throws SQLException {
    Connection c = connect();
    stmnt = c.createStatement();
    String query = "select " + selectColoumn + " from [" + SheetName + "$] where " + where + ";";
    String record = "";
    ResultSet rs = stmnt.executeQuery(query);
    while (rs.next()) {
      record = rs.getString(1);
    }
    close(c);
    return record;

  }

  public Connection connect() {
    try {
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      // jdbcDataSource dataSource = new jdbcDataSource();
      // using DSN-less connection
      // c =
      c =
          DriverManager
              .getConnection("jdbc:odbc:Driver={Microsoft Excel Driver (*.xls)};DBQ=TestData.xls");
    } catch (Exception e) {
      System.err.println(e);
    }
    return c;
  }

  public String[][] getRowData(String selectRow) throws SQLException {
    Connection c = connect();
    stmnt = c.createStatement();
    String query = "SELECT * from [Data$] where Test_ID='" + selectRow + "';";
    // System.out.println( query);
    ResultSet rs = stmnt.executeQuery(query);
    ResultSetMetaData rsmd = rs.getMetaData();
    int numberOfColumns = rsmd.getColumnCount();

    // String[] results=new String[500];
    String[][] rresults = new String[numberOfColumns][2];
    // System.out.println(rs.next() );
    // if( rs.next())
    {
      // System.out.println(rs.next() );
      for (int i = 1; rs.next(); i++) {

        for (int j = 1; j <= numberOfColumns; j++) {
          rresults[j - 1][0] = (rsmd.getColumnName(j));
          rresults[j - 1][1] = rs.getString(j);
          // System.out.println(rsmd.getColumnName(j)+":"+rresults[j-1][0] );
          // System.out.println("RRecords:"+rsmd.getColumnName(j)+":"+j+":"+rresults[j-1][1]);
        }
        // System.out.println( "Records:"+results[i] );
      }
    }

    close(c);
    return rresults;

  }

  public String[][] getSMSRowData(String selectRow) throws SQLException {
    Connection c = connect();
    stmnt = c.createStatement();
    String query = "SELECT * from [MessagingServices$] where Test_ID='" + selectRow + "';";
    // System.out.println( query);
    ResultSet rs = stmnt.executeQuery(query);
    ResultSetMetaData rsmd = rs.getMetaData();
    int numberOfColumns = rsmd.getColumnCount();

    // String[] results=new String[500];
    String[][] rresults = new String[numberOfColumns][2];
    // System.out.println(rs.next());
    // if( rs.next())
    {
      // System.out.println(rs.next() );
      for (int i = 1; rs.next(); i++) {

        for (int j = 1; j <= numberOfColumns; j++) {
          rresults[j - 1][0] = (rsmd.getColumnName(j));
          rresults[j - 1][1] = rs.getString(j);
          // System.out.println( rsmd.getColumnName(j)+":"+rresults[j-1][0] );
          // System.out.println( "RRecords:"+rsmd.getColumnName(j)+":"+j+":"+rresults[j-1][1] );
        }
        // System.out.println( "Records:"+results[i] );
      }
    }

    close(c);
    return rresults;

  }

  public void close(Connection c) {
    try {
      stmnt.close();
      c.close();
    } catch (Exception e) {
      System.err.println(e);
    }
  }



}
