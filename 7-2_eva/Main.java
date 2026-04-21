import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        if(args.length < 1){
            System.out.println("Usage: java Main <input_filename>");
            return;
        }
        try{
            Application app = new Application();
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null){
                String[] parts = line.split("\\s+");
                switch(parts[0]){
                    case "Present":
                        sb.append(app.present());
                        break;
                    case "Draw":
                        app.addDocument(new DrawingDocument("DrawingDocument"));
                        break;
                    case "Text":
                        app.addDocument(new TextDocument("TextDocument"));
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
}