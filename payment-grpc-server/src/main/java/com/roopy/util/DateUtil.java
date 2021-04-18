package com.roopy.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

public class DateUtil {
    /**
     * <p>
     * 현재 연도값을 리턴
     * </p>
     * @return 년(年)
     */
    public static int getCurrentYearAsInt() {
        Calendar cd = new GregorianCalendar(Locale.KOREA);

        return cd.get(Calendar.YEAR);
    }

    /**
     * <p>
     * 현재 월을 리턴
     * </p>
     * @return 월(月)
     */
    public static int getCurrentMonthAsInt() {
        Calendar cd = new GregorianCalendar(Locale.KOREA);

        return cd.get(Calendar.MONTH) + 1;
    }

    /**
     * <p>
     * 현재 일을 리턴
     * </p>
     * @return 일(日)
     */
    public static int getCurrentDayAsInt() {
        Calendar cd = new GregorianCalendar(Locale.KOREA);

        return cd.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * <p>
     * 현재 시간을 리턴
     * </p>
     * @return 시(時)
     */
    public static int getCurrentHourAsInt() {
        Calendar cd = new GregorianCalendar(Locale.KOREA);

        return cd.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * <p>
     * 현재 분을 리턴
     * </p>
     * @return 분(分)
     */
    public static int getCurrentMinuteAsInt() {
        Calendar cd = new GregorianCalendar(Locale.KOREA);

        return cd.get(Calendar.MINUTE);
    }

    /**
     * <p>
     * 현재 초를 리턴
     * </p>
     * @return 밀리초
     */
    public static int getCurrentMilliSecondAsInt() {
        Calendar cd = new GregorianCalendar(Locale.KOREA);

        return cd.get(Calendar.MILLISECOND);
    }

    /**
     * <p>
     * 현재 년도를 YYYY 형태로 리턴
     * </p>
     * @return 년도(YYYY)
     */
    public static String getCurrentYearAsString() {
        Calendar cd = new GregorianCalendar(Locale.KOREA);

        return getFormalYear(cd);
    }

    /**
     * <P>
     * 현재 월을 MM 형태로 리턴
     * </p>
     * @return 월(MM)
     */
    public static String getCurrentMonthAsString() {
        Calendar cd = new GregorianCalendar(Locale.KOREA);

        return getFormalMonth(cd);
    }

    /**
     * <p>
     * 현재 일을 DD 형태로 리턴
     * </p>
     * @return 일(DD)
     */
    public static String getCurrentDayAsString() {
        Calendar cd = new GregorianCalendar(Locale.KOREA);

        return getFormalDay(cd);
    }

    /**
     * <p>
     * 현재 시간을 HH 형태로 리턴
     * </p>
     * @return 시간(HH)
     */
    public static String getCurrentHourAsString() {
        Calendar cd = new GregorianCalendar(Locale.KOREA);

        return getFormalHour(cd);
    }

    /**
     * <p>
     * 현재 분을 mm 형태로 리턴
     * </p>
     * @return 분(mm)
     */
    public static String getCurrentMinuteAsString() {
        Calendar cd = new GregorianCalendar(Locale.KOREA);

        return getFormalMin(cd);
    }

    /**
     * <p>
     * 현재 초를 ss 형태로 리턴
     * </p>
     * @return 초(ss)
     */
    public static String getCurrentSecondAsString() {
        Calendar cd = new GregorianCalendar(Locale.KOREA);

        return getFormalSec(cd);
    }

    /**
     * <p>
     * 현재 밀리초를 sss 형태로 리턴
     * </p>
     * @return 밀리초(sss)
     */
    public static String getCurrentMilliSecondAsString() {
        Calendar cd = new GregorianCalendar(Locale.KOREA);

        return getFormalMSec(cd);
    }

    /**
     * <p>
     * 현재 날짜를 년월일을 합쳐서 String으로 리턴하는 메소드
     * </p>
     * @return 년+월+일 값
     */
    public static String getCurrentDateAsString() {
        Calendar cd = new GregorianCalendar(Locale.KOREA);

        return getFormalYear(cd) + getFormalMonth(cd) + getFormalDay(cd);
    }

    /**
     * <p>
     * 현재 시간을 시분초를 합쳐서 String으로 리턴하는 메소드
     * </p>
     * @return 시+분+초 값
     */
    public static String getCurrentTimeAsString() {
        Calendar cd = new GregorianCalendar(Locale.KOREA);

        return getFormalHour(cd) + getFormalMin(cd) + getFormalSec(cd);
    }

    /**
     * <p>
     * 현재 날짜와 시간을 년월일시분초를 합쳐서 String으로 리턴하는 메소드
     * </p>
     * @return 년+월+일+시+분+초 값
     */
    public static String getCurrentDateTimeAsString() {
        Calendar cd = new GregorianCalendar(Locale.KOREA);

        return getFormalYear(cd) + getFormalMonth(cd) + getFormalDay(cd) + getFormalHour(cd) + getFormalMin(cd) + getFormalSec(cd);
    }

    /**
     * <p>
     * 년도 표시를 네자리로 형식화 한다.
     * </p>
     * @param cd
     *        년도를 포함하는 <strong>Calendar</strong> 오브젝트
     * @return 네자리로 형식화된 년도
     */
    private static String getFormalYear(Calendar cd) {
        return StringUtils.leftPad(Integer.toString(cd.get(Calendar.YEAR)), 4, '0');
    }

    /**
     * <p>
     * 월(Month) 표시를 두자리로 형식화 한다.
     * </p>
     * @param cd
     *        월을 포함하는 <strong>Calendar</strong> 오브젝트
     * @return 두자리로 형식화된 월
     */
    private static String getFormalMonth(Calendar cd) {
        return StringUtils.leftPad(Integer.toString(cd.get(Calendar.MONTH) + 1), 2, '0');
    }

    /**
     * <p>
     * 일(Day) 표시를 두자리로 형식화 한다.
     * </p>
     * @param cd
     *        일자를 포함하는 <strong>Calendar</strong> 오브젝트
     * @return 두자리로 형식화된 일
     */
    private static String getFormalDay(Calendar cd) {
        return StringUtils.leftPad(Integer.toString(cd.get(Calendar.DAY_OF_MONTH)), 2, '0');
    }

    /**
     * <p>
     * 시간(Hour) 표시를 두자리로 형식화 한다.
     * </p>
     * @param cd
     *        시간을 포함하는 <strong>Calendar</strong> 오브젝트
     * @return 두자리로 형식화된 시간
     */
    private static String getFormalHour(Calendar cd) {
        return StringUtils.leftPad(Integer.toString(cd.get(Calendar.HOUR_OF_DAY)), 2, '0');

    }

    /**
     * <p>
     * 분(Minute) 표시를 두자리로 형식화 한다.
     * </p>
     * @param cd
     *        분을 포함하는 <strong>Calendar</strong> 오브젝트
     * @return 두자리로 형식화된 분
     */
    private static String getFormalMin(Calendar cd) {
        return StringUtils.leftPad(Integer.toString(cd.get(Calendar.MINUTE)), 2, '0');

    }

    /**
     * <p>
     * 초(sec) 표시를 두자리로 형식화 한다.
     * </p>
     * @param cd
     *        초를 포함하는 <strong>Calendar</strong> 오브젝트
     * @return 두자리로 형식화된 초
     */
    private static String getFormalSec(Calendar cd) {
        return StringUtils.leftPad(Integer.toString(cd.get(Calendar.SECOND)), 2, '0');

    }

    /**
     * <p>
     * 밀리초(millisec) 표시를 세자리로 형식화 한다.
     * </p>
     * @param cd
     *        밀리초를 포함하는 <strong>Calendar</strong> 오브젝트
     * @return 세자리로 형식화된 밀리초
     */
    private static String getFormalMSec(Calendar cd) {
        return StringUtils.leftPad(Integer.toString(cd.get(Calendar.MILLISECOND)), 3, '0');
    }

    /**
     * <p>
     * Date -> String
     * </p>
     * @param date 변환할 날짜
     * @return String The Date string. Type, yyyyMMdd HH:mm:ss.
     */
    public static String toString(Date date, String format, Locale locale) {

        if (StringUtils.isEmpty(format)) {
            format = "yyyy-MM-dd HH:mm:ss";
        }

        if (null == locale || locale.equals(null)) {
            locale = java.util.Locale.KOREA;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format, locale);

        String tmp = sdf.format(date);

        return tmp;
    }

    /**
     * <p>
     * 해당 문자열이 주어진 일자 형식을 준수하는지 여부를 검사한다.
     * </p>
     * @param source
     *        검사할 대상 문자열
     * @param format
     *        Date 형식의 표현. 예) "yyyy-MM-dd".
     * @return 형식에 합당하는 경우 Date 객체를 리턴한다.
     * @throws ParseException
     *         형식이 잘못 되었거나 존재하지 않는 날짜인 경우 발생함
     */
    public static boolean dateFormatCheck(String source, String format) throws ParseException {

        boolean isValidDate = false;

        if (source == null) {
            throw new ParseException("날짜 정보가 없습니다.", 0);
        }

        if (format == null) {
            throw new ParseException("유효성 체크 형식 정보가 없습니다.", 0);
        }

        SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.KOREA);

        Date date = null;

        try {
            date = formatter.parse(source);
            isValidDate = true;
        } catch (ParseException e) {
            throw e;
        }

        if (!formatter.format(date).equals(source)) {
            isValidDate = false;
        }

        return isValidDate;
    }

    /**
     * <p>
     * 해당 문자열이 주어진 일자 형식을 Timestamp 형식으로 변경 처리한다.
     * </p>
     * @param source
     * @param format
     * @return
     * @throws ParseException
     */
    public static Timestamp convertStringToTimeStamp(String source, String format) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.KOREA);

