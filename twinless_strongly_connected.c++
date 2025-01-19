#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Graph {
    int V; 
    vector<vector<int>> adj; 

    void bridgeUtil(int u, int disc[], int low[], int parent[], bool &hasBridge) {
        static int time = 0;
        disc[u] = low[u] = ++time;

        for (int v : adj[u]) {
            if (disc[v] == -1)
                parent[v] = u;
                bridgeUtil(v, disc, low, parent, hasBridge);

                low[u] = min(low[u], low[v]);

                
                if (low[v] > disc[u]) {
                    hasBridge = true;
                    cout << "جسر: " << u << " - " << v << endl;
                }
            } else if (v != parent[u]) 
                low[u] = min(low[u], disc[v]);
            }
        }
    }

public:
    Graph(int V) {
        this->V = V;
        adj.resize(V);
    }

    void addEdge(int u, int v) {
        adj[u].push_back(v);
        adj[v].push_back(u); 
    }

    void findBridges() {
        int *disc = new int[V];
        int *low = new int[V];
        int *parent = new int[V];
        bool hasBridge = false;

        for (int i = 0; i < V; i++) {
            disc[i] = -1;
            low[i] = -1;
            parent[i] = -1;
        }

        for (int i = 0; i < V; i++) {
            if (disc[i] == -1) {
                bridgeUtil(i, disc, low, parent, hasBridge);
            }
        }

        if (!hasBridge) {
            cout << "لا توجد جسور في الرسم البياني." << endl;
        }

        delete[] disc;
        delete[] low;
        delete[] parent;
    }
};

int main() {
    Graph g(5);
    g.addEdge(0, 1);
    g.addEdge(1, 2);
    g.addEdge(1, 3);
    g.addEdge(3, 4);

    g.findBridges();

    return 0;
}
// ليا مريش , ماريا الحساني , جودي عبيد 