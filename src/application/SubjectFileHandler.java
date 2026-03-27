package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SubjectFileHandler{

    private static final String FILE_NAME = "subjects.dat";

    public static void saveSubjects(ArrayList<Subject> subjects){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            out.writeObject(subjects);
            out.close();
        } 
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Subject> loadSubjects(){
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME));
            ArrayList<Subject> subjects = (ArrayList<Subject>) in.readObject();
            in.close();
            return subjects;
        } catch (Exception e){
            return new ArrayList<>();
        }
    }
}