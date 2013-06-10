package util.btree;

import util.Costable;

/**
 * Created with IntelliJ IDEA.
 * User: joshrendek
 * Date: 6/9/13
 * Time: 7:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class TreeObject<T extends Costable> {

    private int cost;

    public TreeObject(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
