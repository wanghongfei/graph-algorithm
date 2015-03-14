package cn.fh.ds.tree.test;

import cn.fh.ds.tree.BinarySearchTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by wanghongfei on 15-3-14.
 */
public class BinarySearchTreeTest {
    private BinarySearchTree bst;

    @Before
    public void initData() {
        bst = new BinarySearchTree<Integer>();

        Integer[] nums = new Integer[]{-1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, -100};
        for (Integer num : nums) {
            bst.put(num);
        }
    }

    @Test
    public void testPutAndGet() {

        boolean contains = bst.contains(0);
        Assert.assertTrue(contains);
        contains = bst.contains(1);
        Assert.assertTrue(contains);
        contains = bst.contains(2);
        Assert.assertTrue(contains);
        contains = bst.contains(3);
        Assert.assertTrue(contains);
        contains = bst.contains(4);
        Assert.assertTrue(contains);
        contains = bst.contains(5);
        Assert.assertTrue(contains);
        contains = bst.contains(6);
        Assert.assertTrue(contains);
        contains = bst.contains(7);
        Assert.assertTrue(contains);
        contains = bst.contains(8);
        Assert.assertTrue(contains);
        contains = bst.contains(9);
        Assert.assertTrue(contains);


        contains = bst.contains(10);
        Assert.assertFalse(contains);
    }

    @Test
    public void testGetMinAndMax() {
        /*Comparable min = bst.getMin();
        Assert.assertEquals(9, min.intValue());*/
    }
}
