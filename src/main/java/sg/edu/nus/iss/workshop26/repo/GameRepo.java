package sg.edu.nus.iss.workshop26.repo;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.workshop26.models.Game;


@Repository
public class GameRepo {

    @Autowired
    private MongoTemplate mongoTemplate;
    //first 25
    //    //db.game.find({}).skip(25).limit(25) 
    public List<Game> search(Integer limit,Integer offset)

    {
        Query q = new Query();
        q.skip(offset).limit(limit);
        return mongoTemplate.find(q, Document.class, "game")
                    .stream()
                    .map(t -> Game.fromJSON(t))
                    .toList();
    }

    //get by rank
    // THis is the correct one :db.game.find({ "ranking": { $exists: true } }).sort({ "ranking": 1 })
    // this is also correct :db.game.find({ ranking: { $exists: true } }).sort({ ranking: 1, gross: 1 })
    //The Criteria.where("ranking").exists(true) part ensures that only documents with a "ranking" field are retrieved.
    public List<Game> getGamesByRank() {
        Query q = new Query(Criteria.where("ranking").exists(true));
        q.with(Sort.by(Sort.Direction.ASC, "ranking"));
        
        return mongoTemplate.find(q, Document.class, "game")
                .stream()
                .map(t -> Game.fromJSON(t))
                .toList();
    }
    
    //get rank details
    // db.game.find({gid: ObjectId('<your-gid-value>')}) ; only for hexadecimal
    // this is the correct one :db.game.find({ gid: <your-gid-value> })

    public Game getGameDetails(Integer gid){
        Query q= new Query();
        q.addCriteria(Criteria.where("gid").is(gid));
        return mongoTemplate.findOne(q, Game.class, 
                    "game");
    }
    
}
