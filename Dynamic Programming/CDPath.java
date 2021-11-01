import java.io.*;
import java.util.*;

public class CDPath {
  public static void main(String[] argv) {

    // We have a CD player that can hold several CDs at once.  
    // Each CD has the same number of songs, though there may be many duplicates of the same song in our collection, 
    // or even on the same CD.  

    // The CD player always starts at the first CD in the list on the first song (song #0).  
    // After each song, it shuffles to any other CD at random, but only moves forward or backward one song number 
    // (it will not move backward if on the first song, nor forward if on the last song).

    // For instance, if Vogue (cd2, song #2) just played, the shuffle may move backward a song to Thriller or Royals 
    // (song #1 of cd0 or cd1) or forward a song to Thriller (song #3 of either cd0 or cd1).  
    // On the other hand, if Thriller just played (cd0, song #0), it could only move to Royals, 
    // because its other possible move would move to a Thriller song.

    // Write an algorithm that takes a list of CDs and returns a valid path that the shuffle function could take, 
    // with the cd and song number of each song, such that each unique song is played exactly once with no repetitions.  
    // If it is not possible to form such a list, return an empty list.

    String[] cd0 = {"Thriller", "Thriller", "Lights", "Thriller"};
    String[] cd1 = {"Thriller", "Royals", "Lights", "Thriller"};
    String[] cd2 = {"Thriller", "Thriller", "Vogue", "Thriller"};
    String[] cd3 = {"Thriller", "Royals", "Thriller", "Lights"};

    String[][] cdList0 = {cd0, cd1, cd2};    
    // playAllSongs(cdList0) => []    

    String[][] cdList1 = {cd0, cd3, cd2};
    // playAllSongs(cdList1) => [(0,0), (1,1), (2,2), (1,3)]    

    String[] cd4 = {"Roar", "Superstition", "Roar"};
    String[] cd5 = {"Africa","Zombie", "Africa"};
    String[] cd6 = {"Push", "Happy", "Happy"} ;
    String[][] cdList2 = {cd4, cd5, cd6};
    // playAllSongs(cdList2) => multiple options of length 6:
    // [(0, 0), (1, 1), (2, 0), (0, 1), (1, 0), (2, 1)]			
    // [(0, 0), (1, 1), (2, 0), (0, 1), (1, 2), (2, 1)]			
    // [(0, 0), (2, 1), (1, 0), (0, 1), (2, 0), (1, 1)]			
    // [(0, 0), (2, 1), (1, 2), (0, 1), (2, 0), (1, 1)]
    

    String[] cd7 = {"Survivor", "Survivor", "Beatles", "Survivor"};
    String[] cd8 = {"Survivor", "Waterfalls", "Survivor", "Faith"};
    String[] cd9 = {"Faith", "Survivor", "Survivor", "Survivor"};
    String[][] cdList3 = {cd7, cd8, cd9};
    // playAllSongs(cdList3) => [(0,0), (1,1), (0,2), (1,3)]	
    
    String[] cd10 = {"ABBA", "Beatles"};
    String[] cd11 = {"ABBA", "Beatles"};
    String[] cd12 = {"Beatles", "ABBA"};
    String[] cd13 = {"Beatles", "ABBA"};
    String[][] cdList4 = {cd11, cd10};
    String[][] cdList5 = {cd10, cd12};
    String[][] cdList6 = {cd10, cd12, cd11, cd13};
    // playAllSongs(cdList4) => [(0,0), (1,1)]
    // playAllSongs(cdList5) => []
    // playAllSongs(cdList6) => [(0,0), (2,1)]
    
    System.out.println(find(cdList4));
  }

  
  // Your function here
  public static List<Tuple> find(String[][] cds) {
    Set<String> checker = new HashSet<>();
    for (int i = 0; i < cds.length; i++) {
      for (int j = 0; j < cds[0].length; j++) {
        if (!checker.contains(cds[i][j])) {
          checker.add(cds[i][j]);
        }
      }
    }
    int unique = checker.size();
    
    Stack<Tuple> result = new Stack<>();
    helper(result, new HashSet<>(), cds, unique, 0, 0);
    return result;
  }
  
  private static void helper(Stack<Tuple> result, Set<String> checker, String[][] cds, int unique, int cd, int track) {
    if (result.size() == unique) {
      return;
    } else {
      result.push(new Tuple(cd, track));
      checker.add(cds[cd][track]);
      //System.out.println(checker);
      if (cd != 0) {
        for (int i = 0; i < cds[cd - 1].length; i++) {
          if (!checker.contains(cds[cd - 1][i])) {
            helper(result, checker, cds, unique, cd - 1, i);
          }
        }
      }
      if (cd != cds.length - 1) {
        for (int i = 0; i < cds[cd + 1].length; i++) {
          if (!checker.contains(cds[cd + 1][i])) {
            helper(result, checker, cds, unique, cd + 1, i);
          }
        }
      }
      result.pop();
      checker.remove(cds[cd][track]);
    }
  }
  
  private static class Tuple {
    int cd;
    int track;
    
    public Tuple(int cd, int track) {
      this.cd = cd;
      this.track = track;
    }
  }
}