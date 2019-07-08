package com.atguigu.jdbc.whc.common;

import com.vdurmont.emoji.EmojiParser;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 表情
 * @author jinxy
 *
 */
public class EmojiUtil extends EmojiParser {
	
	/**
	 * 表情
	 * @param str 内容
	 * @return
	 */
	public static String onlyEmojiToUnicode(String str){
		if(str==null||"".equals(str)){
			return "";
		}
		StringBuffer sbf=new StringBuffer();
		for(int i=0;i<str.length();i++){
			 char c = str.charAt(i);
			 if(!EmojiUtil.isEmojiCharacter(str.charAt(i)))//判断
				 sbf.append(EmojiUtil.getUnicode(String.valueOf(c)));//将表情转换unicode
			 else
				 sbf.append(c);
		}
		System.out.println(sbf.toString());
		return sbf.toString();
	}
	
	
	public static boolean isEmojiCharacter(char codePoint){
	return (codePoint==0x0)||(codePoint == 0x9)||(codePoint == 0xA)||(codePoint == 0xD)||((codePoint >= 0x20) && (codePoint <= 0xD7FF))||
			((codePoint >= 0xE000) && (codePoint <= 0xFFFD))||((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
	}
	
	
	/**
	 * 将表情字符转化为Unicode
	 * @param source
	 * @return
	 */
	public static String getUnicode(String  source){
		String returnUniCode=null;
		String uniCodeTemp=null;
		for(int i=0;i<source.length();i++){
			uniCodeTemp = "\\u"+Integer.toHexString((int)source.charAt(i));
			returnUniCode=returnUniCode==null?uniCodeTemp:returnUniCode+uniCodeTemp;
		}
		return returnUniCode;
	}
		
	//字符串转换unicode
	public static String stringToUnicode(String string) {
		StringBuffer unicode = new StringBuffer();
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);  // 取出每一个字符
			unicode.append("\\u" +Integer.toHexString(c));// 转换为unicode
		}
		return unicode.toString();		
	}
	
	/**
     * 把十六进制Unicode编码字符串转换为中文字符串
     */
	public static String unicodeToString(String str) {
		Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{2,4}))");
		Matcher matcher = pattern.matcher(str);
		char ch;
		while (matcher.find()) {
			ch = (char) Integer.parseInt(matcher.group(2), 16);
            str = str.replace(matcher.group(1), ch + "");
		}
		return str;
	}
	
	/**
     * 获取非表情字符串
     * @param input
     * @return
     */
	public static String getNonEmojiString(String input) {
		int prev = 0;
		StringBuilder sb = new StringBuilder();
		List<UnicodeCandidate> replacements = getUnicodeCandidates(input);
		for (UnicodeCandidate candidate : replacements) {
			sb.append(input.substring(prev, candidate.getEmojiStartIndex()));
            prev = candidate.getFitzpatrickEndIndex();
		}
		return sb.append(input.substring(prev)).toString();
	}
	
	/**
	 * 获取表情字符串
	 * @param input
	 * @return
	 */
	 public static String getEmojiUnicodeString(String input){
		 EmojiTransformer  transformer = new EmojiTransformer() {
			 public String transform(UnicodeCandidate unicodeCandidate) {
				 return unicodeCandidate.getEmoji().getHtmlHexadecimal();
			 }
		 };
		 StringBuilder sb = new StringBuilder();
		 List<UnicodeCandidate> replacements = getUnicodeCandidates(input);
		 for (UnicodeCandidate candidate : replacements) {
			 sb.append(transformer.transform(candidate));
		 }
		 return  parseToUnicode(sb.toString());
	 }
	 
	 
	  /**
	     * 检测是否有emoji字符
	     * @param source
	     * @return 一旦含有就抛出
	     */
	 public static boolean containsEmoji(String source) {
		 if (StringUtils.isBlank(source)) {
	            return false;
	        }
		 int len = source.length();
		 for (int i = 0; i < len; i++) {
			 char codePoint = source.charAt(i);
			 if (isEmojiCharacter(codePoint)) {
	                //do nothing，判断到了这里表明，确认有表情字符
	                return true;
	            }
		 }
		 return false;
	 }
	
	
	
	

}






