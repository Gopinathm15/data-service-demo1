package com.datalayer.services;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.datalayer.domains.FileData;
import com.datalayer.repository.FileDataRepository;
import com.datalayer.response.CommonResponse;

@Service
public class FileService {

	@Autowired
	private FileDataRepository fileDataRepository;

	public ResponseEntity storeFileData(FileData fileData) {
		fileData.setCreatedAt(Calendar.getInstance().getTime());
		fileDataRepository.save(fileData);
		return ResponseEntity.ok(new CommonResponse(null));
	}

	public ResponseEntity getFileData() {
		List<FileData> fileDataFromDB = fileDataRepository.findAll();
		return ResponseEntity.ok(new CommonResponse(fileDataFromDB));
	}

}
