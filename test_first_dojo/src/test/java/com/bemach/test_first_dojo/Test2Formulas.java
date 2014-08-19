package com.bemach.test_first_dojo;

import junit.framework.TestCase;

/*
 * We're doing expressions; you may need to do a spike if you're not familiar with parsing.
 * For background, look up "recursive descent" or "operator precedence". (Other techniques can work as well.)
 */
public class Test2Formulas extends TestCase
{
   public void testFormulaSpec()
   {
      Sheet sheet = new Sheet();
      sheet.put("B1", " =7"); // note leading space
      assertEquals("Not a formula", " =7", sheet.get("B1"));
      assertEquals("Unchanged", " =7", sheet.getLiteral("B1"));
   }

   public void testConstantFormula()
   {
      Sheet sheet = new Sheet();
      sheet.put("A1", "=7");
      assertEquals("Formula", "=7", sheet.getLiteral("A1"));
      assertEquals("Value", "7", sheet.get("A1"));
   }

   public void testParentheses()
   {
      Sheet sheet = new Sheet();
      sheet.put("A1", "=(7)");
      assertEquals("Parends", "7", sheet.get("A1"));
   }

   public void testDeepParentheses()
   {
      Sheet sheet = new Sheet();
      sheet.put("A1", "=((((10))))");
      assertEquals("Parends", "10", sheet.get("A1"));
   }

   public void testMultiply()
   {
      Sheet sheet = new Sheet();
      sheet.put("A1", "=2*3*4");
      assertEquals("Times", "24", sheet.get("A1"));
   }

   public void testAdd()
   {
      Sheet sheet = new Sheet();
      sheet.put("A1", "=71+2+3");
      assertEquals("Add", "76", sheet.get("A1"));
   }

   public void testPrecedence()
   {
      Sheet sheet = new Sheet();
      sheet.put("A1", "=7+2*3");
      assertEquals("Precedence", "13", sheet.get("A1"));
   }

   public void testFullExpression()
   {
      Sheet sheet = new Sheet();
      sheet.put("A1", "=7*(2+3)*((((2+1))))");
      assertEquals("Expr", "105", sheet.get("A1"));
   }

   public void testSimpleFormulaError()
   {
      Sheet sheet = new Sheet();
      sheet.put("A1", "=7*");
      assertEquals("Error", "#Error", sheet.get("A1"));
   }

   public void testParenthesisError()
   {
      Sheet sheet = new Sheet();
      sheet.put("A1", "=(((((7))");
      assertEquals("Error", "#Error", sheet.get("A1"));
   }
}
