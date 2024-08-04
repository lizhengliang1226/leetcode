package com.lzl.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 手机app防沉迷
 * 2
 * App1 1 09:00 10:00
 * App2 2 11:00 11:30
 * 09:30
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/04
 */
public class T58 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        List<App> l = new ArrayList<>();
        AppManager am = new AppManager();
        for (int i = 0; i < N; i++) {
            String[] split = sc.nextLine().split(" ");
            String appName = split[0];
            int pro = Integer.parseInt(split[1]);
            String time = split[2].replace(":", "");
            String s = split[3].replace(":", "");
            am.addApp(new App(appName, pro, Integer.parseInt(time), Integer.parseInt(s)));
        }
        int t = Integer.parseInt(sc.nextLine().replace(":", ""));
        App a = am.getAppFromTime(t);
        System.out.println(a == null ? "NA" : a.name);
    }

    private static class App {
        String name;
        int pro;
        int startTime;
        int endTime;

        public App(String name, int pro, int startTime, int endTime) {
            this.name = name;
            this.pro = pro;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    private static class AppManager {
        List<App> apps = new ArrayList<>();

        public void addApp(App app) {
            if (apps == null) {
                apps = new ArrayList<>();
            }
            if (canAdd(app.startTime, app.endTime, app.pro)) {
                apps.add(app);
            }
        }

        public boolean canAdd(int startTime, int endTime, int pro) {
            boolean can = true;
            App a = null;
            List<App> removeList = new ArrayList<>();
            for (App app : apps) {
                int startTime1 = app.startTime;
                int endTime1 = app.endTime;
                if (hasConfilt(startTime, endTime, startTime1, endTime1)) {
                    int i = app.pro - pro;
                    if (i > 0) {
                        can = false;
                        break;
                    } else {
                        removeList.add(app);
//                        break;
                    }
                }

            }

            if (can) {
                apps.removeAll(removeList);
            }
            return can;
        }

        private boolean hasConfilt(int startTime, int endTime, int startTime1, int endTime1) {
            return startTime < endTime1 && startTime1 < endTime;
        }

        public App getAppFromTime(int t) {
            for (App app : apps) {
                if (app.startTime <= t && app.endTime >= t) {
                    return app;
                }
            }
            return null;
        }
    }
}
