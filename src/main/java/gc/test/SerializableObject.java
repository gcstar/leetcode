package gc.test;

import java.io.*;

/**
 * Created by dataanalyze on 2017/10/23.
 */
public class SerializableObject implements Serializable{

    private static final long serialVersionUID = 1L;

    private String str0;
    private transient String str1;
    private static String str2 = "abc";

    public SerializableObject(String str0, String str1)
    {
        this.str0 = str0;
        this.str1 = str1;
    }

    public String getStr0()
    {
        return str0;
    }

    public String getStr1()
    {
        return str1;
    }



    public  static void main(String... args) throws Exception{
        File file = new File("/Users/dataanalyze/file/test/s.txt");
        OutputStream os = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        SerializableObject serializableObject = new SerializableObject("1", "2");
        oos.writeObject(serializableObject);
        
        oos.close();
        
        
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));


        SerializableObject serializableObject1 = (SerializableObject) ois.readObject();

        System.out.println(serializableObject1.getStr0()+ " "+ serializableObject1.getStr1());


        ois.close();

    }




}
