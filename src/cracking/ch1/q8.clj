(ns cracking.ch1.q8)

(defn- zero-coords 
  "Search matrix for a sequence of coordinates whose value is zero"
  [mx]
  (for [x (range (alength (first mx)))
        y (range (alength mx))
        :when (= 0 (aget mx x y))]
    [x y]))

(defn- zero-row! [mx y]
  (let [row (aget mx y)]
    (doseq [x (range (alength row))]
      (aset mx x y 0))))

(defn- zero-col! [mx x]
  (let [len (alength mx)]
    (doseq [y (range len)]
      (aset mx x y 0))))

(defn zero-matrix [mx]
  (let [coords (zero-coords mx)
        xs     (distinct (map first coords))
        ys     (distinct (map second coords))]
    (doseq [x xs] (zero-col! mx x))
    (doseq [y ys] (zero-row! mx y)))
  mx)