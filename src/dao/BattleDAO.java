/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Battle;

import javax.jdo.*;

/**
 *
 * @author g14925mm
 */

///////////////////////////////////////////////////////////////
// 戦闘時のナレーションと結果を持つデータをとってくるクラス。。。であってる？
// うん…？このクラスの必要性？Battleとは…あ！戦闘履歴か！！これ！！！
///////////////////////////////////////////////////////////////

public class BattleDAO {
	/*
     private final String DRIVER_NAME = "org.apache.derby.jdbc.ClientDriver";
    private final String JDBC_URL = "jdbc:derby://localhost:1527/db25541";
    private final String DB_USER = "db";
    private final String DB_PASS = "db";
    public static String text = "";
    */
	
	/*
public List<Battle> testBattle(){
    List<Battle> battleList = new ArrayList<Battle>();
    String name= "NAME";
    String text = "うめこがモンスターに5のダメージ！";
    Battle battle = new Battle(name,text);
    battleList.add(battle);
	return battleList;
}
	*/
    
	// バトル履歴を全部読み込む？(commented by g13943se)
    public List<Battle> findAll() {
        //Connection conn = null;
        List<Battle> battleList = new ArrayList<Battle>();
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        try {
        	/*
           Class.forName(DRIVER_NAME);
           conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
           String sql = "SELECT * FROM BATTLE";
           PreparedStatement psmt = conn.prepareStatement(sql);
           ResultSet rs = psmt.executeQuery();
           while(rs.next()) {
               String name= rs.getString("NAME");
               String text = rs.getString("TEXT");
               Battle battle = new Battle(name,text);
               battleList.add(battle);
           }
           */
        	
        	battleList = (List<Battle>) manager.newQuery("select from " + Battle.class.getName()).execute();
        
        }catch(JDOObjectNotFoundException e){ System.out.println(e);
        /*
        }catch(SQLException e) {
            e.printStackTrace();
            return null;
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        */
        
        }finally {
        	/*
            if(conn != null) {
                try {
                    conn.close();
                }catch(SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
            */
        	
        	manager.close();
        	
        }
        return battleList;
    }
    
    // バトル履歴の新規追加?(commented by g13943se)
    public void create(Battle battle) {
        //Connection conn = null;
    	PersistenceManagerFactory factory = PMF.get();
    	PersistenceManager manager = factory.getPersistenceManager();
        try {
        	/*
            conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
            String sql = "INSERT INTO BATTLE (NAME,TEXT) VALUES(?,?)";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1,battle.getName());
            psmt.setString(2,battle.getText());
            int i = psmt.executeUpdate();
            */
        	manager.makePersistent(battle);
        /*
        }catch(SQLException e) {
            e.printStackTrace();
            //System.out.println("SQLエラー！");
        */
        	
        }finally {
        	/*
            if(conn != null) {
                try {
                    conn.close();
                }catch(SQLException e) {
                    e.printStackTrace();
                    //System.out.println("エラーだよ！");
                }
            }
            */
        	
        	manager.close();
        }
    }
}
