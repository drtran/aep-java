package com.bemach.test_first_dojo;

import junit.framework.TestCase;

public class Test4CircularReferences extends TestCase
{
   public void testThatCircularReferenceDoesntCrash()
   {
      Sheet sheet = new Sheet();
      sheet.put("A1", "=A1");
      assertTrue(true);
   }

   public void testThatCircularReferencesAdmitIt()
   {
      Sheet sheet = new Sheet();
      sheet.put("A1", "=A1");
      assertEquals("Detect circularity", "#Circular", sheet.get("A1"));
   }
}
