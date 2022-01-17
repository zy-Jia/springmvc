package com.gyofu.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileHandler {

    @PostMapping("/upload")
    public String upload(MultipartFile img, HttpServletRequest request) {
        if (img.getSize() > 0) {
            String path = request.getServletContext().getRealPath("file");
            String name = img.getOriginalFilename();
            File file = new File(path, name);
            try {
                img.transferTo(file);
                request.setAttribute("path", "/file/" + name);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "upload";
    }

    @PostMapping("/uploads")
    public String uploads(MultipartFile[] imgs, HttpServletRequest request) {
        List<String> files = new ArrayList<>();
        for (MultipartFile img : imgs) {
            if (img.getSize() > 0) {
                String path = request.getServletContext().getRealPath("file");
                String name = img.getOriginalFilename();
                File file = new File(path, name);
                try {
                    img.transferTo(file);
                    files.add("/file/" + name);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        request.setAttribute("files", files);
        return "uploads";
    }

    @GetMapping("/download/{name}")
    public void download(@PathVariable("name") String name, HttpServletRequest request, HttpServletResponse response) {
        if (name != null) {
            name += ".png";
            String path = request.getServletContext().getRealPath("file");
            File file = new File(path, name);
            OutputStream outputStream = null;
            if (file.exists()) {
                response.setContentType("application/forc-download");
                response.setHeader("Content-Disposition", "attachment;filename=" + name);
                try {
                    outputStream = response.getOutputStream();
                    outputStream.write(FileUtils.readFileToByteArray(file));
                    outputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (outputStream != null){
                        try {
                            outputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
