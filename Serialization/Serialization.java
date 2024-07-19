
import java.io.*;
class Man implements Serializable{
    private int width;
    private int height;
    private transient int thin = 10;
    public void setWidth(int w) {
        this.width = w;
    }
    public void setHeight(int h) {
        this.height = h;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    public int getThin() {
        return thin;
    }

    public void setThin(int thin) {
        this.thin = thin;
    }
}
public class Serialization{

    public static void main (String[] args) throws IOException {
        Man myBox = new Man();
        myBox.setWidth(50);
        myBox.setHeight(20);
        myBox.setThin(67);

        Man myBox1 = new Man();
        myBox1.setWidth(40);
        myBox1.setHeight(60);
        myBox1.setThin(77);

//Serialization
        FileOutputStream fileStream = new FileOutputStream("MyGame.txt");
// Make a ObjectOutputStream
        ObjectOutputStream os = new ObjectOutputStream(fileStream);
// Write the object
        os.writeObject(myBox);
        os.writeObject(myBox1);
        os.close();

        //Write in a text file

        FileWriter writer = new FileWriter("MyGame1.txt");
        BufferedWriter bw = new BufferedWriter(writer);

        bw.write("Box 1 width: " + myBox.getWidth() + "\n");
        bw.write("Box 1 height: " + myBox.getHeight() + "\n");

        bw.write("Box 2 width: " + myBox1.getWidth() + "\n");
        bw.write("Box 2 height: " + myBox1.getHeight() + "\n");

        bw.close();

//Deserialization
        // Make a FileInputStream
        FileInputStream fileInputStream = new FileInputStream("MyGame.txt");
// Make an ObjectInputStream
        ObjectInputStream input = new ObjectInputStream(fileInputStream);
// Read the objects
        Object one = null;
        try {
            one = input.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Object two = null;
        try {
            two = input.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

// Cast the objects
        Man elf = (Man) one;
        Man troll = (Man) two;
        System.out.println(elf.getWidth());
        System.out.println(elf.getHeight());
        System.out.println(troll.getWidth());
        System.out.println(troll.getHeight());
        System.out.println("------------");
        System.out.println("Trancient: " + elf.getThin());
        System.out.println("Trancient: " + troll.getThin());
        os.close();
    }
}