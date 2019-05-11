package cn.edu.nuc.ssm.entity.movie;

import cn.edu.nuc.ssm.enums.MovieShowPath;
import cn.edu.nuc.ssm.util.StringUtil;

public class Type {
    private String typeid;

    private String typename;

    private String colum1;

    private String colum2;

    private String colum3;

    private String colum4;

    private String colum5;

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid == null ? null : typeid.trim();
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public String getColum1() {
        return colum1;
    }

    public void setColum1(String colum1) {
        if(StringUtil.isNotEmpty(colum1)&&!StringUtil.isNum(colum1)){
            this.colum1 = String.valueOf(MovieShowPath.getMovieShowPathCode(colum1));
        }else {
            this.colum1 = colum1 == null ? null : colum1.trim();
        }
    }

    public String getColum2() {
        return colum2;
    }

    public void setColum2(String colum2) {
        this.colum2 = colum2 == null ? null : colum2.trim();
    }

    public String getColum3() {
        return colum3;
    }

    public void setColum3(String colum3) {
        this.colum3 = colum3 == null ? null : colum3.trim();
    }

    public String getColum4() {
        return colum4;
    }

    public void setColum4(String colum4) {
        this.colum4 = colum4 == null ? null : colum4.trim();
    }

    public String getColum5() {
        return colum5;
    }

    public void setColum5(String colum5) {
        this.colum5 = colum5 == null ? null : colum5.trim();
    }
}