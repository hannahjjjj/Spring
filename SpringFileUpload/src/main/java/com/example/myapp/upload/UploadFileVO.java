package com.example.myapp.upload;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UploadFileVO {
	private int fileId;
	private String directoryName;
	private String fileName;
	private long fileSize;
	private String fileContentType;
	private Timestamp fileUploadDate;
	private byte[] fileData;
	
	@Override
	public String toString() {
		return "UploadFileVO [fileId=" + fileId + ", directoryName=" + directoryName + ", fileName=" + fileName
				+ ", fileSize=" + fileSize + ", fileContentType=" + fileContentType + ", fileUploadDate="
				+ fileUploadDate + "]";
	}
}
