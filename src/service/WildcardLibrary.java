package service;

import java.util.List;
import java.util.Map;

public class WildcardLibrary{
    private WildcardConfig wildcardConfig;

    public WildcardLibrary(){
        wildcardConfig = new WildcardConfig();
    }

    public void setConfig(List<Map<String, String>> configList){
        for(Map<String, String> config : configList){
            for(Map.Entry<String, String> entry : config.entrySet()){
                wildcardConfig.insert(entry.getKey(), entry.getValue());
            }
        }
    }

    public boolean isMatch(Map<String, String> query){
        return wildcardConfig.isMatch(query);
    }
}
