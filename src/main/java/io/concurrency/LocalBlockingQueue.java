package io.concurrency;

import java.util.ArrayList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LocalBlockingQueue<E> {
	
	E[] items;
	int capacity;
	int size;
	int head = 0;
	int tail = 0;
	
	volatile int variable = 5;
	ReentrantLock lock = new ReentrantLock();
	Condition notEmpty = lock.newCondition();
	Condition notFull  = lock.newCondition();
	
	Object producer = new Object();
	Object consumer = new Object();
	
	public LocalBlockingQueue(int capacity) {
		items = (E[])new Object[capacity];
		this.capacity = capacity;
	}
	
	public synchronized void put(E item) {
		//lock.lock();
		try {
			while(capacity >= size) {
				try {
					notFull.await();
					
					producer.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			items[tail] = item;
			tail++;
			size++;
			//notEmpty.signalAll();
			consumer.notifyAll();
		} finally {
			lock.unlock();
		}

	}
	
	public synchronized E take() {
		lock.lock();
		E item = null;
		try {
			while(size == 0) {
				try {
					notEmpty.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			item = items[head];
			head++;
			size--;
			notFull.signalAll();
		} finally {
			lock.unlock();
		}
		
		return item;		
	}

}
