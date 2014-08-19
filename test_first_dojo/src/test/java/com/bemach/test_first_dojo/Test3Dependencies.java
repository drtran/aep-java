package com.bemach.test_first_dojo;

import junit.framework.TestCase;

public class Test3Dependencies extends TestCase
{
   public void testThatCellReferenceWorks()
   {
      Sheet sheet = new Sheet();
      sheet.put("A1", "8");
      sheet.put("A2", "=A1");
      assertEquals("cell lookup", "8", sheet.get("A2"));
   }

   public void testThatCellChangesPropagate()
   {
      Sheet sheet = new Sheet();
      sheet.put("A1", "8");
      sheet.put("A2", "=A1");
      assertEquals("cell lookup", "8", sheet.get("A2"));

      sheet.put("A1", "9");
      assertEquals("cell change propagation", "9", sheet.get("A2"));
   }

   public void testThatFormulasKnowCellsAndRecalculate()
   {
      Sheet sheet = new Sheet();
      sheet.put("A1", "8");
      sheet.put("A2", "3");
      sheet.put("B1", "=A1*(A1-A2)+A2/3");
      assertEquals("calculation with cells", "41", sheet.get("B1"));

      sheet.put("A2", "6");
      assertEquals("re-calculation", "18", sheet.get("B1"));
   }

   public void testThatDeepPropagationWorks()
   {
      Sheet sheet = new Sheet();
      sheet.put("A1", "8");
      sheet.put("A2", "=A1");
      sheet.put("A3", "=A2");
      sheet.put("A4", "=A3");
      assertEquals("deep propagation", "8", sheet.get("A4"));

      sheet.put("A2", "6");
      assertEquals("deep re-calculation", "6", sheet.get("A4"));
   }

   public void testThatFormulaWorksWithManyCells()
   {
      Sheet sheet = new Sheet();
      sheet.put("A1", "10");
      sheet.put("A2", "=A1+B1");
      sheet.put("A3", "=A2+B2");
      sheet.put("A4", "=A3");
      sheet.put("B1", "7");
      sheet.put("B2", "=A2");
      sheet.put("B3", "=A3-A2");
      sheet.put("B4", "=A4+B3");

      assertEquals("multiple expressions - A4", "34", sheet.get("A4"));
      assertEquals("multiple expressions - B4", "51", sheet.get("B4"));
   }
}
