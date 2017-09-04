package org.yl.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.util.List;

/**
 * 迁移zookeeper节点及节点数据
 * @author wgzh159@163.com
 */
public class ZookeeperMoveTest {

    public static void main(String[] args) throws Exception{

//
//        Class.forName("org.gjt.mm.mysql.Driver");
//        Connection conn = DriverManager.getConnection("jdbc:mysql://10.18.19.161:3306/supply_other?useSSL=false", "supply_other", "supply_other");
//        System.out.println(conn);
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery("select * from ar");
//        while(rs.next()){
//            System.out.println(rs.getInt(1));
//            System.out.println(rs.getString(2));
//        }
//        rs.close();
//        stmt.close();
//        conn.close();

//

        //旧zk配置
        ZooKeeper oldzk = new ZooKeeper("zoo1-dev.sl.com:12181", 60000, null);
        //新zk配置
        ZooKeeper newzk = new ZooKeeper("127.0.0.1:2193", 60000, null);
        //迁移的节点
        String node = "/com/dianrong/cfg/1.0.0/scf";
        newzk.create("/com", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        newzk.create("/com/dianrong", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        newzk.create("/com/dianrong/cfg", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        newzk.create("/com/dianrong/cfg/1.0.0", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        newzk.create("/com/dianrong/cfg/1.0.0/scf", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        List<String> children = oldzk.getChildren(node, false);

        for(String child:children){
            System.out.println(child);
        }

        System.out.print(children);

        move(oldzk, newzk, children,node);
        oldzk.close();
        newzk.close();
    }

    private static void move(ZooKeeper oldzk, ZooKeeper newzk, List<String> children,String parent)
            throws KeeperException, InterruptedException {
        if(children==null || children.isEmpty()){
            return;
        }else{
            for(String child:children){
                String c = parent+"/"+child;
                System.out.println(c);
                byte[] data = oldzk.getData(c, false, null);
                if(data != null){
                    System.out.print("@@@@@@@@@"+new String(data));
                }
                try{
                    if(newzk.exists(c, false)==null){
                        newzk.create(c, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                    }else{
                        newzk.setData(c, data, -1, null, null);
                    }
                    Thread.sleep(10);
                }catch (Exception e){
                    System.out.print(1111);
                }
                move(oldzk, newzk, oldzk.getChildren(c, false),c);
            }
        }
    }
}