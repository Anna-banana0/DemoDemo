package com.employee.payroll.helper;

import com.employee.payroll.repository.FileDetailRepository;
import com.employee.payroll.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class FilePickupThread implements Runnable{
    static FileDetailRepository fileDetailRepository;
    @Qualifier("fileDetRepository")
    @Autowired
    private FileDetailRepository xfileDetailRepository;
    private MultipartFile[] files;
    private int fileCount;

    public FilePickupThread(MultipartFile[] files, int fileCount) {
        this.files = files;
        this.fileCount = fileCount;
    }

    @Override
    public void run() {
        //MultipartFile[] allfiles = files;
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(Constant.NO_OF_THREADS);
        executor.setMaxPoolSize(Constant.NO_OF_THREADS);
        executor.setQueueCapacity(Constant.QUEUE_CAPACITY);
        executor.setThreadNamePrefix("SME thread");
    }


    public static List<MultipartFile> checkDbUpdates(MultipartFile file,int fileCount){
        List<MultipartFile> allfiles = new ArrayList<>();
        try {
            if(fileDetailRepository.findStatusByFileName(file.getOriginalFilename()).equals("Uploaded")){
                allfiles.add(file);
            }
            Thread.sleep(2000);
            if(fileCount == allfiles.size())
                return allfiles;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return allfiles;
    }
    @PostConstruct
    private void initStaticDepartmentRepo() {
        fileDetailRepository = this.xfileDetailRepository;
    }

}
