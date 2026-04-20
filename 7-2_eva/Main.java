import java.util.*;
import java.io.*;

public class Main{
    static List<Document> documents = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        if(args.length < 1){
            System.out.println("Usage: java Main <input_filename>");
            return;
        }
        try{
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line;
            while((line = reader.readLine()) != null){
                String[] parts = line.split("\\s+");
                switch(parts[0]){
                    case "Present":
                        present();
                        break;
                    case "Draw":
                        addDocument(new DrawingDocument("DrawingDocument"));
                        break;
                    case "Text":
                        addDocument(new TextDocument("TextDocument"));
                        break;
                    default:
                        continue;
                }
            }
            reader.close();
            String output = sb.toString();
            System.out.print(output);
            BufferedWriter writer = new BufferedWriter(new FileWriter(args[0].split("\\s+")[0] + ".out"));
            writer.write(output);
            writer.close();
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
    }

    public static void present(){
        for(Document d : documents){
            sb.append(d.getName() + "\n");
        }
    }

    public static void addDocument(Document d){
        documents.add(d);
    }
}