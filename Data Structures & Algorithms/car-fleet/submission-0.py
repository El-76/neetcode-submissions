class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        cars = []
        
        l = len(position)

        for i in range(0, l):
            cars += [ (position[i], speed[i]) ]

        cars.sort(reverse = True, key = lambda x: x[0])

        n = 0
        maxt = 0.0
        for i in range(0, l):
             t = (target - cars[i][0]) / cars[i][1]

             if t > maxt:
                maxt = t
                n += 1

        return n