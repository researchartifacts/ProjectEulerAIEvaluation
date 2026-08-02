package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ107 {

    public ResponseDto Question107() {
        ResponseDto responseDto = new ResponseDto();
        int totalWeight = 0;
        List<Edge> edges = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("helloworld-api/problems/101to200/0107_network.txt"))) {
            String line;
            int row = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                for (int col = row + 1; col < parts.length; col++) {
                    if (!parts[col].equals("-")) {
                        int weight = Integer.parseInt(parts[col]);
                        edges.add(new Edge(row, col, weight));
                        totalWeight += weight;
                    }
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(edges);
        int mstWeight = 0;
        int[] parent = new int[40];
        for (int i = 0; i < 40; i++) parent[i] = i;

        for (Edge edge : edges) {
            int root1 = find(parent, edge.u);
            int root2 = find(parent, edge.v);
            if (root1 != root2) {
                mstWeight += edge.weight;
                parent[root1] = root2;
            }
        }

        responseDto.setAnswer(String.valueOf(totalWeight - mstWeight));
        return responseDto;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent, parent[i]);
    }

    static class Edge implements Comparable<Edge> {
        int u, v, weight;
        Edge(int u, int v, int weight) {
            this.u = u; this.v = v; this.weight = weight;
        }
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }
}
