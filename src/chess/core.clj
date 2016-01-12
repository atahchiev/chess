(ns chess.core)
(require '[clojure.string :as str])

(def ^:dynamic move "W")
(defn board []
  [[  ]
   [(Pawn. 1 0 "B")(Pawn. 1 1 "B")(Pawn. 1 2 "B")(Pawn. 1 3 "B")(Pawn. 1 4 "B" )(Pawn. 1 5 "B")(Pawn. 1 6 "B")(Pawn. 1 7 "B")  ]
   [ (Empty.)(Empty.)(Empty.)(Empty.)(Empty.)(Empty.)(Empty.)(Empty.)]
   [ (Empty.)(Empty.)(Empty.)(Empty.)(Empty.)(Empty.)(Empty.)(Empty.)]
   [ (Empty.)(Empty.)(Empty.)(Empty.)(Empty.)(Empty.)(Empty.)(Empty.)]
   [ (Empty.)(Empty.)(Empty.)(Empty.)(Empty.)(Empty.)(Empty.)(Empty.)]
   [(Pawn. 6 0 "W")(Pawn. 6 1 "W")(Pawn. 6 2 "W")(Pawn. 6 3 "W")(Pawn. 6 4 "W")(Pawn. 6 5 "W")(Pawn. 6 6 "W")(Pawn. 7 7 "W")  ]
   [(Rock. 0 0 "W" false)]])

(def last-moved-piece )

(defn- findistance [cls]
  (cond
    (instance? chess.core.Pawn cls) "P"
    (instance? chess.core.Knight cls) "N"
    (instance? chess.core.Bishop cls) "B"
    (instance? chess.core.Rock cls) "R"
    (instance? chess.core.Queen cls) "Q"
    (instance? chess.core.King cls) "K"
    (instance? chess.core.Empty cls) "-"
    )
  )
(defn printboard [board]
  (if (= (board) []) []
    (println (str/join (map findistance (nth board 0)))

    (printboard (rest board))
  )))

(defprotocol Piece
  (possibleMoves [this]))


(defrecord Pawn [x y color]
  Piece
  (possibleMoves [this]
                 (if (= (:color (((board)x)y)) "W")
                   (if (= x 6)
                     (if (and
                           (= chess.core.Empty (type (((board)x) (- y 1))))
                           (= chess.core.Empty (type (((board)x) (- y 2)))))


                       x
                       )
                     )))
  )


(defrecord Knight [x y color] )
(defrecord Bishop [x y color ] )
(defrecord Rock [x y color moved] )
(defrecord Queen [x y color ] )
(defrecord King [x y color moved chess] )
(defrecord Empty [] )



;; (possibleMoves  (((board)6)6))



(defn check-input [input]
  (re-matches #"(?i)[a-e]{1}[1-8]{1} +[a-e]{1}[1-8]{1}" input)
  )

(defn letters-to-num [input]
  (map int (str/split input  #""))
  )

(defn parse-input [input]
    (if (check-input input)

        (concat
          (subvec (str/split input  #"") 0 2)
          (subvec (str/split input  #"") 3 )))
      )


(parse-input "e2 e4")

;; (->> (range)
;;             (map #(* % %))
;;             (filter even?)
;;             (take 10)
;;             (reduce +))


;; (= (type (((initial-board) 1) 0)) chess.core.Pawn)
;; (let [yayinput (read-line)]
;;     (if (= yayinput "1234")
;;       (println "Correct")
;;       (println "Wrong")))
(def  k [1 2 3 4 5 ])
(assoc k 2 100)
(defn interactive-f [a]
  (println a)
  (flush)
  (def b (read-line))
  (interactive-f b)
  )
