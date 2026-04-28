package kr.ac.kopo.gnuyog._026example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/chap07")
public class Chap07_01Controller {

    @GetMapping("/form")
    public String requestForm() {
        return "viewFilePage";
    }

    @PostMapping("/form")
    public String requestFileUploadResult(MultipartHttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        MultipartFile file = request.getFile("fileImage");

        if (file != null && !file.isEmpty()) {
            String originFileName = file.getOriginalFilename();
            String storedFileName = name + "_" + originFileName;

            // 실제 파일이 저장되는 물리적 경로 (D드라이브)
            File saveFile = new File("D:\\upload\\" + storedFileName);

            // 폴더가 없으면 생성
            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }

            try {
                file.transferTo(saveFile);

                model.addAttribute("title", "파일 업로드 결과 페이지");
                model.addAttribute("originFileName", originFileName);

                // [핵심] HTML에 전달할 때는 위에서 설정한 매핑 경로(/upload/)를 사용합니다.
                model.addAttribute("saveFileName", "/upload/" + storedFileName);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "viewFilePageResult";
    }
}
