// Copyright 2014-2015 Boundary, Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.boundary.plugin.sdk;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MeasurementSinkStandardOutTest {
	private PrintStream old;
	ByteArrayOutputStream baos;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		old = System.out;
		baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(old);
	}

	@Test
	public void testWriter() {
		MeasurementSinkStandardOut writer = new MeasurementSinkStandardOut();
		Date d = new Date();
		Measurement m = new Measurement("BOUNDARY_CPU",3.1459,"great-white-north",d);

		String expectedOutput = "BOUNDARY_CPU 3.1459 great-white-north " + Long.toString(d.getTime()) + "\n";
		
		writer.send(m);
		String output = baos.toString();
		assertEquals("check output",expectedOutput,output);
	}
}
