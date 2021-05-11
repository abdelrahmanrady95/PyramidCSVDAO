import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PyramidCSVDAO extends Thread {
    public final List<Pyramid> p_list=new ArrayList<Pyramid>();
	public void readcsv(String path) throws FileNotFoundException, IOException  {
	BufferedReader br=new BufferedReader(new FileReader(path));
	String line;
        line=br.readLine(); 

	if(line!=null)
            System.out.println(line);
        do{   
            line=br.readLine(); 
            if(line!=null){
		String [] parts=line.split(",");
		if (parts[7].isEmpty()) {
                    p_list.add(new Pyramid(parts[0],parts[2],parts[4],Double.parseDouble("20")));
		}
		else{
                    p_list.add(new Pyramid(parts[0],parts[2],parts[4],Double.parseDouble(parts[7])));
		}
		}
        }while(line!=null);
	for(int i=0;i<p_list.size();i++){
            System.out.println("#"+(i+1)+" "+p_list.get(i).getPharaoh()+","+p_list.get(i).getModern_name()+","+p_list.get(i).getSite()+","+p_list.get(i).getHeight());
	}

	}
    @Override
	public void run()
	{
	try {
            readcsv("C:\\Users\\Rady\\Downloads\\Compressed\\pyramids.csv");
	} catch (FileNotFoundException e) {  

	} catch (IOException ex) {
            Logger.getLogger(PyramidCSVDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

	}

	public Pyramid  createpyramid(String [] metadata){
            return new Pyramid(metadata[0],metadata[2],metadata[4],Double.parseDouble(metadata[7]));
	}
    
}
