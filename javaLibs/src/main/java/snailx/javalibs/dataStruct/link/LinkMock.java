package snailx.javalibs.dataStruct.link;

/**
 * <des>
 *
 * @author YangGang
 * @date 2019/1/18
 */
public class LinkMock {

    public static SingleNode mockNormalLink() {
        SingleNode node = new SingleNode(1);
        SingleNode node1 = new SingleNode(2);
        SingleNode node2 = new SingleNode(3);
        SingleNode node3 = new SingleNode(4);
        SingleNode node4 = new SingleNode(3);
        SingleNode node5 = new SingleNode(2);
        SingleNode node6 = new SingleNode(1);

        node.mNextNode = node1;
        node1.mNextNode = node2;
        node2.mNextNode = node3;
        node3.mNextNode = node4;
        node4.mNextNode = node5;
//        node5.mNextNode = node6;
        return node;
    }

    public static SingleNode mockLoopLink() {
        SingleNode node = new SingleNode(1);
        SingleNode node1 = new SingleNode(2);
        SingleNode node2 = new SingleNode(3);
        SingleNode node3 = new SingleNode(4);
        SingleNode node4 = new SingleNode(3);
        SingleNode node5 = new SingleNode(2);
        SingleNode node6 = new SingleNode(1);

        node.mNextNode = node1;
        node1.mNextNode = node2;
        node2.mNextNode = node3;
        node3.mNextNode = node4;
        node4.mNextNode = node5;
        node5.mNextNode = node6;

        //链表的环
        node6.mNextNode = node3;

        return node;
    }

    public static SingleNode mockReverseLink() {
        SingleNode node = new SingleNode(1);
        SingleNode node1 = new SingleNode(2);
        SingleNode node2 = new SingleNode(3);
        SingleNode node3 = new SingleNode(4);
        SingleNode node4 = new SingleNode(5);
        SingleNode node5 = new SingleNode(6);

        node.mNextNode = node1;
        node1.mNextNode = node2;
        node2.mNextNode = node3;
        node3.mNextNode = node4;
        node4.mNextNode = node5;

        return node;
    }
}
