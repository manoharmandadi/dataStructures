package com.manosoft.datastructures.linear;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class QueueTest {

    private Queue queue;
    
    @Test
    public void testEmpty() {
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
    }

    @Test
    public void testFull() {
        fillQueue();
        assertTrue(queue.isFull());
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testRemove() {
        fillQueue();
        assertTrue(queue.isFull());
        for(int val = 1; val < 9; val++) {
            assertEquals(val, queue.remove());
        }
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testInsertRemove() {
        assertTrue(queue.isEmpty());
        queue.insert(10);
        assertEquals(10, queue.remove());
    }

    @Before
    public void setUp() {
        queue = new Queue(8);
    }

    @After
    public void tearDown() {
        queue = null;
    }
    
    private void fillQueue() {
        for(int val = 1; val <11; val++) {
            queue.insert(val);
        }
    }
}
