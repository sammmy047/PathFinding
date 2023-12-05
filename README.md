# PathFinding using A* algorithm
This project used the A* Search Algorithm, which is one of the search algorithms for finding the shortest path between nodes or graphs by using information about path cost and heuristics, as the standard shortest path to compare with the path generated by users. The application was also designed using Java. Currently, A* Search Algorithm is one of the popular techniques used in pathfinding algorithms and graph traversals in many applications. Because of its efficiency, in a square grid that has many obstacles, A* Search Algorithm can reach the target cell from the starting cell as quickly as possible by picking the node at every step based on the ‘f’ value, which is a parameter equal to the sum of the two parameters ‘g’ and ‘h’ values. Therefore, in every step, while traversing through the map, the Algorithm picks the node or cell that has the lowest ‘f’ and processes that node or cell.

Implementation of A* Algorithm:
Here the start position is represented by the blue color tile and the target is represented by the yellow color tile. Here we add barriers using the black tiles to indicate that the specific path is blocked.

![image](https://github.com/sammmy047/PathFinding/assets/76446088/4f1e62c0-eb47-4c63-905a-0363f3a00a65)


Here the red tiles are used to represent all the possible paths that have been explored by the algorithm in-order to determine the optimal path.

![image](https://github.com/sammmy047/PathFinding/assets/76446088/1cfe79b4-90f5-4a07-ac8c-5f4c4cd7fd9a)


Here the green tiles are use to represent the optimal path that has been discovered by the A* algorithm keeping track of the various obstacles present.

![image](https://github.com/sammmy047/PathFinding/assets/76446088/9aceeae3-d34e-4418-a613-1732c4e8a932)
