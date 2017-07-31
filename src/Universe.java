import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Universe {

    private Set<Cell> cells = new HashSet<>();

    public boolean isEmpty() {
        return cells.isEmpty();
    }

    public void add(Cell cell) {
        cells.add(cell);
    }

    public void nextGeneration() {
        this.cells = this.cells.stream().filter(cell -> this.getNeighbours(cell).size() == 2).collect(Collectors.toSet());
    }

    private Set<Cell> getNeighbours(Cell cell) {
        Set<Cell> neighbours = new HashSet<>();
        neighbours.add(new Cell(cell.getX() + 1, cell.getY()));
        neighbours.add(new Cell(cell.getX() - 1, cell.getY()));
        neighbours.add(new Cell(cell.getX(), cell.getY() + 1));
        neighbours.add(new Cell(cell.getX(), cell.getY() - 1));
        neighbours.add(new Cell(cell.getX() + 1, cell.getY() + 1));
        neighbours.add(new Cell(cell.getX() + 1, cell.getY() - 1));
        neighbours.add(new Cell(cell.getX() - 1, cell.getY() - 1));
        neighbours.add(new Cell(cell.getX() - 1, cell.getY() + 1));
        neighbours.retainAll(this.cells);

        return neighbours;
    }

    public boolean hasCell(Cell cell) {
        return this.cells.contains(cell);
    }
}
