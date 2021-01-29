package link.hitech.gaspar.service;

import link.hitech.gaspar.engine.AutoCompleteEngine;
import link.hitech.gaspar.entity.Suggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataIngestionService {


    Map<String, AutoCompleteEngine> engines = new HashMap<>();


    public void submitSuggestions(List<Suggestion> suggestions) {
        for (Suggestion s : suggestions) {
            AutoCompleteEngine engine;
            String group = s.getGroup();
            if (engines.containsKey(group)) {
                engine = engines.get(group);
            } else {
                engine = new AutoCompleteEngine();
                engines.put(group, engine);
            }
            engine.add(s);
        }
    }


}
