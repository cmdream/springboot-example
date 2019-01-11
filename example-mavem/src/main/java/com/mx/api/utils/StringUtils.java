package com.mx.api.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

/**
 * 字符串处理工具类
 * 
 * @author ljp
 * @date 2014年12月4日
 */
public class StringUtils {
	// 初始化零字符数组
	private static final char[] zeroArray = "0000000000000000000000000000000000000000000000000000000000000000"
			.toCharArray();
	 private static final char[] spaceArray = "                                                                ".toCharArray();
	/**
	 * 将日期转化为完整字符串格式 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return String
	 * @date 2014年12月4日
	 */
	public static String dateToLongString(Date date) {
		return dateToString(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 将日期转化为中文字符串 yyyy年MM月dd日
	 * 
	 * @param date
	 * @return String
	 * @date 2014年12月4日
	 */
	public static String dateToSimpleZhString(Date date) {
		return dateToString(date, "yyyy年MM月dd日");
	}

	/**
	 * 将日期转化为简单字符串 yyyy-MM-dd
	 * 
	 * @param date
	 * @return String
	 * @date 2014年12月4日
	 */
	public static String dateToSimpleString(Date date) {
		return dateToString(date, "yyyy-MM-dd");
	}

	/**
	 * 将日期字转化为指定格式的字符串
	 * 
	 * @param date
	 * @param format
	 * @return String
	 * @date 2014年12月4日
	 */
	public static String dateToString(Date date, String format) {
		if (date == null || format == null || "".equals(format)) {
			return "";
		}
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}

	/**
	 * 将简单的日期yyyy-MM-dd字符串转化为日期类型
	 * 
	 * @param value
	 * @return Date
	 * @date 2014年12月4日
	 */
	public static final Date simpleStringToDate(String value) {
		return stringToDate(value, "yyyy-MM-dd");
	}

	/**
	 * 将完整格式yyyy-MM-dd HH:mm:ss的日期字符串转化为日期类型
	 * 
	 * @param value
	 * @return Date
	 * @date 2014年12月4日
	 */
	public static final Date longStringToDate(String value) {
		return stringToDate(value, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 将指定格式的日期字符串转化为日期类型
	 * 
	 * @param value
	 * @param format
	 *            指定的日期格式
	 * @return Date
	 * @date 2014年12月4日
	 */
	public static final Date stringToDate(String value, String format) {
		if (value == null || value.length() == 0 || "".equals(format.trim())) {
			return null;
		}
		SimpleDateFormat df = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = df.parse(value);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	 /**
     * 将BigDecimal格式化为字符串，并去掉其中的","
     * @param value
     * @return String
     */
    public static final String formatBigDecimal(BigDecimal value) {
		DecimalFormat format = new DecimalFormat();
		format.applyPattern("#,##0.00");
		return format.format(value).replaceAll(",", "");
    }

	/**
	 * 将Number类型格式化为字符串，格式为format
	 * 
	 * @param value
	 * @param format
	 * @return String
	 * @date 2014年12月4日
	 */
	public static final String formatBigDecimal(Number value, String format) {
		DecimalFormat df = new DecimalFormat();
		df.applyPattern(format);
		return df.format(value);
	}

	/**
	 * 得到指定日期年份
	 * 
	 * @param date
	 *            指定日期
	 * @return 返回年份字符串 格式 yyyy
	 * @date 2014年12月4日
	 */
	public static final String getStringYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return String.valueOf(calendar.get(Calendar.YEAR));
	}

	/**
	 * 得到指定日期月份,从01开始
	 * 
	 * @param date
	 *            指定日期
	 * @return 返回月份字符串 格式 MM
	 * @date 2014年12月4日
	 */
	public static final String getStringMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int month = calendar.get(Calendar.MONTH);
		return zeroPadString(String.valueOf(month + 1), 2);
	}

	/**
	 * 得到指定日期天数
	 * 
	 * @param date
	 *            指定日期
	 * @return 返回天数字符串 格式 dd
	 * @date 2014年12月4日
	 */
	public static final String getStringDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		return zeroPadString(String.valueOf(day), 2);
	}

	/**
	 * 得到指定日期推后（或推前）n年的年月
	 * 
	 * @param date
	 *            指定日期
	 * @param some
	 *            推后年数,负数为推前
	 * @return 返回年月字符串 格式 yyyy-MM
	 * @date 2014年12月4日
	 */
	public static final String getSomeNextYear(Date date, int some) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, some);
		return dateToString(calendar.getTime(), "yyyy-MM");
	}

