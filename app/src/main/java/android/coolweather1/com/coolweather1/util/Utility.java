package android.coolweather1.com.coolweather1.util;

import android.coolweather1.com.coolweather1.db.City;
import android.coolweather1.com.coolweather1.db.County;
import android.coolweather1.com.coolweather1.db.Province;
import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Y.N on 2018/6/5.
 */

public class Utility {
    /**
     *解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allProvinces = new JSONArray(response);
                for (int i = 0; i < allProvinces.length(); i++) {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.getProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            }catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    /**
     * 解析和处理服务器返回的市级数据
     */

    public static boolean handleCityResponse(String response, int provinceId){
        if (!TextUtils.isEmpty(response)) {
            try{
            JSONArray allCities = new JSONArray(response);
            for (int i = 0; i < allCities.length(); i++) {
                JSONObject cityObject = allCities.getJSONObject(i);
                City city = new City();
                city.setCityName(cityObject.getString("name"));
                city.getCityCode(cityObject.getInt("id"));
                city.setProvinceId(provinceId);
                city.save();
            }
            return true;
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }
    return false;
}



/**
 *  解析和处理服务器返回的县级数据
 */

public static boolean handleCountyResponse(String response, int cityId) {
    if (!TextUtils.isEmpty(response)) {
        try {
            JSONArray allCounties = new JSONArray(response);
            for (int i = 0; i < allCounties.length(); i++) {
                JSONObject countyObject = allCounties.getJSONObject(i);
                County county = new County();
                county.setCountName(countyObject.getString("name"));
                county.setWeatherId(countyObject.getString("weather1_id"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    return false;

}
}