package sg.edu.nus.iss.workshop26.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;

import sg.edu.nus.iss.workshop26.models.Comment;
import sg.edu.nus.iss.workshop26.models.Game;
import sg.edu.nus.iss.workshop26.repo.CommentsRepo;
import sg.edu.nus.iss.workshop26.repo.GameRepo;

@Service
public class GameService {
    
   @Autowired
    private GameRepo repo1;

    @Autowired CommentsRepo repo2;

    public List<Game> searchGame(Integer limit, Integer offset){
        return repo1.search(limit, offset);
    }

    public List<Game> getGamesByRank(){
        return repo1.getGamesByRank();
    }

    public Game getGameDetails(Integer gid){
        return repo1.getGameDetails(gid);
    }

    public List<Comment> searchComment(String q, Float score, Integer limit, Integer offset) {
        List<String> includes = new LinkedList<>();
        List<String> excludes = new LinkedList<>();

        for (String w : q.split(" ")) {
            if (w.startsWith("-")) {
                String[] exW = w.split("-");
                excludes.add(exW[1]);
            } else {
                includes.add(w);
            }
        }
        System.out.println(excludes);
        System.out.println("--------------");
        System.out.println(includes);

        return repo2.search(includes, excludes, limit, offset);
    } 
}
