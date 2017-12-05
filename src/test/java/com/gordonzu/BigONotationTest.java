package com.gordonzu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BigONotationTest {

    private BigONotation mBig1, mBig2, mBig3, mBig4;

    @Before
    public void setUp() throws Exception {
        mBig1 = new BigONotation(100000);
        mBig2 = new BigONotation(200000);
        mBig3 = new BigONotation(300000);
        mBig4 = new BigONotation(400000);
    }

    @After
    public void tearDown() throws Exception {
        mBig1 = null;
        mBig2 = null;
        mBig3 = null;
        mBig4 = null;
    }

    /*
    *************************************************************************************
     */

    @Test
    public void addItemToArrayTest() throws Exception {
        mBig1.addItemToArray(666);
        assertTrue(mBig1.getItemsInArray() == 100000);

        mBig4.addItemToArray(666);
        assertTrue(mBig4.getItemsInArray() == 400000);
    }

    @Test
    public void linearSearchTest() {
        assertTrue(mBig1.linearSearch(666));
        assertTrue(mBig2.linearSearch(666));
        assertTrue(mBig3.linearSearch(666));
        assertTrue(mBig4.linearSearch(666));
    }

    @Test
    public void bubbleSortTest() {
        mBig1.bubbleSort();
        mBig2.bubbleSort();
        assertTrue(true);
    }

    @Test
    public void binarySearchTest() {
        mBig1.addItemToArray(365786);
        mBig1.binarySearch(365787);

        mBig4.addItemToArray(767888);
        mBig4.binarySearch(767887);
    }


































}