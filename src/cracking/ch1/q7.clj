(ns cracking.ch1.q7)

(defn- new-coords 
  "Coordinates that x, y should map to for a 90 degree rotation"
  [n x y]
  [y (dec (- n x))])

(defn- quad-coords
  "Return the coordinates of one quadrant. Since an odd-length square matrix
   cannot be cleanly divided into four quadrants, include middle column as well"
  [n]
  (for [x (range (Math/round  (double (/ n 2))))
        y (range (quot n 2))]
    [x y]))

(defn- rotate! 
  "Starting at a given coordinate, rotate each pixel inline and stop upon
   return to the original coordinates"
  [matrix n [x1 y1]]
  (loop [x x1 y y1 v (aget matrix x y)]
    (let [[x2 y2]  (new-coords n x y)
          next-val (aget matrix x2 y2)]
      (aset matrix x2 y2 v)
      (if-not (and (= x1 x2) (= y1 y2))
        (recur x2 y2 next-val)))))

(defn rotate-90
  "Rotate N x N matrix 90 degrees in place"
  [matrix]
  (let [n (count (first matrix))]
    (loop [xs (quad-coords n)]
      (when (seq xs)
        (rotate! matrix n (first xs))
        (recur (rest xs)))))
  matrix)
