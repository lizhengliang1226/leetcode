package com.lzl.util;


import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 文件工具类
 *
 * @author LZL
 * @version v1.0
 * @date 2022/8/14-23:33
 */
public class FileUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("=====文件操作类=====");
            System.out.println("| 1. 批量移动文件  2. 批量文件重命名");
            System.out.println("请输入操作类型：");
            final int i = scanner.nextInt();
            scanner.nextLine();
            choose(i);
        }

    }

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
        System.out.println("请输入要重命名的文件所在目录(默认当前目录：" + System.getProperty("user.dir") + ")：");
        String dir = "";
        dir = scanner.nextLine();
        if (dir == null || dir.length() == 0) dir = System.getProperty("user.dir");

        System.out.println("请输入要重命名的文件的扩展名(默认mp4)：");
        String ext = scanner.nextLine();
        if (ext == null || ext.length() == 0) ext = "mp4";

        final File file = new File(dir);
        if (file.isDirectory()) {
            System.out.println("要重命名的文件所在目录：" + dir);
            System.out.println("文件重命名扩展名：" + ext);
            System.out.println("以上信息是否正确，确定移动吗？(y/n)");
            String flag = "";
            flag = scanner.nextLine();
            while (!"y".equals(flag) && !"n".equals(flag)) {
                System.out.println("请输入正确的选择！");
                flag = scanner.nextLine();
            }
            if (flag.equals("y")) {
                dfsRename(file, ext);
            } else {
                batchRenameFiles();
            }
        } else {
            System.out.println("该目录不存在或者格式错误，请重新输入！");
            batchRenameFiles();
        }
    }

    private static void dfsRename(File file, String ext) {
        final File[] files = file.listFiles();
        assert files != null;
        for (File f1 : files) {
            if (f1.isDirectory()) {
                dfsRename(f1, ext);
            } else {
                final String f1Name = f1.getName();
                // 如果名字以指定后缀结尾则找到了，准备重命名
                if (f1Name.endsWith(ext)) {
                    // 如果名字是Gxxxx.MP4则直接跳过
                    if (f1Name.startsWith("G") && f1Name.length() == 9) continue;
                    if (f1Name.startsWith("JD") && f1Name.length() == 9) continue;
                    if (isContainChinese(f1Name)) continue;
                    System.out.println("找到：" + f1Name);
//                    renameToStand(f1, f1Name);
                    System.out.println("重命名成功！");
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
     * 重命名到标准类型
     */
    private static void renameToStand(File f1, String f1Name) {
        // 先以-分割
        String[] fa = f1Name.split("-");
        // 拿到第一个元素的尾部索引
        int i = fa[0].length() - 1;
        // 遇到@ 数字 ]
        // 取字符
        char c = fa[0].charAt(i);
        // 倒序遍历，如果字符不是数字，不是@不是]就一直遍历，直到遇到
        while (!Character.isDigit(c) && c != '@' && c != ']') {
            i--;
            // 遍历到头部了也直接结束
            if (i == -1) break;
            c = fa[0].charAt(i);
        }
        // 找到了应该重命名的起始位置，切割字符串拿到命名后的名字
        fa[0] = fa[0].substring(i + 1);
        StringJoiner sj = new StringJoiner("-");
        // 适用sj把命名后的名字用-连接起来
        Arrays.stream(fa).forEach(sj::add);
        // 将文件用新名字重命名
        final boolean b = f1.renameTo(new File(f1.getParent() + "\\" + sj));
    }

    private static void batchMoveFiles() {
        System.out.println("请输入要移动的文件所在目录(默认当前目录：" + System.getProperty("user.dir") + ")：");
        String dir = "";
        dir = scanner.nextLine();
        if (dir == null || dir.length() == 0) dir = System.getProperty("user.dir");

        System.out.println("请输入要移动的文件的扩展名(默认mp4)：");
        String ext = scanner.nextLine();
        if (ext == null || ext.length() == 0) ext = "mp4";

        System.out.println("请输入要移动的位置((默认当前目录：" + System.getProperty("user.dir") + ")：");
        String dir2 = scanner.nextLine();
        if (dir2 == null || dir2.length() == 0) dir2 = System.getProperty("user.dir");

        final File file = new File(dir);
        if (file.isDirectory()) {
            warnInfo(dir,dir2,ext,"移动");
            String flag = "";
            flag = scanner.nextLine();
            while (!"y".equals(flag) && !"n".equals(flag)) {
                System.out.println("请输入正确的选择！");
                flag = scanner.nextLine();
            }
            if (flag.equals("y")) {
                dfs(file, ext, dir2);
            } else {
                batchMoveFiles();
            }
        } else {
            System.out.println("该目录不存在或者格式错误，请重新输入！");
            batchMoveFiles();
        }
    }

    private static void warnInfo(String source, String target, String ext, String opType) {
        System.out.println(opType + "操作文件源目录：" + source);
        System.out.println(opType + "操作文件目标目录：" + target);
        System.out.println(opType + "操作文件扩展名：" + ext);
        System.out.println("以上信息是否正确，确定执行操作吗？(y/n)");
    }

    private static void dfs(File file, String ext, String des) {
        final File[] files = file.listFiles();
        assert files != null;
        for (File f1 : files) {
            if (f1.isDirectory()) {
                dfs(f1, ext, des);
            } else {
                if (f1.getName().endsWith(ext)) {
                    System.out.println("找到：" + f1.getName());
                    final boolean b = f1.renameTo(new File(des + "\\" + f1.getName()));
                    System.out.println("移动成功！");
                }
            }
        }
    }
}
