package com.service;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapDemoService {
    Map<String,Integer> map = new LinkedHashMap<>();

    {
        map.put("Revanth", 36);
        map.put("Chenna",38);
        map.put("Varsha", 22);
    }

    public boolean validateUser(String name, int id) {
        //checl if name key is present in map
        if(map.containsKey(name)){
            //fetch the id on the basis of name
           int passedId =  map.get(name);
           if(passedId == id) return true;
        }
        return false;
    }
}
