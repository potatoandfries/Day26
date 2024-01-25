package sg.edu.nus.iss.workshop26.models;

import org.bson.Document;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

public class Game {

    private Integer gid;
    private String name;
    private Integer year;
    private Integer ranking;
    private Integer user_rated;
    private String url;
    private String image;

    

    public Game() {
    }

    public Integer getGid() {
        return gid;
    }
    public void setGid(Integer gid) {
        this.gid = gid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public Integer getRanking() {
        return ranking;
    }
    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }
    public Integer getUser_rated() {
        return user_rated;
    }
    public void setUser_rated(Integer user_rated) {
        this.user_rated = user_rated;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
    return "Game[game=" +
            gid +
            ", name=" +
            name +
            ", year=" +
            year +
            ", ranking=" +
            ranking +
            ", user_rated=" +
            user_rated +
            ", url=" +
            url +
            ", images=" +
            image +
            
            "]";
        }

        public JsonObject toJSON() {
            JsonObjectBuilder objBuilder = Json.createObjectBuilder()
                    .add("gid", getGid())
                    .add("name", getName())
                    .add("year", getYear())
                    .add("ranking", getRanking())
                    .add("users_rated", getUser_rated()) //!= null ? getUser_rated() : 0) // if null set 0
                    
                    .add("url", getUrl())// !=null ?  getUrl() :"empty")
                    
                    .add("image", getImage());// != null ? getImage() : "empty"); // if null set string
        
            return objBuilder.build();
        }
        


        public static Game fromJSON(Document jsonObject) {
            Game game = new Game(); // Create a new Game object
            
            // Set the fields from the JsonObject
            game.setGid(jsonObject.getInteger("gid"));
            game.setName(jsonObject.getString("name"));
            game.setYear(jsonObject.getInteger("year"));
            game.setRanking(jsonObject.getInteger("ranking"));
            game.setUser_rated(jsonObject.getInteger("users_rated"));
            game.setUrl(jsonObject.getString("url"));
            game.setImage(jsonObject.getString("image"));
            
            return game;
        }
}
