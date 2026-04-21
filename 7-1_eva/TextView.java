import java.util.*;

public class TextView{
    private String[] text;
    private List<Element> elements;
    
    public TextView(String[] text){
        this.text = text;
        this.elements = new ArrayList<>();
    }

    public void setText(String[] text){
        this.text = text;
    }

    public void addElement(Element e){
        this.elements.add(e);
    }

    public String display(){
        String s = "";
        boolean first = true;
        for(String t : text){
            if(!first) s += " ";
            else first = false;
            s += t;
        }
        for(Element e : elements){
            if(!first) s += " ";
            else first = false;
            s += e.getname();
        }
        s += "\n";
        return s;
    }
}