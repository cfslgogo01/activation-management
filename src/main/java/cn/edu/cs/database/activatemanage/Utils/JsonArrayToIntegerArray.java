package cn.edu.cs.database.activatemanage.Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class JsonArrayToIntegerArray {

    public ArrayList<Integer> getIntegerArrayOnData(String str, String Data) {
        Map parseObject = JSON.parseObject(str, (Map.class));
        JSONArray data = (JSONArray) parseObject.get(Data);
        ArrayList<Integer> Ints = new ArrayList<Integer>();
        for (int i = 0; i < data.size(); i++) {
            Ints.add(Integer.parseInt(data.getString(i)));
        }
        return Ints;
    }

    public ArrayList<Integer> getIntegerArray(String str) {
        return this.getIntegerArrayOnData(str, "data");
    }
    public <U> ArrayList<U> getObjectArray(String str,String Data, Class<U> clazz){
        Map parseObject = JSON.parseObject(str, (Map.class));
        JSONArray data = (JSONArray) parseObject.get(Data);
        ArrayList<U> Objs = new ArrayList<U>();
        for (int i = 0; i < data.size(); i++) {
            Objs.add(
                    JSON.toJavaObject((JSON) JSON.toJSON(data.getString(i)),clazz)
            );
        }
        return Objs;
    }
    public ArrayList<Integer> getIntegerArrayOnDataByKey(String str,String Data,String Key) {
        Map parseObject = JSON.parseObject(str, (Map.class));
        JSONArray data = (JSONArray) parseObject.get(Data);
        ArrayList<Integer> Ints = new ArrayList<Integer>();
        for (int i = 0; i < data.size(); i++) {
            String string = data.getString(i);
            Map map = JSON.parseObject(string
                    , Map.class);
            Object map1 = map.get(Key);
            Ints.add(Integer.parseInt( map1.toString()));
        }
        return Ints;
    }
}
