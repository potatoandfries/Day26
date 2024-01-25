package sg.edu.nus.iss.workshop26.models;

import org.bson.Document;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Comment {

    private String c_id;
    private String user;
    private int rating;
    private String c_text;
    private int gid;

    public Comment() {
    }
    
    
    public String getC_id() {
        return c_id;
    }


    public void setC_id(String c_id) {
        this.c_id = c_id;
    }


    public String getUser() {
        return user;
    }


    public void setUser(String user) {
        this.user = user;
    }


    public int getRating() {
        return rating;
    }


    public void setRating(int rating) {
        this.rating = rating;
    }


    public String getC_text() {
        return c_text;
    }


    public void setC_text(String c_text) {
        this.c_text = c_text;
    }


    public int getGid() {
        return gid;
    }


    public void setGid(int gid) {
        this.gid = gid;
    }


    @Override
    public String toString() {
        return "Comment{" +
                "c_id='" + c_id + '\'' +
                ", user='" + user + '\'' +
                ", rating=" + rating +
                ", c_text='" + c_text + '\'' +
                ", gid=" + gid +
                '}';
    }

    public JsonObject toJSON() {
        return Json.createObjectBuilder()
                .add("c_id", getC_id())
                .add("user", getUser())
                .add("rating", getRating())
                .add("c_text", getC_text())
                .add("gid", getGid())
                .build();
    }


    public static Comment fromJSON(Document jsonObject) {
        Comment comment = new Comment(); // Create a new Comment object
        
        // Set the fields from the JsonObject
        comment.setC_id(jsonObject.getString("c_id"));
        comment.setUser(jsonObject.getString("user"));
        comment.setRating(jsonObject.getInteger("rating"));
        comment.setC_text(jsonObject.getString("c_text"));
        comment.setGid(jsonObject.getInteger("gid"));
        
        return comment;
    }

    
}
