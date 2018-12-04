package com.cm.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author liaochaofan
 * @date 2018/7/23 20:55
 */
public interface IFileService {
    String upload(MultipartFile file, String path);
}
