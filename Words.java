package Words;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader; 
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Words {
    public static void main(String[] args) throws Exception{
        String[] words = {"One", "Two", "Three", "Four", "Five"}; 
        Random randomNumbers = new Random(); 
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Words.txt"))){
            for (int i = 0; i < 100; i++){
                writer.write(words[randomNumbers.nextInt(words.length)] + "\n" ); 
            }
        }
        Map<String, Integer> wordCount = new HashMap<>(); 
        try (BufferedReader reader = new BufferedReader(new FileReader("Words.txt"))){
            String line; 
            while((line = reader.readLine()) != null){
                wordCount.put(line, wordCount.getOrDefault(line, 0) + 1); 
            }
      BufferedWriter writer = new BufferedWriter(new FileWriter("Output.txt")); 
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()){
               writer.write(entry.getKey() + ": " + entry.getValue()); 
               writer.newLine(); 
            }

            writer.close(); 
        }
    }
}
