package service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WildcardConfig{
    private Map<String, Set<String>> data;

    public WildcardConfig(){
        data = new HashMap<>();
    }

    public void insert(String key, String value){
        data.computeIfAbsent(key, k -> new HashSet<>()).add(value);
    }

    public boolean isMatch(Map<String, String> query){
        for(Map.Entry<String, String> entry : query.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();

            if(data.containsKey(key)){
                Set<String> possibleValues = data.get(key);
                if(!possibleValues.contains(value) && !possibleValues.contains("*")){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
