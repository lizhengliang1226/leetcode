package com.lzl.util;


import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 文件工具类
 *
 * @author LZL
 * @version v1.0
 * @date 2022/8/14-23:33
 */
public class FileUtils {
    private static final Scanner scanner = new Scanner(System.in);
    private static String curPath = System.getProperty("user.dir");

    public static void main(String[] args) {
        while (true) {
            System.out.println("====================文件操作工具====================");
            System.out.println("| 1. 批量移动文件\t\t2. 批量文件重命名");
            System.out.println("请输入操作类型：");
            final int i = scanner.nextInt();
            scanner.nextLine();
            choose(i);
        }
    }

    /**
     * 选择功能
     *
     * @param chos
     */
    public static void choose(int chos) {
        switch (chos) {
            case 1:
                batchMoveFiles();
                break;
            case 2:
                batchRenameFiles();
                break;
            default:
                System.out.println("没有该操作！");
                break;
        }
    }

    private static void batchRenameFiles() {
        System.out.println("请输入要重命名的文件所在目录(默认当前目录：" + curPath + ")：");
        String dir;
        dir = scanner.nextLine();
        if (isBlank(dir)) dir = curPath;

        System.out.println("请输入要重命名的文件的扩展名(默认mp4，多个以逗号分隔)：");
        String exts = scanner.nextLine();
        if (isBlank(exts)) exts = "mp4";

        final File file = new File(dir);
        if (file.isDirectory()) {
            System.out.println("重命名操作=>要重命名的文件所在目录：" + dir);
            System.out.println("重命名操作=>文件扩展名：" + exts);
            System.out.println("以上信息是否正确，确定重命名吗？(y/n)");
            String flag;
            flag = scanner.nextLine();
            while (!"y".equals(flag) && !"n".equals(flag)) {
                System.out.println("请输入正确的选择(y/n)！");
                flag = scanner.nextLine();
            }
            if (flag.equals("y")) {
                rename(file, exts);
            } else {
                System.out.println("结束重命名操作！");
                batchRenameFiles();
            }
        } else {
            System.out.println("该目录不存在或者格式错误，请重新输入！");
            batchRenameFiles();
        }
    }

    /**
     * 重命名文件
     *
     * @param file
     * @param exts
     */
    private static void rename(File file, String exts) {
        final File[] files = file.listFiles();
        assert files != null;
        label1:
        for (File f1 : files) {
            if (f1.isDirectory()) {
                rename(f1, exts);
            } else {
                final String f1Name = f1.getName();
                // 如果名字以指定后缀结尾则找到了，准备重命名
                for (String ext : Arrays.stream(exts.split(",")).distinct().collect(Collectors.toList())) {
                    String name = f1.getName();
                    String[] fileNames = name.split("\\.");
                    String fileExt = fileNames[fileNames.length-1];
                    if(fileExt.equals(ext)){
                        if (isContainChinese(f1Name)) continue label1;
                        name= name.replace("hhd800.com@", "").replace("_X1080X","");
                        System.out.println("找到：" + f1Name);
                        boolean b = f1.renameTo(new File(f1.getParent() + "\\" + name));
                        System.out.println("重命名成功！");
                        break;
                    }
                }
            }
        }
    }
    /* 判断是否包含中文 */
    public static boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        return m.find();
    }

    /**
     * 批量移动文件，扫描指定路径下的所有文件，移动所有包含给定扩展名的文件到达指定目录
     */
    private static void batchMoveFiles() {
        System.out.println("请输入要移动的文件所在目录(默认当前目录：" + curPath + ")：");
        String srcPath;
        srcPath = scanner.nextLine();
        if (isBlank(srcPath)) srcPath = curPath;
        System.out.println("请输入要移动的文件的扩展名(默认mp4,多个以逗号分隔)：");
        String exts = scanner.nextLine();
        if (isBlank(exts)) exts = "mp4";
        System.out.println("请输入要移动的目标位置((默认当前目录：" + curPath + ")：");
        String tagPath = scanner.nextLine();
        if (isBlank(tagPath)) tagPath = curPath;
        File file = new File(srcPath);
        if (file.isDirectory()) {
            warnInfo(srcPath, tagPath, exts, "批量移动");
            String flag;
            flag = scanner.nextLine();
            while (!"y".equals(flag) && !"n".equals(flag)) {
                System.out.println("请输入正确的选择（y/n）！");
                flag = scanner.nextLine();
            }
            if (flag.equals("y")) {
                move(file, exts, tagPath);
            } else {
                System.out.println("结束移动！");
                batchMoveFiles();
            }
        } else {
            System.out.println("该目录不存在或者格式错误，请重新输入！");
            batchMoveFiles();
        }
    }

    public static boolean isBlank(CharSequence str) {
        if (str != null && str.length() != 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isNotBlank(CharSequence str) {
        return !isBlank(str);
    }

    /**
     * 打印警告信息
     *
     * @param source
     * @param target
     * @param ext
     * @param opType
     */
    private static void warnInfo(String source, String target, String ext, String opType) {
        System.out.println(opType + "操作=>文件源目录：" + source);
        System.out.println(opType + "操作=>文件目标目录：" + target);
        System.out.println(opType + "操作=>文件扩展名：" + ext);
        System.out.println("以上信息是否正确，确定执行操作吗？(y/n)");
    }

    /**
     * 移动文件到指定目录
     *
     * @param file 文件
     * @param exts 扩展名
     * @param des  目标路径
     */
    private static void move(File file, String exts, String des) {
        final File[] files = file.listFiles();
        assert files != null;
        for (File f1 : files) {
            if (f1.isDirectory()) {
                move(f1, exts, des);
            } else {
                for (String ext : Arrays.stream(exts.split(",")).distinct().collect(Collectors.toList())) {
                    String name = f1.getName();
                    String[] fileNames = name.split("\\.");
                    String fileExt = fileNames[fileNames.length-1];
                    if (fileExt.equals(ext)) {
                        System.out.println("找到：" + name + "开始移动！");
                        boolean b = f1.renameTo(new File(des + "\\" + name));
                        System.out.println("移动成功！");
                        break;
                    }
                }
            }
        }
    }
}
