package FD;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class CloneUtils {
   
        @SuppressWarnings("unchecked")
        public static <T extends Serializable> T clone(Map<String, List<String>> eqTupleMap){
             
            T clonedObj = null;
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
              ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(eqTupleMap);
              oos.close();
                 
                ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
               ObjectInputStream ois = new ObjectInputStream(bais);
                clonedObj = (T) ois.readObject();
               ois.close();
                
            }catch (Exception e){
                e.printStackTrace();
            }
             
            return clonedObj;
        }
}