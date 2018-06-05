package android.coolweather1.com.coolweather1.db;

import org.litepal.crud.DataSupport;

/**
 * Created by Y.N on 2018/6/4.
 */

public class Province extends DataSupport {

    private int id;
    private String provinceName;
    private int provinceCode;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getProvinceName(){
        return provinceName;
    }

    public void setProvinceName(String provinceName){
        this.provinceName = provinceName;
    }

    public int getProvinceCode(int id){
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode){
        this.provinceCode = provinceCode;
    }


    public int getProvinceCode() {
        return 0;
    }
}
