package sg.edu.nus.iss.workshop26.repo;

import java.util.List;
import sg.edu.nus.iss.workshop26.models.Comment;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Repository;

@Repository
public class CommentsRepo {
    
    @Autowired
    private MongoTemplate mongoTemplate;

    //Pagination >> words to include and exclude
    public List<Comment> search(List<String> includes, List<String> excludes){
        return null; // 10 ,0
    }
    //Pagination >> words to include and exclude >> that is the limit
    public List<Comment> search(List<String> include, List<String> excludes, Integer limit){
        return null; // 10 ,0
    }
    
    //     db.comment.createIndex({ text: "text" }) // Create a text index on the 'text' field

    // db.comment.find({
    //   $text: {
    //     $search: "keyword1 keyword2", // Your search terms
    //     $language: "default" // Language to use (optional)
    //   }
    // }).sort({
    //   score: { $meta: "textScore" } // Sort by relevance score
    // }).skip(offset).limit(limit)

    public List<Comment> search(List<String> includes, List<String> excludes, Integer limit, Integer offset) {
    TextCriteria tc = TextCriteria.forDefaultLanguage()
            .matchingAny(includes.toArray(new String[includes.size()]))
            .notMatchingAny(excludes.toArray(new String[excludes.size()]));
        
    TextQuery tq = (TextQuery) TextQuery.queryText(tc)
            .includeScore("score")
            .sortByScore()
            .skip(offset)
            .limit(limit);
    
    return mongoTemplate.find(tq, Document.class, "comment")
            .stream()
            .map(t -> Comment.fromJSON(t))
            .toList();
}
}
