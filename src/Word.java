import java.util.ArrayList;

/**
 * Created by Tank on 5/20/2015.
 */
public class Word {
    private String string;
    private boolean discovered;
    private ArrayList<Word> neighbours;
    private int distance;
    public Word(String string){
        distance = -1;
        this.discovered = false;
        this.string = string;
        this.neighbours = new ArrayList<Word>();
    }
    public void addNeighbour(Word word){
        neighbours.add(word);
    }
    public ArrayList<Word> getNeighbours(){
        return neighbours;
    }
    public String getString() {
        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        if (string != null ? !string.equals(word.string) : word.string != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return string != null ? string.hashCode() : 0;
    }

    public void setDiscovered(){

        discovered = true;
    }
    public boolean isDiscovered(){
        return discovered;
    }
    public int distance(){
        return distance;
    }
    public void setDistance(int distance){
        this.distance = distance;
    }

    @Override
    public String toString() {
        return string;
    }
}
