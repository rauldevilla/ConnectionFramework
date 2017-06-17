package com.monstermachines.connectionfw.GMC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.monstermachines.connectionfw.core.InformationItem;
import com.monstermachines.connectionfw.core.Source;

public class GMCVehiclesModelFlatFile implements Source {

	private String[] content;
	private int readingIndex = 0;
	
	public GMCVehiclesModelFlatFile(File in) throws IOException {
		load(in);
	}

	private void load(File in) throws IOException {
		List<String> contentAsList = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(in));
		try {
			String line = null;
			while ((line = reader.readLine()) != null) {
				contentAsList.add(line);
			}
		} finally {
			reader.close();
		}
		if (contentAsList.size() == 0) {
			return;
		}
		this.content = new String[contentAsList.size()];
		this.content = contentAsList.toArray(this.content);
	}
	
	private static GMCVehiclesModelFlatFileInformationItem flatLineToInformationItem(String line) {
		GMCVehiclesModelFlatFileInformationItem item = new GMCVehiclesModelFlatFileInformationItem();
		item.setCode(line.substring(0, 4));
		item.setName(line.substring(4));
		return item;
	}
	
	@Override
	public InformationItem next() {
		if (this.content == null || this.readingIndex == this.content.length) {
			return null;
		}
		return flatLineToInformationItem(this.content[this.readingIndex++]);
	}

}
