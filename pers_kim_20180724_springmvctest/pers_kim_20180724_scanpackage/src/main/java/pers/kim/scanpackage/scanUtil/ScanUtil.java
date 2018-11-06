package pers.kim.scanpackage.scanUtil;

import pers.kim.scanpackage.annotation.Bean;

import javax.jws.Oneway;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Create on 7/24/2018
 *
 * @Author Kim
 */
public class ScanUtil {
    public static String parseClass(Class target, Class bean) {
        String beanName = null;
        Bean beanAnnotation = (Bean) target.getAnnotation(bean);
        if (beanAnnotation != null) {
            beanName = beanAnnotation.name();
        }
        return beanName;
    }

    public static Map<String, Object> scanPackage(String packageName) throws Exception {
        Map<String, Object> beans = new HashMap<>();
        String path = packageName.replace(".", "/");
        URL url = ScanUtil.class.getClassLoader().getResource(path);
        File file = new File(url.getFile());
        beans = findClassFromFile(file, beans, packageName);
        return beans;
    }

    public static Map<String, Object> findClassFromFile(File file, Map<String, Object> map, String packageName) throws Exception {
        File[] list = file.listFiles();
        if (list != null) {
            for (File f : list) {
                if (f.isDirectory()) {
                    findClassFromFile(f, map, packageName);
                } else {
                    String fn = f.getName();
                    int index = fn.lastIndexOf(".class");
                    if (index != -1) {
                        fn = fn.substring(0, index);
                        String classPath = packageName + "." + fn;
                        Class claz = Class.forName(classPath);
                        String key = parseClass(claz, Bean.class);
                        if (key != null) {
                            map.put(key, claz.newInstance());
                        }
                    }
                }
            }
        }
        return map;
    }

    public static void main(String[] args) throws Exception {
        String packageName = "pers.kim.scanpackage.reflectService";
        Map<String, Object> map = scanPackage(packageName);
        for (String key : map.keySet()) {
            System.out.println(key);
        }
    }
}
