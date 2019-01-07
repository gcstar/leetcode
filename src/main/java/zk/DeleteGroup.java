package zk;

import java.util.List;

/**
 * Created by guchao on 18/12/17.
 */
public class DeleteGroup extends ConnectionWatch {

    public void delete(String group) throws Exception {
        String path = "/" + group;
        List<String> children;
        try {
            children = zk.getChildren(path, false);
            for (String child : children) {
                zk.delete(path + "/" + child, -1);
            }
            zk.delete(path, -1);
        } catch (Exception e) {
            System.err.println("opps!");
        }
    }

    public static void main(String... args) throws Exception {
        DeleteGroup group = new DeleteGroup();
        group.connect("localhost");
        group.delete("test");
        group.close();

    }
}