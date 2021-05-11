package com.project.utils;

public class PageUtils {

    public static int getAllPage(int allProduct, int unit) {
        int allPage = 0;
        // 페이지 수 계산
        if (allProduct % unit == 0) {
            allPage = allProduct / unit;
        } else {
            allPage = allProduct / unit + 1;
        }
        return allPage;
    }

}