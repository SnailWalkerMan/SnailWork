package snailx.javalibs.dataStruct.link;

/**
 * <des>
 *
 * @author YangGang
 * @date 2019/1/18
 */
public class LinkADT {

    public static void main(String[] args) {
//        judgeLoop();
//        findMiddle();
        reverse();
    }

    public static void printLink(SingleNode node) {
        if (node == null) {
            return;
        }
        while (node != null) {
            System.out.print(node.t+" - ");
            node = node.mNextNode;
        }
    }

    private static void reverse() {
        SingleNode before = LinkMock.mockReverseLink();
        printLink(before);
        System.out.println();
        SingleNode singleNode = SingleNodeUtils.reverseV1(LinkMock.mockReverseLink());
        printLink(singleNode);
    }

    public static void judgeLoop() {
        System.out.println(SingleNodeUtils.isLoopV2(LinkMock.mockLoopLink(), 0));
        System.out.println(SingleNodeUtils.isLoopV1(LinkMock.mockNormalLink()));
    }

    private static void findMiddle() {
        SingleNode middleNode = SingleNodeUtils.findMiddle(LinkMock.mockNormalLink());
        System.out.print("Middle Link node is ");
        while (middleNode != null) {
            System.out.print(middleNode.t + " - ");
            middleNode = middleNode.mNextNode;
        }
    }
}
