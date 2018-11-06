package test.person.kim.regexandgame;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;
import person.kim.regexandgame.regex.TestRegex;

public class TestClass {
	private TestRegex kim;

//	@Test
	public void testRegex() {
		String[] arr = { "oocl", "香港", "ita" };
		String world = "东方海外是香港联交所上市公司 (0316) 东方海外（国际）有限公司 (OOCL) 的全资附属公司，为世界最具规模之综合国际货柜运输、物流及码头公司之一亦为香港最为熟悉之环球商标之一，为客户提供全面的物流及运输服务，航线联系亚洲 、欧洲、北美、 地中海、印度次大陆、中东及澳洲/新西兰等地。为客户提供以客为尊的物流方案、精益求精及不断创新的服务精神，一向享誉业内。东方海外率先在中国提供全线物流及运输服务，在信息服务方面亦是业内先驱。";
		TestRegex kim = new TestRegex();
		kim.findWorld(arr, world);
	}

//	@Test
	public void testDate() throws ParseException {
		Date date = new Date();
		// 格式化时间
		SimpleDateFormat fom = new SimpleDateFormat("yyyy年MM月dd日");
		String fDate = fom.format(date);
		System.out.println(fDate);
		Date dd = fom.parse(fDate);
		System.out.println(dd);
	}

//	@Test
	public void testString() {
		String str = new String(" acd4441234 ");
		String str1 = "444";
		String str2 = new String("444");
		String str3 = "444";
		// ==是指对内存地址进行比较
		// equals()是对字符串的内容进行比较
		System.out.println(str.equals(str1));
		System.out.println(str1.equals(str3));
		System.out.println(str.equals(str2));
		System.out.println(str == str1);
		System.out.println(str1 == str3);
		System.out.println(str == str2);
		System.out.println("==========================");
		System.out.println(str.charAt(1)); // 该位置的值
		System.out.println(str.indexOf("4"));// 第一个出现的位置
		System.out.println(str.substring(0, 1) + "\t" + str);
		System.out.println(str.trim());
	}

//	@Test
	public void testList() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(123);
		list.add(345);
		list.add(567);
		list.add(0, 999);
//		System.out.println(list.get(3));
		list.set(0, 0);
		list.remove(0);
		System.out.println(list.indexOf(345));
		Object[] array = list.toArray();
		for (Object object : array) {
			System.out.println(object);
		}
		System.out.println("===========testList===============");
		for (Integer item:list) {
			System.out.println(item);
		}
	}
//	@Test
	public void testSet() {
//		set会去重
		Set<Integer> set=new HashSet<>();
		set.add(1);
		set.add(1);
		set.add(1);
		set.add(1444);
		for (Integer integer : set) {
			System.out.println(integer);
		}
	}
	@Test
	public void testMap() {
		Map<String, Integer> map=new HashMap<>();
		map.put("a", 1);
		map.put("k123ad", 2);
		map.put("casdad", 1);
		map.put("dxxxx2", 1);
		Set<String> keySet = map.keySet();
		for (String string : keySet) {
			System.out.println(string + "----" + map.get(string));
		}
//		Set<Entry<String,Integer>> entrySet = map.entrySet();
//		for (Entry<String, Integer> entry : entrySet) {
//			System.out.println(entry.getKey() + "----" +entry.getValue());
//		}
	}
}
