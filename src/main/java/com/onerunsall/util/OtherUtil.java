package com.onerunsall.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class OtherUtil {
	public static Logger logger = Logger.getLogger(OtherUtil.class);

	public static boolean isLinux() {
		Properties prop = System.getProperties();
		String os = prop.getProperty("os.name");
		if (os != null && os.toLowerCase().indexOf("linux") > -1) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isWindows() {
		Properties prop = System.getProperties();
		String os = prop.getProperty("os.name");
		if (os != null && os.toLowerCase().indexOf("windows") > -1) {
			return true;
		} else {
			return false;
		}
	}

//	public static List<String> extractOffStrs(List<String> oldStrs, List<String> newStrs, boolean force) {
//		if (oldStrs == null || oldStrs.isEmpty())
//			return new ArrayList();
//		if (newStrs == null || newStrs.isEmpty()) {
//			if (force)
//				return oldStrs;
//			else
//				return new ArrayList();
//		}
//		List<String> offUrls = new ArrayList<String>();
//		for (String oldUrl : oldStrs) {
//			if (!newStrs.contains(oldUrl))
//				offUrls.add(oldUrl);
//		}
//		return offUrls;
//	}
//
//	public static List<String> extractOffStrs(String[] oldStrs, String[] newStrs, boolean force) {
//		if (oldStrs == null || oldStrs.length == 0)
//			return new ArrayList();
//		if (newStrs == null || newStrs.length == 0) {
//			if (force)
//				return new ArrayList(Arrays.asList(oldStrs));
//			else
//				return new ArrayList();
//		}
//		return extractOffStrs(new ArrayList(Arrays.asList(oldStrs)), new ArrayList(Arrays.asList(newStrs)), force);
//	}

	public static List<Map> lineToCatalog(List<Map> srcList, String idName, String upIdName, String childrenName) {
		List<Map> aas = new ArrayList();
		Map<Integer, Map> am = new HashMap();
		while (true) {
			if (am.size() == srcList.size())
				break;
			for (Map a : srcList) {
				Integer id = (Integer) a.get(idName);
				Integer upId = (Integer) a.get(upIdName);
				if (am.get(id) != null)
					continue;
				a.put(childrenName, new ArrayList());

				if (upId == 0) {
					aas.add(a);
				} else {
					Map up = am.get(upId);
					if (up == null)
						continue;
					List children = (List) up.get(childrenName);
					children.add(a);
				}

				am.put(id, a);
			}
		}
		return aas;
	}

	public static boolean validUrlIs404(String url) {
		return true;
	}

}