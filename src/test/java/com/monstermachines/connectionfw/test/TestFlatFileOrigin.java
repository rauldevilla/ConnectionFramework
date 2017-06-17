package com.monstermachines.connectionfw.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.monstermachines.connectionfw.GMC.GMCVehiclesModelFlatFile;
import com.monstermachines.connectionfw.core.IntegrationFramework;
import com.monstermachines.connectionfw.core.IntegrationStatus;
import com.monstermachines.connectionfw.core.Source;

public class TestFlatFileOrigin {

	@Test
	public void testGMCVehiclesModelFlatFile() throws IOException {
		
		File in = new File("./src/test/resources/GMC_test_VehiclesModelsFlatFile.txt");
		assertTrue(in.exists());
		
		Source source = new GMCVehiclesModelFlatFile(in);
		
		IntegrationFramework framework = new IntegrationFramework();
		
		IntegrationStatus status = framework.update(source);
		
		assertEquals(2, status.getProcessedRows());
		assertNull(status.getErrors());
	}

}
