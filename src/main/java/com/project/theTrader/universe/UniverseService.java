package com.project.theTrader.universe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.Queue;

import com.project.theTrader.star.Star;
import com.project.theTrader.star.StarRepository;
import com.project.theTrader.star.StarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping(consumes = "application/json", produces = "application/json")

public class UniverseService {

    List<Universe> universe = new ArrayList<Universe>();

    @Autowired
    UniverseRepository universeRepository;

    @Autowired
    StarService starService;

    List<Star> starList = new ArrayList<Star>();

    public List<Universe> getAllStars() {
        List<Universe> stars = new ArrayList<Universe>();
        universeRepository.findAll().forEach(star -> stars.add(star));
        return stars;
    }

    public Vector<Vector<Integer>> createGraph() {

        Vector<Vector <Integer> > adj = new Vector<Vector<Integer>>(13);

        Vector<Integer> edges0 = new Vector<>();
        Vector<Integer> edges1 = new Vector<>();
        Vector<Integer> edges2 = new Vector<>();
        Vector<Integer> edges3 = new Vector<>();
        Vector<Integer> edges4 = new Vector<>();
        Vector<Integer> edges5 = new Vector<>();
        Vector<Integer> edges6 = new Vector<>();
        Vector<Integer> edges7 = new Vector<>();
        Vector<Integer> edges8 = new Vector<>();
        Vector<Integer> edges9 = new Vector<>();
        Vector<Integer> edges10 = new Vector<>();
        Vector<Integer> edges11 = new Vector<>();
        Vector<Integer> edges12 = new Vector<>();
        Vector<Integer> edges13 = new Vector<>();

        edges0.add(1);

        edges1.add(0);
        edges1.add(2);
        edges1.add(4);
        edges1.add(8);

        edges2.add(1);
        edges2.add(3);

        edges3.add(2);
        edges3.add(6);
        edges3.add(11);

        edges4.add(1);
        edges4.add(9);

        edges5.add(8);
        edges5.add(13);

        edges6.add(3);

        edges7.add(8);
        edges7.add(10);

        edges8.add(1);
        edges8.add(5);
        edges8.add(7);
        edges8.add(9);

        edges9.add(4);
        edges9.add(8);

        edges10.add(7);
        edges10.add(12);

        edges11.add(3);

        edges12.add(10);
        edges12.add(13);

        edges13.add(5);
        edges13.add(12);

        adj.add(edges0);
        adj.add(edges1);
        adj.add(edges2);
        adj.add(edges3);
        adj.add(edges4);
        adj.add(edges5);
        adj.add(edges6);
        adj.add(edges7);
        adj.add(edges8);
        adj.add(edges9);
        adj.add(edges10);
        adj.add(edges11);
        adj.add(edges12);
        adj.add(edges13);

        return adj;

    }

    public List<Star> nearbyStars(Long starId) {

        List<Star> nearby = new ArrayList<Star>();
        Queue<Integer> q = new LinkedList<Integer>();
        boolean[] visited = new boolean[14];     
        Vector<Vector<Integer>> adj = new Vector<Vector<Integer>>();
        adj = createGraph();

        Star starFrom = new Star(); 
        starFrom = starService.getStarById(starId);
        int indexFrom = starFrom.getPosGrafo();
        System.out.println("indexFrom: " + indexFrom);
        int cont = 0;

        starList = starService.getAll();

        q.add(indexFrom);
        visited[indexFrom] = true;

        while (!q.isEmpty() || cont < 10) {
            int v = q.peek();
            q.remove();
            for (int u: adj.get(v)) {
            if(cont < 10){
                if (!visited[u]) {
                    Star starN = new Star();
                    for (int j = 0; j < starList.size(); j++) {
                        int p;
                        p = starList.get(j).getPosGrafo();
                        if (p == u) {
                            starN = starList.get(j);
                            break;
                        }
                    }
                    nearby.add(starN);
                    visited[u] = true;
                    q.add(u);
                    cont++;
                }
            }
         }   
        }

        return nearby;
    }

}
