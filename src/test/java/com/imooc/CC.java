package com.imooc;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import org.springframework.beans.BeanUtils;

import java.util.*;

/**
 * Created by admin on 2017/6/18.
 */
public class CC {
    public static void main(String[] args){
//        List<String> orgList = new ArrayList<String>();
//        orgList.add("test");
//        List<String> destList = new ArrayList<String>();
//        BeanUtils.copyProperties(orgList,destList);
//        System.out.print(destList.size());
//        orgList.
//        String[] a = new String[]{"a"};
//        String[] strings = Arrays.copyOf(a, a.length);
//        System.out.print(strings[0]);

//        String[] a = new String[]{"a"};
//        System.out.print(a);
//        changeArr(a);

//          List<String> orgList = new ArrayList<String>();
//         orgList.add("test");
//        List<String> destList = (Arrays.asList(new String[orgList.size()]));
//        Collections.copy(destList,orgList);


        List<String> orgList = new ArrayList<String>();
        orgList.add("test");
        List<String> destList = (Arrays.asList(new String[orgList.size()]));
        changeList(destList);
        System.out.println(orgList.get(0));
    }

    public static  void changeArr(String[] org){
        org[0] = "b";
    }

    public static  void changeList(List<String> list){
        for (int i = 0; i < list.size(); i++){
            list.set(i,"ddd");
        }
    }
}
