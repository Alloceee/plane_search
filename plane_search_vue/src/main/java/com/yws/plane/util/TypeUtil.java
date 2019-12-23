package com.yws.plane.util;

import com.yws.plane.entity.Company;

import java.util.ArrayList;
import java.util.List;

public class TypeUtil<T> {
    public static List<Integer> companyIds(List<Company> companies) {
        List<Integer> ids = new ArrayList<>();
        for (Company company : companies) {
           ids.add(company.getId());
        }
        System.out.println(ids);
        return ids;
    }
}

