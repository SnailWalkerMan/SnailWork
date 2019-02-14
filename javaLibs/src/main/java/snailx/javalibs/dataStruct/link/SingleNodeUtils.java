package snailx.javalibs.dataStruct.link;

import java.util.HashMap;

/**
 * <des>
 *
 * @author YangGang
 * @date 2019/1/18
 */
public class SingleNodeUtils {

    public static boolean isLoopV1(SingleNode head) {
        if (head == null) return false;
        SingleNode slow = head;
        SingleNode fast = head.mNextNode;

        while (fast != null && fast.mNextNode != null) {
            slow = slow.mNextNode;
            fast = fast.mNextNode.mNextNode;

            if (fast == null) {
                return false;
            } else if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    private static HashMap<SingleNode, Integer> mNodeTracks = new HashMap<>();

    public static boolean isLoopV2(SingleNode head, int index) {
        if (head == null || head.mNextNode == null) return false;

        if (mNodeTracks.containsKey(head)) {
            System.out.println("node loop start at " + mNodeTracks.get(head));
            return true;
        } else {
            mNodeTracks.put(head, index);
            return isLoopV2(head.mNextNode, ++index);
        }
    }

    public static SingleNode findMiddle(SingleNode headNode) {
        if (headNode == null || headNode.mNextNode == null) return headNode;
        SingleNode slow = headNode;
        SingleNode fast = headNode.mNextNode;

        while (fast != null && fast.mNextNode != null) {
            slow = slow.mNextNode;
            fast = fast.mNextNode.mNextNode;
        }

        //出现偶数个 or 奇数个中点情况
        if (fast != null) {
            slow.mNextNode.mNextNode = null;
        } else {
            slow.mNextNode = null;
        }

        return slow;
    }

    public static SingleNode reverseV1(SingleNode headNode) {
        if (headNode == null || headNode.mNextNode == null) {
            return headNode;
        } else {
            SingleNode newNode = reverseV1(headNode.mNextNode);
            headNode.mNextNode.mNextNode = headNode;
            headNode.mNextNode = null;
            return newNode;
        }
    }
}
