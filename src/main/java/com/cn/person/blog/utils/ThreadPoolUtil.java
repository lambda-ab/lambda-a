package com.cn.person.blog.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class ThreadPoolUtil {

    /**
     * 电小二开卡接口  活体审核接口  线程数量
     */
    public static final ExecutorService OPEN_CARD_POOLS = Executors.newFixedThreadPool(10);
    public static final ExecutorService TEST_POOLS = Executors.newFixedThreadPool(10);

    public static final ExecutorService DEX_ORDER_RE_PUSH = Executors.newFixedThreadPool(5);

    /**
     * 多线程执行 并且把结果集 装入 futureList
     *
     * @param executorService 线程池
     * @param callable        线程执行类
     * @param futureList      结果集
     */
    public static void doThread(ExecutorService executorService, Callable callable, List<Future<Object>> futureList) {
        futureList.add(executorService.submit(callable));
    }

    /**
     * 多线程执行
     *
     * @param executorService 线程池
     * @param callable        线程执行类
     */
    public static void doThread(ExecutorService executorService, Callable callable) {
        executorService.submit(callable);
    }

    /**
     * 获取线程执行结果 futureList
     *
     * @param futureList 结果集
     * @return
     */
    public static List<Object> getFutureResult(List<Future<Object>> futureList) {
        List<Object> result = new ArrayList<>();
        for (Future<Object> future : futureList) {
            try {
                while (true) {
                    if (future.isDone() && !future.isCancelled()) {
                        result.add(future.get());
                        break;
                    } else {
                        Thread.sleep(1000);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                log.error("{}", e);
            }
        }
        return result;
    }

}
