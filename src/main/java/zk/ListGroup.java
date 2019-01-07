package zk;

import java.util.List;

/**
 * Created by guchao on 18/12/17.
 */
public class ListGroup extends ConnectionWatch {
    public void list(String group) throws Exception {
        String path = "/" + group;
        try {
            List<String> children = zk.getChildren(path, false);

            if (children.isEmpty()) {
                System.out.println("no child in group:" + group);
                System.exit(1);
            }
            for (String child : children) {
                System.out.println("child:" + child);
            }

        } catch (Exception e) {
            System.err.println("exception occur");
        }

    }

    public static void main(String... args) throws Exception {
        ListGroup listGroup = new ListGroup();
        listGroup.connect("localhost");
        listGroup.list("test");
        listGroup.close();
    }
}
