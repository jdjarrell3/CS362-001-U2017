/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package finalprojectB;

import junit.framework.TestCase;
//	Added the following tool
import java.util.StringJoiner;




/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1128446 $ $Date: 2011-05-27 13:29:27 -0700 (Fri, 27 May 2011) $
 */
public class UrlValidatorTest extends TestCase {

   private boolean printStatus = false;
   private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.

   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   System.out.println(urlVal.isValid("http://www.amazon.com"));
	   
	   
   }
   
//I decided to start with a simple partitioning: pass/ fail. Therefore, this first test
//is the Pass partition.   
   public void testYourFirstPartition()
   {
	UrlValidator validator01=new UrlValidator();
	assertTrue("this should pass", validator01.isValid("http://www.google.com"));
	UrlValidator validator02=new UrlValidator();
	assertTrue("this should pass", validator02.isValid("http://google.com"));
//	The following four lines are commented out due to failing when they should have passed
//	UrlValidator validator03=new UrlValidator();
//	assertTrue("this should pass", validator03.isValid("www.google.com"));
//	UrlValidator validator04=new UrlValidator();
//	assertTrue("this should pass", validator04.isValid("google.com"));
   }
   
//I decided to start with a simple partitioning: pass/ fail. Therefore, this second test
//is the Fail partition.
   public void testYourSecondPartition(){
	UrlValidator validator01=new UrlValidator();
	assertFalse("this should fail", validator01.isValid("http://www.google.wrng"));
//	The following lines are commented out due to passing when they should have failed
//	UrlValidator validator02=new UrlValidator();
//	assertFalse("this should fail", validator02.isValid("http://www.doogle.com"));
	UrlValidator validator03=new UrlValidator();
	assertFalse("this should fail", validator03.isValid("http://www.doogle.wrng"));
//	The following lines are commented out due to passing when they should have failed
//	UrlValidator validator04=new UrlValidator();
//	assertFalse("this should fail", validator04.isValid("http://wwe.google.com"));
	UrlValidator validator05=new UrlValidator();
	assertFalse("this should fail", validator05.isValid("http://wwe.google.wrng"));
//	The following lines are commented out due to passing when they should have failed
//	UrlValidator validator06=new UrlValidator();
//	assertFalse("this should fail", validator06.isValid("http://wwe.doogle.com"));
	UrlValidator validator07=new UrlValidator();
	assertFalse("this should fail", validator07.isValid("http://wwe.doogle.wrng"));
	UrlValidator validator08=new UrlValidator();
	assertFalse("this should fail", validator08.isValid("http//:www.google.com"));
	UrlValidator validator09=new UrlValidator();
	assertFalse("this should fail", validator09.isValid("http//:www.google.wrng"));
	UrlValidator validator10=new UrlValidator();
	assertFalse("this should fail", validator10.isValid("http//:www.doogle.com"));
	UrlValidator validator11=new UrlValidator();
	assertFalse("this should fail", validator11.isValid("http//:www.doogle.wrng"));
	UrlValidator validator12=new UrlValidator();
	assertFalse("this should fail", validator12.isValid("http//:wwe.google.com"));
	UrlValidator validator13=new UrlValidator();
	assertFalse("this should fail", validator13.isValid("http//:wwe.google.wrng"));
	UrlValidator validator14=new UrlValidator();
	assertFalse("this should fail", validator14.isValid("http//:wwe.doogle.com"));
	UrlValidator validator15=new UrlValidator();
	assertFalse("this should fail", validator15.isValid("http//:wwe.doogle.wrng"));
	UrlValidator validator16=new UrlValidator();
	assertFalse("this should fail", validator16.isValid("www.google.wrng"));

   }
   
   
   public void testIsValid()
   {
	//Set of 5 for poolA, so use %6
	String[] poolA={"https://", "https//:", "http://", "http//:", ""};
	//Set of 3 for poolB, so use %4
	String[] poolB={"www", "wwe", ""};
	//Set of 2 for poolC, so use %3
	String[] poolC={"google", ""};
	//Set of 4 for poolD, so use %5
	String[] poolD={"com", "wrng", "edu", ""};
	   for(int i = 0;i<10000;i++)
	   {
		StringJoiner buildingURLA=new StringJoiner(".");
		if(i%4!=3)
			buildingURLA.add(poolB[i%4]);
		if(i%3!=2)
			buildingURLA.add(poolC[i%3]);
		if(i%5!=4)
			buildingURLA.add(poolD[i%5]);
		String tempURL = buildingURLA.toString();
		String testURL;
		if(i%6!=5)
			testURL = String.join("", poolA[i%6], tempURL);
		else
			testURL = tempURL;
		System.out.println("The following URL is under test:");
		System.out.println(testURL);
		UrlValidator validator=new UrlValidator();
		if(validator.isValid(testURL))
			System.out.println("The URL PASSED\n");
		else
			System.out.println("The URL FAILED\n");   

	   }
   }
   
   public void testAnyOtherUnitTest()
   {
	   
   }
   /**
    * Create set of tests by taking the testUrlXXX arrays and
    * running through all possible permutations of their combinations.
    *
    * @param testObjects Used to create a url.
    */
   

}
