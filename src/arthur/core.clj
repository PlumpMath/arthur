
(ns arthur.core
  (:refer-clojure :exclude [==])
  (:use clojure.core.logic))

(defrel dev x)
(defrel pm x)
(defrel youngling x)
(defrel lead x)
(fact dev 'rod)
(fact dev 'gavd)
(fact dev 'craig)
(fact dev 'tidy)
(fact dev 'stevea)
(fact dev 'andy)
(fact dev 'alpha)
(fact dev 'kdawg)
(fact dev 'david)
(fact dev 'bendy)
(fact dev 'steff)
(fact pm 'pete)
(fact pm 'ines)
(fact pm 'ian)
(fact youngling 'kdawg)
(fact youngling 'steff)
(fact youngling 'bendy)
(fact lead 'gavd)
(fact lead 'craig)
(fact lead 'tidy)

(defn containso [x xs]
  (conde
    ((fresh [y ys]
       (conso y ys xs)
       (== x y)))
    ((fresh [y ys]
      (conso y ys xs)
      (containso x ys)))))

(defn lasto [x xs]
  (conde
    ((fresh [a b]
      (conso a b xs)
      (== b '())
      (== a x)))
    ((fresh [a b]
      (conso a b xs)
      (lasto x b)))))

(defn firsto2 [x xs]
  (conde
    ((fresh [a b]
      (conso a b xs)
      (== a x)))))

;; TODO

(run 1 [q]
  (ppendo '(1 2 3) '(4 5 6) q))

(defn ppendo [xs ys zs]
  (conde
    ((== ys '()) (== xs zs))
    ((fresh [a b c d]
      (conso a b ys)
      (conso a '() c)
      (ppendo a xs d)
      (ppendo d b zs)))))

;; TEAMS

(defn ^ {:doc "Teams are 3 people; 1 PM, 1 Lead and 1 Youngling"}
  teamo [xs]
  (conde
    ((fresh [x y ys z zs]
      (conso x ys xs)
      (conso y zs ys)
      (conso z () zs)
      (pm x)
      (lead y)
      (youngling z)
      (!= x y)
      (!= x z)
      (!= y z)))))

(defn teamso [xs]
  (conde
    ((== xs ()))
    ((fresh [x y]
      (conso x y xs)
      (teamo x)
      (teamso y)))))

(run 3 [q]
  (teamso q))

