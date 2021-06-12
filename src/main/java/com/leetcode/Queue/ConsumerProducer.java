package com.leetcode.Queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA
 * Project:
 * Author: jingren
 * Date: 2021/3/28
 */
public class ConsumerProducer {

    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingQueue();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        new Thread(producer).start();
        new Thread(consumer).start();
    }

    static class Producer implements Runnable {

        private BlockingQueue queue;

        public Producer(BlockingQueue queue) {
            this.queue = queue;
        }


        @Override
        public void run() {

            for (int i = 0; i < 20; i++) {
                System.out.println("生产第" + i + "条数据");
                try {
                    queue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }

    static class Consumer implements Runnable {

        private BlockingQueue queue;

        private volatile int i = 0;

        public Consumer(BlockingQueue queue) {
            this.queue = queue;
        }


        @Override
        public void run() {
            while (true) {

                try {
                    queue.take();
                    System.out.println("消费第" + i++ + "条数据数据");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
