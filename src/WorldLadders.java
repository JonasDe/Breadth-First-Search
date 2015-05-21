import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by Tank on 5/20/2015.
 */
public class WorldLadders {
    public static void main(String[] args) {


        Scanner scan = null;
        File inputFile = new File(args[2]);

        try {
             scan = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Word> words = new ArrayList<Word>();
        Word chosenWord = null;
        Word soughtForWord = null;
        while(scan.hasNext()){
            String wordRepresentation = scan.next();
            Word word = new Word(wordRepresentation);

            if(wordRepresentation.equals(args[0])){
                chosenWord = word;
            }
            if(wordRepresentation.equals(args[1])){
                soughtForWord = word;
            }
            words.add(word);



        }

        //Word chosenWord = words.get(words.indexOf(new Word(args[0])));
        //Word soughtForWord = words.get(words.indexOf(new Word(args[1])));
        for(int i = 0; i < words.size(); i++){
           for(int j = 0; j < words.size(); j++){
                if(i == j) continue;
               Word word = words.get(i);
               Word word1 = words.get(j);
                if(hasEdge(word, word1)){
                   word.addNeighbour(word1);
               }
           }
        }

        ArrayDeque<Word> theQueue = new ArrayDeque<Word>();
        theQueue.add(chosenWord);
        chosenWord.setDiscovered();
        int distance = 0;
        chosenWord.setDistance(distance);
        int answer = -1;
        while(!theQueue.isEmpty()){
            Word temp = theQueue.poll();
            answer = processNeighbours(temp, theQueue, soughtForWord);
            if(answer > 0) break;
        }
        if(answer >= 0){
            System.out.println("There exists a path with length " + answer +" between "+ chosenWord+ " and "+ soughtForWord);
        }else{
            System.out.println("No path found between " + chosenWord + " and " + soughtForWord);
        }

    }private static boolean hasEdge(Word a, Word b){
        String from = a.getString();
        String to = b.getString();
        from = from.substring(from.length()-4,from.length());
        StringBuilder sb = new StringBuilder(to);
        for(int i = 0; i < 4; i++){
            int position = sb.indexOf(from.charAt(i) + "");
            if(position < 0) return false;
            sb.deleteCharAt(position);
        }
        return true;
    }private static int processNeighbours(Word word, ArrayDeque<Word> daQueue, Word finalWord ){

        for(Word w: word.getNeighbours()){
            if(w.isDiscovered()) continue;
            daQueue.add(w);
            w.setDiscovered();
            w.setDistance(word.distance()+1);
            if(w.equals(finalWord)) return w.distance();
        }
        return -1;
    }
}