	/**
	 * 得到指定日期推后（或推前）n月的年月
	 * 
	 * @param date
	 *            指定日期
	 * @param some
	 *            推后月数,负数为推前
	 * @return 返回年月字符串 格式 yyyy-MM
	 * @date 2014年12月4日
	 */
	public static final String getSomeNextMonth(Date date, int some) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, some);
		return dateToString(calendar.getTime(), "yyyy-MM");
	}

	/**
	 * 得到指定日期推后（或推前）n天的日期
	 * 
	 * @param date
	 *            指定日期
	 * @param some
	 *            推后天数,负数为推前
	 * @return 返回日期字符串 格式 yyyy-MM-dd
	 * @date 2014年12月4日
	 */
	public static final String getSomeNextDay(Date date, int some) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, some);
		return dateToSimpleString(calendar.getTime());
	}

	/**
	 * 得到指定时间推后（或推前）n小时的时间
	 * 
	 * @param date
	 *            指定时间
	 * @param num
	 *            推后小时数,负数为推前
	 * @return 返回时间字符串格式 yyyy-MM-dd HH:mm:ss
	 * @date 2014年12月4日
	 */
	public static final String getSomeNextHour(Date date, int num) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, num);
		return dateToLongString(calendar.getTime());
	}

	/**
	 * 得到指定时间推后（或推前）n分钟的时间
	 * 
	 * @param date
	 *            指定时间
	 * @param num
	 *            推后分钟数,负数为推前
	 * @return 返回时间字符串格式 yyyy-MM-dd HH:mm:ss
	 * @date 2014年12月4日
	 */
	public static final String getSomeNextMtnute(Date date, int num) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, num);
		return dateToLongString(calendar.getTime());
	}

	/**
	 * 得到两个日期之间的天数
	 * 
	 * @param simpleDateStrStart
	 *            开始日期 格式 :yyyy-MM-dd
	 * @param simpleDateStrEnd
	 *            结束日期 格式 :yyyy-MM-dd
	 * @return int
	 * @date 2014年12月4日
	 */
	public static int getDaysBetween(String simpleDateStrStart,
			String simpleDateStrEnd) {
		// 通过日期字符串转换成日期对象
		Date startDate = simpleStringToDate(simpleDateStrStart);
		Date endDate = simpleStringToDate(simpleDateStrEnd);
		// 获取结束日期的毫秒数减去开始日期的毫秒数，返回的是两个日期相差的毫秒数
		long daysOfMilliseconds = endDate.getTime() - startDate.getTime();
		// 用相差的毫秒数时间除以（1000*60*60*24），返回的是两个日期相差的天数
		long days = (daysOfMilliseconds / (1000 * 60 * 60 * 24));
		// 返回两个日期相差的天数
		return (int) days;
	}

	/**
	 * 得到指定日期月的最后一天
	 * 
	 * @param dateStr
	 *            指定日期 格式 yyyy-MM-dd
	 * @return 返回月的最后一天 格式 yyyy-MM-dd
	 * @date 2014年12月4日
	 */
	public static final String getLastDayInMonth(String dateStr) {
		Date date = simpleStringToDate(dateStr);
		return getLastDayInMonth(date);
	}

	/**
	 * 得到指定日期月的最后一天
	 * 
	 * @param date
	 * @return 返回月的最后一天 格式 yyyy-MM-dd
	 * @date 2014年12月4日
	 */
	public static final String getLastDayInMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.roll(Calendar.DAY_OF_MONTH, false);
		return dateToSimpleString(cal.getTime());
	}

	/**
	 * 得到指定日期月的第一天
	 * 
	 * @param date
	 * @return 返回月的第一天 格式 yyyy-MM-dd
	 * @date 2014年12月4日
	 */
	public static final String getFirstDayInMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return dateToSimpleString(cal.getTime());
	}

	/**
	 * 得到指定日期的星期，格式 周一、周二 ..
	 * 
	 * @param dateSrt
	 *            指定日期格式：yyyy-MM-dd
	 * @return String
	 * @date 2014年12月4日
	 */
	public static final String getDayOfWeek(String dateSrt) {
		Date date = simpleStringToDate(dateSrt);
		return getDayOfWeek(date);
	}

	/**
	 * 得到指定日期的星期，格式 周一、周二 ..
	 * 
	 * @param date 
	 * @return String
	 * @date 2014年12月4日
	 */
	public static final String getDayOfWeek(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		switch (week) {
		case 1:
			return "周日";
		case 2:
			return "周一";
		case 3:
			return "周二";
		case 4:
			return "周三";
		case 5:
			return "周四";
		case 6:
			return "周五";
		case 7:
			return "周六";
		default:
			return "";
		}
	}

	/**
	 * 把任何类型转成String类型 null则返回空字符串 "" 时间按照 yyyy-MM-dd格式 数字按照 #,##0.00格式 其他返回
	 * obj.toString()
	 * 
	 * @param obj
	 * @return String
	 * @date 2014年12月4日
	 */
	public static final String toString(Object obj) {
		if (obj == null) {// null
			return "";
		} else if (obj instanceof Date) { // 日期类型 返回格式 yyyy-MM-dd
			return StringUtils.dateToSimpleString((Date) obj);
		} else if (obj instanceof Integer || obj instanceof Short
				|| obj instanceof Long) { // 整数类型返回
			return obj.toString();
		} else if (obj instanceof Number) {// 数字 #,##0.0,若是0,显示0.00,否则显示每三位用,分隔
			return StringUtils.formatBigDecimal((Number) obj, "#,##0.00");
		} else { // 其他类型
			return obj.toString();
		}
	}

	/**
	 * 格式化BigDecimal 小数点不足2位的，补足 多于2位的，直接显示
	 * 
	 * @param value
	 * @return String
	 */
	public static String formatBigDecmialTail(BigDecimal value) {
		String strValue = value.toString();
		int index = strValue.indexOf(".");
		if (index == -1) {
			return strValue + ".00";
		}

		if (index + 2 == strValue.length()) {
			return strValue + "0";
		}

		return strValue;
	}

	/**
	 * 
	 * @Title: zeroPadString : TODO 使用零填充字符串
	 * @return String 返回类型
	 * @date 2014年12月8日
	 */
	public static final String zeroPadString(String string, int length) {
		if (string == null || string.length() > length) {
			return string;
		}
		StringBuffer buf = new StringBuffer(length);
		buf.append(zeroArray, 0, length - string.length()).append(string);
		return buf.toString();
	}

	/**
	 * 移除指定字符串的最后一个字符
	 * 
	 * @param str
	 * @return String
	 * @date 2014年12月11日
	 */
	public static final String removeLastChar(String str) {
		if (str == null || "".equals(str)) {
			return "";
		}
		int len = str.length();
		return str.substring(0, len - 1);
	}

	/**
	 * 移除指定字符串的最后一个字符
	 * 
	 * @param sb
	 * @return String
	 * @date 2014年12月11日
	 */
	public static final String removeLastChar(StringBuffer sb) {
		if (sb == null || sb.length() == 0) {
			return "";
		}
		return removeLastChar(sb.toString());
	}

	/**
	 * 格式文件大小，以B、KB、MB、GB、TB显示
	 * 
	 * @param size
	 * @return String
	 * @date 2014年12月11日
	 */
	public static final String formatFileSize(Long size) {
		if (size == null || size < 0) {
			return "";
		}
		// 格式化数字
		DecimalFormat df = new DecimalFormat("#.00");
		// 判断文件的大小使用恰当的单位
		if (size < Math.pow(2, 10)) { // 不足1KB使用单位B
			return df.format(size) + "B";
		} else if (size < Math.pow(2, 20)) { // 不足1MB使用单位KB
			return df.format(size / Math.pow(2, 10)) + "KB";
		} else if (size < Math.pow(2, 30)) { // 不足1GB使用单位MB
			return df.format(size / Math.pow(2, 20)) + "MB";
		} else if (size < Math.pow(2, 40)) { // 不足1TB使用单位GB
			return df.format(size / Math.pow(2, 30)) + "GB";
		} else { // 达到1TB的都使用单位TB
			return df.format(size / Math.pow(2, 40)) + "TB";
		}

	}

	/**
	 * 得到文字的首字母
	 * 
	 * @return int[]
	 * @date 2015年01月07日
	 */
	// 国标码和区位码转换常量
	static final int GB_SP_DIFF = 160;
	// 存放国标一级汉字不同读音的起始区位码
	static final int[] secPosValueList = { 1601, 1637, 1833, 2078, 2274, 2302,
			2433, 2594, 2787, 3106, 3212, 3472, 3635, 3722, 3730, 3858, 4027,
			4086, 4390, 4558, 4684, 4925, 5249, 5600 };
	// 存放国标一级汉字不同读音的起始区位码对应读音
	static final char[] firstLetter = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
			'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'w', 'x',
			'y', 'z' };

	// 获取一个字符串的拼音码
	public static String getFirstLetter(String oriStr) {
		String str = oriStr.toLowerCase();
		StringBuffer buffer = new StringBuffer();
		char ch;
		char[] temp;
		for (int i = 0; i < str.length(); i++) { // 依次处理str中每个字符
			ch = str.charAt(i);
			temp = new char[] { ch };
			byte[] uniCode = new String(temp).getBytes();
			if (uniCode[0] < 128 && uniCode[0] > 0) { // 非汉字
				buffer.append(temp);
			} else {
				buffer.append(convert(uniCode));
			}
		}
		return buffer.toString();
	}

	// 获取一个汉字的拼音首字母。GB码两个字节分别减去160，转换成10进制码组合就可以得到区位码.例如汉字“你”的GB码是0xC4/0xE3，分别减去0xA0（160）就是0x24/0x43
	// ,0x24转成10进制就是36，0x43是67，那么它的区位码就是3667，在对照表中读音为‘n’
	static char convert(byte[] bytes) {
		char result = '-';
		int secPosValue = 0;
		int i;
		for (i = 0; i < bytes.length; i++) {
			bytes[i] -= GB_SP_DIFF;
		}
		secPosValue = bytes[0] * 100 + bytes[1];
		for (i = 0; i < 23; i++) {
			if (secPosValue >= secPosValueList[i]
					&& secPosValue < secPosValueList[i + 1]) {
				result = firstLetter[i];
				break;
			}
		}
		return result;
	}
	  /**
     * 取str从0始(0 based)最长长度为length的子串,
     * 若str的长度小于length 返回str
     * @param str
     * @param length
     * @return String
     */
    public static String subStr(String str,int length) {
    	return subString(str,0,length);
    }
    
    /**
     * 同 String java.lang.String.substring(int beginIndex, int endIndex)
     * 若endIndex大于字符串的长度就取endIndex = length 
     * @param str
     * @param from
     * @param to
     * @return String
     */
    public static String subString(String str,int from,int to) {
    	int length = str.length();
    	if(from>=length) {
    		return "";    	
    	}
    	if(to > length) {
    		to = length;
    	}
    	return str.substring(from,to);
    }
    /**
	 * 用给定的分隔符对字符串进行拆分，并生成数组
	 * 
	 * @param message
	 *            需要拆分的字符串
	 * @param separator
	 *            分隔符
	 * @return 生成的数组
	 */
	public static String[] splitToArray(String message, String separator) {
		List<String> list = new ArrayList<String>();
		int start = 0;
		int index = 0;
		while((index = message.indexOf(separator, start)) != -1) {
			list.add(message.substring(start,index));
			start = index + separator.length();
		}
		
		if(start < message.length()) {
			list.add(message.substring(start, message.length()));
		}

		return (String[]) list.toArray(new String[list.size()]);
	}
	
	/**
     * 左边用空格补齐，字符串居右
     * @param string
     * @param length
     * @return String
     */
    public static final String leftSpacePadString(String string, int length) {
        return spacePadString(string, length, 2);
    }
    /**
     * 用空格补足字符串
     * 
     * @param string 需要补足的字符串
     * @param length 字符串长度
     * @param position 1 之后补空格，2 之前补空格， 3 两边补空格，字符串居中
     * @return String
     */
    private static final String spacePadString(String string, int length, int position) {
    	if(string == null) {
    		return "";
    	}
    	
    	string = string.trim();
    	if(string.getBytes().length >= length) {
        	//中文特殊处理
    		if(string.getBytes().length != string.length()) {
    	   		return string.substring(0, length/2);
    		} else {
    			return string.substring(0,length);
    		}
     	}
    	
        StringBuffer buf = new StringBuffer(length);
        if(position == 1 ) {
        	buf.append(string).append(spaceArray, 0, length - string.getBytes().length);
        } else if(position == 2) {
            buf.append(spaceArray, 0, length - string.getBytes().length).append(string);      	
        } else if(position == 3) {
        	buf.append(spaceArray, 0, (length - string.getBytes().length)/2);
        	buf.append(string);
        	buf.append(spaceArray, 0, (length - string.getBytes().length)/2);
        }
        return buf.toString();
    }
    /**
     * 获取下一天
     * @param day
     * @return Date
     */
	public static Date nextDay(Date day) {
		Calendar today = Calendar.getInstance();
		today.setTime(day);
		today.add(Calendar.DAY_OF_YEAR, 1);
		return today.getTime();
	}
	
	/**
	* 判断两个日期是否为同一天
	* @param dayA
	* @param dayB
	* @return boolean
	*/
	public static boolean isSameDay(Date dayA, Date dayB) {
		Calendar day1 = Calendar.getInstance();
		day1.setTime(dayA);
		Calendar day2 = Calendar.getInstance();
		day2.setTime(dayB);
		
		return day1.get(Calendar.DAY_OF_YEAR) == day2.get(Calendar.DAY_OF_YEAR);
	}
	    
	/**
	 * 计算两个日期之间的天数
	 * 
	 * @param simpleDateStrStart 格式为 yyyy-MM-dd的日期字符串
	 * @param simpleDateStrEnd 格式为 yyyy-MM-dd的日期字符串
	 * 
	 * 
	 */
	public static long getDaysAfter (String simpleDateStrStart,String simpleDateStrEnd ) {
		Date startDate=simpleStringToDate(simpleDateStrStart);
		Date endDate=simpleStringToDate(simpleDateStrEnd);
	
		long daysOfMilliseconds = endDate.getTime() - startDate.getTime();
		long days=(daysOfMilliseconds/(1000*60*60*24)) ;
		
		return days;
	}
	/**
	 * 计算两个日期之间的小时数
	 * 
	 * @param startTimeStr 格式为 yyyy-MM-dd HH-mm-ss的日期字符串
	 * @param endTimeStr 格式为 yyyy-MM-dd HH-mm-ss的日期字符串
	 * 
	 * @return String 精确到十分位的小时
	 */
	public static String getHoursTimeSpace(String startTimeStr,String endTimeStr){
		Date endTime = longStringToDate(endTimeStr);
		Date startTime = longStringToDate(startTimeStr);
		long millisecond= endTime.getTime()-startTime.getTime();
		long minute=millisecond/(1000*60);
		BigDecimal b = new BigDecimal(minute);
		BigDecimal ret = b.divide(new BigDecimal(60), 1,BigDecimal.ROUND_HALF_EVEN);
		return ret.toString();
	}
	 /**
     * 判断String返回值
     * @param value
     * @return boolean
     */
    public static final boolean isEmpty(String value){
    	return (value == null||"".equals(value));
    }
    /**
     * 右边用空格补齐，字符串居左
     * @param string
     * @param length
     * @return String
     */
    public static final String rightSpacePadString(String string, int length) {
        return spacePadString(string, length, 1);
    }
    /**
     * 将数值字符串格式化为两位小数
     * @param value
     * @return String
     */
    public static final String formatStringToTwoDecimal(String value) {
    	if(value == null || value.length() == 0) {
    		return "";
    	}
    	
    	int decimalIndex = value.indexOf(".");
    	if(decimalIndex != -1) {
    		if((decimalIndex + 1) == value.length()) {
    			return value + "00";
    		}
    		
    		if((decimalIndex + 2) == value.length()) {
    			return value + "0";
    		}
    		
    		value = value.substring(0, decimalIndex + 3);
    	}
    	
    	return value;
    }
    
    /**
     * 将数学表达式拆分入栈
     * @param IFX
     * @return String[]
     */
	private static String[] trnsInToSufix(String IFX){
		// PFX放后缀表达式，IFX为中缀表达式
		String PFX[] = new String[IFX.length()];
		StringBuffer numBuffer = new StringBuffer();// 用来保存一个数的
		Stack<String> s = new Stack<String>();// 放操作符
		String a;
		s.push("=");// 第一个为等号
		int i = 0, j = 0;
		char ch;
		for (i = 0; i < IFX.length();) {
			ch = IFX.charAt(i);
			switch (ch) {
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				while (Character.isDigit(ch) || ch == '.')// 拼数
				{
					numBuffer.append(ch); // 追加字符
					ch = IFX.charAt(++i);
				}
				PFX[j++] = numBuffer.toString();// break;
				numBuffer = new StringBuffer(); // 清空已获取的运算数字
				continue; // 这里要重新循环，因为i已经增加过了
			case '(':
				s.push("(");
				break;
			case ')':
				while (s.peek() != "(")
					PFX[j++] = s.pop();
				break;
			case '+':
			case '-':
				while (s.size() > 1 && s.peek() != "(")
					PFX[j++] = s.pop();
				a = String.valueOf(ch);
				s.push(a);
				break;
			case '*':
			case '/':
				while (s.size() > 1 && (s.peek() == "*") || s.peek() == "/" || s.peek() == "s" || s.peek() == "c"
						|| s.peek() == "t" || s.peek() == "^" || s.peek() == "√")
					// 优先级比较，与栈顶比较，
					PFX[j++] = s.pop();// 当前操作符优先级大于等于栈顶的弹出栈顶
				a = String.valueOf(ch);
				s.push(a);
				break;
			case 's':
			case 'c':
			case 't':// 三角函数
				while (s.size() > 1 && (s.peek() == "s" || s.peek() == "c" || s.peek() == "t" || s.peek() == "^"
						|| s.peek() == "√"))
					// 优先级比较，与栈顶，大于等于的弹出
					PFX[j++] = s.pop();
				a = String.valueOf(ch);
				s.push(a);
				break;
			case '^':// 幂
			case '√':// 开方
				while (s.size() > 1 && (s.peek() == "^" || s.peek() == "√"))
					PFX[j++] = s.pop();
				a = String.valueOf(ch);
				s.push(a);
				break;
			}
			i++;
		}
		while (s.size() > 1)
			PFX[j++] = s.pop();
		PFX[j] = "=";

		return PFX;
	}
	
	/**
	 * 将数学表达式字符串计算出结果
	 * @param expStr 数学表达式字符串
	 * @return String
	 */
	public static String doEval(String expStr){
		String PFX[] = null;
		try {
			PFX = trnsInToSufix(expStr);
		} catch (EmptyStackException e) {
			return "syntax error";
		}
		int i = 0;
		double x1, x2, n;
		String str;
		Stack<String> s = new Stack<String>();
		while (PFX[i] != "=") {
			str = PFX[i];
			switch (str.charAt(0)) {
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				s.push(str);
				break;
			case '+':
				x1 = Double.parseDouble(s.pop());
				x2 = Double.parseDouble(s.pop());
				n = x1 + x2;
				s.push(String.valueOf(n));
				break;
			case '-':
				x1 = Double.parseDouble(s.pop());
				x2 = Double.parseDouble(s.pop());
				n = x2 - x1;
				s.push(String.valueOf(n));
				break;
			case '*':
				x1 = Double.parseDouble(s.pop());
				x2 = Double.parseDouble(s.pop());
				n = x1 * x2;
				s.push(String.valueOf(n));
				break;
			case '/':
				x1 = Double.parseDouble(s.pop());
				x2 = Double.parseDouble(s.pop());
				n = x2 / x1;
				s.push(String.valueOf(n));
				break;
			case 's':
				x1 = Double.parseDouble(s.pop());
				n = Math.sin(x1 * Math.PI / 180);
				s.push(String.valueOf(n));
				break;
			case 'c':
				x1 = Double.parseDouble(s.pop());
				n = Math.cos(x1 * Math.PI / 180);
				s.push(String.valueOf(n));
				break;
			case 't':
				x1 = Double.parseDouble(s.pop());
				n = Math.tan(x1 * Math.PI / 180);
				s.push(String.valueOf(n));
				break;
			case '√':
				x1 = Double.parseDouble(s.pop());
				n = Math.sqrt(x1);
				s.push(String.valueOf(n));
				break;// 开方
			case '^':
				x1 = Double.parseDouble(s.pop());
				x2 = Double.parseDouble(s.pop());
				n = Math.pow(x2, x1);
				s.push(String.valueOf(n));
				break;
			}
			i++;
		}
		String result = s.pop();
		return result;
	}

	public static boolean isBlank(String str) {
		int strLen;
		if (str != null && (strLen = str.length()) != 0) {
			for(int i = 0; i < strLen; ++i) {
				if (!Character.isWhitespace(str.charAt(i))) {
					return false;
				}
			}

			return true;
		} else {
			return true;
		}
	}
}