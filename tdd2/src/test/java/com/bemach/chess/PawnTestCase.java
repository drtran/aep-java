package com.bemach.chess;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.bemach.chess.Pawn;
import com.bemach.test.IntegrationTest;

@Category(IntegrationTest.class)
public class PawnTestCase {
    final String WHITE = "white";
    final String BLACK = "black";
    
    @Test
    public void aPawnCanBeCreated() {
        Pawn pawn = new Pawn(WHITE);
        assertNotNull(pawn);
    }

    @Test
    public void aPawnIsWhite(){
        Pawn pawn = new Pawn(WHITE);
        assertEquals(WHITE, pawn.getColor());
    }
    
    @Test
    public void aPawnIsBlack() {
        Pawn pawn = new Pawn(BLACK);
        assertEquals(BLACK, pawn.getColor());
    }
}
