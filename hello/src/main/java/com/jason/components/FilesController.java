package com.jason.components;

import com.jason.dto.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;

/**
 * Created by BNC on 2019/4/11.
 */
@Controller
public class FilesController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/imageUpload")
    public MessageDTO imageUpload(MultipartFile file) {
        MessageDTO msg = null;
        if (file.isEmpty()) {
            return new MessageDTO(0, 200, "上传文件为空");
        }
        String fileName = file.getName();
        StringBuffer path = new StringBuffer();
        File createFile = new File(fileName);

        return msg;
    }
}
