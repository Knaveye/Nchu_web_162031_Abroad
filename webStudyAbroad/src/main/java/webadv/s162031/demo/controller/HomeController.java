package webadv.s162031.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
public class HomeController {

	@GetMapping("/detail")
	public String todetail() {
		return "detail";
	}
	/*
	 * 下载所有明细文件
	 *
	 * */

	@GetMapping("/downloadDetail")
	public void downloadFile(Model model, HttpServletRequest request, HttpServletResponse response, String path, String name) throws IOException {
		File imageFile = new File(path);
		if (!imageFile.exists()) {
			return;
		}

		//下载的文件携带这个名称
		response.setHeader("Content-Disposition", "attachment;filename=" + name);
		//文件下载类型--二进制文件
		response.setContentType("application/octet-stream");

		try {
			FileInputStream fis = new FileInputStream(path);
			byte[] content = new byte[fis.available()];
			fis.read(content);
			fis.close();

			ServletOutputStream sos = response.getOutputStream();
			sos.write(content);

			sos.flush();
			sos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
