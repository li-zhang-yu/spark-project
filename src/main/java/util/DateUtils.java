package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期时间工具类
 */
public class DateUtils {

    public static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 判断一个时间是否在另一个时间之前
     * @param time1
     * @param time2
     * @return
     */
    public static boolean before(String time1,String time2){
        try {
            Date dateTime1 = TIME_FORMAT.parse(time1);
            Date dateTime2 =TIME_FORMAT.parse(time2);
            if (dateTime1.before(dateTime2)) {
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 判断一个时间是否在另一个时间之后
     * @param time1
     * @param time2
     * @return
     */
    public static boolean after(String time1,String time2){
        try {
            Date dateTime1 = TIME_FORMAT.parse(time1);
            Date dateTime2 =TIME_FORMAT.parse(time2);
            if (dateTime1.after(dateTime2)) {
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 计算时间差值(单位为秒)
     * @param time1
     * @param time2
     * @return
     */
    public static int minus(String time1,String time2){
        try {
            Date dateTime1 = TIME_FORMAT.parse(time1);
            Date dateTime2 =TIME_FORMAT.parse(time2);

            long millisecond = dateTime1.getTime() - dateTime2.getTime();

            return Integer.valueOf(String.valueOf(millisecond / 1000));
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 获取年月日和小时
     * @param datetime （yyyy-MM-dd HH:mm:ss）
     * @return
     */
    public static String getDateHour(String datetime){
        String date = datetime.split(" ")[0];
        String hourMinuteSecond = datetime.split(" ")[1];
        String hour = hourMinuteSecond.split(":")[0];
        return date + "_" + hour;
    }

    /**
     * 获取当天日期（yyyy-MM-dd）
     * @return
     */
    public static String getTodayDate() {
        return DATE_FORMAT.format(new Date());
    }

    /**
     * 获取昨天的日期（yyyy-MM-dd）
     * @return
     */
    public static String getYesterdayDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_YEAR, -1);

        Date date = cal.getTime();

        return DATE_FORMAT.format(date);
    }

    /**
     * 格式化日期（yyyy-MM-dd）
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        return DATE_FORMAT.format(date);
    }

    /**
     * 格式化时间（yyyy-MM-dd HH:mm:ss）
     * @param date
     * @return
     */
    public static String formatTime(Date date) {
        return TIME_FORMAT.format(date);
    }

}