        Date date = formatter.parse(source);

        return new Timestamp(date.getTime());
    }

    /**
     * <p>
     * 해당 문자열이 주어진 일자 형식을 Date 형식으로 변경 처리한다.
     * </p>
     * @param source
     * @param format
     * @return
     * @throws ParseException
     */
    public static Date convertStringToDate(String source, String format) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.KOREA);

        Date date = formatter.parse(source);

        return date;
    }

    /**
     * 현재날짜 기준으로 입력받은 일자 전 날짜 계산
     *
     * @param format 날짜형식
     * @param day 일
     * @return 현재날짜 기준 입력받은 일 전의 날짜
     * @throws ParseException
     */
    public static String getDateAsStringBeforeDay(String format, int day) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, day);

        String  thisDayMiner = cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE);

        SimpleDateFormat sdfmt = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdfmt.parse(thisDayMiner);
        thisDayMiner = new java.text.SimpleDateFormat (format).format(date);

        return thisDayMiner;
    }

    /**
     * 두날짜 비교
     *
     * @param format 날짜형식
     * @param startDt 시작일자
     * @param endDt 종료일자
     * @return boolean
     * @throws ParseException
     */
    public static boolean compareDate(String format, String strtDt, String endDt) throws ParseException {
        boolean result = true;

        SimpleDateFormat strDtFmt = new SimpleDateFormat(format, Locale.KOREA);
        SimpleDateFormat endDtFmt = new SimpleDateFormat(format, Locale.KOREA);

        Date d1 = strDtFmt.parse(strtDt);
        Date d2 = endDtFmt.parse(endDt);

        if (d1.after(d2)) {
            result = false;
        }

        return result;
    }

    /**
     * 해당월의 마지막 날짜를 구한다.
     *
     * @param date 날짜형식
     * @return Date 해당월의 마지막 날짜
     */
    public static Date getLastDateOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);

        return cal.getTime();
    }

    /**
     * 해당주의 첫번째 날짜를 구한다.
     *
     * @param date 날짜형식
     * @return Date 해당월의 첫번째 날짜
     */
    public static Date getFirstDateOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, (dayOfWeek-1)*-1);

        return cal.getTime();
    }

    /**
     * 해당월의 마지막 날짜를 구한다.
     *
     * @param date 날짜형식
     * @return Date 해당월의 마지막 날짜
     */
    public static Date getLastDateOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, 7-dayOfWeek);

        return cal.getTime();
    }
}