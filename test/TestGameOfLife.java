import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestGameOfLife {
    @Test
    public void newlyCreatedUniverseShouldBeEmpty() {
        Universe universe = new Universe();
        assertTrue(universe.isEmpty());
    }

    @Test
    public void universeWithTwoCellsShouldNotBeEmpty() {
        Universe universe = new Universe();
        universe.add(new Cell());
        universe.add(new Cell());
        assertFalse(universe.isEmpty());
    }

    @Test
    public void universeWithOneCellShouldBeEmptyInTheNextGeneration() throws Exception {
        Universe universe = new Universe();
        universe.add(new Cell(0, 0));
        universe.nextGeneration();
        assertTrue(universe.isEmpty());
    }

    @Test
    public void universeWithOneCellAndOneNeighbourShouldBeEmptyInTheNextGeneration() throws Exception {
        Universe universe = new Universe();
        universe.add(new Cell(0, 0));
        universe.add(new Cell(0, 1));
        universe.nextGeneration();
        assertTrue(universe.isEmpty());
    }

    @Test
    public void cellWithTwoNeighboursShouldBeAliveInTheNextGeneration() throws Exception {
        Universe universe = new Universe();
        universe.add(new Cell(0, 0));
        universe.add(new Cell(0, 1));
        universe.add(new Cell(1, 1));
        universe.nextGeneration();
        assertFalse(universe.isEmpty());
        assertTrue(universe.hasCell(new Cell(0, 0)));
    }

    @Test
    public void cellWithThreeNeighboursShouldBeAliveInTheNextGeneration() throws Exception {
        Universe universe = new Universe();
        universe.add(new Cell(0, 0));
        universe.add(new Cell(0, 1));
        universe.add(new Cell(1, 1));
        universe.add(new Cell(1, 0));
        universe.nextGeneration();
        assertFalse(universe.isEmpty());
        assertFalse(universe.hasCell(new Cell(0, 0)));
    }

    @Test
    @Ignore
    public void cellWithFourNeighboursShouldDieInTheNextGeneration() throws Exception {

    }
}
