import java.util.List;
import java.util.ArrayList;

public class Application{
    private List<Document> documents;
    public Application(){
        this.documents = new ArrayList<>();        
    }

    public void addDocument(Document d){
        documents.add(d);
    }

    public String present(){
        String s = "";
        for(Document d : documents){
            s += d.getName() + "\n";
        }
        return s;
    }
}