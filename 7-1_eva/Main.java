import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        if(args.length < 1){
            System.out.println("Usage: java Main <input_filename>");
            return;
        }
        try{
            Map<String, TextView> textviews = new HashMap<>();
            // List<TextView> textviews = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null){
                String[] ss = line.split("\\s+");
                if(ss[1].equals("add")){
                    TextView tv;
                    if(textviews.containsKey(ss[0])){
                        tv = textviews.get(ss[0]);
                    }else{
                        tv = new TextView(null);
                        textviews.put(ss[0], tv);
                    }
                    for(int i=2; i<ss.length; i++){
                        if (ss[i].equals("scrollBar")) tv.addElement(new ScrollBar("scrollBar"));
                        else if(ss[i].equals("thickBlackBorder")) tv.addElement(new ThickBlackBorder("thickBlackBorder"));
                    }
                }
                else if(ss[1].equals("display")){
                    TextView tv = (textviews.containsKey(ss[0]))? textviews.get(ss[0]) : null;
                    if(tv == null) continue;
                    sb.append(tv.display());
                }else{
                    TextView tv;
                    String[] text = Arrays.copyOfRange(ss, 1, ss.length);
                    if(textviews.containsKey(ss[0])){
                        tv = textviews.get(ss[0]);
                        tv.setText(text);
                    }else{
                        tv = new TextView(text);
                        textviews.put(ss[0], tv);
                    }
                }
            }
            reader.close();
            String output = sb.toString();
            System.out.print(output);
            BufferedWriter writer = new BufferedWriter(new FileWriter(args[0].split("\\.")[0] + ".out"));
            writer.write(output);
            writer.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}