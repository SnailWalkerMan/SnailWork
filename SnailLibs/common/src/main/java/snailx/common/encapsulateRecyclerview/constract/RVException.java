package snailx.common.encapsulateRecyclerview.constract;

/**
 * <des>
 *
 * @author Jir
 * @date 2018/10/11
 */
public class RVException extends RuntimeException {

    public RVException() {
    }

    public RVException(@RVExceptionRule String message) {
        super(message);
    }
}
