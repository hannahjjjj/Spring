package com.example.myapp.upload;

import java.util.HashMap;
import java.util.List;

public interface IUploadService {
	
	void uploadFile(UploadFileVO file);

	List<UploadFileVO> getFileList(String dir);
	List<UploadFileVO> getAllFileList();
	List<UploadFileVO> getImageList(String dir);
	
	UploadFileVO getFile(int fileId);
	
	String getDirectoryName(int fileId);
	void updateDirectory(int[] fileIds, String directoryName);
	
	void deleteFile(int fileId);
}
