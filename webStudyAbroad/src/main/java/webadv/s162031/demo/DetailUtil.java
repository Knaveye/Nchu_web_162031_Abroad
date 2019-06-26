package webadv.s162031.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.jboss.jandex.Main;
import org.springframework.util.ResourceUtils;

public class DetailUtil {
	public static  String  getUrl() {

		String path = null;
		try {
			String serverpath= ResourceUtils.getURL("").getPath().replace("%20"," ");
			path=serverpath.substring(1);//从路径字符串中取出工程路径
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return path;
	}
}
