package com.study.springboot;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

  public static void main(String[] args) {
    ReentrantLock lock = new ReentrantLock();
    lock.tryLock();
    lock.lock();
    lock.unlock();
  }
}
