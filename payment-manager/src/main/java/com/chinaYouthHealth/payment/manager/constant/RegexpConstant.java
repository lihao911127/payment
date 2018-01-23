package com.chinaYouthHealth.payment.manager.constant;

public class RegexpConstant {
    /**
     * 18位身份证|15位身份证
     */
    //public static final String IDCRAD_PATTERN = "(^(\\d{17})(\\d|[xX])$)?";
//	public static final String IDCRAD_PATTERN = "^(^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$)|(^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])((\\d{4})|\\d{3}[X])$)$";
	public static final String IDCRAD_PATTERN = "^(\\d{15}|\\d{17}[\\dX])$";

    /**
     * 邮箱
     */
    public static final String EMAIL_PATTERN = "^(\\w)+(\\.\\w+)*@gomeholdings\\.com$";

    /**
     * 手机号
     */
    public static final String MOBILE_PATTERN = "^(1[3|4|5|7|8])[0-9]{9}$";
    /**
     * 密码（包含数字和字母）
     */
    public static final String CHECKPASSWORD_PATTERN = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,20}$";

    /**
     * 密码（包含数字、字母和任意特殊字符两种及以上）
     */
    public static final String CHECKPASSWORD_PATTERN2 = "^(?![A-z]+$)(?!\\d+$)(?![\\W]+$)\\S{8,20}$";

    /**
     * 密码（包含数字、字母和（~!@#$%^&*()_~！@#￥%……&*（）——）中的特殊字符中的两种及以上）
     */
    public static final String CHECKPASSWORD_PATTERN3 = "^(?![A-Z]+$)(?![a-z]+$)(?!\\d+$)(?![~!@#$%^&*()_~！@#￥%……&*（）——]+$)[A-z\\d~!@#$%^&*()_~！@#￥%……&*（）——]{8,20}$";

    /**
     * 密码（包含数字、字母和（~!@#$%^&*()_~！@#￥%……&*（）——）中的特殊字符三种以上)
     */
    public static final String CHECKPASSWORD_PATTERN4 = "(?=.*[A-z])(?=.*\\d)(?=.*[~!@#$%^&*()_~！@#￥%……&*（）——])[A-z\\d~!@#$%^&*()_~！@#￥%……&*（）——]{8,20}$";


    //public static final String PASSWORD_PATTERN5 = "^(?![0-9]+$)(?![A-z]+$)(?![^A-z0-9]+$)^.{8,20}$";

    /**
     * 不能含有特殊字符
     */
    public static final String NAME_PATTERN = "^([a-zA-Z0-9\u4e00-\u9fa5()\\-（）——]*)$";

    /**
     * 两位小数的正数，必须大于0
     */
    public static final String NUMBER_PATTERN = "^([1-9]+(\\.[0-9]{2})?|0\\.[1-9][0-9]|0\\.0[1-9])$";

    public static void main(String[] args) {
        String str = "#112a11sqazxswedcfrrr";//长的情况
        String str1 = "#112a";//短的情况
        String str2 = "#12212111";//字符和数字的情况
        String str3 = "#qazwsxeda";//字符和字母的情况
        String str41 = "1112s12a";//字母和数字的情况1
        String str42 = "1112s12A";//字母和数字的情况2
        String str5 = "1112s12A#";//字母和数字和字符的情况1
        String str61 = "1112s12#";//字母和数字和字符的情况2
        String str62 = "1112A12#";//字母和数字和字符的情况4
        String str7 = "1112#121";//字母和数字和字符的情况3
        String str81 = "Assssqwxwd";//字母的情况1
        String str82 = "assssqwxwd";//字母的情况1
        String str83 = "ASDDWEECFER";//字母的情况1
        String str9 = "1112222121";//数字的情况
        String str10 = "#@######";//字符的情况
        System.out.println(str.matches(CHECKPASSWORD_PATTERN3));
        System.out.println(str1.matches(CHECKPASSWORD_PATTERN3));
        System.out.println(str2.matches(CHECKPASSWORD_PATTERN3));
        System.out.println(str3.matches(CHECKPASSWORD_PATTERN3));
        System.out.println(str41.matches(CHECKPASSWORD_PATTERN3));
        System.out.println(str42.matches(CHECKPASSWORD_PATTERN3));
        System.out.println(str5.matches(CHECKPASSWORD_PATTERN3));
        System.out.println(str61.matches(CHECKPASSWORD_PATTERN3) + "--====");
        System.out.println(str62.matches(CHECKPASSWORD_PATTERN3) + "--====");
        System.out.println(str7.matches(CHECKPASSWORD_PATTERN3));
        System.out.println(str7.matches(CHECKPASSWORD_PATTERN2));

        System.out.println(str81.matches(CHECKPASSWORD_PATTERN3) + "---");
        System.out.println(str82.matches(CHECKPASSWORD_PATTERN3));
        System.out.println(str83.matches(CHECKPASSWORD_PATTERN3));
        System.out.println(str9.matches(CHECKPASSWORD_PATTERN3));
        System.out.println(str10.matches(CHECKPASSWORD_PATTERN3));

        System.out.println("==========NUMBER_PATTERN==========");
        String n1 = "0";
        String n2 = "0.0";
        String n3 = "0.00";
        String n4 = "0.01";
        String n5 = "l.343";
        System.out.println(n1 + "：" + n1.matches(NUMBER_PATTERN));
        System.out.println(n2 + "：" + n2.matches(NUMBER_PATTERN));
        System.out.println(n3 + "：" + n3.matches(NUMBER_PATTERN));
        System.out.println(n4 + "：" + n4.matches(NUMBER_PATTERN));
        System.out.println(n5 + "：" + n5.matches(NUMBER_PATTERN));


    }
}
