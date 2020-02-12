package com.yws.plane.util;

import com.yws.plane.entity.Company;
import com.yws.plane.entity.Message;
import com.yws.plane.entity.News;
import com.yws.plane.entity.Plane;

import java.util.ArrayList;
import java.util.List;

public class TypeUtil<T> {
    public static List<Integer> companyIds(List<Company> companies) {
        List<Integer> ids = new ArrayList<>();
        for (Company company : companies) {
           ids.add(company.getCid());
        }
        return ids;
    }

    public static List<Integer> newsIds(List<News> news) {
        List<Integer> ids = new ArrayList<>();
        for (News news1 : news) {
            ids.add(news1.getId());
        }
        return ids;
    }

    public static List<Integer> planeIds(List<Plane> planes) {
        List<Integer> ids = new ArrayList<>();
        for (Plane plane : planes) {
            ids.add(plane.getId());
        }
        return ids;
    }

    public static List<Long> messageIds(List<Message> messages) {
        List<Long> ids = new ArrayList<>();
        for (Message message : messages) {
            ids.add(message.getId());
        }
        return ids;
    }
}

