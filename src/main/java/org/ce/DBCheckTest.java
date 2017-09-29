package org.ce;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yang on 30/08/2017.
 */
public class DBCheckTest {

    static class KeyStore{

        public  String nodeId;

        public String privateKey;

        public String publicKey;

        public void setNodeId(String nodeId){
             this.nodeId = nodeId;
        }

        public void setPrivateKey(String privateKey){
            this.privateKey = privateKey;
        }

        public void setPublicKey(String publicKey){
            this.publicKey = publicKey;
        }

        public String toString(){
            return nodeId+"*****"+privateKey+"*****"+publicKey;
        }
    }

    public static Connection getConn(String username,String passwd,String dbname){
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://10.134.159.170:"+dbname;
        Connection conn=null;
        try {
            Class.forName(driver);
            conn= DriverManager.getConnection(url,username,passwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static Map<String,KeyStore> getData(String type) throws Exception{
        Connection conn = null;
        if("cf".equals(type)){
            conn=getConn("supply_cf","supply_cfsdfas","3307/supply_cf");
        }else if("dianrong".equals(type)){
            conn=getConn("supply_dianrong","supply_dianrongsdfas","3308/supply_dianrong");
        }else if("juyi".equals(type)){
            conn=getConn("supply_other","supply_othersdfas","3306/supply_other");
        }

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT node_id,private_key,public_key FROM bc_node");

        Map map = new HashMap<String,KeyStore>();

        while (rs.next()){
            KeyStore ks = new KeyStore();
            ks.setNodeId(rs.getString(1));
            ks.setPrivateKey(rs.getString(2));
            ks.setPublicKey(rs.getString(3));

            map.put(ks.nodeId,ks);
        }

        stmt.close();
        conn.close();

        return  map;
    }


    public static void main(String [] args) throws Exception{

        DBCheckTest test = new DBCheckTest();
        Map<String,KeyStore> cfMap = test.getData("cf");
        Map<String,KeyStore> dianrongMap = test.getData("dianrong");
        Map<String,KeyStore> juyiMap = test.getData("juyi");

        /**
         * CF节点与点融节点
         */
        //CF节点与点融节点======》CF公钥一致
        if(cfMap.get("cf").publicKey.equals(dianrongMap.get("cf").publicKey)){
            System.out.println("CF节点与点融节点======》CF公钥一致");
        }else {
            System.out.println("！！！！！11");
        }

        //CF节点与点融节点======》CF公钥一致
        if(cfMap.get("node1").publicKey.equals(dianrongMap.get("node1").publicKey)){
            System.out.println("CF节点与点融节点======》node1公钥一致");
        }else {
            System.out.println("！！！！！22");
        }

        //CF节点与点融节点======》CF公钥一致
        if(cfMap.get("node2").publicKey.equals(dianrongMap.get("node2").publicKey)){
            System.out.println("CF节点与点融节点======》node2公钥一致");
        }else {
            System.out.println("！！！！！33");
        }


        /**
         * CF节点与钜亿节点对比
         */
        //CF节点与钜亿节点======》CF公钥一致
        if(cfMap.get("cf").publicKey.equals(juyiMap.get("cf").publicKey)){
            System.out.println("CF节点与钜亿节点======》CF公钥一致");
        }else {
            System.out.println("！！！！！44");
        }

        //CF节点与钜亿节点======》CF公钥一致
        if(cfMap.get("node1").publicKey.equals(juyiMap.get("node1").publicKey)){
            System.out.println("CF节点与钜亿节点======》node1公钥一致");
        }else {
            System.out.println("！！！！！55");
        }

        //CF节点与钜亿节点======》CF公钥一致
        if(cfMap.get("node2").publicKey.equals(juyiMap.get("node2").publicKey)){
            System.out.println("CF节点与钜亿节点======》node2公钥一致");
        }else {
            System.out.println("！！！！！66");
        }



    }


}
