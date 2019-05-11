package cn.edu.nuc.ssm.enums;

public enum MovieShowPath {
    后台电影类型(0,"后台电影类型"),
    首页大框轮播图(11,"首页大框轮播图"),
    首页中框轮播图(12,"首页中框轮播图"),
    首页中框轮播小图(121,"首页中框轮播小图"),
    首页正在热播(13,"首页正在热播"),
    首页小框轮播图(14,"首页小框轮播图"),

    电影详细信息页图(21,"电影详细信息页图"),
    电影详细信息页左侧轮播图(22,"电影详细信息页左侧轮播图"),

    电影订单页图(31,"电影订单页图"),
    电影订单页左侧轮播图(32,"电影订单页左侧轮播图"),

    尾部(9,"尾部")
    ;
    private int code;
    private String value;
    MovieShowPath(int code, String value){
        this.code = code;
        this.value = value;
    }
    public static int getMovieShowPathCode(String name){
        return MovieShowPath.valueOf(name).code;
    }
    public static String getMovieShowPathValue(int code){
        String vlu = "";
        for(MovieShowPath movieShowPath : MovieShowPath.values()){
            if(movieShowPath.code==code){
                vlu = movieShowPath.value;
                break;
            }
        }
        return vlu;
    }
}
